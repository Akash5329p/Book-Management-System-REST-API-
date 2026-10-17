# Book-Management-System-REST-API-

# 📚 Book Management System

A RESTful web application built with **Java and Spring Boot** to manage a book inventory.
It supports full CRUD operations, input validation and centralized exception handling,
following a clean layered architecture.

## ✨ Features
- Add a new book (POST)
- Fetch a book by ID or fetch all books (GET)
- Update a book's number of pages (PUT) and name (PATCH)
- Delete a book by ID or delete all books (DELETE)
- Validation: a book must have at least 30 pages, and negative page counts are rejected
- Custom `BookNotFoundException` returns a clear message with HTTP 404
- Empty book names are rejected during update

## 🛠️ Tech Stack
- **Language:** Java
- **Framework:** Spring Boot, Spring Web, Spring Data JPA (Hibernate)
- **Validation:** Jakarta Bean Validation
- **Database:** [MySQL / H2 — fill in]
- **Tools:** [Postman, Eclipse/STS, Git & GitHub — keep only what you used]

## 🏗️ Architecture
Controller → Service → Repository → Database

| Layer | Class | Responsibility |
|---|---|---|
| Entity | `Book` | JPA entity with validation rules |
| Repository | `BookRepo` | Data access through `JpaRepository` |
| Service | `Book_Service` | Business logic, transactional updates |
| Controller | `Book_Controller` | REST endpoints, HTTP status codes |
| Exception | `BookNotFoundException`, `GlobalException` | Centralized error handling |

## 🔗 API Endpoints
| Method | Endpoint | Description | Success |
|---|---|---|---|
| POST | `/book` | Add a new book | 201 Created |
| GET | `/book/{id}` | Get a book by ID | 200 OK |
| GET | `/book` | Get all books | 200 OK |
| PUT | `/book/{id}/pages/{pages}` | Update the number of pages | 200 OK |
| PATCH | `/book/{id}/name/{b_Name}` | Update the book name | 200 OK |
| DELETE | `/book/{id}` | Delete a book | 200 OK |
| DELETE | `/book` | Delete all books | 200 OK |

**Sample request body (POST /book):**
```json
{
  "b_Name": "Atomic Habits",
  "genre": "Self-help",
  "author_name": "James Clear",
  "pages": 320,
  "price": 499
}
```

## 🧪 Testing
I manually tested every endpoint using [Postman] and checked the stored data with SQL queries.

| Type | Scenarios covered |
|---|---|
| Positive | Add valid book, fetch by ID, fetch all, update pages/name, delete |
| Negative | Fetch/update a non-existent ID (expect 404), book with fewer than 30 pages, negative pages, empty name |
| Boundary | Pages = 29, 30, 31 |
| DB verification | SELECT queries to confirm insert, update and delete results |

📎 Test case document: `TestCases.xlsx` [add this file]

## ▶️ How to Run
1. Clone the repository: `git clone <your-repo-link>`
2. Configure the database in `application.properties` [add your settings, without passwords]
3. Run the application as a Spring Boot app (`BookManagementSystemApplication`)
4. Test the APIs at `http://localhost:8080/book`

## 🚀 Future Improvements
- Add validation on price and the update endpoints
- Add search by genre/author and pagination
- Automated API testing and Selenium UI tests
