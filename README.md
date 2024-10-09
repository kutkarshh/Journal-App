# Journal App

## Overview

The Journal App is a RESTful web application that allows users to create, manage, and delete journal entries. Built with Spring Boot, this application provides endpoints to interact with journal entries, enabling users to store their thoughts and experiences efficiently.

## Features

- Create new journal entries
- Retrieve all journal entries
- Retrieve a specific journal entry by ID
- Update existing journal entries
- Delete journal entries
- Bulk create multiple journal entries
- Delete all journal entries

## Technologies Used

- Java
- Spring Boot
- MongoDB
- Maven
- Lombok (for boilerplate code reduction)
- Spring Data MongoDB

## Project Structure

src
└── main
    ├── java
    │   └── net
    │       └── ukumar
    │           └── journalApp
    │               ├── controller
    │               │   └── JournalEntryControllerV2.java
    │               ├── entities
    │               │   └── JournalEntryV2.java
    │               └── services
    │                   └── JournalEntryServiceV2.java
    └── resources
        └── application.properties

## API Endpoints

### 1. Get All Journal Entries
- **Endpoint:** `GET /journalv2`
- **Description:** Retrieves a list of all journal entries.
- **Response:**
  - Status: `200 OK`
  - Body: `List<JournalEntryV2>`

### 2. Create a New Journal Entry
- **Endpoint:** `POST /journalv2`
- **Description:** Creates a new journal entry.
- **Request Body:**
  - `JournalEntryV2`
- **Response:**
  - Status: `201 Created` (on success)
  - Status: `400 Bad Request` (on failure)
  - Body: `JournalEntryV2`

### 3. Create Multiple Journal Entries
- **Endpoint:** `POST /journalv2/createEntries`
- **Description:** Creates multiple journal entries.
- **Request Body:**
  - `List<JournalEntryV2>`
- **Response:**
  - Status: `200 OK`
  - Body: `Boolean` (success status)

### 4. Get Journal Entry by ID
- **Endpoint:** `GET /journalv2/id/{id}`
- **Description:** Retrieves a journal entry by its ID.
- **Response:**
  - Status: `200 OK` (if found)
  - Status: `404 Not Found` (if not found)
  - Body: `JournalEntryV2`

### 5. Update Journal Entry
- **Endpoint:** `PUT /journalv2/id/{id}`
- **Description:** Updates an existing journal entry by its ID.
- **Request Body:**
  - `JournalEntryV2`
- **Response:**
  - Status: `200 OK` (on success)
  - Status: `404 Not Found` (if entry not found)
  - Body: `JournalEntryV2`

### 6. Delete Journal Entry by ID
- **Endpoint:** `DELETE /journalv2/id/{id}`
- **Description:** Deletes a journal entry by its ID.
- **Response:**
  - Status: `200 OK` (on success)
  - Status: `404 Not Found` (if entry not found)
  - Body: `JournalEntryV2`

### 7. Delete All Journal Entries
- **Endpoint:** `DELETE /journalv2`
- **Description:** Deletes all journal entries.
- **Response:**
  - Status: `200 OK`
  - Body: `Boolean` (success status)

## How to Run the Project

1. Clone the repository:
   ```bash
   git clone https://github.com/username/journalApp.git
   cd journalApp
   ```

2. Configure MongoDB connection in `application.properties`.

3. Build the project using Maven:
   ```bash
   mvn clean install
   ```

4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

5. Access the API at `http://localhost:8080/journalv2`.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- [Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
- [MongoDB Documentation](https://docs.mongodb.com/)
```
