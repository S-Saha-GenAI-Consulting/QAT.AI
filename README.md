# QAT.AI Workspace

This workspace contains two main projects: `qGen-HUB` and `Selenium-Automation`. Below is an overview of the structure and purpose of each project.

---

## qGen-HUB

### Description
`qGen-HUB` is a utility for generating test cases, prompts, and analyzing requirements. It is designed to assist in functional test case generation, automation script creation, requirement gap analysis, and user story generation.

### Directory Structure
qGen-HUB/ ├── 1.Input/ │ └── Template.js # Input templates for test case generation ├── 2.Prompt_Library/ │ ├── Context.js # Context management for prompts │ └── TestCase.js # Test case prompt definitions ├── 3.Output/ │ └── TestCase.js # Generated test case outputs


---

## Selenium-Automation

### Description
`Selenium-Automation` is a Selenium-based automation framework designed to test web applications. It integrates TestNG and Cucumber for test execution and reporting.

### Directory Structure
Selenium-Automation/ ├── pom.xml # Maven configuration file ├── .vscode/ │ └── settings.json # VS Code workspace settings ├── src/ │ ├── main/java/ # Application source code (if any) │ └── test/java/ # Test source code ├── target/ │ ├── classes/ # Compiled classes │ ├── surefire-reports/ # TestNG and Cucumber reports │ └── reports/ # HTML and JSON reports


### Features
- **Cucumber Integration**: Write tests in Gherkin syntax.
- **TestNG Support**: Manage test execution and reporting.
- **Reusable Methods**: Common utilities for WebDriver operations.
- **HTML and JSON Reports**: Automatically generated after test execution.

### Setup
1. Install dependencies using Maven:
   ```sh
   mvn clean install

Running Tests
To execute tests, run the following Maven command:

Test reports will be generated in the target/surefire-reports/ directory.

License
This workspace is licensed under the MIT License. See the LICENSE file for details.

Contact
For any questions or issues, please contact [sayantan.saha@outlook.in]. ```