# TechEazy-Assignment

## Overview
This project is a Spring Boot application that provides APIs  for managing students and subjects. It utilizes H2 in-memory database for data storage and implements JWT-based authentication.

## Prerequisites
- Java 17 or higher
- Apache Maven
- Git (optional, for cloning the repository)

## Getting Started

### Clone the Repository
To get started, clone the repository to your local machine using the following command:

```bash
git clone https://github.com/pawaradvait/assignment-TechEazy
cd assignment-TechEazy
```

### Build the Project
Navigate to the project directory and build the project using Maven:

```bash
./mvnw clean install
```





### Run the Application
You can run the application using the following command:

```bash
./mvnw spring-boot:run
```

### Access the Application
Once the application is running, you can access the H2 console at:
```
http://localhost:8080/h2-console/
```
Use the following credentials to log in:
- **JDBC URL**: `jdbc:h2:mem:testdb`
- **User Name**: `sa`
- **Password**: (leave blank)

### add Admin User by Wrting sql script in h2-console
 `PASSWORD` IS :- 1234  
 `USERNAME` IS :- pawaradvait2003@gmail.com
```sql
INSERT INTO `STUDENT` (`NAME`, `PASSWORD`, `ROLE`, `ADDRESS`, `EMAIL`) 
VALUES ('advait', '{bcrypt}$2a$10$MvlGoh6NJqFKNu8TQOa2veua36QrCXJ8zO7uAr4.tg36mQAJpnGoC', 'ROLE_ADMIN', 'mumbai', 'pawaradvait2003@gmail.com');
```



### API Endpoints
The following API endpoints are available:
put prefrex :- `http://localhost:8080`

- *POST `/api/login`*: Authenticate a user and receive a JWT token.
- *POST `/api/student`*: Add a new student  - registration.
- *POST `/api/subject`*: Add a new subject  (requires authentication) - role ->ADMIN required.
- *GET `/api/getAllStudents`*: Retrieve all students (requires authentication) - role ->ADMIN required.
- *GET `/api/getAllSubject`*: Retrieve all subjects (requires authentication) - role ->ADMIN required.


 ### Postman Collection

A Postman collection for API testing is available in the `postman` folder of this repository. To use it:

1.Open Postman.

2.Import the collection:

3.Go to File -> Import.

4.Select postman/techeasy.postman_collection.json.

Use the requests in the collection to test the APIs.



