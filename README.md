# Spring-Hibernate-JPA-CRUD
A Spring Boot application demonstrating CRUD operations using Hibernate and JPA with a MySQL database.

# Spring Boot CRUD Application with Hibernate & MySQL
This is a simple Spring Boot CRUD application that uses Hibernate and JPA to manage student records. It connects to a MySQL database, allowing for basic operations such as creating, reading, updating, and deleting records from a `student` table.

## Features
- Implements CRUD operations for `Student` entities
- Uses Hibernate and JPA for ORM (Object-Relational Mapping)
- Connects to MySQL to persist data
- Provides a command-line interface for running different CRUD operations

## Project Structure
The project includes the following key files:
- `Student.java`: Entity class representing the `Student` table in the database.
- `StudentDAO.java`: Interface defining CRUD methods for `Student`.
- `StudentDAOImpl.java`: Implementation of `StudentDAO` using JPA's `EntityManager`.
- `CrudApplication.java`: Main application class that sets up and runs the CRUD operations.
- `application.properties`: Configuration file for the Spring Boot application and database connection.

## Prerequisites

### Java
- Ensure you have Java 17 or higher installed.

### MySQL and MySQL Workbench
- Download and install MySQL Community Edition and MySQL Workbench if not already installed.

#### Installation Instructions:
1. [Download MySQL Community Edition](https://dev.mysql.com/downloads/mysql/)
2. [Download MySQL Workbench](https://dev.mysql.com/downloads/workbench/)

### Spring Boot
- [Install Spring Boot](https://spring.io/guides/gs/spring-boot/)

## Setting Up MySQL

## Ensure the database name, username, and password match those you created in MySQL.

1. **Start the MySQL Server**: Once MySQL is installed, start the MySQL server using MySQL Workbench or your terminal.

2. **Create a Database**:
    - Open MySQL Workbench.
    - Connect to your MySQL server.
    - Run the following SQL command to create a new database for this application:
      ```sql
      CREATE DATABASE student_tracker;
      ```

3. **Create a MySQL User and Grant Permissions**:
    - Run the following commands to create a new user and grant it access to the `student_tracker` database:
      ```sql
      CREATE USER 'springrest'@'localhost' IDENTIFIED BY 'springrest';
      GRANT ALL PRIVILEGES ON student_tracker.* TO 'springrest'@'localhost';
      FLUSH PRIVILEGES;
      ```

## Configuring the Application

In `src/main/resources/application.properties`, configure the following settings to connect your Spring Boot application to MySQL:

```properties
spring.application.name=crud
spring.datasource.url=jdbc:mysql://localhost:3306/student_tracker
spring.datasource.username=springrest
spring.datasource.password=springrest

# Optional settings
spring.main.banner-mode=off  # Disables the Spring Boot startup banner
logging.level.root=warn      # Reduces logging verbosity

## Running the Application
1. Clone the Repository:
git clone https://github.com/yourusername/spring-boot-crud
cd spring-boot-crud

2. Build the Application: Use Maven to build the project:
mvn clean install

3. Run the Application: Start the application using the Spring Boot command:
mvn spring-boot:run

4. Perform CRUD Operations:
The application will run and execute the CRUD operations defined in CrudApplication.java. Modify the file to select the operations you want to perform.

## CRUD Operations in CommandLineRunner
In CrudApplication.java, you’ll find a CommandLineRunner bean that defines various CRUD operations such as creating, reading, updating, and deleting records. Uncomment specific method calls to test each operation.

## License
This project is licensed under the MIT License.

## Acknowledgements
This project was developed using:
1. Spring Boot
2. Hibernate & JPA
3. MySQL
