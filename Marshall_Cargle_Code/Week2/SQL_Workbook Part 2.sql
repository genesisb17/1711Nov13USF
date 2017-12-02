--Part II – Creating and working with your own custom database
--1.0	Creating the OfficeSupply Database
--1.1 Create Company Database using SSMS Interface
--Task – Create a user and name it “OfficeSupply” in Oracle Web Console
-- USER SQL
CREATE USER OfficeSupply IDENTIFIED BY p4ssw0rd 
DEFAULT TABLESPACE "USERS"
TEMPORARY TABLESPACE "TEMP";

-- QUOTAS

-- ROLES
GRANT "CONNECT" TO OfficeSupply ;
GRANT "RESOURCE" TO OfficeSupply ;

-- SYSTEM PRIVILEGES
GRANT CREATE VIEW TO OfficeSupply ;
GRANT CREATE SESSION TO OfficeSupply ;
GRANT CREATE TABLE TO OfficeSupply ;
/
--Task – Delete the OfficeSupply user
drop user "OFFICESUPPLY" CASCADE;
/
--1.2 Create Company Database using DDL
--Task – Create a user and name it “OfficeSupply” using DDL (SQL Script in SQL Developer)
-- USER SQL
CREATE USER OfficeSupply IDENTIFIED BY p4ssw0rd 
DEFAULT TABLESPACE "USERS"
TEMPORARY TABLESPACE "TEMP";

-- QUOTAS

-- ROLES
GRANT "CONNECT" TO OfficeSupply ;
GRANT "RESOURCE" TO OfficeSupply ;

-- SYSTEM PRIVILEGES
GRANT CREATE VIEW TO OfficeSupply ;
GRANT CREATE SESSION TO OfficeSupply ;
GRANT CREATE TABLE TO OfficeSupply ;
/
--2.0	Creating Tables and Relationships
--2.1 Create Tables for OfficeSupply
--Task – Using the DDL, create a table named “Employees” with following attributes and datatypes: 
--EmployeeID(PK number, not null), UserName(varchar(20), not null), Password(varchar(20), not null), 
--Name(varchar(25), not null), Department(char(2), not null), Manager(number, not null).
CREATE TABLE Employees
(
    EmployeeID NUMBER NOT NULL,
    Username VARCHAR2(20) NOT NULL,
    Password VARCHAR(20) NOT NULL,
    Name VARCHAR(25) NOT NULL,
    Department CHAR(2) NOT NULL,
    Manager Number NOT NULL,
    CONSTRAINT PK_Employee PRIMARY KEY  (EmployeeID)
);
/
--Task – Using the DDL, create a table named “Orders” with following attributes and datatypes:
--OrderID(PK, number, not null), EmployeeID(FK, number, not null), OrderDate(date, not null), Status(char, not null).
CREATE TABLE Orders
(
    OrderID NUMBER NOT NULL,
    EmployeeID Number NOT NULL,
    OrderDate Date NOT NULL,
    Status CHAR(2) NOT NULL,
    CONSTRAINT PK_Order PRIMARY KEY  (OrderID)
);
/
ALTER TABLE Orders ADD CONSTRAINT FK_EmployeeID
    FOREIGN KEY (EmployeeID) REFERENCES Employees (EmployeeID);
/
--Task – Using the DDL, create a table named “OrderItem” with the following attributes and datatypes:
--OrderID(PK, FK, number, not null), ProductID(PK, FK, number, not null), Quantity(number, not null).
CREATE TABLE OrderItem
(
    OrderID NUMBER NOT NULL,
    ProductID Number NOT NULL,
    Quantity Number NOT NULL,
    CONSTRAINT PK_OrderItem PRIMARY KEY  (OrderID,ProductID)
);
/
ALTER TABLE OrderItem ADD CONSTRAINT FK_OrderID
    FOREIGN KEY (OrderID) REFERENCES Orders (OrderID);
/
ALTER TABLE OrderItem ADD CONSTRAINT FK_ProductID
    FOREIGN KEY (ProductID) REFERENCES Product (ProductID);
/
--Task – Using DDL, create a table named “Category” with the following attributes and datatypes:
--CatID(PK, number, not null), Name(varchar(80), null), Descript(varchar(255), null)
CREATE TABLE Category
(
    CatID NUMBER NOT NULL,
    Name VARCHAR(80) NOT NULL,
    Descript VARCHAR(225) NOT NULL,
    CONSTRAINT PK_Cat PRIMARY KEY  (CatID)
);
/

--Task – Using DDL, create a table named “Product” with the following attributes and datatypes:
--ProductID(PK, number, not null), CatID(FK, number, not null), Name(varchar(80), null), Descript(varchar(255), null),
--UnitCost(number, null), SuppID(FK, number, not null).
CREATE TABLE Product
(
    ProductID NUMBER NOT NULL,
    CatID Number NOT NULL,
    Name VARCHAR(80) NOT NULL,
    Descript VARCHAR(225) NOT NULL,
    UnitCost Number NOT NULL,
    SuppID Number not null,
    CONSTRAINT PK_Product PRIMARY KEY  (ProductID)
);
/
ALTER TABLE Product ADD CONSTRAINT FK_CatID
    FOREIGN KEY (CatID) REFERENCES Category (CatID);
/
ALTER TABLE Product ADD CONSTRAINT FK_SuppID
    FOREIGN KEY (SuppID) REFERENCES Supplier (SuppID);
/
--Task – Using DDL, create a table named “Supplier” with the following attributes and datatypes:
--SuppID(PK, number, not null), Name(varchar(80), null).
CREATE TABLE Supplier
(
    SuppID NUMBER NOT NULL,
    Name VARCHAR(80) NOT NULL,
    CONSTRAINT PK_Supplier PRIMARY KEY  (SuppID)
);
/

--2.2 Creating Relationships
--Task – Create a 1:N relationship between Employees(PK) and Orders(FK)
--Task – Create a 1:N relationship between Orders(PK) and OrderItem(FK)
--Task – Create a 1:N relationship between Product(PK) and OrderItem(FK)
--Task – Create a 1:N relationship between Supplier(PK) and Product(FK)
--Task – Create a 1:N relationship between Category(PK) and Product(FK)

--3.0	Performing SQL Queries
--3.1 SELECT
--Task – Select all the rows from the employees table
Select * From Employees;
--Task – Select all the rows from the employees table where the Department is HR
Select * From EMployees where department = 'HR';
--Task – Select all the rows from the employees table where username is jsmith and department is HR
Select * from employees where department ='HR' and username='jsmith';
--Task – Select all the rows from the employees table where manager is true or department is HR
Select * from employees where manager=true or department = 'HR';

--3.2 ORDER BY
--Task – Select name from product table and order by name in ascending order.
select name from PRODUCT order by ASC;
--Task – Select name from product table and order by name in descending order.
select name from product order by DESC;
--Task- Select all records from category table order by name.
select * from CATEGORY order by name;

--3.3 INSERT INTO
--3.4 UPDATE
--Task – Update unit cost in products table where name is ruler
update product set unitcost where name='ruler'
