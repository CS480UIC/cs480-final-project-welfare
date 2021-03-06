### Simple Queries ###
CREATE VIEW NutritionalFundsOverOrUnder AS
SELECT funds
FROM nutritional
WHERE funds > 500000 OR FUNDS < 250000
ORDER BY funds;

CREATE VIEW IncomeBetween10000And30000 AS
SELECT total_net 
FROM income
WHERE total_net > 10000 AND total_net < 30000
ORDER BY recipient_ID;

CREATE VIEW TotalGrossOver10000 AS
SELECT recipient_ID
FROM income
WHERE total_gross > 10000 AND investments > 0
ORDER BY total_gross;

CREATE VIEW Mangers AS
SELECT first_name,last_name from administrator
where title like 'm%'
ORDER BY first_name;

### Aggregate Queries ###

# numeric function
 CREATE VIEW AvgNutritionalFunds AS
SELECT avg(funds)
FROM nutritional;

# string function
CREATE VIEW LongestRecipientNameCount AS
SELECT MAX(LENGTH(first_name)) AS FirstNameCount, MAX(LENGTH(last_name)) AS LastNameCount
FROM recipient;

# date function
CREATE VIEW OldestYear AS
SELECT YEAR(MIN(birthdate)) AS "Year"  
FROM recipient;

# having function
CREATE VIEW IncomeOver50000 AS
SELECT recipient_ID, total_gross from income
group by recipient_ID
having total_gross > 50000;

### Complex Queries ###

# complex query using join
 CREATE VIEW recipNameAndIncome AS
SELECT recipient.first_name, recipient.last_name, income.total_net
FROM recipient
INNER JOIN income on recipient.ID = income.recipient_ID;

# correlated subquery query without exists
CREATE VIEW RecipientsEligibleForAllMedicalPrograms AS
SELECT recipient_ID
FROM income
WHERE total_net <
	(SELECT MIN(funds) 
	 FROM medical);

# correlated subquery query with exists
CREATE VIEW InvestmentsAboveZero AS
SELECT recipient_ID, investments
FROM income C
WHERE EXISTS
	(SELECT *
     FROM income
     WHERE C.investments > 0);	
     
# complex query using join
CREATE VIEW getNutritionalSource AS
SELECT nutritional.program_name, nutritionalsource.source from nutritional 
inner join nutritionalsource on nutritional.program_ID = nutritionalsource.program_ID;

### CREATING INDEXES For Each Table ###

# Index for recipient_table
CREATE INDEX recipID
ON recipient(ID);

# Index for administrator_table
CREATE INDEX AdminTitles
ON administrator(title);

# Index for income_table
CREATE INDEX IncomeRecID
ON income(recipient_ID);

# Index for address_table
CREATE INDEX AddressRecID
ON address(recipient_ID);

# Index for medical_table
CREATE INDEX MedicalProgramID
ON medical(program_ID);

# Index for medicalfacility_table
CREATE INDEX MedicalFacility
ON medicalfacility(medicalfacility_ID);

# Index for eligibility_table
CREATE INDEX Eligibility
ON eligibility(recipient_ID);

# Index for housing_table
CREATE INDEX HousingProgramID
ON housing(program_ID);

# Index for nutritional_table
CREATE INDEX nutritionalProgramID
ON nutritional(program_ID);

# Index for nutritionalSource
CREATE INDEX nutritionalSource
ON nutritionalSource(program_ID);
