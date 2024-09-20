<h1 align="center"> java-selenium-Project </h1>

This project is a comprehensive framework designed for web automation using Java, Selenium, and Cucumber. It integrates TestNG for test execution and Extent Reports for detailed reporting.

## 🚀 Getting Started

### Project Overview
The framework supports multiple testing scenarios, including purchase flows and error validations. It is configured to run tests in parallel, allowing for efficient and scalable test execution.

### 📝 Features

* Web Automation: Uses Selenium WebDriver for browser automation.
* Test Management: Leverages TestNG for managing test cases and suites.
* BDD Support: Incorporates Cucumber for behavior-driven development (BDD).
* Parallel Execution: Supports parallel test execution to reduce test runtime.
* Extensive Reporting: Uses ExtentReports for detailed test reports.
* Flexible Configuration: Configurable test execution through Maven profiles.

### 🚧 Prerequisites
Before you begin, ensure you have met the following requirements:

* ☕ Java Development Kit (JDK) version 21 or later
* 🧊 Apache Maven
* <p>An IDE such as <img src="https://user-images.githubusercontent.com/25181517/192108890-200809d1-439c-4e23-90d3-b090cf9a4eea.png" alt="word" width="20" height="20"> IntelliJ IDEA or <img src="https://user-images.githubusercontent.com/25181517/192108892-6e9b5cdf-4e35-4a70-ad9a-801a93a07c1c.png" alt="word" width="20" height="20"> Eclipse.</p>
* A compatible browser Google Chrome, Edge, Firefox 

### 🔗 Requirements

* Java Version: 21.0.3 - <a href="https://www.oracle.com/eg/java/technologies/downloads/" target="_blank">Java</a>
* Apache Maven: 3.9.9 - <a href="https://maven.apache.org/install.html" target="_blank">Maven</a>

### 🔗 Dependencies
This project uses the following dependencies:

* Selenium Java: 4.22.0
* Apache Maven: 3.9.9
* TestNG: 7.7.0 (test scope)
* Jackson Databind: 2.17.2
* Extent Reports: 5.1.2
* Cucumber: 7.18.1

### 🖍 Patterns
  * Page Object
  * PageFactory
    
### 🌐 Application under test

* https://rahulshettyacademy.com/client
  __Note:__ This website has been taken from a course and it's published for learning purpose. The author is contact@rahulshettyacademy.com

### 🛠️ Installation  

1. Clone this repository to your local machine.
   ```
   git clone https://github.com/Zeyad222/java-selenium-Project.git
   ```
2. Navigate to the project directory using the command line.
   ```
   cd SeleniumFrameWorkDesign
   ```  
3. Install the dependencies and run the smoke test plan (configured).
   ```
   mvn clean install
   ```

### ⚙️ Configuration
Configure your test environment by editing the testng.xml and profile-specific XML files located in the testSuites directory. Make sure to set up your WebDriver paths and other necessary configurations in these files.

### 🧪 How to run tests

1. Using IntelliJ IDEA

   * Go to Maven Profiles
   * Write/change the desired browser (chrome, edge, firefox) Maven Profile as the browser from `src/main/java/resources/GlobalData.properties`. Check the BaseTest class for more declaration.
   * Select the test classes on the `src/test/java/tests/ "desired test"` and for TestNG `testSuites/` directory.
   * Right-click and click on Run
     
2. Using Command Line

   * To run the test suite in browser 
     ```
     mvn test -P"profile-name" -Dbrowser="browser-name"
     ```
   * To run the TestNG XML files.
     ```
     mvn test -P"profile-name" -Dbrowser="browser-name"
     ```
   * For example you can run tests using Maven commands with specific profiles:

     * Run Regression Tests:
       ```
       mvn test -PRegression -Dbrowser="browser-name"
       ```
     * Run Purchase Tests:
       ```
       mvn test -PPurchase -Dbrowser="edge"
       ```
     * Run Error Validation Tests:
       ```
       mvn test -PErrorValidation -Dbrowser="chrome"
       ```
     * Run Cucumber Tests:
       ```
       mvn test -PCucumberTests -Dbrowser="firefox"
       ```
       
### 📝 Reports
   `By running the test the report files will be generated`
  * To view `Extent Report` of test, access the file: `/report/index.html`
  * To view `Extent Report` of test, access the file: `/target/cucumber.html`

### 👥 Contributing
Feel free to fork the project and submit pull requests. All contributions are welcome. Ensure that your changes align with the existing coding style and structure. Additionally, please update any relevant documentation if necessary.

   * Steps to Contribute:
     * Option 1: 
          1. Fork the repository.
          2. Create a new branch (`git checkout -b feature-branch`).
          3. Make your changes and commit them (`git commit -am 'Add new feature'`).
          4. Push to the branch (`git push origin feature-branch`).
          5. Create a pull request.
         
     * Option 2:
          * :bowtie: Clone this repository to your local machine.
