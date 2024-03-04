**Introduction**
This README provides an overview of the Test Automation Project developed using Selenium Java with TestNG framework and Maven build tool. The purpose of this project is to automate the testing of the to-do web application(https://todomvc.com/examples/react/dist/). The project covers a set of test scenarios, including both negative and positive tests, to ensure the robustness and reliability of the application.

**Project Structure**
The project is structured as follows:
src/main/java/ToDoAssignment/ToDoAssignment: Contains the main Java source code.
src/test/java: Contains the test classes & it's implementation for automation testing. The folder has the following structure - 
  - Pages : Object Repositary containing element locators
  - test: These are the positive & negentive scenarios those have been covered
  - Utilities: The folder contains all the reusable functions & the file reading classes
  - WebActions: This contains methods for executing the test
config.properties: This files contain all the configurable parameters of the solution (e.g. URL, Browser Type etc.)
testng.xml: Contains the TestNG XML file for test execution configuration.
pom.xml: Maven configuration file for project dependencies and build settings.
target/surefire-reports: The folder contains the test reports. Please refer to "index.html" and "emailable-report.html". These reports are generated if the project is run by Maven (mvn clean test)
test-output: in case the code is run through testng.xml, the reports - "index.html" and "emailable-report.html" are generated in this folder.

**Software Vesrions**
Developer Tool: Eclipse (2023-09 (4.29.0))
Java Vesrion: java 11.0.21 2023-10-17 LTS
Selenium: 4.17.0
testng: 7.9.0

**Test Scenarios**
**Positive Tests (5 scenarios)**
- Verify that a new task can be added successfully.
- Verify that a added task can be edited successflly.
- Verify that a added task can be deleted successflly.
- Verify that  all tasks can be "Marked All Completed" successfully
- Verify that a individual task can be marked completed successfully
**Negative Tests (4 scenarios)**
- Verify that the application does not allow adding an empty task.
- Verify that the application does not allow adding a task below allowed characters (minimum 2 characters).
- Verify that the application does not show active tasks under completed task list.
- Verify that the application does not show completed tasks under active task list.

**Test Automation Framework**
- Selenium WebDriver is used for browser automation to interact with the web application under test.
- TestNG is used as the testing framework for organizing and executing test cases. It provides features such as annotations, assertions, and parameterization.
- Maven is used as the build automation tool to manage project dependencies and build processes. It simplifies project setup and dependency management.
- Test Organization : Test classes are organized based on the test scenarios they cover. Each test class focuses on a specific aspect of functionality.
- Reporting - TestNG generates detailed HTML reports automatically after test execution. These reports provide information about the test results, including passed, failed, and skipped tests. Please refer to project structure section to trace the reporting files.

**How to Run Tests**
- Clone the project repository to your local machine.
- Ensure that Java and Maven are installed on your system.
- Open a terminal or command prompt and navigate to the project directory.
- Run the following Maven command to execute the tests: mvn clean test
- After test execution, view the generated HTML reports in the target/surefire-reports directory.

**Conclusion**
The Test Automation Project provides comprehensive test coverage for the to-do web application, ensuring its functionality meets the specified requirements. The use of Selenium WebDriver with TestNG and Maven simplifies test automation and facilitates efficient test execution and reporting. By following the instructions provided, users can easily run the automated tests and analyze the test results.

For any questions or issues, please contact subhashree.P1992@gmail.com.
