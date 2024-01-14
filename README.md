# LeaveApp - College Leave Management System

LeaveApp is a web application designed to streamline the leave request process within college departments. It consists of two modules - one for students and another for the Head of the Department (HOD). The application allows HODs to manage students, handle leave requests, and provides students with a platform to submit and track their leave applications.

## Features

### HOD Module
- Add and update student profiles.
- View and manage leave requests submitted by students.
- Approve or reject leave requests based on department policies.
- Password recovery and change functionalities.

### Student Module
- Receive login credentials via email.
- Submit and track leave requests.
- Update personal details.
- Change passwords securely.

## Setup Steps

### Prerequisites
- NetBeans 8.2
- JDK 1.8u202
- MySQL 5.1
- JSP, Servlets, HTML, CSS, JavaScript
- Git

### Instructions
1. Clone the repository:
    ```bash
    git clone https://github.com/rohitkalampatil/LeaveApp.git
    cd LeaveApp
    ```

2. Open the project in NetBeans 8.2.

3. Set up the MySQL database:
   - Create a new database and execute the SQL script provided in the `Database_Script.sql` file.

4. Configure database connection:
   - Open `src/java/util/DatabaseUtil.java` and update the database connection parameters.

5. Add required libraries:
   - Download the following JAR files:
     - [mail.jar](https://github.com/javaee/javamail/releases)
     - [activation.jar](https://javaee.github.io/javamail/)
     - [sqlconnector.jar](https://dev.mysql.com/downloads/connector/j/)

   - Copy these JAR files to the `lib` folder in your project.

6. Build and run the project.

7. Access the application in your web browser at `http://localhost:8080/LeaveApp`.

## Libraries

- [JavaMail API](https://javaee.github.io/javamail/) - For email functionalities.
- [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/) - JDBC driver for MySQL.
- [Apache Tomcat](http://tomcat.apache.org/) - Servlet container for running the application.

## Contribution Guidelines

If you wish to contribute to this project, please follow these steps:

1. Fork the repository.
2. Clone your fork locally.
3. Make your changes.
4. Test thoroughly.
5. Commit and push your changes.
6. Submit a pull request.

Thank you for contributing to LeaveApp!
