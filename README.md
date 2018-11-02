## Tech Stack
* Test Framework: TestNG
* Build Tool: Gradle
* Browser Automation: Selenium WebDriver
* Selenium WebDriver Binaries Management: [WebDriverManager](https://github.com/bonigarcia/webdrivermanager)
* YAML Processor: [SnakeYAML](https://bitbucket.org/asomov/snakeyaml)

## Requirements
* Java 8

## How to run
``./gradlew test``

It gets the test data from **flights.yaml** which is under _src/test/resources_
You do not need to deal Browser Drivers. WebDriverManager handles browser binaries for you.
If you would like to run test on Firefox, then update following code in BaseTest class to

``WebDriverManager.getInstance(FIREFOX).setup();``

