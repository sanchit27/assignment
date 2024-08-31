# 🚀 Java Bounding Box Finder

![Java CI/CD](https://github.com/sanchit27/assignment/actions/workflows/ci.yml/badge.svg)
![License](https://img.shields.io/badge/license-MIT-blue.svg)
![Java Version](https://img.shields.io/badge/Java-17-007396.svg?logo=java&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-3.8.4-C71A36.svg?logo=apache-maven&logoColor=white)

The **Java Bounding Box Finder** project is a simple yet powerful tool that identifies the minimum bounding box around contiguous groups of asterisks (`*`) in a text grid. This project is built using Java 17 and Maven, with a focus on clean code and automated testing.

---

## 🌟 Features

- **Minimum Bounding Box Calculation**: Efficiently finds the smallest bounding box for contiguous groups of asterisks.
- **Automated Testing with JUnit**: Includes a suite of unit tests to ensure the accuracy of the bounding box calculations.
- **CI/CD Pipeline with GitHub Actions**: Automatically builds, tests, and validates code changes with every commit.

---

## 📚 Project Structure

```bash
.
├── src/
│   ├── main/
│   │   └── java/
│   │       └── moneylion/
│   │           └── App.java   # Main application code
│   └── test/
│       └── java/
│           └── moneylion/
│               └── AppTest.java  # Unit tests
├── input/
│   ├── input1.txt  # Sample input files
│   ├── input2.txt
│   └── ...
├── output/
│   ├── expected1.txt  # Expected output files
│   ├── expected2.txt
│   └── ...
├── actual_output/  # Directory to store actual outputs after running tests
├── run_tests.sh  # Custom script to run tests and compare results
├── pom.xml  # Maven configuration file
└── .github/
    └── workflows/
        └── ci.yml  # GitHub Actions workflow for CI/CD
```
---
## ⚙️ Setup
### Prerequisites
Ensure you have the following installed on your system:

1. Java 17: This project requires Java 17. You can download JDK 17 here.
M2. aven 3.8+: Maven is used to manage project dependencies and to build the project. You can download Maven here.
3. Git: Git is required for cloning the repository and managing version control. You can download Git here.
   
## Installation
Follow these steps to set up the project on your local machine:

1. Clone the Repository:

Clone the project repository from GitHub to your local machine:
```bash
git clone https://github.com/sanchit27/assignment.git
cd assignment
```
````
