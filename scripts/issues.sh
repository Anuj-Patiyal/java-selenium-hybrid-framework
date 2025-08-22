#!/bin/bash
# Refactored GitHub Issue Creation Script
set -euo pipefail

# === CONFIGURATION ===
ASSIGNEE="${1:-$(gh api user --jq '.login')}"
LABEL_FILTER="${2:-}"
ISSUES_DIR=".github/issues"

# === Theme from release-pr.sh ===
readonly GREEN='\033[1;32m'
readonly ORANGE='\033[38;5;214m'
readonly RED='\033[1;31m'
readonly WHITE='\033[1;37m'
readonly BLUE='\033[1;34m'
readonly PURPLE='\033[1;35m'
readonly CYAN='\033[1;36m'
readonly NC='\033[0m'

# === Icons from release-pr.sh ===
readonly ICON_PASS="${GREEN}✓${NC}"
readonly ICON_WARN="${ORANGE}⚠${NC}"
readonly ICON_FAIL="${RED}✗${NC}"
readonly ICON_INFO="${BLUE}ℹ${NC}"
readonly ICON_SKIP="${WHITE}○${NC}"
readonly ICON_ADD="${PURPLE}+${NC}"
readonly ICON_UPDATE="${CYAN}↻${NC}"

# === Global Variables ===
declare -A known_labels=()
declare -a existing_labels_lower=()
declare -i created=0 skipped=0 failed=0 total=0

# === FUNCTIONS ===

log_info() {
    echo -e "${ICON_INFO} ${BLUE}$1${NC}" >&2
}

log_warn() {
    echo -e "${ICON_WARN} ${ORANGE}$1${NC}" >&2
}

log_success() {
    echo -e "${ICON_PASS} ${GREEN}$1${NC}" >&2
}

log_error() {
    echo -e "${ICON_FAIL} ${RED}$1${NC}" >&2
    exit 1
}

log_skip() {
    echo -e "${ICON_SKIP} ${WHITE}$1${NC}" >&2
}

get_display_width() {
    echo -n "$1" | wc -m
}

normalize_title() {
    echo "$1" | perl -CSDA -pe 's/\p{So}//g' | sed 's/[^[:alnum:]]//g' | tr '[:upper:]' '[:lower:]'
}

cache_existing_labels() {
    log_info "Caching existing labels..."
    mapfile -t existing_labels_lower < <(gh label list --limit 1000 | awk '{print tolower($1)}')
}

create_label_if_needed() {
    local label_name="$1"
    label_name=$(echo "$label_name" | sed 's/^[[:space:]]*//;s/[[:space:]]*$//' | tr -d '"')

    if [[ -n "${known_labels[$label_name]:-}" ]]; then return 0; fi

    local lower_label=$(echo "$label_name" | tr '[:upper:]' '[:lower:]')
    if printf "%s\n" "${existing_labels_lower[@]}" | grep -qx "$lower_label"; then
        known_labels[$label_name]=1
        return 0
    fi

    if gh label create "$label_name" --color "$(echo "$label_name" | sha256sum | head -c 6)" &>/dev/null; then
        known_labels[$label_name]=1
        existing_labels_lower+=("$lower_label")
        log_success "Created label: $label_name"
        return 0
    fi

    log_warn "Failed to create label: $label_name"
    return 1
}

check_issue_exists() {
    local clean_title="$1"
    local compare_title=$(normalize_title "$clean_title")

    # Get all existing issues with their titles
    local existing_titles
    mapfile -t existing_titles < <(gh issue list --limit 1000 --json title --jq '.[].title' 2>/dev/null || echo "")

    # Check if any existing title matches when normalized
    for title in "${existing_titles[@]}"; do
        if [[ "$(normalize_title "$title")" == "$compare_title" ]]; then
            return 0  # Issue exists
        fi
    done

    return 1  # Issue doesn't exist
}

create_issue_from_file() {
    local file="$1"
    local raw_title=$(awk -F': ' '/^title:/ {print $2; exit}' "$file")
    local clean_title=$(echo "$raw_title" | sed 's/^"//;s/"$//' | xargs)

    # Check if issue already exists
    if check_issue_exists "$clean_title"; then
        log_skip "Issue already exists: $clean_title"
        return 1
    fi

    # Check label filter
    if [[ -n "$LABEL_FILTER" ]]; then
        local labels=$(awk -F': ' '/^labels:/ {print $2; exit}' "$file" | tr -d '[]"' | tr ',' '\n' | xargs -n1)
        local found_match=0

        for label in $labels; do
            if [[ "${label,,}" == "${LABEL_FILTER,,}" ]]; then
                found_match=1
                break
            fi
        done

        if [[ $found_match -eq 0 ]]; then
            log_skip "Skipping due to label filter: $clean_title"
            return 1
        fi
    fi

    local milestone=$(awk -F': ' '/^milestone:/ {print $2; exit}' "$file" | tr -d '"')
    local milestone_arg=()
    if [[ -n "$milestone" ]]; then
        milestone_arg=("--milestone" "$milestone")
    fi

    local body=$(awk '/^---$/ {count++; next} count >= 2 {print}' "$file")

    local labels=$(awk -F': ' '/^labels:/ {print $2; exit}' "$file" | tr -d '[]"' | tr ',' '\n' | xargs -n1)
    local label_args=()

    for label in $labels; do
        if create_label_if_needed "$label"; then
            label_args+=("-l" "$label")
        fi
    done

    log_info "Creating issue: $clean_title"
    if issue_url=$(gh issue create -t "$clean_title" -b "$body" --assignee "$ASSIGNEE" "${label_args[@]}" "${milestone_arg[@]}" 2>/dev/null); then
        log_success "Created issue: $issue_url"
        return 0
    else
        log_warn "Failed to create issue: $clean_title"
        return 2
    fi
}

print_summary() {
    echo -e "\n${PURPLE}╔══════════════════════════════════════════════════════════════╗"
    echo -e "║${NC}${WHITE}                📊  S U M M A R Y                       ${NC}${PURPLE}║"
    echo -e "╚══════════════════════════════════════════════════════════════╝${NC}"

    echo -e "\n${WHITE}Processed ${total} issue files:${NC}"
    echo -e "  ${ICON_PASS} Created:    ${GREEN}${created}${NC}"
    echo -e "  ${ICON_SKIP} Skipped:    ${WHITE}${skipped}${NC}"
    echo -e "  ${ICON_FAIL} Failed:     ${RED}${failed}${NC}"
}

main() {
    if [[ ! -d "$ISSUES_DIR" ]]; then
        log_error "Directory '$ISSUES_DIR' not found."
    fi

    cache_existing_labels

    echo -e "\n${CYAN}🚀 Starting issue creation from '$ISSUES_DIR'...${NC}"

    local file_list=("$ISSUES_DIR"/*.md)
    total=${#file_list[@]}

    for file in "${file_list[@]}"; do
        [[ -f "$file" ]] || continue

        if create_issue_from_file "$file"; then
            created=$((created + 1))
        else
            case $? in
                1) skipped=$((skipped + 1)) ;;
                2) failed=$((failed + 1)) ;;
            esac
        fi
    done

    print_summary
}

main "$@"
