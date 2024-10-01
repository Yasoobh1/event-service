# Event Management Microservice

## Overview

The **Event Management Microservice** is a Spring Boot application designed to facilitate the management of events, ticket booking, and payment processing. This microservice allows users to create and search for events, book and cancel tickets, and receive notifications regarding their bookings.

## Features

- **Event Management**: Create, update, and delete events.
- **Ticket Booking**: Book tickets for events and handle cancellations.
- **Payment Processing**: Securely process payments for ticket purchases.
- **Notifications**: Send booking confirmations and cancellation notifications to users.

## Tech Stack

- **Java**: The primary programming language.
- **Spring Boot**: Framework for building microservices.
- **Spring Data JPA**: For data access and repository management.
- **H2 Database**: In-memory database for development and testing.
- **Swagger**: API documentation and testing interface.
- **Maven**: Build and dependency management tool.

## Getting Started

### Prerequisites

- **Java 11** or higher
- **Maven**
- **Git**

### Installation

1. **Clone the repository**:

   ```bash
   git clone https://github.com/Yasoobh1/event-service.gitt

2. **Clone the repository**:
cd event-service

3. **Build the project:**:
mvn clean install

4. **Run the application:**:
mvn spring-boot:run

5. **Access the application:**:
Open your browser and navigate to http://localhost:8080/h2-console.


6. **Access Swagger UI:**:
Open your browser and navigate to http://localhost:8080/swagger-ui/index.html (replace with your configured Swagger URL).


**Postman Collections**
Postman:

1. Download the Postman collection from this repository (e.g., Event Collection.postman_collection.json).
2. Open Postman.
3. Click on Import in the top left corner.
4. Choose the File option and select the downloaded Postman collection.
5. Click Import to add the collection to your Postman workspace.

