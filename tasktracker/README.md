# Spring Boot Project

This is a Spring Boot project using Spring Web and Spring Data JPA.

## Prerequisites

- JDK 21 (Required - confirmed from pom.xml)
- PostgreSQL Database
- IntelliJ IDEA or Cursor IDE with Java development support

## Getting Started

### Database Setup
This project requires a PostgreSQL database as shown in the tutorial: 
[Spring Boot Tutorial for this project: How to use cursor IDE in java spring development]( https://youtu.be/kDVRfzd1Ie8 )

### Opening the Project

1. Open IntelliJ IDEA or Cursor IDE
2. Select "Open" or "Open Project" from the welcome screen
3. Navigate to the project directory and select it
4. Wait for the IDE to import and index the project
5. The IDE should automatically detect it as a Maven project and download dependencies

### Running the Application

There are several ways to run the application:

#### Using Cursor IDE
1. Navigate to the main class (annotated with @SpringBootApplication)
2. Right-click and select "Run" or click the green play button in the gutter
3. The application will start and be available at http://localhost:8080

#### Using Maven Command Line
1. Open a terminal in the project root directory
2. Run the following command to install dependencies:
   ```bash
   mvn clean install
   ```
3. After successful build, the application will be packaged as a JAR file in the target directory



