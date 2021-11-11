CREATE DATABASE  IF NOT EXISTS `welfare` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `welfare`;
-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: welfare
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `recipient_ID` int NOT NULL,
  `city` varchar(60) NOT NULL,
  `state` varchar(60) NOT NULL,
  `street` varchar(80) NOT NULL,
  UNIQUE KEY `recipient_ID` (`recipient_ID`),
  CONSTRAINT `address_ibfk_1` FOREIGN KEY (`recipient_ID`) REFERENCES `recipient` (`ID`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (10294,'Houston','Texas','Webster Street'),(574698,'Helena','Montana','Abbey Street '),(975623,'Trenton','New Jersey','11th Street'),(978654,'Chicago','Illinois','Halsted'),(983628,'New York','New York','Wall Street');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `administrator`
--

DROP TABLE IF EXISTS `administrator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `administrator` (
  `first_name` varchar(60) NOT NULL,
  `last_name` varchar(60) NOT NULL,
  `title` varchar(60) NOT NULL,
  `ID` int NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrator`
--

LOCK TABLES `administrator` WRITE;
/*!40000 ALTER TABLE `administrator` DISABLE KEYS */;
INSERT INTO `administrator` VALUES ('Joseph','Joestar','Clerk',89245),('Sara','Cruz','Clerk',298571),('Bill','Williamson','Manager',601347),('William','Blake','Manager',982321),('Sylvia','Plath','Manager',983126);
/*!40000 ALTER TABLE `administrator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eligibility`
--

DROP TABLE IF EXISTS `eligibility`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `eligibility` (
  `recipient_ID` int DEFAULT NULL,
  `citizenship` varchar(60) NOT NULL,
  `residency` varchar(100) NOT NULL,
  `family` varchar(100) NOT NULL,
  KEY `recipient_ID` (`recipient_ID`),
  CONSTRAINT `eligibility_ibfk_1` FOREIGN KEY (`recipient_ID`) REFERENCES `recipient` (`ID`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eligibility`
--

LOCK TABLES `eligibility` WRITE;
/*!40000 ALTER TABLE `eligibility` DISABLE KEYS */;
INSERT INTO `eligibility` VALUES (978654,'yes','yes','1'),(983628,'no','yes','5'),(975623,'no','no','2'),(10294,'yes','yes','9'),(574698,'no','yes','3');
/*!40000 ALTER TABLE `eligibility` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entity1`
--

DROP TABLE IF EXISTS `entity1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `entity1` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entity1`
--

LOCK TABLES `entity1` WRITE;
/*!40000 ALTER TABLE `entity1` DISABLE KEYS */;
/*!40000 ALTER TABLE `entity1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `housing`
--

DROP TABLE IF EXISTS `housing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `housing` (
  `program_name` varchar(300) NOT NULL,
  `program_ID` int NOT NULL,
  `administrator_ID` int NOT NULL,
  `housing_size` smallint NOT NULL,
  `funds` bigint NOT NULL,
  PRIMARY KEY (`program_ID`),
  UNIQUE KEY `administrator_ID` (`administrator_ID`),
  CONSTRAINT `housing_ibfk_1` FOREIGN KEY (`administrator_ID`) REFERENCES `administrator` (`ID`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `housing`
--

LOCK TABLES `housing` WRITE;
/*!40000 ALTER TABLE `housing` DISABLE KEYS */;
INSERT INTO `housing` VALUES ('Helper Housing',12345,601347,3,500000),('Assisted Living',67890,89245,5,700000),('Under One Roof',289317,983126,8,801999),('Homes for the Homeless',910112,982321,1,2000000),('Affordable Housing Program',987654,298571,4,509015);
/*!40000 ALTER TABLE `housing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `income`
--

DROP TABLE IF EXISTS `income`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `income` (
  `recipient_ID` int NOT NULL,
  `total_gross` bigint NOT NULL,
  `total_net` bigint NOT NULL,
  `investments` bigint NOT NULL,
  UNIQUE KEY `recipient_ID` (`recipient_ID`),
  CONSTRAINT `income_ibfk_1` FOREIGN KEY (`recipient_ID`) REFERENCES `recipient` (`ID`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `income`
--

LOCK TABLES `income` WRITE;
/*!40000 ALTER TABLE `income` DISABLE KEYS */;
INSERT INTO `income` VALUES (10294,2000,2000,0),(574698,12000,11000,125),(975623,15000,12000,350),(978654,45000,30000,0),(983628,10000,9000,0);
/*!40000 ALTER TABLE `income` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `username` varchar(60) NOT NULL,
  `pass` varchar(60) NOT NULL,
  `email` varchar(60) NOT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `pass` (`pass`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES ('anders95','hiddenpass','anders95@gmail.com'),('notthatguy79','secret','notthatguy79@gmail.com'),('runner267','jogislife','runner267@gmail.com'),('spicywater6','whyisitspicy','spicywater6@gmail.com'),('thatguy76','password1','thatguy76@gmail.com');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medical`
--

DROP TABLE IF EXISTS `medical`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medical` (
  `program_name` varchar(300) NOT NULL,
  `program_ID` int NOT NULL,
  `administrator_ID` int NOT NULL,
  `funds` bigint NOT NULL,
  PRIMARY KEY (`program_ID`),
  UNIQUE KEY `administrator_ID` (`administrator_ID`),
  CONSTRAINT `medical_ibfk_1` FOREIGN KEY (`administrator_ID`) REFERENCES `administrator` (`ID`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medical`
--

LOCK TABLES `medical` WRITE;
/*!40000 ALTER TABLE `medical` DISABLE KEYS */;
INSERT INTO `medical` VALUES ('Medicare',1,601347,100000),('Medicaid',2,89245,20000),('Veterans Care',3,982321,30000),('TRICARE',4,298571,40000),('IHS',5,983126,100000);
/*!40000 ALTER TABLE `medical` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicalfacility`
--

DROP TABLE IF EXISTS `medicalfacility`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medicalfacility` (
  `program_ID` int NOT NULL,
  `medicalfacility_ID` int NOT NULL,
  `facility` varchar(300) NOT NULL,
  PRIMARY KEY (`medicalfacility_ID`),
  UNIQUE KEY `program_ID` (`program_ID`),
  CONSTRAINT `medicalfacility_ibfk_1` FOREIGN KEY (`program_ID`) REFERENCES `medical` (`program_ID`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicalfacility`
--

LOCK TABLES `medicalfacility` WRITE;
/*!40000 ALTER TABLE `medicalfacility` DISABLE KEYS */;
INSERT INTO `medicalfacility` VALUES (1,153,'Florida Hospital Orlando'),(2,234,'Jackson Memorial Hospital'),(3,320,'Methodist Hospital'),(4,354,'Norton Hospital'),(5,542,'Northwestern Memorial Hospital');
/*!40000 ALTER TABLE `medicalfacility` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nutritional`
--

DROP TABLE IF EXISTS `nutritional`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nutritional` (
  `program_name` varchar(300) NOT NULL,
  `program_ID` int NOT NULL,
  `administrator_ID` int NOT NULL,
  `funds` bigint NOT NULL,
  PRIMARY KEY (`program_ID`),
  UNIQUE KEY `administrator_ID` (`administrator_ID`),
  CONSTRAINT `nutritional_ibfk_1` FOREIGN KEY (`administrator_ID`) REFERENCES `administrator` (`ID`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nutritional`
--

LOCK TABLES `nutritional` WRITE;
/*!40000 ALTER TABLE `nutritional` DISABLE KEYS */;
INSERT INTO `nutritional` VALUES ('Vitamin Dispersion Fund',23,601347,350000),('Edgewater Trust',45,983126,50000),('Helping Hand',56,982321,999999),('Feeding America',87,89245,500000),('U.S. Nutritional Welfare Program',91,298571,2500000);
/*!40000 ALTER TABLE `nutritional` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nutritionalsource`
--

DROP TABLE IF EXISTS `nutritionalsource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nutritionalsource` (
  `program_ID` int NOT NULL,
  `nutritionalsource_ID` int DEFAULT NULL,
  `source` varchar(300) NOT NULL,
  UNIQUE KEY `program_ID` (`program_ID`),
  CONSTRAINT `nutritionalsource_ibfk_1` FOREIGN KEY (`program_ID`) REFERENCES `nutritional` (`program_ID`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nutritionalsource`
--

LOCK TABLES `nutritionalsource` WRITE;
/*!40000 ALTER TABLE `nutritionalsource` DISABLE KEYS */;
INSERT INTO `nutritionalsource` VALUES (23,153,'Department of Agriculture'),(45,542,'Edgewater Agricultural Municipality'),(56,320,'Red Cross'),(87,234,'Feeding America Network'),(91,354,'U.S. Department of Agriculture');
/*!40000 ALTER TABLE `nutritionalsource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recipient`
--

DROP TABLE IF EXISTS `recipient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recipient` (
  `first_name` varchar(60) NOT NULL,
  `last_name` varchar(60) NOT NULL,
  `ID` int NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipient`
--

LOCK TABLES `recipient` WRITE;
/*!40000 ALTER TABLE `recipient` DISABLE KEYS */;
INSERT INTO `recipient` VALUES ('Aubrey','Beardsley',10294),('Steve','Rogers',574698),('Anders','Zorn',975623),('Leroy','Jenkins',978654),('Smitty','Wermanjenson',983628);
/*!40000 ALTER TABLE `recipient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-10 23:05:05
