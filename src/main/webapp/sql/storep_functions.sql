### SELECT ALL RECIPIENTS PROCEDURE ###

USE `welfare`;
DROP procedure IF EXISTS `selectAllRecips`;

USE `welfare`;
DROP procedure IF EXISTS `welfare`.`selectAllRecips`;
;

DELIMITER $$
USE `welfare`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `selectAllRecips`()
BEGIN
SELECT * FROM recipient;
END$$

DELIMITER ;
;

#### GET RECIPIENT INCOME FUNCTION ###

USE `welfare`;
DROP function IF EXISTS `getRecipIncome`;

USE `welfare`;
DROP function IF EXISTS `welfare`.`getRecipIncome`;
;

DELIMITER $$
USE `welfare`$$
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
END$$

DELIMITER ;
;

### SELECT ALL ADDRESS PROCEDURE ###
USE `welfare`;
DROP procedure IF EXISTS `new_procedure`;

DELIMITER $$
USE `welfare`$$
CREATE PROCEDURE `new_procedure` ()
BEGIN
SELECT recipient_ID
FROM address
WHERE city = "Chicago";
END$$

DELIMITER ;
;
#### GET TOTAL NET INCOME OF ALL RECIPIENTS FUNCTION ###

USE welfare;
DROP function IF EXISTS new_function;

DELIMITER $$
USE welfare$$
CREATE FUNCTION new_function ()
RETURNS INTEGER
READS SQL DATA
BEGIN
DECLARE netSum INT;
SELECT SUM(total_net) INTO netSum
FROM income;
RETURN netSum;
END$$

DELIMITER ;
;