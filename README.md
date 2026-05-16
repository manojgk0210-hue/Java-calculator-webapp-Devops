# 🧮 Calculator Web App — Spring Boot

A simple calculator web application built with **Spring Boot**. Enter two numbers and perform basic arithmetic operations right from the browser.

---

## 💡 Why I Built This

When practising DevOps, I kept running into problems using other people's GitHub repositories:

- Package and dependency **versions were outdated or mismatched**
- I had to **edit their config files** just to get things running
- More time was spent troubleshooting others' code than learning DevOps

So I built my own simple project. That way, when I deploy to the cloud, I fully understand the codebase, and everything is up to date from the start.

---

## ✨ Features

- Enter **two numbers** via a web form
- Choose an operation: **Add, Subtract, Multiply, Divide**
- Instant result displayed on the page
- **Unit tests** written to verify each operation

---

## 🛠️ Tech Stack

| Layer      | Technology        |
|------------|-------------------|
| Language   | Java              |
| Framework  | Spring Boot       |
| Build Tool | Maven / Gradle    |
| Testing    | JUnit             |
| Frontend   | HTML (Thymeleaf)  |

---

## 🚀 Getting Started

### Prerequisites

- Java 17+
- Maven or Gradle installed

### Run Locally

```bash
# Clone the repo
git clone https://github.com/your-username/calculator-app.git
cd calculator-app

# Run the app
./mvnw spring-boot:run
```

Then open your browser and go to: `http://localhost:8080`

---

## 🧪 Running Tests

```bash
./mvnw test
```

All calculator operations (add, subtract, multiply, divide) are covered by unit tests.

---

## 📁 Project Structure

```
src/
├── main/
│   ├── java/         # Controller & Service logic
│   └── resources/    # Templates & config
└── test/
    └── java/         # Unit tests
```

---

## ☁️ Purpose

This project is built specifically for **DevOps practice** — including:

- Containerising with **Docker**
- Setting up **CI/CD pipelines**
- Deploying to a **cloud platform** (AWS / GCP / Azure)

Having my own project makes this process smoother and more enjoyable.

---

## 📄 License

This project is open source and free to use.
