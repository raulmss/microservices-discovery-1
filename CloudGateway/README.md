# 🌐 Cloud Gateway (API Gateway)

## 📌 Project Overview

This **Cloud Gateway** service acts as an **API Gateway** for routing and managing requests to different microservices within the system. It provides a **single entry point** for clients, ensuring efficient communication between services while implementing **load balancing, service discovery, and security**.

---

## 🚀 Technologies Used

- **Java 1.8 & Spring Boot 2.2.5** – Core framework for building the microservice.
- **Spring Cloud Gateway** – API gateway for routing requests and managing microservices.
- **Spring Cloud Netflix Eureka** – Service discovery for dynamic microservices registration.
- **Spring Cloud Load Balancer** – Distributes traffic across multiple service instances.
- **YAML Configuration** – Defines routes and integration with Eureka.

---

## 🏗️ Architecture & Routing

The **API Gateway** is responsible for **forwarding client requests** to the appropriate microservices:

| **Service**         | **Route Prefix** | **Target URI**           |
| ------------------- | ---------------- | ------------------------ |
| **Product Service** | `/product/**`    | `http://localhost:8091/` |
| **Stock Service**   | `/stock/**`      | `http://localhost:8092/` |

🔹 **Eureka Integration** – The API Gateway registers itself with Eureka at:
http://localhost:8761/eureka/ http://localhost:8762/eureka/

🔹 **Dynamic Routing** – Requests hitting `http://localhost:8080/product/**` are automatically forwarded to `http://localhost:8091/`, and `http://localhost:8080/stock/**` is routed to `http://localhost:8092/`.

---

## 📡 API Endpoints

Since this is an **API Gateway**, it does not have its own business logic but routes requests:

### **✅ Product Service Routes**

### **✅ Stock Service Routes**

---

## ⚙️ Setup & Installation

### **Prerequisites**

- **JDK 1.8**
- **Maven**
- **Eureka Server Running on Ports 8761 & 8762**
- **Product & Stock Services Running**

### **Steps to Run**

1. **Clone the Repository:**

   ```sh
   git clone https://github.com//cloud-gateway.git
   cd cloud-gateway

   ```

2. **Build and Run the API Gateway:**
   ```sh
    mvn clean install
    mvn spring-boot:run

   ```
3. **Verify the Service Discovery:**
   1. Open Eureka Dashboard at http://localhost:8761
   2. The API Gateway should be registered as api-gateway

4.**Test Routing:**

```sh
curl -X GET http://localhost:8080/product/1
curl -X GET http://localhost:8080/stock/1
```
