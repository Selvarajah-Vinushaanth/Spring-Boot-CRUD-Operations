# Spring Boot Demo Application

A RESTful web service built with Spring Boot framework for user management.

## Description

This is a Spring Boot application that provides a complete REST API for user management with MySQL database integration. It demonstrates CRUD operations, JPA repositories, exception handling, and API documentation with Swagger.

## Prerequisites

- Java 21 or higher
- Maven 3.6+
- MySQL 8.0+
- Git

## Installation

1. Clone the repository:
```bash
git clone <repository-url>
cd springboot/demoapp
```

2. Configure MySQL database:
   - Create a database named `spring-boot-demo`
   - Update credentials in `src/main/resources/application.properties` if needed

3. Build the application:
```bash
./mvnw clean install
```

## Usage

Run the application:
```bash
./mvnw spring-boot:run
```

The application will start on `http://localhost:8080`

## API Documentation

The application provides interactive API documentation using Swagger UI:

![Swagger API Documentation](.src/images/Screenshot 2025-08-03 104353.png)

### Available Endpoints
- `GET /api/users` - Get all users
- `GET /api/users/{id}` - Get user by ID
- `POST /api/users` - Create a new user
- `PUT /api/users/{id}` - Update user by ID
- `DELETE /api/users/{id}` - Delete user by ID

### Access API Documentation
- Swagger UI: `http://localhost:8080/swagger-ui.html`
- OpenAPI JSON: `http://localhost:8080/v3/api-docs`

## Project Structure

```
springboot/
├── demoapp/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/vinu/demoapp/
│   │   │   │   ├── controllers/        # REST controllers
│   │   │   │   ├── entity/            # JPA entities
│   │   │   │   ├── exceptions/        # Custom exceptions
│   │   │   │   ├── model/            # Data models
│   │   │   │   ├── repository/       # JPA repositories
│   │   │   │   └── DemoappApplication.java
│   │   │   └── resources/
│   │   │       └── application.properties
│   │   └── test/
│   ├── target/                       # Build output
│   ├── .mvn/wrapper/                # Maven wrapper
│   ├── pom.xml                      # Maven configuration
│   └── README.md
└── images/                          # Documentation images
    └── swagger-api-docs.png
```

## Features

- RESTful API for user management
- MySQL database integration with JPA/Hibernate
- Custom exception handling
- Interactive API documentation with Swagger/OpenAPI
- Maven build system
- Spring Boot DevTools for development

## Database Configuration

The application uses MySQL database with the following default configuration:
- Database: `spring-boot-demo`
- Username: `vinu`
- Password: `123`
- Port: `3306`

Update `src/main/resources/application.properties` to change these settings.

## Sample API Requests

### Create a User
```bash
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{"name": "John Doe", "email": "john@example.com"}'
```

### Get All Users
```bash
curl -X GET http://localhost:8080/api/users
```

### Get User by ID
```bash
curl -X GET http://localhost:8080/api/users/1
```

### Update User
```bash
curl -X PUT http://localhost:8080/api/users/1 \
  -H "Content-Type: application/json" \
  -d '{"name": "Jane Doe", "email": "jane@example.com"}'
```

### Delete User
```bash
curl -X DELETE http://localhost:8080/api/users/1
```

## Contributing

1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is open source and available under the [MIT License](LICENSE).
