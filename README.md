# 🚀 Java Selenium Hybrid Framework 

## 📊 Project Status

| Category | Badges |
|----------|--------|
| **Version** | ![GitHub release](https://img.shields.io/github/v/release/Anuj-Patiyal/java-selenium-hybrid-framework) ![GitHub Release Date](https://img.shields.io/github/release-date/Anuj-Patiyal/java-selenium-hybrid-framework) ![GitHub commits since latest release](https://img.shields.io/github/commits-since/Anuj-Patiyal/java-selenium-hybrid-framework/latest) |
| **Activity** | ![GitHub last commit](https://img.shields.io/github/last-commit/Anuj-Patiyal/java-selenium-hybrid-framework) ![GitHub commit activity](https://img.shields.io/github/commit-activity/m/Anuj-Patiyal/java-selenium-hybrid-framework) ![GitHub contributors](https://img.shields.io/github/contributors/Anuj-Patiyal/java-selenium-hybrid-framework) |
| **Size** | ![GitHub repo size](https://img.shields.io/github/repo-size/Anuj-Patiyal/java-selenium-hybrid-framework) ![GitHub code size](https://img.shields.io/github/languages/code-size/Anuj-Patiyal/java-selenium-hybrid-framework) ![GitHub language count](https://img.shields.io/github/languages/count/Anuj-Patiyal/java-selenium-hybrid-framework) ![GitHub top language](https://img.shields.io/github/languages/top/Anuj-Patiyal/java-selenium-hybrid-framework) |
| **CI/CD** | ![Main CI](https://img.shields.io/github/actions/workflow/status/Anuj-Patiyal/java-selenium-hybrid-framework/main-ci.yml) ![POM Validation](https://img.shields.io/github/actions/workflow/status/Anuj-Patiyal/java-selenium-hybrid-framework/pom-validation.yml) ![Feature PR](https://img.shields.io/github/actions/workflow/status/Anuj-Patiyal/java-selenium-hybrid-framework/feature-pr.yml) ![Release](https://img.shields.io/github/actions/workflow/status/Anuj-Patiyal/java-selenium-hybrid-framework/release-pr.yml) |
| **Issues** | ![GitHub issues](https://img.shields.io/github/issues/Anuj-Patiyal/java-selenium-hybrid-framework) ![GitHub closed issues](https://img.shields.io/github/issues-closed/Anuj-Patiyal/java-selenium-hybrid-framework) ![GitHub pull requests](https://img.shields.io/github/issues-pr/Anuj-Patiyal/java-selenium-hybrid-framework) ![GitHub closed pull requests](https://img.shields.io/github/issues-pr-closed/Anuj-Patiyal/java-selenium-hybrid-framework) |
| **Milestones** | ![GitHub milestones](https://img.shields.io/github/milestones/progress/Anuj-Patiyal/java-selenium-hybrid-framework/1) ![GitHub milestones](https://img.shields.io/github/milestones/progress-percent/Anuj-Patiyal/java-selenium-hybrid-framework/1) |
| **Tech Stack** | ![Java](https://img.shields.io/badge/Java-21-blue) ![Maven](https://img.shields.io/badge/Maven-3.6%2B-orange) ![Selenium](https://img.shields.io/badge/Selenium-4.34.0-green) ![TestNG](https://img.shields.io/badge/TestNG-7.11.0-red) ![Log4j](https://img.shields.io/badge/Log4j-2.20.0-blueviolet) ![Allure](https://img.shields.io/badge/Allure-2.25.0-ff69b4) |
| **License & Maintenance** | ![GitHub](https://img.shields.io/github/license/Anuj-Patiyal/java-selenium-hybrid-framework) ![Maintenance](https://img.shields.io/maintenance/yes/2025) ![Website](https://img.shields.io/website?url=https%3A%2F%2Fgithub.com%2FAnuj-Patiyal%2Fjava-selenium-hybrid-framework) |
| **Social** | ![GitHub forks](https://img.shields.io/github/forks/Anuj-Patiyal/java-selenium-hybrid-framework?style=social) ![GitHub stars](https://img.shields.io/github/stars/Anuj-Patiyal/java-selenium-hybrid-framework?style=social) ![GitHub watchers](https://img.shields.io/github/watchers/Anuj-Patiyal/java-selenium-hybrid-framework?style=social) ![GitHub discussions](https://img.shields.io/github/discussions/Anuj-Patiyal/java-selenium-hybrid-framework) |

> A scalable and modular automation framework foundation using Java, Selenium WebDriver, and TestNG with comprehensive CI/CD integration.

---

## 📚 Table of Contents
1. [Project Overview](#-project-overview)
2. [Architecture](#-architecture)
3. [Project Structure](#-project-structure)
4. [Milestones](#-milestones)
5. [Branching Strategy](#-branching-strategy)
6. [CI/CD Pipeline](#-cicd-pipeline)
7. [Installation](#-installation)
8. [Usage](#-usage)
9. [Contributing](#-contributing)
10. [Author](#-author)
11. [License](#-license)
12. [Roadmap](#-roadmap)

---
## 🎯 Project Overview
This project establishes a robust foundation for Selenium WebDriver automation framework using **Java 21**, **TestNG**, **Maven**, and comprehensive **GitHub Actions CI/CD**.
The framework is designed for scalability, maintainability, and enterprise-grade quality assurance.

### 🎯 Key Objectives
- ✅ **Modular Architecture**: Scalable Page Object Model design
- ✅ **CI/CD Integration**: Full GitHub Actions automation
- ✅ **Quality Assurance**: Comprehensive validation and reporting
- ✅ **Documentation**: Professional guides and automation
- ✅ **Extensibility**: Easy to add new features and tests

---

## 🏗️ Architecture

### Framework Architecture Diagram
```mermaid
graph TB
    subgraph "Test Automation Framework"
        A[Test Scripts] --> B[TestNG Framework]
        B --> C[Page Object Model]
        C --> D[WebDriver Manager]
        D --> E[Selenium WebDriver]
        E --> F[Web Applications]
        
        G[Configuration Manager] --> H[Properties Files]
        I[Log4j2 Logging] --> J[Log Files]
        K[Allure Reports] --> L[HTML Reports]
        M[CI/CD Pipeline] --> N[GitHub Actions]
        
        B --> G
        B --> I
        B --> K
        B --> M
    end
    
    subgraph "Supporting Infrastructure"
        O[Maven Build] --> P[Dependency Management]
        Q[Git Version Control] --> R[Branch Management]
        S[GitHub Actions] --> T[Automated Workflows]
        U[HTML Reports] --> V[Visual Analytics]
    end
    
    style A fill:#e1f5fe
    style F fill:#f3e5f5
    style N fill:#fff3e0
    style V fill:#e8f5e8
```
### CI/CD Pipeline Architecture
```mermaid
flowchart TD
    A[Code Commit] --> B[GitHub Actions Trigger]
    
    subgraph "CI/CD Pipeline"
        B --> C[POM Validation]
        B --> D[Main CI Pipeline]
        B --> E[Feature Validation]
        B --> F[Release Automation]
        
        C --> C1[XML Validation]
        C --> C2[Dependency Checks]
        C --> C3[HTML Reports]
        
        D --> D1[Build & Test]
        D --> D2[Security Scanning]
        D --> D3[Quality Checks]
        
        E --> E1[Branch Testing]
        E --> E2[Artifact Upload]
        
        F --> F1[Version Tagging]
        F --> F2[Release Notes]
        F --> F3[GPG Signing]
    end
    
    subgraph "Output & Artifacts"
        C3 --> G[Validation Reports]
        D3 --> H[Test Results]
        E2 --> I[Feature Artifacts]
        F2 --> J[Release Packages]
    end
    
    G --> K[Quality Dashboard]
    H --> K
    I --> K
    J --> K
    
    style A fill:#bbdefb
    style K fill:#c8e6c9
```
---

## 📁 Project Structure

```
java-selenium-java-selenium-hybrid-framework/
├── .github/
│ ├── workflows/ # GitHub Actions workflows
│ │ ├── main-ci.yml# Main CI pipeline
│ │ ├── pom-validation.yml # POM validation workflow
│ │ ├── feature-pr.yml # Feature branch validation
│ │ ├── release-pr.yml # Release automation
│ │ └── release-automation.yml # Release triggers
│ ├── scripts/ # Automation scripts
│ │ ├── pom-validator.sh # Enhanced POM validation (v1.4)
│ │ ├── milestones.sh# Milestone management
│ │ ├── issues.sh# Issue creation
│ │ ├── feature-pr.sh# Feature PR processing
│ │ └── release-pr.sh# Release PR processing
│ ├── issues/# Issue templates
│ │ └── ci-setup-issue.md# CI setup issue template
│ ├── features/# Feature PR templates
│ │ ├── maven-setup.md # Initial setup template
│ │ └── ci-setup.md# CI setup template
│ └── releases/# Release PR templates
│ ├── maven-setup-release.md # Initial release template
│ └── ci-setup-release.md# CI release template
├── src/
│ ├── main/java/ # Core framework classes
│ │ ├── config/# Configuration management
│ │ ├── drivers/ # WebDriver management
│ │ ├── pages/ # Page Object Model
│ │ ├── utils/ # Utility classes
│ │ └── exceptions/# Custom exceptions
│ └── test/java/ # Test classes
│ ├── tests/ # Test implementations
│ ├── listeners/ # TestNG listeners
│ └── base/# Base test classes
│ └── resources/ # Test configurations
│ ├── config.properties# Framework configuration
│ ├── log4j2.xml # Logging configuration
│ └── test-data/ # Test data files
├── Reports/ # Generated reports
│ ├── pom-validation-report.html # POM validation reports
│ └── allure-reports/# Allure test reports
├── pom.xml# Maven configuration
├── README.md# Project documentation
├── milestones.json# Project milestones
├── LICENSE# MIT License
└── .gitignore # Git ignore rules
```

---

## 📊 Milestones
### 📊 Milestone Progress Overview
```mermaid
gantt
    title Project Milestones Timeline
    dateFormat  YYYY-MM-DD
    axisFormat  %b %d
    
    section Completed
    v0.0.0 - Maven Setup       :done,    milestone1, 2025-08-21, 0d
    Initial Configuration      :done,    2025-08-19, 2025-08-21
    
    section In Progress
    v0.2.0 - CI Setup          :active,  milestone2, 2025-08-27, 0d
    CI/CD Implementation       :         2025-08-22, 2025-08-27
    
    section Planned
    v0.1.0 - Simple Tests      :         milestone3, 2025-08-24, 0d
    First Test Creation        :         2025-08-22, 2025-08-24
    v0.3.0 - Log4j2 Integration:         milestone4, 2025-08-30, 0d
    Logging Setup              :         2025-08-28, 2025-08-30
    v0.4.0 - Exception Handling:         milestone5, 2025-09-03, 0d
    Error Management           :         2025-08-31, 2025-09-03
    v0.5.0 - Driver Management :         milestone6, 2025-09-06, 0d
    Driver Factory             :         2025-09-04, 2025-09-06
    v0.6.0 - Page Object Model :         milestone7, 2025-09-09, 0d
    POM Implementation         :         2025-09-07, 2025-09-09
    v0.7.0 - Wait Utilities    :         milestone8, 2025-09-12, 0d
    Wait Strategies            :         2025-09-10, 2025-09-12
    v0.8.0 - Screenshot Utility:         milestone9, 2025-09-15, 0d
    Screenshot Capture         :         2025-09-13, 2025-09-15
    v0.9.0 - TestNG Listeners  :         milestone10, 2025-09-18, 0d
    Listeners Implementation   :         2025-09-16, 2025-09-18
    v1.0.0 - Allure Integration:         milestone11, 2025-09-21, 0d
    Reporting Setup            :         2025-09-19, 2025-09-21
    v1.1.0 - Retry Mechanism   :         milestone12, 2025-09-24, 0d
    Retry Logic                :         2025-09-22, 2025-09-24
```
###📋 Detailed Milestone Status
| Version | Feature                 | Status         | Target Date | Progress |
|---------|-------------------------|----------------|-------------|----------|
| v0.0.0  | Maven Initial Config    | ✅ Completed   | 2025-08-21  | 100%     |
| v0.1.0  | Simple Test Creation    | ✅ Completed   | 2025-08-24  | 100%     |
| v0.2.0  | CI Setup                | 🚧 In Progress | 2025-08-27  | 100%     |
| v0.3.0  | Log4j2 Integration      | ⏳ Planned     | 2025-08-30  | 0%       |
| v0.4.0  | Exception Handling      | ⏳ Planned     | 2025-09-03  | 0%       |
| v0.5.0  | Driver Management       | ⏳ Planned     | 2025-09-06  | 0%       |
| v0.6.0  | Page Object Model       | ⏳ Planned     | 2025-09-09  | 0%       |
| v0.7.0  | Wait Utilities          | ⏳ Planned     | 2025-09-12  | 0%       |
| v0.8.0  | Screenshot Utility      | ⏳ Planned     | 2025-09-15  | 0%       |
| v0.9.0  | TestNG Listeners        | ⏳ Planned     | 2025-09-18  | 0%       |
| v1.0.0  | Allure Integration      | ⏳ Planned     | 2025-09-21  | 0%       |
| v1.1.0  | Retry Mechanism         | ⏳ Planned     | 2025-09-24  | 0%       |

---

## 🌿 Branching Strategy
```mermaid
gitGraph
    commit id: "Initial commit"
    branch dev
    checkout dev
    commit id: "v0.0.0: Maven Setup"
    branch feature/maven-setup
    commit id: "Maven Compiler, Selenium & TestNG"
    checkout dev
    merge feature/maven-setup id: "Merge feature/maven-setup"
    branch feature/ci-setup
    commit id: "GitHub Actions workflows"
    commit id: "POM validator script"
    checkout dev
    merge feature/ci-setup id: "Merge feature/ci-setup"
    checkout main
    merge dev id: "Release v0.2.0"
    tag v0.2.0
    checkout dev
    branch feature/log4j2
    commit id: "Log4j2 configuration"
```
### Branch Protection Rules
```mermaid
flowchart LR
    A[Feature Branch] --> B[Pull Request]
    B --> C[CI Validation]
    C --> D[Code Review]
    D --> E[Merge to Dev]
    E --> F[QA Testing]
    F --> G[Release PR]
    G --> H[Production Merge]
    
    subgraph "Quality Gates"
        C
        D
        F
    end
    
    style C fill:#c8e6c9
    style D fill:#fff9c4
    style F fill:#ffcdd2
```
---

## 🔁 CI/CD Pipeline

### Workflow Metrics

| Metric            | Value        | Target | Status |
|-------------------|--------------|--------|--------|
| Build Time        | ~2m 15s      | < 3m   | ✅     |
| Test Coverage     | 0% (initial) | > 80%  | ⏳     |
| Validation Checks | 23           | 25+    | 🚧     |
| Success Rate      | 100%         | > 95%  | ✅     |

### Workflow Architecture
```mermaid
flowchart TD
    A[Code Push/PR] --> B{GitHub Event}
    
    B -->|Push to main/dev| C[Main CI Pipeline]
    B -->|Any PR| D[POM Validation]
    B -->|PR to feature/*| E[Feature PR Check]
    B -->|CI Success on main| F[Release Automation]
    
    subgraph "Main CI Pipeline"
        C --> C1[Validate POM]
        C1 --> C2[Build & Test]
        C2 --> C3[Security Scan]
        C3 --> C4[Quality Check]
    end
    
    subgraph "POM Validation"
        D --> D1[XML Validation]
        D1 --> D2[Dependency Check]
        D2 --> D3[HTML Report]
    end
    
    C4 --> G[Upload Artifacts]
    D3 --> G
    E --> G
    F --> H[Create Release]
    
    G --> I[GitHub Actions]
    H --> I
```
---

## ⚙️ Installation

### Prerequisites
- Java 21+ JDK
- Maven 3.6+
- Git 2.30+
- GitHub account with repo access

### Quick Setup

```bash
# Clone repo
git clone https://github.com/Anuj-Patiyal/java-selenium-hybrid-framework.git
cd java-selenium-hybrid-framework

# Verify Java & Maven
java -version
mvn -version

# Build project
mvn clean install

# Run validation
chmod +x .github/scripts/pom-validator.sh
./.github/scripts/pom-validator.sh --html
```

---

## 🚀 Usage

### Run Tests

```bash
# Run all tests
mvn test

# Specific browser
mvn test -Dbrowser=chrome

# Specific group
mvn test -Dgroups=smoke

# Parallel execution
mvn test -Dparallel=classes -DthreadCount=4
```

### CI/CD

```bash
# Trigger workflow manually
gh workflow run main-ci.yml

# Check status
gh run list

# Download artifacts
gh run download <run-id>
```

---

## 🤝 Contributing
### Development Workflow
```mermaid
flowchart LR
    A[Fork Repository] --> B[Create Feature Branch]
    B --> C[Implement Changes]
    C --> D[Run Validation]
    D --> E[Create Pull Request]
    E --> F[CI Validation]
    F --> G[Code Review]
    G --> H[Merge to Dev]
    H --> I[Release Process]
```

### Guidelines
- Branch naming: `feature/*`, `fix/*`
- Commit messages: follow **conventional commits**
- Add tests for new features
- Update documentation
- Run validation before PR

### Code Review Checklist
- ✅ CI checks passed
- ✅ Style guidelines followed
- ✅ Tests included
- ✅ Docs updated
- ✅ Backward compatible

---

## 👨‍💻 Author

**Anuj Kumar** 🏅 QA Consultant & Test Automation Architect
📧 [anujpatiyal@live.in](mailto:anujpatiyal@live.in)
🔗 [LinkedIn](https://www.linkedin.com/in/anuj-kumar-qa/)
🌐 [GitHub](https://github.com/Anuj-Patiyal)

---

## 📜 License

MIT License © 2025 [Anuj-Patiyal](https://github.com/Anuj-Patiyal)
```text
MIT License

Copyright (c) 2025 Anuj-Patiyal

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
---

## 🔮 Roadmap

### Short-term (4 weeks)
- ✅ Complete CI/CD pipeline (v0.2.0)
- 🚧 Implement Log4j2 integration (v0.3.0)
- 🚧 Add exception handling (v0.4.0)
- 🚧 Driver management (v0.5.0)

### Medium-term (8 weeks)
- Page Object Model
- Wait utilities
- Screenshot & video capture
- TestNG listeners

### Long-term (12+ weeks)
- Allure report integration
- Retry mechanism
- Cross-browser testing
- Mobile testing

---

> "First, solve the problem. Then, write the code." – John Johnson
> 
> Last updated: **August 2025** | Version: **0.2.0** | Documentation: ✅ Complete
