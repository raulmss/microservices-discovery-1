# 🛍️ Product Service

## 📌 Project Overview
The **Product Service** is a microservice responsible for managing product details and retrieving stock information via inter-service communication. It leverages **Spring Cloud OpenFeign** for calling the **Stock Service**, enabling a decoupled architecture.

---

## 🚀 Technologies Used
- **Java 11 & Spring Boot 2.5.3** – Core framework for backend development.
- **Spring Cloud OpenFeign** – Simplifies HTTP calls between microservices.
- **Spring Cloud Netflix Eureka Client** – Registers the service with Eureka for discovery.
- **Spring Cloud Sleuth & Zipkin** – Provides distributed tracing for request monitoring.
- **Spring Boot Actuator** – Adds monitoring capabilities.
- **YAML Configuration** – Manages application properties.

---

## 🏗️ Architecture

The **Product Service** retrieves product details and queries stock information from the **Stock Service** via **Feign Client**.

| **Service**          | **Role** |
|----------------------|---------|
| **Product Service**  | Handles product information and calls Stock Service for availability. |
| **Stock Service**    | Provides stock details for products. |
| **Eureka Server**    | Registers and discovers microservices. |
| **Zipkin**           | Monitors and traces inter-service communication. |

### 🔄 **Inter-Service Communication**
- Uses **Spring Cloud OpenFeign** to call the **Stock Service**:
  ```java
  @FeignClient(name = "stock-service")
  interface StockFeignClient {
      @GetMapping("/stock/{productid}")
      int getStock(@PathVariable("productid") String productId);
  }
Stock details are retrieved dynamically based on product ID.

📡 API Endpoints

### ✅ Product Management
GET http://localhost:8091/product/{productid} – Fetch product details along with stock availability.

### ⚙️ Setup & Installation
Prerequisites
JDK 11
Maven
Eureka Server Running on Ports 8761 & 8762
Stock Service Running on Port 8092
Zipkin Tracing Server Running on Port 9411

#### Steps to Run

1. **Clone the Repository**:
    ```sh 
    git clone https://github.com/raulmss/microservices-discovery-1.git
    cd product-service

2. **Build and Run the Product Service:**:
    ```sh 
    mvn clean install
    mvn spring-boot:run
   
3. **Verify Registration in Eureka:**
   1. Open http://localhost:8761
   2. The Product Service should be registered.


4. **Test the Service Communication:**
    ```sh 
   curl -X GET http://localhost:8091/product/123
