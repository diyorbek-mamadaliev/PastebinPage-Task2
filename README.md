**By Diyorbek Mamadaliev**

# PastebinPage - Selenium Automation Project

This project demonstrates how to use Selenium WebDriver with JUnit for automated web testing using Google Chrome. It provides a simple example of interacting with the Pastebin website.

## Prerequisites

Before you begin, make sure you have the following prerequisites installed:

- **Java Development Kit (JDK)**: Ensure that you have Java Development Kit 21 or higher installed on your system.

- **Google Chrome**: Make sure you have Google Chrome Version 114.0.5938.92 and above installed on your machine.

- **Maven**: Ensure that you have Apache Maven installed. This project uses Maven for dependency management and build automation.

## Project Setup

1. **Clone the Repository**: Clone this repository to your local machine or download it as a ZIP archive and extract it.

2. **Maven Dependencies**: The project uses Maven to manage its dependencies. The necessary dependencies are already specified in the `pom.xml` file.

   ```xml
   <dependencies>
       <!-- Selenium WebDriver -->
       <dependency>
           <groupId>org.seleniumhq.selenium</groupId>
           <artifactId>selenium-java</artifactId>
           <version>4.12.1</version>
       </dependency>

       <!-- JUnit 5 for Testing -->
       <dependency>
           <groupId>org.junit.jupiter</groupId>
           <artifactId>junit-jupiter-api</artifactId>
           <version>5.8.1</version>
           <scope>test</scope>
       </dependency>
   </dependencies>
