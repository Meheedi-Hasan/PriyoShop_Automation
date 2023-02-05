# PriyoShop_Web_Automation

### This is a project where an [E-commerce site](https://priyoshop.com/) is automated by writing test suites using selenium-webdriver and TestNg as testing framework.

#### The following key modules/pages are automated:

  * Login
  * Search
  * Cart
  * Checkout

### Technology:

  * Tool: Selenium Webdriver
  * IDE: Intellij IDEA
  * Build tool: Gradle
  * Language: Java
  * Testing Framework : TestNG

### Prerequisite:

  * Need to install jdk 11, gradle and allure
  * Configure Environment variable for jdk 11, gradle and allure
  * Clone this project and unzip it
  * Open the project folder
  * Double click on "build.gradle" and open it through IntellIJ IDEA
  * Let the project build successfully
  * Click on "Terminal" and run the automation scripts
  
### Run the Automation Script by the following command:
```
gradle clean test
````
  * Selenium will open the browser and start automating.
  * After automation to view allure report , give the following commands:
```
allure generate allure-results --clean -o allure-report
allure serve allure-results
```
<!--
### Below is my allure overview report:
  <img src="https://drive.google.com/file/d/1FQUHhDi5miRXeNQJKiOh5fUQqkOFMYG5/view?usp=sharing" alt="alllure overview report" width="350">

### Here are the suites of this project:

![Suites of this project](https://drive.google.com/file/d/1E9kL-TZ9f2uohsWfaie8CEMTXsiw8eEU/view?usp=sharing)
-->
