# Backend Spring E-Commerce Microservices

### Front-End for this project
https://github.com/fernandorff/react-e-commerce

## Overview

This repository contains the backend microservices API for a Spring-based E-Commerce system. The microservices are built using Spring Boot, WebFlux, Kafka, and communicate with each other to provide a seamless E-Commerce experience. The API is documented using Swagger.

## Prerequisites

Before you start, ensure you have the following installed on your machine:

- Java Development Kit (JDK) 11 or later
- Apache Kafka
- Docker
- PostgreSQL
- Maven

## Getting Started

1. Clone the repository:

```
git clone https://github.com/fernandorff/spring-ecommerce-micro-services.git

cd spring-ecommerce-micro-services
```

2. Start Apache Kafka and create necessary topics.

```
cd ./kafka-simple

docker compose
```

3. Start each service locally.

## Microservices Overview

### 1. Order Service

- Handles order creation and updates.
- - Sends real-time notifications to users using Kafka and SSE.

### 2. Product Service

- Manages product information.

### 3. Stock Service

- Manages product stock and prices.

## Screenshots

- **Swagger API Documentation**

![image](https://github.com/fernandorff/spring-ecommerce-micro-services/assets/101672271/603b5ef5-c9bd-415a-b384-d7f62e80031d)
![image](https://github.com/fernandorff/spring-ecommerce-micro-services/assets/101672271/035a0fc1-0e76-4398-8adb-7cce85d4b085)
![image](https://github.com/fernandorff/spring-ecommerce-micro-services/assets/101672271/0e591391-28f4-4d77-89a8-d7de258484f9)

- **Kafka Topic Configuration**

![image](https://github.com/fernandorff/spring-ecommerce-micro-services/assets/101672271/b95934b7-9a26-4a00-a587-3424686ab8c5)

- **WebFlux Reactive Endpoints**

![image](https://github.com/fernandorff/spring-ecommerce-micro-services/assets/101672271/b2e39bde-f7f2-443c-a229-b0b4bb528a2e)

- **File upload and AWS Bucket integration**

![image](https://github.com/fernandorff/spring-ecommerce-micro-services/assets/101672271/a6874e4d-17aa-4512-8679-918f8dfb31b4)


## Technologies Used

- **Spring Boot:** Backend framework.
- **WebFlux:** Reactive programming.
- **Kafka:** Message broker for communication between microservices.
- **PostgreSQL:** Database for storing application data.
- **Swagger:** API documentation.

## API Documentation

Explore the API endpoints and documentation using Swagger at the default local api address.
