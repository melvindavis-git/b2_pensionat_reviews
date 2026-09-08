# B2 Pensionat — Reviews Service

Internal microservice that owns room reviews for the B2 Pensionat system. It is not
meant to be called directly by end users — the [booking service](../b2_pensionat_booking)
is the public entry point and proxies review operations to this service.
See that project's README for the full system architecture and how to run everything
together (Docker Compose / Kubernetes).

## Responsibility

Create and list reviews for rooms, backed by its own MySQL database
(`pensionat_reviews`).

## API — `/review`

| Method | Path | Description |
|---|---|---|
| GET | `/review` | List all reviews. |
| POST | `/review` | Create a review (`roomId`, `reviewContent`, `stars`, `name`, `createdAt`). |

Interactive API docs (Swagger UI, via springdoc) are available at
`/swagger-ui.html` once the service is running.

## Tech stack

Java 25, Spring Boot 4, Spring Web MVC, Spring Data JPA, MySQL, springdoc-openapi.

## Configuration

| Property | Purpose |
|---|---|
| `server.port` | Defaults to `8082`. |
| `spring.datasource.url` | MySQL connection string. |

The `prod` profile (`application-prod.properties`, activated via
`--spring.profiles.active=prod` or `SPRING_PROFILES_ACTIVE=prod`) points the
datasource at the `reviews-db` host, matching the Docker Compose / Kubernetes
service name used by the booking project.

## Running standalone

```bash
./mvnw clean package
java -jar target/*.jar
```

Requires a reachable MySQL instance matching `application.properties`.

To run it as part of the full system (with the booking and customer services and
their databases), use the Docker Compose or Kubernetes setup documented in the
[booking service README](../b2_pensionat_booking).

## Tests

```bash
./mvnw test
```
