# Student Management System

A full-stack Student Management System developed using Spring Boot, React.js, and MySQL.The application allow users to manage student records through RESTful APIs and a React.js web interface, with support for CRUD operations, pagination, and sorting.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- REST API
- React.js
- Axios
- Maven

## Features

- Add new student records
- View all student records
- Update existing student records
- Delete student records
- RESTful APIs for student management
- Pagination for student records
- Sorting student records
- React.js frontend for interacting with the backend
- Axios for communication between the frontend and backend
- MySQL database for storing student information

## Project Structure

```text
StudentManagementSystem/
├── src/                  # Spring Boot backend
├── frontend/             # React.js frontend
├── pom.xml               # Maven configuration
├── mvnw
├── mvnw.cmd
├── .gitignore
└── README.md

## Backend Overview

The backend of the application is developed using Spring Boot.

It provides RESTful APIs for managing student records and handles the business logic, database operations, validation, exception handling, pagination, and sorting.

### Backend Technologies

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven

### Backend Responsibilities

- Create student records
- Retrieve student records
- Update student records
- Delete student records
- Validate student input
- Handle exceptions
- Perform pagination
- Perform sorting
- Communicate with the MySQL database

## Frontend Overview

The frontend of the application is developed using React.js.

It provides a user-friendly interface for managing student records and communicates with the Spring Boot backend using Axios.

### Frontend Technologies

- React.js
- Axios
- JavaScript
- HTML
- CSS

### Frontend Responsibilities

- Display student records
- Add new students
- Edit existing students
- Delete students
- Send requests to the backend using Axios
- Display backend responses in the user interface

## API Endpoints

The application provides RESTful APIs for managing student records.

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/v1/students` | Create a new student |
| GET | `/api/v1/students` | Get all students with pagination and sorting |
| GET | `/api/v1/students/{id}` | Get a student by ID |
| PUT | `/api/v1/students/{id}` | Update an existing student |
| DELETE | `/api/v1/students/{id}` | Delete a student by ID |

## How to Run the Project

### Prerequisites

Ensure the following software is installed and configured:

- Java
- Maven
- MySQL
- Node.js
- npm

### 1. Clone the Repository

Clone the repository from GitHub:

```bash
git clone https://github.com/amarchinni/StudentManagementSystem.git
cd StudentManagementSystem



