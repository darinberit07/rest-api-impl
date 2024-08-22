# REST API Implementation - Employee Management (CRUD)
This Employee Management project is a Spring Boot application designed to manage employee data. It provides a RESTful API to perform CRUD (Create, Read, Update, Delete) operations on employee records, and interacts with a MySQL database to persist data.

## Features
**Add New Employee:** Allows adding new employee records with details such as name, department, and salary.  
**View employee:** View an employee details using their ID.  
**View Employee List:** Retrieve a list of all employees stored in the database.  
**View Employee Lists based on parameters:** Retrieve a list of employees based on grade, designation.  
**Update Employee Details:** Modify existing employee details.  
**Delete Employee:** Remove an employee record from the system.  
**Delete ALL Employees** Removes the entire records from the database.

**Security** 
- Spring Security implemented with username-password login
- **"/register"** endpoint registers a new user with username and password credentials, which is used to login

## Technologies Used
- **Java 17**: Core programming language.
- **Spring Boot 3.3.x**: Framework used to build the application.
- **Spring Data JPA**: For database access and ORM.
- **MySQL**: Database used for storing employee records.
- **Apache Maven 3.9.7**: Dependency management.
- **JUnit 5**: For unit testing the application.

## API Endpoints
- **GET** /employee/get/id/{id}
- **GET** /employee/get/all
- **GET** /employee/get/designation?desgn={desgn}
- **GET** /employee/get/grade?grade={grade}
- **POST** /employee/add/new
- **PUT** /employee/update/id/{id}
- **DELETE** /employee/delete/id/{id}
- **DELETE ALL** /employee/delete/all

- **Register User** /register
