# Employee Performance Management API

A Spring Boot RESTful API for managing and retrieving employee performance, projects, and department data.  
This application uses **Spring Boot**, **Spring Data JPA**, **H2 Database**, and **Swagger** for API documentation.

---

## 🚀 Features

- 📄 View list of employees with filters:
  - Review score + review date
  - Multiple department names
  - Multiple project names
- 🔍 Fetch full employee details by ID:
  - Basic info
  - Department
  - All assigned projects
  - Last 3 performance reviews
- 🗃️ In-memory H2 database with sample data
- 🔧 Swagger UI for interactive testing

---

## 📦 Tech Stack

| Layer        | Technology                         |
|--------------|------------------------------------|
| Language     | Java 17+                           |
| Framework    | Spring Boot 3.x                    |
| ORM          | Spring Data JPA + Hibernate        |
| Database     | H2 (in-memory)                     |
| Docs         | Swagger (Springdoc OpenAPI 3)      |
| Build Tool   | Maven                              |
| IDE Support  | IntelliJ / VS Code with Lombok     |

---

## 🏗️ Project Structure

src/main/java/com/example/empperfapi
├── controller → REST API layer
├── dto → Data Transfer Objects
├── model → JPA entity classes
├── repository → Spring Data JPA interfaces
├── service → Business logic layer
└── EmpPerfApiApplication.java

---

## ⚙️ Getting Started

### ✅ Prerequisites

- JDK 17 or higher
- Maven 3.6+
- IntelliJ / VS Code with Lombok Plugin
