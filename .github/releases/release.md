---
title: "🎯 Release v0.1.0 - First Simple Test"
assignees: Anuj-Patiyal
reviewers: opencode-qa
milestone: v0.1.0
linked_issue: 2
labels: test, first-test
---

# 🎯 Release v0.1.0 - First Simple Test

{{RELEASE_METADATA}}

## 🚀 Summary
This is the **first functional release** of our Java Selenium Hybrid Framework. It introduces a foundational UI automation test using **Selenium + TestNG**, setting the stage for further framework development and enhancements.

## ✅ What's Included

- 🧪 **Basic Functional Test**
  Adds the `TextBoxTest.java` to validate form submission on [`https://demoqa.com/text-box`](https://demoqa.com/text-box):
  - Inputs:
    - Full Name
    - Email
    - Current Address
    - Permanent Address
  - Verifies if submitted data is displayed correctly.

- 🧰 **Tech Stack**
  - Java
  - Maven
  - Selenium WebDriver
  - TestNG

## 🔍 Test Execution Summary

| Test Method                  | Status  |
|-----------------------------|---------|
| `testTextBoxFormSubmission()` | ✅ Passed |

- Ran successfully on Chrome with UI visible.
- Verified via `mvn clean test`.

## 📁 Project Structure Overview
```
📦 java-selenium-hybrid-framework/
├── src/test/java/tests/TextBoxTest.java # 🆕 Basic functional test
├── pom.xml # ✔ Maven config
├── .gitignore # ✔ Standard ignores
├── LICENSE # ✔ MIT License
└── README.md # ✔ Setup Guide
```

## 📌 Linked Items
- 🔗 Issue: `#2` – First Test Implementation
- 📌 Milestone: `v0.1.0` – First Working Selenium Test

## 📈 Roadmap Ahead

| Version  | Feature                             | Status       |
|----------|-----------------------------------|--------------|
| `v0.2.0` | ConfigManager + `.properties` files | 🗂️ Planned  |
| `v0.3.0` | GitHub Actions CI integration       | 🛠️ Planned  |


## 👤 Author

**Anuj Kumar** – [LinkedIn](https://www.linkedin.com/in/anuj-kumar-qa/)  
🏅 *QA Consultant & Test Automation Engineer*
