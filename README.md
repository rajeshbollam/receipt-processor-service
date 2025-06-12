# Receipt Processor Service

This project implements a RESTful web service that fulfills the API contract described in the provided `api.yml`. The service processes receipts and calculates reward points based on specific business rules.

## Features

- POST `/receipts/process`: Accepts receipt JSON and returns a unique receipt ID.
- GET `/receipts/{id}/points`: Returns the points awarded to a previously processed receipt.

## Tech Stack

- Java 17
- Spring Boot
- Maven
- Docker

---

## Dockerized Setup

### Prerequisites

- [Docker](https://www.docker.com/get-started) installed on your system

### Build the Docker Image

Run the following command from the root directory of the project (where the `Dockerfile` is located):

```bash
docker build -t receipt-processor-service .
```


### Run the Application

After building the Docker image, run the following command:

```bash
docker run -p 8080:8080 receipt-processor-service
