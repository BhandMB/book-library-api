# 📚 Book Library REST API

[![CI](https://github.com/BhandMB/book-library-api/actions/workflows/ci.yml/badge.svg)](https://github.com/BhandMB/book-library-api/actions/workflows/ci.yml)
[![Java 17](https://img.shields.io/badge/Java-17-orange?logo=openjdk)](https://www.oracle.com/java/)
[![Spring Boot 3.1.11](https://img.shields.io/badge/Spring%20Boot-3.1.11-6DB33F?logo=springboot)](https://spring.io/projects/spring-boot)

A production-style RESTful API for managing a book library, built with **Java 17, Spring Boot 3.1.11, Spring Data JPA, Hibernate, H2, Jakarta Validation, and OpenAPI/Swagger**.

The project demonstrates layered backend architecture, CRUD operations, search and filtering, pagination, validation, exception handling, API documentation, seed data, and automated testing with MockMvc.

## 🚀 Highlights

- Full CRUD for books
- Pagination and sorting
- Search by title, author, or genre
- Filtering by author, genre, availability, and minimum rating
- ISBN lookup
- Toggle book availability
- Jakarta Bean Validation
- Centralized exception handling
- Swagger/OpenAPI documentation
- H2 database with seed data
- Unit and integration tests using MockMvc
- Maven build and GitHub Actions CI

## 🏗️ Architecture

```text
┌──────────────────────┐
│       Client         │
│ Browser / Postman    │
└──────────┬───────────┘
           │ HTTP / JSON
           ▼
┌──────────────────────┐
│    REST Controller   │
│    BookController    │
└──────────┬───────────┘
           ▼
┌──────────────────────┐
│     Service Layer    │
│      BookService     │
└──────────┬───────────┘
           ▼
┌──────────────────────┐
│   Repository Layer   │
│    BookRepository    │
└──────────┬───────────┘
           ▼
┌──────────────────────┐
│      H2 Database     │
│    JPA / Hibernate   │
└──────────────────────┘

Cross-cutting: DTOs • Validation • Exception Handling • OpenAPI
```

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 17 |
| Framework | Spring Boot 3.1.11 |
| Web | Spring MVC / REST |
| Persistence | Spring Data JPA + Hibernate |
| Database | H2 (in-memory) |
| Validation | Jakarta Bean Validation |
| API Docs | SpringDoc OpenAPI / Swagger |
| Build | Maven |
| Testing | JUnit + MockMvc |
| CI | GitHub Actions |

## 📁 Project Structure

```text
src/main/java/
└── .../booklibrary/
    ├── controller/      # REST endpoints
    ├── service/         # Business logic
    ├── repository/      # Data access
    ├── dto/             # API request/response models
    ├── entity/          # JPA entities
    ├── exception/       # Error handling
    └── config/          # Configuration

src/test/
└── ...                  # Unit and MockMvc integration tests
```

## 📖 Complete API

Base URL: `http://localhost:8080`

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/v1/books` | Get books with pagination and sorting |
| GET | `/api/v1/books/{id}` | Get a book by ID |
| GET | `/api/v1/books/isbn/{isbn}` | Find a book by ISBN |
| POST | `/api/v1/books` | Create a book |
| PUT | `/api/v1/books/{id}` | Update a book |
| DELETE | `/api/v1/books/{id}` | Delete a book |
| GET | `/api/v1/books/search?query={query}` | Search books |
| GET | `/api/v1/books/author/{author}` | Filter by author |
| GET | `/api/v1/books/genre/{genre}` | Filter by genre |
| GET | `/api/v1/books/available` | Get available books |
| GET | `/api/v1/books/rating?minRating={rating}` | Filter by minimum rating |
| PATCH | `/api/v1/books/{id}/toggle-availability` | Toggle availability |

### Pagination & Sorting

`GET /api/v1/books` supports:

| Parameter | Default | Description |
|---|---:|---|
| `page` | `0` | Zero-based page number |
| `size` | `10` | Page size; maximum 100 |
| `sort` | `id,asc` | Field and direction |

Example:

```text
GET /api/v1/books?page=0&size=10&sort=title,asc
```

Supported sort fields include `id`, `title`, `author`, `publishedYear`, `genre`, `rating`, `createdAt`, and `updatedAt`.

### Create Book

```http
POST /api/v1/books
Content-Type: application/json
```

```json
{
  "title": "Clean Architecture",
  "author": "Robert C. Martin",
  "isbn": "9780134494166",
  "publishedYear": 2017,
  "genre": "Technology",
  "rating": 4.6,
  "description": "A guide to software structure and design.",
  "available": true
}
```

### Update Book

```http
PUT /api/v1/books/{id}
Content-Type: application/json
```

Use the book JSON structure shown above.

### Toggle Availability

```http
PATCH /api/v1/books/{id}/toggle-availability
```

### Error Handling

Invalid requests return structured JSON validation errors. Missing resources and application errors are handled through centralized exception handling.

## 🔎 Swagger & H2 Console

After starting the application:

- **Swagger UI:** `http://localhost:8080/swagger-ui.html`
- **OpenAPI JSON:** `http://localhost:8080/v3/api-docs`
- **H2 Console:** `http://localhost:8080/h2-console`

H2 configuration:

```text
JDBC URL: jdbc:h2:mem:bookdb
Username: sa
Password: <empty>
```

## ▶️ Getting Started

### Prerequisites

- JDK 17+
- Maven 3.8+

### Run

```bash
git clone https://github.com/BhandMB/book-library-api.git
cd book-library-api
mvn spring-boot:run
```

The application starts on port `8080`.

## 🧪 Testing

The project includes **unit and integration tests using MockMvc**. These tests exercise HTTP endpoints and application behavior without requiring a separately deployed server.

Run the test suite:

```bash
mvn test
```

Build the application:

```bash
mvn clean package
```

## ⚙️ Continuous Integration

GitHub Actions runs the Maven test suite automatically on pushes and pull requests. The workflow uses **JDK 17**, caches Maven dependencies, and fails when the build or tests fail.

## 📌 What This Project Demonstrates

- REST API design
- Layered architecture
- Dependency injection
- DTO/entity separation
- JPA/Hibernate persistence
- Validation and exception handling
- Pagination and sorting
- Automated API testing with MockMvc
- OpenAPI documentation
- Maven builds
- GitHub Actions CI

## 📄 License

This project is licensed under the MIT License.

---

⭐ If you find this project useful, consider giving it a star.