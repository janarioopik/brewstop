# BrewStop ☕️

A lightweight **Spring Boot 3 + HSQLDB** service that manages a small café’s menu
and price-change history:

* **Products** (drinks & cakes) belong to **Categories**
* Every price update is stored in **PRICE_CHANGE**
* Runs 100 % in-memory – zero external database setup

The project showcases classic **Controller → Service → Repository** layering,
external SQL scripts (`schema.sql`, `data.sql`), and Swagger-generated docs.

---

## Table of Contents

1. [Features](#features)
2. [Prerequisites](#prerequisites)
3. [Getting Started](#getting-started)  
   3.1 [Clone the repo](#clone-the-repo)  
   3.2 [Run in IntelliJ IDEA](#run-in-intellij-idea)
4. [Swagger UI](#swagger-ui)
5. [Configuration](#configuration)
6. [Database Initialisation](#database-initialisation)
7. [Database Structure](#database-structure)
8. [Available Endpoints](#available-endpoints)
9. [Project Layout](#project-layout)

---

## Features

| Action            | Endpoint                                        |
|-------------------|-------------------------------------------------|
| **Products**      |                                                 |
| List all products | `GET /products`                                 |
| Get product by ID | `GET /product/{id}`                             |
| Create product    | `POST /product`                                 |
| Update product    | `PUT /product/{id}`                             |
| Delete product    | `DELETE /product/{id}`                          |
| **Price changes** |                                                 |
| Change price      | `POST /product/{id}/change-price?newPrice=9.99` |
| Price history     | `GET /product/{id}/price-changes`               |

All endpoints accept / return JSON and follow REST status codes (`200 OK`, `201 Created`, `404 Not Found`, …).

---

## Prerequisites

* **JDK 21**
* **Gradle 8+** (or the provided `gradlew`)
* IntelliJ IDEA 2024 .x (recommended)

---

## Getting Started

### Clone the repo

```bash
git clone https://github.com/janarioopik/brewstop.git
cd brewstop



```
## Run in IntelliJ IDEA
Open Project ➜ choose the folder with build.gradle.

Wait for Gradle sync.

Run BrewstopApplication.java (green ▶︎).

Visit http://localhost:8080/swagger-ui/index.html.

Stop with the red ■ when done.

Command-line alternative
./gradlew bootRun

```
Swagger UI
Interactive API docs:
http://localhost:8080/swagger-ui/index.html

```
Configuration
Runtime settings live in
src/main/resources/application.properties.
Defaults: HSQLDB memory DB, server port 8080.

```
Database Initialisation
File	Purpose
schema.sql	DDL – creates CATEGORY, PRODUCT, PRICE_CHANGE
data.sql	Seeds two categories & two demo products

Executed automatically each start-up.

```
Database Structure

objectivec
Copy
CATEGORY 1 ────∞ PRODUCT 1 ────∞ PRICE_CHANGE

```
![ERD Diagram](docs/ERD.png)

```
Available Endpoints
Method	Path	Description
GET	/products	List all products
GET	/product/{id}	One product
POST	/product	Create product
PUT	/product/{id}	Update product
DELETE	/product/{id}	Remove product
POST	/product/{id}/change-price?newPrice=9.99	Change & log price
GET	/product/{id}/price-changes	Price history

```
Project Layout
text
Copy
brewstop/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── eu.itcrafters.brewstop/
│   │   │       ├── controller/    # REST & DTOs
│   │   │       ├── service/       # Business rules
│   │   │       ├── infrastructure/
│   │   │       │   └── persistence/  # Entities, repos, mappers
│   │   │       └── BrewstopApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── schema.sql
│   │       └── data.sql
│   └── test/ …
├── docs/ERD.png          # (optional) diagram
├── build.gradle
├── gradlew / gradlew.bat
└── README.md             # you are here