USE library_db;

DROP TABLE IF EXISTS Book;
DROP TABLE IF EXISTS Patron;

CREATE TABLE Book
(
    book_id VARCHAR(255) PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    status CHAR(8) NOT NULL
);

CREATE TABLE Patron
(
    patron_id VARCHAR(128) PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    street VARCHAR(80),
    apt_num VARCHAR(5),
    city VARCHAR(50) NOT NULL,
    stateCode VARCHAR(2) NOT NULL,
    zip VARCHAR(5) NOT NULL
);