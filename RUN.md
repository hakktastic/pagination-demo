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

## 🖥️ Custom CSV file
By default the database schema is filled with 1 million records. If you want to increase this, 
please use following script to generate input:
```shell
# create i.e. five million entries
for i in $(seq 1 5000000); do
  echo "value_$i,value_$((i*2)),value_$((i*3)),value_$((i*4)),value_$((i*5))"
done >> dummy_entity_5m.csv
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