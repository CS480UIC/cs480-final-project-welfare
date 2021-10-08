# Entities

### login

### recipient

### administrator

### income
--Name: income

--Synonym: salary

--Description: holds information about the recipients gross and net income, as well as income from investments


### address
--Name: address

--Synonym: location

--Description: holds information about the recipient's address


### eligibility

### medical

### housing

### nutritional

# Relationships
### recipient_makes_income:
there are many recipients who make an income. There is no more than 1 income per recipient. A recipient isn't required to have an income and if there is an income, there must be a recipient that has that income.


### recipient_livesAt_address:
A recipient can have no more than 1 address. There is no more than 1 address per recipient. A recipient isnt required to have an address. An address must have 1 recipient living at it.


# Attributes

### login - 

### recipient - 

### administrator - 

### income - 

### address - 

### eligibility - recipient_ID, citizenship, residency, family

### medical - program_name, ID, facility, funds

### housing - 

### nutritional - 
