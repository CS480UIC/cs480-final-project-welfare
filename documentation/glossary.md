# Entities

### login
--Name: login

--Synonym: credentials

--Description: allows access to recipients and administrators

### recipient
--Name: recipient 

--Synonym: receiver, grantee, beneficiary

--Description: This entity stores the personal information of the welfare recipients.

### administrator
--Name: administrator 

--Synonym: manager, official, supervisor

--Description: This entity stores the personal information of the administrators in charge of dispersing the funds to the recipients.

### income
--Name: income

--Synonym: salary

--Description: holds information about the recipients gross and net income, as well as income from investments


### address
--Name: address

--Synonym: location

--Description: holds information about the recipient's address


### eligibility
--Name: eligibility

--Synonym: qualifications

--Description: A table containing required information that determines a recipient’s ability to get government assistance


### medical
--Name: medical

--Synonym: healthcare

--Description: A table containing the information about a program that offers medical funds to those that are eligible and in need


### housing
—Name: Nutritional

—Synonym: Nutritional welfare programs

—Description: Holds information about different nutritional programs for recipients to choose from and apply to.


### nutritional
—Name: Housing 

—Synonym: Housing welfare programs

—Description: holds information about different housing programs for recipients to choose from and apply to.


# Relationships
### recipient_makes_income:
there are many recipients who make an income. There is no more than 1 income per recipient. A recipient isn't required to have an income and if there is an income, there must be a recipient that has that income.


### recipient_livesAt_address:
A recipient can have no more than 1 address. There is no more than 1 address per recipient. A recipient isnt required to have an address. An address must have 1 recipient living at it.


### recipient_proves_eligibility:
Every one recipient proves there eligibility once.


### administrator_receivesFundsFrom_medical:
Many administrators can receive funds from many medical programs.

### administrator_DispersesFundsTo_recipient
An administrator can disperse funds to 0 (minima) recipients or to many (maxima) recipients.

### admistrator_DispersesFundsFrom_nutritional :
Many administrator can receive funds from many nutritional programs.

### administrator_DispersesFundsFrm_housing:
Many administrator can receive funds from many housing programs.

A recipient receives funds from either 1(maxima) administrator or recieves nothing from 0 (minima) administrators.

### login_grantsAccessTo_recipient: 
No more than 1 login for 1 recipient. 1 recipient can have no more than 1 login. There may be no login for a recipient, and a recipient may have no login information.

### login_grantsAccessTo_administrator: 
No more than 1 login for 1 administrator. 1 administrator can have no more than 1 login. There may be no login for an administrator , and an administrator may have no login information.


# Attributes

### login - username 1 - 1(1),   password 1 - 1(1)

### recipient - ID 1-1 (1), first_name M-1 (1), last_name M-1 (1)

### administrator - ID 1-1 (1), first_name M-1 (1), last_name M-1 (1), title M-1 (1)

### income - recipient_ID 1-1(1), total_gross M - 1(1), total_net M - 1(1), investments M - 1(1)

### address - recipient_ID 1-1(1), city M - 1(1), state M - 1(1), street M-1(1)

### eligibility - recipient_ID 1-1(1), citizenship M-1(1), residency M-1(1), family M-1(1)

### medical - program_name (M-1), ID (1-1), facility (M-M), funds (M-1)

### housing - Program_name(M-1(1)), ID (1-1(1)), source(M-M(1)), funds(M-1(1))

### nutritional - program_name(M-1(1)), ID(1-1(1), housing_size(M-1(1), funds(M-1(1))


# Attributes Data Types

### eligibility
recipient_ID INTEGER

citizenship BOOLEAN

residency BOOLEAN

family SMALLINT

### medical
program_name VARCHAR(300)

ID INTEGER

facility VARCHAR(300)

funds BIGINT


# Dependent Entities and Dependency Relationships
### income:
recipient_makes_income

### address:
recipient_livesAt_address

### eligibility:
recipient_proves_eligibility

### medical:
administrator_receivesFundsFrom_medical

### administrator
login_grantsAccessTo_administrator: 

### recipient
administrator_DispersesFundsTo_recipient
login_grantsAccessTo_recipient: 

### admistrator_DispersesFundsFrom_nutritional :

### administrator_DispersesFundsFrm_housing:


# Supertypes, Subtypes, and Partitions
we did not have any Supertypes, Subtypes, and Partitions in our diagram

# Cascade/Restrict Dependency Relationships

### recipient_makes_income:

### recipient_livesAt_address:

### recipient_proves_eligibility:

### administrator_receivesFundsFrom_medical:

### administrator_DispersesFundsTo_recipient
DELETE CASCADE
### admistrator_DispersesFundsFrom_nutritional :

### administrator_DispersesFundsFrm_housing:

### login_grantsAccessTo_recipient: 
DELETE CASCADE
### login_grantsAccessTo_administrator: 
DELETE CASCADE

# Cascade/Restrict Foreign Keys



