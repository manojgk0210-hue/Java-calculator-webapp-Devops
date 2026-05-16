# Calculator Web Application

Production-style Spring Boot calculator REST API packaged as a WAR web application. Built with Java 21, Maven, layered architecture, validation, exception handling, logging, unit tests, controller tests, and integration tests.

## Technology Stack

- Java 21
- Spring Boot 3.x
- Maven
- Spring Boot Starter Web
- WAR packaging for Tomcat deployment
- Spring Boot Starter Validation
- Lombok
- JUnit 5
- Mockito
- MockMvc
- SLF4J with Logback

## Project Structure

```text
src/
  main/
    java/com/example/calculator/
      config/
      controller/
      dto/
      exception/
      service/
      util/
      CalculatorApplication.java
    resources/
      application.properties
      logback-spring.xml
  test/
    java/com/example/calculator/
      controller/
      integration/
      service/
      CalculatorApplicationTests.java
```

## REST APIs

| Method | Endpoint | Description |
| --- | --- | --- |
| GET | `/api/v1/calculator/health` | Health check |
| POST | `/api/v1/calculator/add` | Addition |
| POST | `/api/v1/calculator/subtract` | Subtraction |
| POST | `/api/v1/calculator/multiply` | Multiplication |
| POST | `/api/v1/calculator/divide` | Division |
| POST | `/api/v1/calculator/modulus` | Modulus |
| POST | `/api/v1/calculator/power` | Power calculation |
| POST | `/api/v1/calculator/sqrt` | Square root |

## Request Examples

Binary operations:

```json
{
  "number1": 10,
  "number2": 5
}
```

Square root:

```json
{
  "number": 16
}
```

## Response Example

```json
{
  "status": "SUCCESS",
  "message": "Operation completed successfully",
  "result": 15,
  "timestamp": "2026-05-16T10:30:00"
}
```

## Validation Rules

- `number1` cannot be null for binary operations.
- `number2` cannot be null for binary operations.
- Division by zero returns `400 Bad Request`.
- Modulus by zero returns `400 Bad Request`.
- Square root of negative numbers returns `400 Bad Request`.
- Malformed JSON returns `400 Bad Request`.

## Maven Commands

Clean the project:

```bash
mvn clean
```

Compile the project:

```bash
mvn clean compile
```

Run tests:

```bash
mvn test
```

Package the WAR web application:

```bash
mvn clean package
```

## Run The Application

Using Maven:

```bash
mvn spring-boot:run
```

Using the packaged WAR:

```bash
java -jar target/calculator-web-application-0.0.1-SNAPSHOT.war
```

Deploy to external Tomcat:

```text
Copy target/calculator-web-application-0.0.1-SNAPSHOT.war into the Tomcat webapps directory.
```

The application starts on:

```text
http://localhost:8080
```

## Curl Commands

Health:

```bash
curl -X GET http://localhost:8080/api/v1/calculator/health
```

Addition:

```bash
curl -X POST http://localhost:8080/api/v1/calculator/add \
  -H "Content-Type: application/json" \
  -d '{"number1":10,"number2":5}'
```

Subtraction:

```bash
curl -X POST http://localhost:8080/api/v1/calculator/subtract \
  -H "Content-Type: application/json" \
  -d '{"number1":10,"number2":5}'
```

Multiplication:

```bash
curl -X POST http://localhost:8080/api/v1/calculator/multiply \
  -H "Content-Type: application/json" \
  -d '{"number1":10,"number2":5}'
```

Division:

```bash
curl -X POST http://localhost:8080/api/v1/calculator/divide \
  -H "Content-Type: application/json" \
  -d '{"number1":10,"number2":5}'
```

Modulus:

```bash
curl -X POST http://localhost:8080/api/v1/calculator/modulus \
  -H "Content-Type: application/json" \
  -d '{"number1":10,"number2":3}'
```

Power:

```bash
curl -X POST http://localhost:8080/api/v1/calculator/power \
  -H "Content-Type: application/json" \
  -d '{"number1":2,"number2":8}'
```

Square root:

```bash
curl -X POST http://localhost:8080/api/v1/calculator/sqrt \
  -H "Content-Type: application/json" \
  -d '{"number":16}'
```

## Example Postman Requests

Create a Postman collection with the following base URL:

```text
http://localhost:8080
```

Use `Content-Type: application/json` for all POST requests.

| Request Name | Method | URL | Body |
| --- | --- | --- | --- |
| Health Check | GET | `{{baseUrl}}/api/v1/calculator/health` | None |
| Add | POST | `{{baseUrl}}/api/v1/calculator/add` | `{ "number1": 10, "number2": 5 }` |
| Subtract | POST | `{{baseUrl}}/api/v1/calculator/subtract` | `{ "number1": 10, "number2": 5 }` |
| Multiply | POST | `{{baseUrl}}/api/v1/calculator/multiply` | `{ "number1": 10, "number2": 5 }` |
| Divide | POST | `{{baseUrl}}/api/v1/calculator/divide` | `{ "number1": 10, "number2": 5 }` |
| Modulus | POST | `{{baseUrl}}/api/v1/calculator/modulus` | `{ "number1": 10, "number2": 3 }` |
| Power | POST | `{{baseUrl}}/api/v1/calculator/power` | `{ "number1": 2, "number2": 8 }` |
| Square Root | POST | `{{baseUrl}}/api/v1/calculator/sqrt` | `{ "number": 16 }` |

## Design Notes

- No database, JPA, or Hibernate is used.
- All state is in memory and calculations are stateless.
- Controllers only handle HTTP concerns.
- Business rules are implemented in the service layer.
- DTOs isolate the API contract from implementation details.
- Global exception handling keeps error responses consistent.
- Constructor-based dependency injection is used throughout.
