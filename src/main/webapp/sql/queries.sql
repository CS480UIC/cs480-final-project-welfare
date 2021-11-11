### Simple Queries ###
CREATE VIEW NutritionalFundsOver500000 AS
SELECT funds
FROM nutritional
WHERE funds > 500000
ORDER BY funds;

### Aggregate Queries ###

# numeric function
 CREATE VIEW AvgNutritionalFunds AS
SELECT avg(funds)
FROM nutritional;

### Complex Queries ###

# complex query using join
 CREATE VIEW recipNameAndIncome AS
SELECT recipient.first_name, recipient.last_name, income.total_net
FROM recipient
INNER JOIN income on recipient.ID = income.recipient_ID;