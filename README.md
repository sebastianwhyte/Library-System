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


<br />


###  Books:

#### GET - List of Books
Retrieves a list of all books.
```
curl -X GET http://localhost:8080/library/v1/books/all
```

<br />


#### GET - Book Lookup
Retrieves the book assigned with a given id.
```
curl -X GET http://localhost:8080/library/v1/books/id
```

Params:

id &emsp;   id of book to search for (required)


<br />


#### GET - Lookup Books with Matching Title
Retrieves books with titles that match a given string.
```
curl -X GET http://localhost:8080/library/v1/books/find/pattern 
```

Params:

pattern &emsp;  pattern to match (required)


<br />


#### POST - Add a Book
Adds a new book to the library.
```
curl -X POST -H "Content-Type: application/json" -d '{"title": "The Great Gatsby", "author": "F. Scott Fitzgerald"}' http://localhost:8080/library/v1/books/add
```
Params:

title &emsp;    title of the book to be added (required) \
author &emsp;   author of the book to be added (required)


<br />


#### PUT - Update a Book
Replaces the book with a given id with another book.

The new book will have the same id as the old one. 

```
curl -X PUT -H "Content-Type: application/json" -d '{"title": "My NEW title", "author": "My NEW author"}' http://localhost:8080/library/v1/books/update/id
```

Params:

id &emsp;   id of the book to be replaced (required) \
title &emsp;    title of the new book (required) \
author &emsp;   author of the new book (required)


<br/>


#### DELETE - Delete Book By Id
Deletes the book assigned the given id.

```
curl -X DELETE -H "Content-Type: application/json" http://localhost:8080/library/v1/books/delete/id
```

Params:

id &emsp;   id of the book to be deleted (required)


<br/>


### Patrons:

#### GET - List of Patrons
Retrieves a list of all patron records.
```
curl -X GET http://localhost:8080/library/v1/patrons/all
```

<br />


#### GET - Patron Lookup
Retrieves the patron assigned with a given id.
```
curl -X GET http://localhost:8080/library/v1/patrons/id
```

Params:

id &emsp;   id of patron to search for (required)


<br />


#### GET - Lookup Patrons with Matching Name
Retrieves patrons with names that match a given string.
```
curl -X GET http://localhost:8080/library/v1/patrons/find/pattern 
```

Params:

pattern &emsp;  pattern to match (required)


<br />


#### POST - Add a Patron
Adds a new patron record to the library.
```
curl -X POST -H "Content-Type: application/json" -d '{"first_name": "My First Name", "last_name": 
"My Last Name", "city": "My City", "state_code": "TX", "zip": "00000"}' http://localhost:8080/library/v1/patrons/add
```
Params:

first_name &emsp; - &emsp; first name of the patron to be added (required) \
last_name &emsp; - &emsp;  last name of the patron to be added (required) \
street &emsp; - &emsp;    street the patron lives on (optional) \
apt_num &emsp; - &emsp;   unit number if patron lives in an apartment (optional) \
city &emsp; - &emsp;   city the patron lives in (required) \
state_code &emsp; - &emsp;   state the patron lives in (required) \
zip &emsp; &emsp; - &emsp;    zip code of the city the patron lives in (required) 


<br />


#### PUT - Update a Patron Record
Replaces the patron with a given id with another patron.

The new patron will have the same id as the old one.

```
curl -X PUT -H "Content-Type: application/json" -d '{"first_name": "My NEW First Name", "last_name": "My NEW Last Name",
 "city": "My NEW City", "state_code": "NY", "zip": "My NEW Zip"}' http://localhost:8080/library/v1/patrons/update/bbcbf4c4-ae09-42c2-a926-1d00b5e0b375
```


Params:

id &emsp; - &emsp;   id of the patron to be replaced (required) \
first_name &emsp; - &emsp; first name of the new patron to be added (required) \
last_name &emsp; - &emsp;  last name of the new patron to be added (required) \
street &emsp; - &emsp;    street the new patron lives on (optional) \
apt_num &emsp; - &emsp;   unit number if patron lives in an apartment (optional) \
city &emsp; - &emsp;   city the new patron lives in (required) \
state_code &emsp; - &emsp;   state the new patron lives in (required) \
zip &emsp; &emsp; - &emsp;    zip code of the city the new patron lives in (required)


<br/>

#### DELETE - Delete Patron By Id
Deletes the book assigned the given id.

```
curl -X DELETE -H "Content-Type: application/json" http://localhost:8080/library/v1/books/delete/id
```

Params:

id &emsp;   id of the patron to be deleted (required)


<br/>
