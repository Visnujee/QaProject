selenium-testng-framework
A sample framework based on Page Object Model, Selenium, TestNG using Java.

This framework is based in Page Object Model (POM).

The framework uses:

Java
Selenium
TestNG


Steps to create test cases:
Let's say we want to automate login to the application.

1.login to application.
A page class typically should contain all the elements that are present on the page and corresponding action methods.

objects.properties - paremeters will be passed from below file and path :

/aspireQAtest/src/test/java/com/aspireapp/test/objects.properties

public boolean homePageLogin(String userName, String passWord) {
		try{
		driver.findElement(user_Name).sendKeys(userName);
		driver.findElement(pass_Word).sendKeys(passWord);
		driver.findElement(login_Btn).click();
		return true;
		}catch(Exception e) {
			System.out.println("Login is not successful" + e );
			return false;
		}
		}
    
2.Execute the test cases :
This project will be executed by using testNG.xml file. 


Reporting
The framework stores report in below file and path,
index.html - /aspireQAtest/test-output/index.html

Key Points:
pom.xml contains below to install all the required dependencies to run a application 

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.aspireapp.test</groupId>
  <artifactId>aspireQAtest</artifactId>
  <packaging>jar</packaging>
  <version>1.0-SNAPSHOT</version>
  <name>aspireQAtest</name>
  <url>http://maven.apache.org</url>
  <dependencies>
<!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>3.141.59</version>
</dependency>

<!-- https://mvnrepository.com/artifact/org.testng/testng -->
<dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.4.0</version>
    <scope>test</scope>
</dependency>

<!-- https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager -->
<dependency>
    <groupId>io.github.bonigarcia</groupId>
    <artifactId>webdrivermanager</artifactId>
    <version>5.0.3</version>
</dependency>

  </dependencies>
</project>
