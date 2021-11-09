create database welfare;
use welfare;
# entity1 table from bookstore demo
CREATE TABLE `entity1` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

# user table from bookstore demo
CREATE TABLE `user` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE login
(
  username VARCHAR(60) primary key,
  pass VARCHAR(60) NOT NULL UNIQUE,
  email VARCHAR(60) NOT NULL UNIQUE
);

CREATE TABLE recipient
(
  first_name VARCHAR(60) NOT NULL,
  last_name VARCHAR(60) NOT NULL,
  ID INT PRIMARY KEY
);

CREATE TABLE administrator
(
  first_name VARCHAR(60) NOT NULL,
  last_name VARCHAR(60) NOT NULL,
  title VARCHAR(60) NOT NULL,
  ID INT PRIMARY KEY
);
