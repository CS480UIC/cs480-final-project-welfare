# Entities

### login

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


### nutritional


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

A recipient receives funds from either 1(maxima) administrator or recieves nothing from 0 (minima) administrators.

# Attributes

### login - 

### recipient - ID 1-1 (1), first_name M-1 (1), last_name M-1 (1)

### administrator - ID 1-1 (1), first_name M-1 (1), last_name M-1 (1), title M-1 (1)

### income - recipient_ID 1-1(1), total_gross M - 1(1), total_net M - 1(1), investments M - 1(1)

### address - recipient_ID 1-1(1), city M - 1(1), state M - 1(1), street M-1(1)

### eligibility - recipient_ID 1-1(1), citizenship M-1(1), residency M-1(1), family M-1(1)

### medical - program_name (M-1), ID (1-1), facility (M-M), funds (M-1)

### housing - 

### nutritional - 
