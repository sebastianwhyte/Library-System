# Library-System

### An application that uses a RESTful API to manage book and patron records.

How to run:
Click the '<>Code' button above and download zip folder.
Unzip the folder, change into the directory of the downloaded folder.

Run the following commands:
```
./mvnw clean install
```
```
java -jar target/Library-System-0.0.1-SNAPSHOT.jar
```

The server will start running and it can now receive HTTP requests.

### Books:

GET - List of Books

```
curl -X GET http://localhost:8080/library/v1/books/all
```
