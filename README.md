# BrewStop ☕

A **Spring Boot 3** REST back-end for a tiny café.  
It lets you

* manage _products_ (e.g. *Espresso*, *Cheesecake*),
* group them into _categories_ (e.g. *Coffee*, *Cake*),
* and keep a _price-change history_.

Everything runs in an **in-memory HSQLDB**; no external DB is needed.

---

## Prerequisites

| Tool       | Version (tested)               |
|------------|--------------------------------|
| **JDK**    | 21+                            |
| **Gradle** | Wrapper included (`./gradlew`) |
| **Git**    | any                            |
| A browser  | to open Swagger UI             |

---
Endpoints:

| Method   | Path                                          | Purpose                                              |
|----------|-----------------------------------------------|------------------------------------------------------|
| `GET`    | **/products**                                 | List all products (with category & price)            |
| `GET`    | **/products/{id}**                            | Get one product                                      |
| `POST`   | **/products**                                 | Add new product                                      |
| `PUT`    | **/products/{id}**                            | Full update                                          |
| `DELETE` | **/products/{id}**                            | Delete product (also deletes its price-history rows) |
| `POST`   | **/products/{id}/change-price?newPrice=10.5** | Change price & create history row                    |
| `GET`    | **/products/{id}/price-history**              | Chronological list of previous prices                |

![ER-Diagram](docs/ERD.png)

## Getting Started

```bash
git clone https://github.com/janarioopik/brewstop.git
cd brewstop
./gradlew bootRun         # starts on http://localhost:8080

