# 🚀 Run Pagination Demo Rest Service
This guide explains how to start and run the Paginantion Demo Rest Service locally using Maven, 
Docker 
Compose and IntelliJ HTTP Requests.

## 🚦 Prerequisites

Make sure you have the following installed:
- Java 25 or higher
- Maven 3.9+
- Docker & Docker Compose
- IDE (e.g., IntelliJ IDEA, VS Code – optional but helpful)

## 💾 Clone the Repository

```shell
   git https://github.com/hakktastic/pagination-demo.git
   cd pagination-demo
   git checkout master
```

## 🛠️ Build the Project

```shell
   mvn clean install
```

## ⚡Start Application

```shell      
  # start the application
  mvn spring-boot:run
```
## 🧪 Test the service
All HTTP requests are located in the [http-requests.http](http-requests.http) file in the root of the repsitory.

## 🛑 Stop Application

```shell  
  # stop the application
  mvn spring-boot:stop
```

> This file was generated with the assistance of an AI tool