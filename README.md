#  Calculator Web App — Spring Boot

A simple calculator web application built with **Spring Boot**. Enter two numbers and perform basic arithmetic operations right from the browser.

> **Purpose:** This project is built to practice real-world **DevOps workflows** — Maven builds, unit testing, WAR deployment on Tomcat, code quality checks with SonarQube, artifact storage in Nexus, containerisation with Docker, CI/CD pipelines, and cloud deployment on AWS / GCP / Azure.

---

## Why I Built This

When practising DevOps, I kept running into problems using other people's GitHub repositories:

- Package and dependency **versions were outdated or mismatched**
- I had to **edit their config files** just to get things running
- More time was spent troubleshooting others' code than learning DevOps

So I built my own simple project. That way, when I deploy to the cloud, I fully understand the codebase, and everything is up to date from the start.

---

##  Features

- Enter **two numbers** via a web form
- Choose an operation: **Add, Subtract, Multiply, Divide**
- Instant result displayed on the page
- **Unit tests** written to verify each operation

---

##  Tech Stack

| Layer      | Technology       |
|------------|------------------|
| Language   | Java 26.0.1      |
| Framework  | Spring Boot 3.3.5 |
| Build Tool | Maven 3.9.15     |
| Testing    | JUnit 5          |
| Frontend   | HTML (Thymeleaf) |

---

##  Getting Started

### Prerequisites

- Java 26.0.1
- Maven 3.9.15

### Run Locally

```bash
# Clone the repo
git clone https://github.com/manojgk0210-hue/Java-calculator-webapp-Devops.git
cd Java-calculator-webapp-Devops

# Run the app
./mvnw spring-boot:run
```

Then open your browser and go to: `http://localhost:9090`

> Port can be changed in `src/main/resources/application.properties`

---

##  Running Tests

```bash
./mvnw test
```

All calculator operations (add, subtract, multiply, divide) are covered by unit tests.

---

## Project Structure

```
src/
├── main/
│   ├── java/com/example/calculator/
│   │   ├── config/        # App configuration
│   │   ├── controller/    # HTTP request handlers
│   │   ├── dto/           # Data Transfer Objects
│   │   ├── exception/     # Custom exceptions
│   │   ├── service/       # Business logic
│   │   └── util/          # Utility/helper classes
│   └── resources/
│       └── static/        # Frontend files (HTML, CSS, JS)
├──test/
│     └── java/com/example/calculator/
│         ├── controller/    # Controller tests
│         ├── integration/   # Integration tests
│         └── service/       # Service unit tests
└── pom.xml

```

---

## DevOps Practice Goals

This project is built specifically for **DevOps practice** — including:

- How Maven works on servers
- How unit tests pass — and how to skip them when needed
- Deploying a `.war` file on a **Tomcat** server
- Code quality checks with **SonarQube**
- Storing build artifacts in **Nexus**
- Containerising with **Docker**
- Setting up **CI/CD pipelines**
- Deploying to a cloud platform (**AWS / GCP / Azure**)

Having my own project makes this process smoother and more enjoyable.

---

##  License

This project is open source and free to use.
