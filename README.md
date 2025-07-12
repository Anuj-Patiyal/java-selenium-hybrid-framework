# 🚀 Java Selenium Hybrid Framework
**Enterprise-Grade Test Automation Solution | v1.0.0**

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
![Java](https://img.shields.io/badge/Java-21-blue)
![Selenium](https://img.shields.io/badge/Selenium-4.34.0-darkgreen)
![TestNG](https://img.shields.io/badge/TestNG-7.11.0-red)
![Maven](https://img.shields.io/badge/Maven-3.9+-blueviolet)

---

## 📖 Table of Contents
- [Framework Overview](#-framework-overview)
- [Features](#-features)
- [Technology Stack](#-technology-stack)
- [Getting Started](#-getting-started)
- [Project Structure](#-project-structure)
- [Configuration](#-configuration)
- [Running Tests](#-running-tests)
- [Release Notes](#-release-notes)
- [Roadmap](#-roadmap)
- [Contributing](#-contributing)
- [Author](#-author)
- [License](#-license)

---

## 🌟 Framework Overview
Enterprise-grade test automation framework combining the best practices of:

- ✅ Modular design with configuration management
- ✅ Headless test execution with Selenium
- ✅ TestNG-powered structured test execution
- ✅ Maven-based dependency and build lifecycle

> Future enhancements include Page Object Model, CI/CD, reporting, and parallel execution.

---

## 🎯 Features
| Feature                 | Status   | Version  |
|------------------------|----------|----------|
| Config Management      | ✅ Live  | v1.0.0   |
| Headless Execution     | ✅ Live  | v1.0.0   |
| Basic Test Structure   | ✅ Live  | v1.0.0   |
| CI/CD (GitHub Actions) | ⏳ Planned | v2.0.0   |
| POM Implementation     | ⏳ Planned | v3.0.0   |
| HTML Reporting         | ⏳ Planned | v4.0.0   |

---

## 🛠 Technology Stack
| Component           | Version     |
|---------------------|-------------|
| Java                | 21          |
| Selenium WebDriver  | 4.34.0      |
| TestNG              | 7.11.0      |
| Maven               | 3.9.10      |

---

## 🚀 Getting Started

### ✅ Prerequisites
- JDK 21+
- Maven 3.9+
- Chrome Browser
- ChromeDriver (in system PATH)

### 📥 Installation
```bash
git clone https://github.com/your-repo/java-selenium-hybrid-framework.git
cd java-selenium-hybrid-framework
```

---

## 📂 Project Structure
```
📦 java-selenium-hybrid-framework
src/
├── main/
│   ├── java/configuration/
│   │   └── ConfigurationManager.java
│   └── resources/
│       └── config.properties
├── test/
│   └── java/tests/
│        └── HomePageTest.java
├── .gitignore
├── LICENSE
├── README.md
└── pom.xml

```

---

## ⚙️ Configuration
Edit `src/main/resources/config.properties`:
```
# Core Settings
base.url=https://demoqa.com
headless=true

# Future Configurations
# browser=chrome
# timeout=30
```

---

## 🧪 Running Tests

```bash
# Run all tests
dmvn clean test

# Run specific test
mvn test -Dtest=HomePageTest
```

---

## 📌 Release Notes
**v1.0.0 – Initial Release (2025-07-12)**

- ✅ Configuration management system
- ✅ Headless browser support
- ✅ Basic test structure using TestNG
- ✅ Maven build configuration

---

## 🗺 Roadmap
| Version   | Target Date  | Features                    |
|-----------|--------------|-----------------------------|
| v2.0.0    | 2025-07-12   | GitHub Actions CI Pipeline |
| v3.0.0    | 2025-07-13   | Page Object Model          |
| v4.0.0    | 2025-08-15   | ExtentReports Integration  |

---

## 👥 Contributing
1. Fork the repository
2. Create your feature branch: `git checkout -b feature/amazing-feature`
3. Commit your changes: `git commit -m 'Add some amazing feature'`
4. Push to the branch: `git push origin feature/amazing-feature`
5. Open a Pull Request

---

## 👨‍💻 Author

**ANUJ KUMAR** 🏅 QA Consultant & Test Automation Engineer
- 📧 Email: [anujpatiyal@live.in](mailto:anujpatiyal@live.in)
- 🌐 Website: *(coming soon)*
- 🔗 [LinkedIn Profile](https://www.linkedin.com/in/anuj-kumar-qa/)

---

## 📜 License
Distributed under the [MIT License](https://opensource.org/licenses/MIT).

> “First, solve the problem. Then, write the code.” – John Johnson

> This framework adheres to this principle with its configuration-first approach.
