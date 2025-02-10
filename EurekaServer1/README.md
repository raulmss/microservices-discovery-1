# 🌍 Eureka Server (Service Discovery)

## 📌 Project Overview
The **Eureka Server** is a **service discovery server** in a **Spring Cloud Microservices Architecture**. It enables microservices to **register themselves dynamically** and **discover other services** for seamless inter-service communication.

### **🔹 Key Features**
- **Service Registration & Discovery** – Microservices register themselves and discover others dynamically.
- **Fault Tolerance & High Availability** – Configured with multiple instances (`eureka1` and `eureka2`).
- **Centralized Service Registry** – Stores metadata about registered microservices.

---

## 🚀 Technologies Used
- **Java 11 & Spring Boot 2.5.3** – Backend framework for Eureka Server.
- **Spring Cloud Netflix Eureka** – Enables service discovery.
- **Spring Cloud Dependencies (2020.0.3)** – Manages microservices-related dependencies.
- **YAML Configuration** – Defines Eureka cluster settings.

---

## 🏗️ Architecture

The **Eureka Server** runs in a **clustered environment** for **high availability**:

| **Instance**   | **Port** | **Peers** |
|---------------|---------|-----------|
| **eureka1**   | `8761`  | Connects to `eureka2` |
| **eureka2**   | `8762`  | Connects to `eureka1` |

Each instance **does not register itself** but connects to the other for **peer-to-peer failover support**.

---

## 📡 API Endpoints

Eureka provides a **dashboard and REST API** for monitoring and managing registered services:

### **✅ Service Discovery API**
- `GET http://localhost:8761/eureka/apps` – List all registered services.
- `GET http://localhost:8761/eureka/apps/{serviceName}` – Get details of a specific service.
- `DELETE http://localhost:8761/eureka/apps/{serviceName}/{instanceId}` – Remove a service instance.
- `GET http://localhost:8761/actuator/health` – Check Eureka Server health.

### **✅ Eureka Dashboard**
- **Eureka UI**: `http://localhost:8761`
- **Peer Instance (eureka2)**: `http://localhost:8762`

---

## ⚙️ Setup & Installation

### **Prerequisites**
- **JDK 11**
- **Maven**

### **Steps to Run**
1. **Clone the Repository:**
   ```sh
   git clone https://github.com/raulmss/microservices-discovery-1.git
   cd eureka-server### **Steps to Run**
   
2. **Build and Run the Eureka Server:**
   ```sh
   mvn clean install
   mvn spring-boot:run

2. **Verify the Eureka Dashboard:**
   1. Open http://localhost:8761 in your browser.
   2. The Eureka Server should be up and running.
4. **Run a Second Instance (Optional for High Availability)**
    ```sh
    mvn spring-boot:run -Dserver.port=8762
