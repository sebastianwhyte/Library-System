USE library_db;

DROP TABLE IF EXISTS Book;
DROP TABLE IF EXISTS Patron;

CREATE TABLE Book
(
    book_id BINARY(16) PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    status CHAR(8) NOT NULL
);

CREATE TABLE Patron
(
    patronId BINARY(16) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    street VARCHAR(255),
    city VARCHAR(255) NOT NULL,
    apt_num VARCHAR(10),
    stateCode CHAR(2) NOT NULL,
    zip INT NOT NULL
);

