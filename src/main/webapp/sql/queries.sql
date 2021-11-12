### Simple Queries ###
CREATE VIEW NutritionalFundsOver500000 AS
SELECT funds
FROM nutritional
WHERE funds > 500000
ORDER BY funds;

CREATE VIEW NetIncomeOver50000 AS
SELECT total_net 
FROM income
WHERE total_net > 50000
ORDER BY recipient_ID;

CREATE VIEW TotalGrossOver10000 AS
SELECT recipient_ID
FROM income
WHERE total_gross > 10000
ORDER BY total_gross;

### Aggregate Queries ###

# numeric function
 CREATE VIEW AvgNutritionalFunds AS
SELECT avg(funds)
FROM nutritional;

# string function
CREATE VIEW LongestRecipientName AS
SELECT MAX(LEN(first_name)) 
FROM recipient;

# date function
CREATE VIEW OldestDate AS
SELECT MIN(birthdate) AS "Min Date"  
FROM recipient;

### Complex Queries ###

# complex query using join
 CREATE VIEW recipNameAndIncome AS
SELECT recipient.first_name, recipient.last_name, income.total_net
FROM recipient
INNER JOIN income on recipient.ID = income.recipient_ID;

# correlated subquery query without exists
CREATE VIEW NetIncomeDoesNotExceedFundsPerRecipient AS
SELECT COUNT(ID) AS numOfRecipients 
FROM recipient
WHERE (funds / numOfRecipients) >
	(SELECT total_net 
	FROM income
	WHERE recipient.id = recipient_id);

# correlated subquery query with exists
CREATE VIEW InvestmentsAboveZero AS
SELECT recipient_ID, investments
FROM income C
WHERE EXISTS
	(SELECT *
     FROM income
     WHERE C.investments > 0);	

### CREATING INDEXES For Each Table ###

# Index for recipient_table
CREATE INDEX recipID
ON recipient(ID);
# Index for administrator_table
CREATE INDEX AdminTitles
ON administrator(title);
