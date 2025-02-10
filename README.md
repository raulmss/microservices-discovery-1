# 🚀 Microservices Architecture Practice Project

## 📌 Overview

This project is designed to **practice microservices architecture** using **Spring Cloud**. It includes fundamental components such as **service discovery, API Gateway, distributed tracing, and inter-service communication**.

👉 **Note:** The `ProductService` and `StockService` have simple implementations, as the focus of this project is to **understand microservices communication, service registration, and distributed tracing** rather than complex business logic.

---

## 🏗️ Project Structure

| **Service**                       | **Description**                                                                                    |
| --------------------------------- | -------------------------------------------------------------------------------------------------- |
| **CloudGateway**                  | Acts as the API Gateway, routing requests to backend microservices.                                |
| **EurekaServer1 & EurekaServer2** | Service discovery servers that enable microservices to register and locate each other dynamically. |
| **ProductService**                | A simple service that returns a mock product and fetches stock data via Feign Client.              |
| **StockService & StockService2**  | Stores and provides hardcoded stock data for testing service communication.                        |
| **Zipkin**                        | Enables distributed tracing to monitor inter-service communication.                                |

---

## 🛠️ Technologies Used

### **🌀 Spring Cloud Gateway (CloudGateway)**

- **Role:** Routes incoming requests to appropriate backend microservices.
- **Key Features:**
  - Dynamic routing based on service names.
  - API security and rate limiting.
  - Load balancing requests to available instances.

### **🔍 Eureka Server (EurekaServer1 & EurekaServer2)**

- **Role:** Provides **service discovery** and registration.
- **Key Features:**
  - Allows services to register dynamically.
  - Enables load balancing with client-side discovery.
  - Handles failover and redundancy using multiple instances.

### **🛒 Product Service (ProductService)**

- **Role:** A mock product service that fetches stock data using Feign Client.
- **Key Features:**
  - Implements **Spring Cloud OpenFeign** for inter-service communication.
  - Registers with **Eureka** for service discovery.
  - Uses **Spring Sleuth & Zipkin** for request tracing.

### **📦 Stock Service (StockService & StockService2)**

- **Role:** Provides hardcoded stock availability for different products.
- **Key Features:**
  - Exposes REST API to fetch stock data.
  - Implements **service registry with Eureka**.
  - Uses **Sleuth & Zipkin** for distributed tracing.

### **📊 Distributed Tracing (Zipkin)**

- **Role:** Tracks requests across microservices to monitor performance and debug issues.
- **Key Features:**
  - Collects trace data from **Spring Sleuth**.
  - Visualizes request flows across microservices.
  - Helps analyze performance bottlenecks.

---

## 🔧 Setup & Installation

### **Prerequisites**

- **JDK 11+**
- **Maven**
- **Docker (Optional) for Containerization**
- **Zipkin Server** running on **http://localhost:9411**
- **Eureka Servers** running on **http://localhost:8761** & **http://localhost:8762**

### **Steps to Run the System**

1. **Clone the Repository**

   ```sh
   git clone https://github.com/raulmss/microservices-discovery-1.git
   cd microservices-discovery-1
   ```

2. **Start Eureka Servers**

   ```sh
   cd EurekaServer1
   mvn spring-boot:run
   ```

   ```sh
   cd EurekaServer2
   mvn spring-boot:run
   ```

3. **Run API Gateway (Cloud Gateway)**

   ```sh
   cd ../CloudGateway
   mvn spring-boot:run
   ```

4. **Start Microservices**
   ```sh
   cd ../ProductService
   mvn spring-boot:run
   ```
   ```sh
   cd ../StockService
   mvn spring-boot:run
   ```
   ```sh
   cd ../StockService2
   mvn spring-boot:run
   ```
5. **Run Zipkin for Tracing**
   after unziping the zipkin file, run the startzipkin.bat file.

## 📡 API Endpoints

### ✅ Product Service

- GET /product/{productId} - Retrieves product details and stock availability.

### ✅ Stock Service

- GET /stock/{productId} - Fetches stock availability for a given product.

### ✅ Eureka Service

- GET /eureka/apps - Lists all registered services.

### ✅ Zipkin

- http://localhost:9411 - Access the Zipkin UI for tracing.
