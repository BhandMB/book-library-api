# 📚 Book Library REST API

A production-ready RESTful API for managing a book library, built with **Spring Boot 3**, **Spring Data JPA**, and **H2** (in-memory database).

## 🚀 Features

- Full **CRUD** for books
- **Pagination and sorting** for the book collection endpoint
- **Search** by title, author, or genre
- Filter by **author**, **genre**, **availability**, or **minimum rating**
- **Toggle availability** of a book
- Input **validation** with detailed error responses
- **Swagger UI** for interactive API documentation
- **H2 Console** for database inspection
- 8 **seed books** loaded on startup
- Unit & integration tests with MockMvc

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| Framework | Spring Boot 3.2 |
| Language | Java 21 |
| Persistence | Spring Data JPA + Hibernate |
| Database | H2 (in-memory) |
| Validation | Jakarta Bean Validation |
| API Docs | SpringDoc OpenAPI (Swagger) |
| Build | Maven |

## ▶️ Running the App

```bash
mvn spring-boot:run
```

The API will start on **http://localhost:8080**

## 📖 API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/v1/books` | Get books with pagination and sorting |
| GET | `/api/v1/books/{id}` | Get book by ID |
| GET | `/api/v1/books/isbn/{isbn}` | Get book by ISBN |
| POST | `/api/v1/books` | Create a new book |
| PUT | `/api/v1/books/{id}` | Update a book |
| DELETE | `/api/v1/books/{id}` | Delete a book |
| GET | `/api/v1/books/search?query=` | Search books |
| GET | `/api/v1/books/author/{author}` | Get by author |
| GET | `/api/v1/books/genre/{genre}` | Get by genre |
| GET | `/api/v1/books/available` | Get available books |
| GET | `/api/v1/books/rating?minRating=` | Filter by rating |
| PATCH | `/api/v1/books/{id}/toggle-availability` | Toggle availability |

### Pagination and Sorting

`GET /api/v1/books` supports the following query parameters:

| Parameter | Default | Description |
|---|---:|---|
| `page` | `0` | Zero-based page number |
| `size` | `10` | Number of books per page; maximum `100` |
| `sort` | `id,asc` | Sort field and direction |

Example:

```text
GET /api/v1/books?page=0&size=10&sort=title,asc
```

Supported sort fields are `id`, `title`, `author`, `publishedYear`, `genre`, `rating`, `createdAt`, and `updatedAt`.

The response includes `content`, `page`, `size`, `totalElements`, `totalPages`, `first`, and `last` pagination metadata.

## 🔍 Useful URLs

- **Swagger UI**: http://localhost:8080/swagger-ui.html
- **H2 Console**: http://localhost:8080/h2-console
  - JDBC URL: `jdbc:h2:mem:bookdb`
  - Username: `sa` | Password: *(empty)*

## 🧪 Running Tests

```bash
mvn test
```

## 📦 Sample Request

```json
POST /api/v1/books
{
  "title": "Clean Architecture",
  "author": "Robert C. Martin",
  "isbn": "9780134494166",
  "publishedYear": 2017,
  "genre": "Technology",
  "rating": 4.6,
  "description": "A craftsman's guide to software structure and design.",
  "available": true
}
```
