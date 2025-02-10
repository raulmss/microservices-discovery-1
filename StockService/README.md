# 📦 Stock Service

## 📌 Project Overview
The **Stock Service** is a microservice responsible for managing product stock availability. It provides **real-time stock information** to the **Product Service** via inter-service communication using **Spring Cloud OpenFeign**.

---

## 🚀 Technologies Used
- **Java 11 & Spring Boot 2.5.3** – Core framework for backend development.
- **Spring Cloud Netflix Eureka Client** – Registers the service with Eureka for service discovery.
- **Spring Cloud Sleuth & Zipkin** – Provides distributed tracing for request monitoring.
- **Spring Boot Actuator** – Adds monitoring capabilities.
- **YAML Configuration** – Manages application properties.

---

## 🏗️ Architecture

The **Stock Service** is part of a **microservices architecture** and is responsible for:
- Storing **stock availability** for different products.
- Providing real-time stock information to the **Product Service** via an **API call**.
- Registering with **Eureka Server** for **service discovery**.
- Enabling **distributed tracing** with **Spring Cloud Sleuth & Zipkin**.

| **Service**          | **Role** |
|----------------------|---------|
| **Stock Service**    | Manages and provides stock availability for products. |
| **Product Service**  | Queries stock availability from Stock Service. |
| **Eureka Server**    | Registers and discovers microservices. |
| **Zipkin**           | Monitors and traces inter-service communication. |

---

## 📡 API Endpoints

### **✅ Stock Management**
- `GET http://localhost:8092/stock/{productId}` – Retrieves stock availability for a product.

  #### **Example Response:**
  ```json
  {
    "productId": "1",
    "stock": 5
  }

### ⚙️ Setup & Installation

#### Prerequisites
- JDK 11
- Maven
- Eureka Server Running on Ports 8761 & 8762
- Zipkin Tracing Server Running on Port 9411

#### Steps to Run
1. **Clone the Repository:**
    ```shell
    git clone https://github.com/raulmss/microservices-discovery-1.git
    cd stock-service
   
2. **Build and Run the Stock Service:**
    ```shell
    mvn clean install
    mvn spring-boot:run
   
3. **Verify Registration in Eureka:**
 - Open http://localhost:8761
 - The Stock Service should be registered.

4. **Test the Service Communication:**
    ```shell
   curl -X GET http://localhost:8092/stock/1
