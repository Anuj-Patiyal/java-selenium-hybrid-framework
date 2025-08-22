---
title: "🎯 v0.1.0 - First simple test"
assignees: Anuj-Patiyal
reviewers: opencode-qa
milestone: v0.1.0
linked_issue: 6
labels: test, first-test
---

## 📄 Description
This PR introduces our **first functional test** as part of the framework development:

- ✅ Adds a **basic Selenium + TestNG test** (`TextBoxTest.java`) to verify form submission on [`https://demoqa.com/text-box`](https://demoqa.com/text-box).
- 🧪 Inputs: Full Name, Email, Current Address, Permanent Address – and validates the result.
- 🚀 Lays the groundwork for framework enhancements (POM, ConfigManager, logging, CI, etc.)

## 📁 Affected Files
```
📦 java-selenium-hybrid-framework/
src/test/java/tests/TextBoxTest.java (newly created) (🆕)
├── 📄 pom.xml              # Maven dependencies and plugins (✔ Existing)
├── 📄 .gitignore           # Standard ignores for Java/Maven (✔ Existing)
├── 📄 LICENSE              # MIT License (✔ Existing)
└── 📄 README.md            # Project overview and setup guide (✔ Existing)

```

## 📌 Why this change?
- To validate the basic flow: browser launch → element interaction → form submission → result validation → teardown.
- Acts as a **baseline test case** for future expansions (modularization, data-driven testing, etc.).

## 🧪 Basic Verification
- [x] `mvn clean` executes successfully
- [x] All dependencies resolved
- [x] Test executed successfully on Chrome (UI visible)

## 🔍 Test Execution
| Test Method                  | Status      |
|-----------------------------|-------------|
| `testTextBoxFormSubmission()` | ✅ Passed |


## 📎 Related Issue / Milestone
- 🎯 **Milestone Progress**:
  - [x] 🚀 `#2` – Project Initialization
  - [ ] 🟡 `#6` – First Test Implementation (`v0.1.0`)

## 🔮 Roadmap (Upcoming Milestones)

| Version  | Feature                             | Status       |
|----------|-------------------------------------|--------------|
| `v0.0.0` | Maven project + Git structure       | ✅ Released  |
| `v0.1.0` | First working Selenium Test         | ⏳ In Review |
| `v0.2.0` | ConfigManager + `.properties` files | 🗂️ Planned  |
| `v0.3.0` | GitHub Actions CI integration       | 🛠️ Planned  |



## 👤 Author

[**ANUJ KUMAR**](https://www.linkedin.com/in/anuj-kumar-qa/)
🏅 *QA Consultant & Test Automation Engineer*
