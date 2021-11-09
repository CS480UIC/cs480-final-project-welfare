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

CREATE TABLE income
(
  recipient_ID INT,
  total_gross BIGINT NOT NULL,
  total_net BIGINT NOT NULL,
  investments BIGINT NOT NULL,
  FOREIGN KEY (recipient_ID) REFERENCES recipient(ID)
  		ON DELETE CASCADE
  		INSERT RESTRICT
);

CREATE TABLE address
(
  recipient_ID INT,
  city VARCHAR(60) NOT NULL,
  state VARCHAR(60) NOT NULL,
  street VARCHAR(80) NOT NULL,
  FOREIGN KEY (recipient_ID) REFERENCES recipient(ID)
  		ON DELETE CASCADE
  		INSERT RESTRICT
);

CREATE TABLE medical
(
	recipient_ID INT,
	citizenship VARCHAR(60) NOT NULL,
	residency VARCHAR(100) NOT NULL,
	family VARCHAR(100) NOT NULL,
	FOREIGN KEY (recipient_ID) REFERENCES recipient(ID)
		ON DELETE CASCADE
		INSERT RESTRICT
);

CREATE TABLE eligibility
(
	program_ID INT,
	program_name VARCHAR(300) NOT NULL,
	facility VARCHAR(300) NOT NULL,
	funds BIGINT NOT NULL,
	FOREIGN KEY (program_ID) REFERENCES administrator(ID)
		ON DELETE CASCADE
		INSERT RESTRICT
);