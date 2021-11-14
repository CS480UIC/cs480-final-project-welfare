-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: welfare
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
-- Temporary view structure for view `avgnutritionalfunds`
--

DROP TABLE IF EXISTS `avgnutritionalfunds`;
/*!50001 DROP VIEW IF EXISTS `avgnutritionalfunds`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `avgnutritionalfunds` AS SELECT 
 1 AS `avg(funds)`*/;
SET character_set_client = @saved_cs_client;

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
-- Temporary view structure for view `getnutritionalsource`
--

DROP TABLE IF EXISTS `getnutritionalsource`;
/*!50001 DROP VIEW IF EXISTS `getnutritionalsource`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `getnutritionalsource` AS SELECT 
 1 AS `program_name`,
 1 AS `source`*/;
SET character_set_client = @saved_cs_client;

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
-- Temporary view structure for view `incomebetween10000and30000`
--

DROP TABLE IF EXISTS `incomebetween10000and30000`;
/*!50001 DROP VIEW IF EXISTS `incomebetween10000and30000`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `incomebetween10000and30000` AS SELECT 
 1 AS `total_net`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `incomeover50000`
--

DROP TABLE IF EXISTS `incomeover50000`;
/*!50001 DROP VIEW IF EXISTS `incomeover50000`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `incomeover50000` AS SELECT 
 1 AS `recipient_ID`,
 1 AS `total_gross`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `investmentsabovezero`
--

DROP TABLE IF EXISTS `investmentsabovezero`;
/*!50001 DROP VIEW IF EXISTS `investmentsabovezero`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `investmentsabovezero` AS SELECT 
 1 AS `recipient_ID`,
 1 AS `investments`*/;
SET character_set_client = @saved_cs_client;

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
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `longestrecipientnamecount`
--

DROP TABLE IF EXISTS `longestrecipientnamecount`;
/*!50001 DROP VIEW IF EXISTS `longestrecipientnamecount`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `longestrecipientnamecount` AS SELECT 
 1 AS `FirstNameCount`,
 1 AS `LastNameCount`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `mangers`
--

DROP TABLE IF EXISTS `mangers`;
/*!50001 DROP VIEW IF EXISTS `mangers`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `mangers` AS SELECT 
 1 AS `first_name`,
 1 AS `last_name`*/;
SET character_set_client = @saved_cs_client;

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
-- Temporary view structure for view `nutritionalfundsoverorunder`
--

DROP TABLE IF EXISTS `nutritionalfundsoverorunder`;
/*!50001 DROP VIEW IF EXISTS `nutritionalfundsoverorunder`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `nutritionalfundsoverorunder` AS SELECT 
 1 AS `funds`*/;
SET character_set_client = @saved_cs_client;

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
-- Temporary view structure for view `oldestyear`
--

DROP TABLE IF EXISTS `oldestyear`;
/*!50001 DROP VIEW IF EXISTS `oldestyear`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `oldestyear` AS SELECT 
 1 AS `Year`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `recipient`
--

DROP TABLE IF EXISTS `recipient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recipient` (
  `first_name` varchar(60) NOT NULL,
  `last_name` varchar(60) NOT NULL,
  `birthdate` date NOT NULL,
  `ID` int NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipient`
--

LOCK TABLES `recipient` WRITE;
/*!40000 ALTER TABLE `recipient` DISABLE KEYS */;
INSERT INTO `recipient` VALUES ('Aubrey','Beardsley','2000-04-23',10294),('Steve','Rogers','1996-09-15',574698),('Anders','Zorn','1989-02-18',975623),('Leroy','Jenkins','1979-07-22',978654),('Smitty','Wermanjenson','1965-04-04',983628);
/*!40000 ALTER TABLE `recipient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `recipientseligibleforallmedicalprograms`
--

DROP TABLE IF EXISTS `recipientseligibleforallmedicalprograms`;
/*!50001 DROP VIEW IF EXISTS `recipientseligibleforallmedicalprograms`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `recipientseligibleforallmedicalprograms` AS SELECT 
 1 AS `recipient_ID`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `recipnameandincome`
--

DROP TABLE IF EXISTS `recipnameandincome`;
/*!50001 DROP VIEW IF EXISTS `recipnameandincome`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `recipnameandincome` AS SELECT 
 1 AS `first_name`,
 1 AS `last_name`,
 1 AS `total_net`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `totalgrossover10000`
--

DROP TABLE IF EXISTS `totalgrossover10000`;
/*!50001 DROP VIEW IF EXISTS `totalgrossover10000`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `totalgrossover10000` AS SELECT 
 1 AS `recipient_ID`*/;
SET character_set_client = @saved_cs_client;

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

--
-- Dumping routines for database 'welfare'
--
/*!50003 DROP FUNCTION IF EXISTS `getRecipIncome` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `getRecipIncome`(firstName VARCHAR(60), lastName VARCHAR(60)) RETURNS int
    READS SQL DATA
BEGIN
DECLARE recipID INT;
DECLARE recipIncome INT;
SELECT ID INTO recipID
FROM recipient
WHERE first_name = firstName AND last_name = lastName;
SELECT total_net INTO recipIncome
FROM income
WHERE recipient_ID = recipID;
RETURN recipIncome;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `new_function` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`welfare`@`localhost` FUNCTION `new_function`() RETURNS int
    READS SQL DATA
BEGIN
DECLARE netSum INT;
SELECT SUM(total_net) INTO netSum
FROM income;
RETURN netSum;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `recipInvest` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `recipInvest`(recip int) RETURNS int
    READS SQL DATA
BEGIN
DECLARE invest int;
SELECT investments INTO invest FROM income
WHERE recipient_ID = recip;
RETURN invest;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `totalHousingFunds` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`welfare`@`localhost` FUNCTION `totalHousingFunds`() RETURNS int
    READS SQL DATA
BEGIN
declare totalFunds int;
select sum(funds) into totalFunds 
from welfare.housing;
RETURN totalFunds;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `allManagers` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`welfare`@`localhost` PROCEDURE `allManagers`()
BEGIN
SELECT first_name, last_name from welfare.administrator 
where title = 'Manager';
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getRecipCity` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`welfare`@`localhost` PROCEDURE `getRecipCity`()
BEGIN
SELECT recipient_ID
FROM address
WHERE city = "Chicago";
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `selectAllRecips` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `selectAllRecips`()
BEGIN
SELECT * FROM recipient;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `total_income_procedure` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`welfare`@`localhost` PROCEDURE `total_income_procedure`()
BEGIN
SELECT total_net, total_gross FROM income
WHERE total_net != total_gross;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `avgnutritionalfunds`
--

/*!50001 DROP VIEW IF EXISTS `avgnutritionalfunds`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`welfare`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `avgnutritionalfunds` AS select avg(`nutritional`.`funds`) AS `avg(funds)` from `nutritional` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `getnutritionalsource`
--

/*!50001 DROP VIEW IF EXISTS `getnutritionalsource`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`welfare`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `getnutritionalsource` AS select `nutritional`.`program_name` AS `program_name`,`nutritionalsource`.`source` AS `source` from (`nutritional` join `nutritionalsource` on((`nutritional`.`program_ID` = `nutritionalsource`.`program_ID`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `incomebetween10000and30000`
--

/*!50001 DROP VIEW IF EXISTS `incomebetween10000and30000`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`welfare`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `incomebetween10000and30000` AS select `income`.`total_net` AS `total_net` from `income` where ((`income`.`total_net` > 10000) and (`income`.`total_net` < 30000)) order by `income`.`recipient_ID` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `incomeover50000`
--

/*!50001 DROP VIEW IF EXISTS `incomeover50000`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`welfare`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `incomeover50000` AS select `income`.`recipient_ID` AS `recipient_ID`,`income`.`total_gross` AS `total_gross` from `income` group by `income`.`recipient_ID` having (`income`.`total_gross` > 50000) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `investmentsabovezero`
--

/*!50001 DROP VIEW IF EXISTS `investmentsabovezero`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`welfare`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `investmentsabovezero` AS select `c`.`recipient_ID` AS `recipient_ID`,`c`.`investments` AS `investments` from `income` `c` where exists(select 1 from `income` where (`c`.`investments` > 0)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `longestrecipientnamecount`
--

/*!50001 DROP VIEW IF EXISTS `longestrecipientnamecount`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`welfare`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `longestrecipientnamecount` AS select max(length(`recipient`.`first_name`)) AS `FirstNameCount`,max(length(`recipient`.`last_name`)) AS `LastNameCount` from `recipient` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `mangers`
--

/*!50001 DROP VIEW IF EXISTS `mangers`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`welfare`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `mangers` AS select `administrator`.`first_name` AS `first_name`,`administrator`.`last_name` AS `last_name` from `administrator` where (`administrator`.`title` like 'm%') order by `administrator`.`first_name` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `nutritionalfundsoverorunder`
--

/*!50001 DROP VIEW IF EXISTS `nutritionalfundsoverorunder`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`welfare`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `nutritionalfundsoverorunder` AS select `nutritional`.`funds` AS `funds` from `nutritional` where ((`nutritional`.`funds` > 500000) or (`nutritional`.`funds` < 250000)) order by `nutritional`.`funds` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `oldestyear`
--

/*!50001 DROP VIEW IF EXISTS `oldestyear`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`welfare`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `oldestyear` AS select year(min(`recipient`.`birthdate`)) AS `Year` from `recipient` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `recipientseligibleforallmedicalprograms`
--

/*!50001 DROP VIEW IF EXISTS `recipientseligibleforallmedicalprograms`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`welfare`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `recipientseligibleforallmedicalprograms` AS select `income`.`recipient_ID` AS `recipient_ID` from `income` where (`income`.`total_net` < (select min(`medical`.`funds`) from `medical`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `recipnameandincome`
--

/*!50001 DROP VIEW IF EXISTS `recipnameandincome`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`welfare`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `recipnameandincome` AS select `recipient`.`first_name` AS `first_name`,`recipient`.`last_name` AS `last_name`,`income`.`total_net` AS `total_net` from (`recipient` join `income` on((`recipient`.`ID` = `income`.`recipient_ID`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `totalgrossover10000`
--

/*!50001 DROP VIEW IF EXISTS `totalgrossover10000`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`welfare`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `totalgrossover10000` AS select `income`.`recipient_ID` AS `recipient_ID` from `income` where ((`income`.`total_gross` > 10000) and (`income`.`investments` > 0)) order by `income`.`total_gross` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-13 22:43:40
