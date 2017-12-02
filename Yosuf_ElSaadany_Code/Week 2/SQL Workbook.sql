
-- 2.1) SELECT
SELECT * FROM EMPLOYEE; 
SELECT * FROM EMPLOYEE WHERE LASTNAME = 'King';
SELECT * FROM EMPLOYEE WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;

-- 2.2) ORDER BY
SELECT * FROM ALBUM ORDER BY TITLE DESC;
SELECT FIRSTNAME FROM CUSTOMER ORDER BY CITY ASC;

-- 2.3) INSERT INTO
INSERT INTO GENRE (GENREID,NAME) VALUES ('27','Brazilian Techno');
INSERT INTO GENRE (GENREID,NAME) VALUES ('28','Deep House');

INSERT INTO EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL)
VALUES ('100', 'ElSaadany', 'Yosuf', 'Engineer', '100', '06-DEC-1992', '13-NOV-2017', '15420 Livingstion Ave', 'Tampa', 'Florida', 'USA','33559', '+1 (614) 717-5692','100','jo.sadany@gmail.com');

INSERT INTO EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL)
VALUES ('1000', 'Genesis', 'Bonds', 'Engineer', NULL , '16-MAY-1992', '13-NOV-2017', '15420 Livingstion Ave', 'Tampa', 'Florida', 'USA','33559', '+1 (614) 717-5692','100','Mo.sadany@gmail.com');

SELECT * FROM EMPLOYEE;

-- 2.4) UPDATE
SELECT * FROM CUSTOMER;
UPDATE CUSTOMER SET FIRSTNAME = 'Robert' , LASTNAME = 'Walter' WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';
SELECT * FROM CUSTOMER;

UPDATE ARTIST SET NAME = 'CCR' WHERE NAME = 'Creedence Clearwater Revival';
SELECT * FROM ARTIST;

-- 2.5) LIKE
SELECT * FROM INVOICE;
SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';

-- 2.6) BETWEEN
SELECT * FROM INVOICE WHERE TOTAL BETWEEN 15 AND 50;
SELECT * FROM EMPLOYEE WHERE HIREDATE BETWEEN '1-JUN-03' AND '1-MAR-04';

-- 2.7) DELETE

ALTER TABLE Invoice
DROP CONSTRAINT FK_CONSTAINT;

ALTER TABLE Invoice
ADD CONSTRAINT FK_InvoiceCustomerId
FOREIGN KEY (CustomerId)
REFERENCES Customer (CustomerId) 
ON DELETE CASCADE;

ALTER TABLE Invoiceline
DROP CONSTRAINT FK_InvoiceLineInvoiceId;

ALTER TABLE InvoiceLine 
ADD CONSTRAINT FK_InvoiceLineInvoiceId
FOREIGN KEY (InvoiceId) 
REFERENCES Invoice (InvoiceId)
ON DELETE CASCADE;

DELETE FROM Customer WHERE Lastname = 'Walter';

SELECT * FROM CUSTOMER;

-- 3.1) System defined functions
-- Create a function that returns the current time.

-- get date
CREATE FUNCTION getDate
  
  RETURN DATE IS
    l_sysdate date;
    BEGIN
      SELECT sysdate
      INTO l_sysdate
      FROM dual;
    return l_sysdate;
    END;

CREATE OR REPLACE FUNCTION currentTime 
  RETURN TIME is X TIME;
  
  BEGIN
  
  SELECT CONVERT (TIME, CURRENT_TIMESTAMP) 
  INTO X 
  FROM dual;
  
  RETURN (X);
  END;

SELECT currentTime() FROM dual;

-- Create a function that returns the length of a mediatype from the mediatype table

CREATE OR REPLACE FUNCTION getLength

  RETURN NUMBER
  IS length1 NUMBER;
  BEGIN
     SELECT COUNT(mediatype.mediatypeid)
     INTO length1
     FROM mediatype;
    RETURN length1;
  END;
/
SELECT getlength FROM dual;

-- 3.2
-- Create a function that returns the average total of all invoices

CREATE OR REPLACE FUNCTION avrg

  RETURN NUMBER 
  IS avrg NUMBER;
    BEGIN
      SELECT AVG(invoice.total)
      INTO avrg
      FROM invoice;
      RETURN avrg;
    END;
    /

SELECT avrg FROM DUAL;

-- Create a function that returns the most expensive track

CREATE OR REPLACE FUNCTION mostexp

  RETURN NUMBER 
  IS expensive NUMBER;
    BEGIN
      SELECT MAX(invoice.total)
      INTO expensive
      FROM invoice;
      RETURN expensive;
    END;
  /

SELECT mostexp FROM DUAL;

-- 3.3 User Defined Scalar Functions
-- Create a function that returns the average price of invoiceline items in the invoiceline table

CREATE OR REPLACE FUNCTION avginvoiceline

  RETURN NUMBER
  IS invoice_avg NUMBER;
    BEGIN
      SELECT AVG(invoiceline.unitprice)
      INTO invoice_avg
      FROM invoiceline;
      RETURN invoice_avg;
    END;
/
SELECT avginvoiceline FROM dual;
  
-- 3.4 User Defined Table Valued Functions
-- Create a function that returns all employees who are born after 1968.

CREATE OR REPLACE FUNCTION allEmployees

  RETURN sys_refcursor 
  AS
    allEmp  sys_refcursor; 
  BEGIN
    OPEN allEmp FOR
      SELECT *
      FROM employee
      WHERE birthdate > '01-JAN-1968';
      RETURN allEmp;
  END;
  /
  
SELECT allEmployees FROM dual;
     
-- 4.1 Basic Stored Procedure
-- Create a stored procedure that selects the first and last names of all the employees

CREATE OR REPLACE PROCEDURE getEmployeeNames

AS
  getemp   sys_refcursor;
BEGIN
  OPEN getemp FOR
    SELECT 
        firstname,
        lastname
    FROM employee;
    RETURN getemp;  
END;
/

SELECT getEmployeeNames FROM dual;
  

END;
/

-- 6.1 AFTER/FOR 3
-- Create an after insert trigger on the employee table fired after a new record is inserted into the table.

CREATE OR REPLACE TRIGGER after_insert
AFTER INSERT
   ON employee
   FOR EACH ROW
BEGIN
  DBMS_OUTPUT.PUT_LINE('TRIGGER AFTER INSERT');
END;
/

-- Create an after update trigger on the album table that fires after a row is inserted in the table

CREATE OR REPLACE TRIGGER after_update
AFTER UPDATE
   ON employee
   FOR EACH ROW
BEGIN
  DBMS_OUTPUT.PUT_LINE('TRIGGER AFTER INSERT');
END;
/

-- Create an after delete trigger on the customer table that fires after a row is deleted from the table.

CREATE OR REPLACE TRIGGER after_insert
AFTER DELETE
   ON employee
   FOR EACH ROW
BEGIN
  DBMS_OUTPUT.PUT_LINE('TRIGGER AFTER DELETE');
END;
/
commit;

--7.1 INNER
-- Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.

select customer.firstname, customer.lastname, invoice.invoiceid
from customer
inner join invoice on customer.customerid = invoice.customerid;

--7.2 OUTER
-- Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.

select cus.customerid, cus.firstname, cus.lastname, inv.invoiceid, inv.total
from customer cus
inner join invoice inv on inv.customerid = cus.customerid;

--7.3 RIGHT
-- Create a right join that joins album and artist specifying artist name and title.

select artist.name as "Artist Name", album.title as "Album Name"
from artist
right join album on artist.artistid = album.artistid;

--7.4 CROSS
-- Create a cross join that joins album and artist and sorts by artist name in ascending order.
select artist.name as "Artist Name", album.title as "Album Name"
from artist
cross join album order by artist.name;

--7.5 SELF
-- Perform a self-join on the employee table, joining on the reportsto column.

select * 
from employee a, employee b
where a.employeeid <> b.employeeid
and a.REPORTSTO = b.REPORTSTO;

-- Part II – Creating and working with your own custom database
-- 1.0	Creating the OfficeSupply Database

-- 1.1 Create Company Database using SSMS Interface
-- Create a user and name it “OfficeSupply” in Oracle Web Console

CREATE USER OfficeSupply
IDENTIFIED BY pass;

GRANT connect to OfficeSupply;
GRANT resource to OfficeSupply;

-- Delete the OfficeSupply user


-- 1.2 Create Company Database using DDL
-- Create a user and name it “OfficeSupply” using DDL (SQL Script in SQL Developer)


-- 2.1 Create Tables for OfficeSupply
-- Using the DDL, create a table named “Employees” with following attributes and datatypes: 
-- EmployeeID(PK number, not null), UserName(varchar(20), not null), Password(varchar(20), not null), 
-- Name(varchar(25), not null), Department(char(2), not null), Manager(number, not null).

CREATE TABLE Employees
(
    EmployeeID number not null, 
    UserName varchar(20) not null, 
    Password varchar(20) not null, 
    Name varchar(25) not null, 
    Department char(2) not null, 
    Manager number not null,
    constraint PK_Employee primary key (EmployeeID)
);

-- Using the DDL, create a table named “Orders” with following attributes and datatypes:
-- OrderID(PK, number, not null), EmployeeID(FK, number, not null), OrderDate(date, not null), Status(char, not null).

CREATE TABLE Orders
(
    OrderID number not null,
    EmployeeID number not null,
    OrderDate date not null,
    Status char not null,
    constraint PK_OrderID primary key (OrderID)
);

ALTER TABLE Orders ADD CONSTRAINT FK_OrdersEmployee
    FOREIGN KEY (EmployeeID) REFERENCES Employees (EmployeeID) ;

-- Using the DDL, create a table named “OrderItem” with the following attributes and datatypes:
-- OrderID(PK, FK, number, not null), ProductID(PK, FK, number, not null), Quantity(number, not null).

CREATE TABLE OrderItem
(
    OrderID number not null,
    ProductID number not null,
    Quantity number not null,
    constraint PK_OrderItem primary key (OrderID, ProductID)
);

ALTER TABLE OrderItem ADD CONSTRAINT FK_OrderItemOrders
    FOREIGN KEY (OrderID) REFERENCES Orders (OrderID) ;
  
ALTER TABLE OrderItem ADD CONSTRAINT FK_OrderItemProduct
    FOREIGN KEY (ProductID) REFERENCES Product (ProductID) ;

-- Using DDL, create a table named “Category” with the following attributes and datatypes:
-- CatID(PK, number, not null), Name(varchar(80), null), Descript(varchar(255), null)

CREATE TABLE Category
(
    CatID number not null,
    Name varchar(80) null,
    Descript varchar(255) null,
    constraint PK_Category primary key (CatID)
);

-- Using DDL, create a table named “Product” with the following attributes and datatypes:
-- ProductID(PK, number, not null), CatID(FK, number, not null), Name(varchar(80), null), Descript(varchar(255), null),
-- UnitCost(number, null), SuppID(FK, number, not null).


CREATE TABLE Product
(
    ProductID number not null,
    CatID number not null,
    Name varchar(80) null,
    Descript varchar(255) null,
    UnitCost number null,
    SuppID number not null,
    constraint PK_Product primary key (ProductID)
);

alter table Product modify ProductID  varchar(20);



ALTER TABLE Product ADD CONSTRAINT FK_ProductCategory
    FOREIGN KEY (CatID) REFERENCES Category (CatID) ;
    
ALTER TABLE Product ADD CONSTRAINT FK_ProductSupplier
    FOREIGN KEY (SuppID) REFERENCES Supplier (SuppID);

-- Using DDL, create a table named “Supplier” with the following attributes and datatypes:
-- SuppID(PK, number, not null), Name(varchar(80), null).

CREATE TABLE Supplier 
(
    SuppID number not null,
    Name varchar(80) not null,
    constraint PK_Supplier primary key (SuppID)
);


-- 3.0 Performing SQL Queries

insert into employees (EMPLOYEEID, Name ,UserName, Password, Department, Manager)
values ('1', 'clark','dclark', 'drc', 'HR', '0');

insert into employees (EMPLOYEEID, Name ,UserName, Password, Department, Manager)
values ('2', 'smith','jsmith', 'js', 'IT', '1');

insert into employees (EMPLOYEEID, Name ,UserName, Password, Department, Manager)
values ('3', 'jones','mjones', 'mj', 'HR', '1');

insert into employees (EMPLOYEEID, Name ,UserName, Password, Department, Manager)
values ('4', 'klink','klink', 'kl', 'IT', '0');


insert into supplier (SuppID, Name)
values ('1', 'XYZ Office Supplies');

insert into supplier (SuppID, Name)
values ('2', 'ABC Office Products');


insert into category (CatID, Name, Descript)
values ('1', 'Audio Visual', null);

insert into category (CatID, Name, Descript)
values ('2', 'Art Supplies', null);

insert into category (CatID, Name, Descript)
values ('3', 'Cleaning Supplies', null);

insert into category (CatID, Name, Descript)
values ('4', 'Computer Supplies', null);

insert into category (CatID, Name, Descript)
values ('5', 'Desk Accessories', null);

insert into category (CatID, Name, Descript)
values ('6', 'Writing Supplies', null);

insert into category (CatID, Name, Descript)
values ('7', 'Printer Supplies', null);


insert into product (ProductID, CatID, Name, Descript, UnitCost, SuppID)
values ('10414', '2', 'Ruler', '12 inch stainless steel', '3.79', '2'); 

insert into product (ProductID, CatID, Name, Descript, UnitCost, SuppID)
values ('7070', '1', 'Transperancy', 'Quick dry ink jet', '24.29', '1'); 

insert into product (ProductID, CatID, Name, Descript, UnitCost, SuppID)
values ('1000', '1', 'Overhead Bulb', 'high intensity replacement bulb', '12', '1'); 

insert into product (ProductID, CatID, Name, Descript, UnitCost, SuppID)
values ('1200', '1', 'Laser Pointer', 'General purpose laser pointer', '29.99', '2'); 

insert into product (ProductID, CatID, Name, Descript, UnitCost, SuppID)
values ('68401', '2', 'Colored Pencils', 'Non toxic 12 pack', '2.84', '1'); 

insert into product (ProductID, CatID, Name, Descript, UnitCost, SuppID)
values ('91249', '3', 'All purpose cleaner', 'Use on all washable surfaces', '4.29', '2'); 

insert into product (ProductID, CatID, Name, Descript, UnitCost, SuppID)
values ('28124', '3', 'Paper Hand Towels', '320 sheets per roll', '5.25', '1');

insert into product (ProductID, CatID, Name, Descript, UnitCost, SuppID)
values ('41143', '4', 'CD-R', '700 mb with jewel case', '1.09', '1');

insert into product (ProductID, CatID, Name, Descript, UnitCost, SuppID)
values ('44766', '4', '3.5 inch Disks', 'High Density Formatted Box of 10', '5.99', '1'); 

insert into product (ProductID, CatID, Name, Descript, UnitCost, SuppID)
values ('12164', '4', 'Monitor Wipes', 'Non abrasive lint free', '6.99', '2'); 

insert into product (ProductID, CatID, Name, Descript, UnitCost, SuppID)
values ('22256', '4', 'Dust Blaster', 'Ozone safe no CFCs', '8.99', '2');

insert into product (ProductID, CatID, Name, Descript, UnitCost, SuppID)
values ('6200', '2', 'Clear Tape', '1 inch wide 6 rolls', '3.90', '1'); 

insert into product (ProductID, CatID, Name, Descript, UnitCost, SuppID)
values ('9700', '1', 'Overhead Projector', 'Portable with travel cover', '759.97', '1'); 

insert into product (ProductID, CatID, Name, Descript, UnitCost, SuppID)
values ('5000', '2', 'Glue Stick', 'Oderless non toxic', '1.99', '2'); 

commit;

--3.1 SELECT
-- Select all the rows from the employees table
select * from employees;

-- Select all the rows from the employees table where the Department is HR
select * from employees where Department = 'HR';

-- Select all the rows from the employees table where username is jsmith and department is HR
select * from employees where username = 'jsmith' AND department = 'HR';

-- Select all the rows from the employees table where manager is true or department is HR
select * from employees where manager = '1' OR department = 'HR';


--3.2 ORDER BY
-- Select name from product table and order by name in ascending order.
select name from product
order by name asc;

-- Select name from product table and order by name in descending order.
select name from product
order by name desc;

-- Select all records from category table order by name.
select * from category
order by name;


--3.3 INSERT INTO
-- Insert a new row into the employees table.
insert into employees (EMPLOYEEID, Name ,UserName, Password, Department, Manager)
values ('5', 'Yosuf','Yosuf.92', '123', 'IT', '0');

-- Insert into a new row into the category table
insert into category (CatID, Name, Descript)
values ('8', 'Other', null);

-- Insert three records into the supplier table.
insert into supplier (SuppID, Name)
values ('3', 'Home Supplies');

insert into supplier (SuppID, Name)
values ('4', 'School Supplies');

insert into supplier (SuppID, Name)
values ('5', 'Work Supplies');

commit;

--3.4 UPDATE
-- Update unit cost in products table where name is ruler
update product
set unitcost = '10'
where name = 'Ruler';

-- Update the description of computer and cleaning supplies in the Category table.
update category
set descript = 'Updated Description'
where name = 'Computer Supplies' or name = 'Cleaning Supplies';

--3.5 LIKE
-- Select username from employees table where username is like “j”
select username from employees
where username like '%j%';

-- Select name from product table where name is like “O”
select name from product
where name like '%O%';


--3.6 BETWEEN
-- Select name from products table where unitprice is between 3 and 10
select name from product
where unitcost between 3 AND 10;

-- Select name from products table where unit price is between 500 and 800
select name from product 
where unitcost between 500 AND 800;

--3.7 DELETE
-- Delete a record from the category where the value is audio visual
alter table product
drop constraint FK_ProductCategory;

ALTER TABLE Product
    ADD CONSTRAINT FK_ProductCategory
    FOREIGN KEY (CatID) 
    REFERENCES Category (CatID)
    ON DELETE CASCADE;
    
delete from category
where name = 'Audio Visual';

-- Delete the three records you previously inserted into the supplier table 
delete from supplier
where SuppID > 2;


commit;

-- 4.1 System Defined Scalar Functions
-- create a function that returns the length of the string of the description of the laser pointer

CREATE OR REPLACE FUNCTION stringlength
    RETURN NUMBER
    IS
      stringlength NUMBER;
    BEGIN
        SELECT LENGTH(descript) 
        INTO stringlength 
        FROM Product  
        WHERE name = 'Ruler';  
        RETURN stringlength;
    END;
/

select stringlength from dual;

-- Create a function the converts a username in the employees table to upper case.

CREATE OR REPLACE FUNCTION converts_upper
    RETURN VARCHAR
    IS
    uppercase VARCHAR;
    BEGIN   
      SELECT UCASE(username) 
      INTO uppercase
      FROM employees;
      RETURN uppercase;
    END;
/

select converts_upper from dual; 

-- 4.2 System Defined Aggregate Function
-- Create a function that gets the sum of the unitprice column from the products table
CREATE OR REPLACE FUNCTION sum_of_unitcost
    RETURN NUMBER
    IS
    sum_unit NUMBER;
    BEGIN   
      SELECT SUM(unitcost) 
      INTO sum_unit
      FROM product;
      RETURN sum_unit;
    END;
/

select sum_of_unitcost from dual;

-- Create a function that gets the count of all the products in the products table
CREATE OR REPLACE FUNCTION count_of_all_products
    RETURN NUMBER
    IS
    product_count NUMBER;
    BEGIN   
      SELECT COUNT(PRODUCTID) 
      INTO product_count
      FROM product;
      RETURN product_count;
    END;
/

select count_of_all_products from dual;

-- 4.4 User Defined Table Valued Functions
-- Create a function that returns whether or not a username belongs to a manager

CREATE OR REPLACE FUNCTION belongs(X in varchar)
    RETURN BOOLEAN
    IS
    YesOrNo BOOLEAN;
    z NUMBER;
    BEGIN   
      SELECT manager 
      INTO z
      FROM employees 
      WHERE manager = 1 AND username = X;
      
      IF z not null 
      THEN 
      YesOrNo = 1;
      ELSE 
      YesOrNo = 0;
      END IF;
      RETURN YesOrNo;
    END;
/

select belongs from dual;

-- 5.1 Basic Stored Procedure
-- Create a store procedure that returns all employees with the username, dept, and manager columns from the employees table. Call the procedure to get the result set.
CREATE OR REPLACE PROCEDURE return_all_employees(all_emps OUT SYS_REFCURSOR)
    AS
    BEGIN 
        OPEN all_emps FOR SELECT * FROM employees;
    END;
/

DECLARE 
allemps SYS_REFCURSOR;
BEGIN
return_all_employees(allemps);
END;
/

select return_all_employees from dual;

execute return_all_employees;
 

-- Create a stored procedure that returns all the products with the name, and unitprice column from the products table.
commit;



-- 8.1 INNER JOIN
-- Perform an inner join on tables product and category
Select *
from Product pr
inner join category ca on pr.CatID = ca.CatID;

-- Perform an inner join on tables employee and orders
Select *
from employees emp
inner join orders ord on ord.EmployeeID = emp.EmployeeID;



-- 8.2 OUTER JOIN
-- Perform an outer join on tables products and orderitems
-- Perform an outer join on tables employee and orders

8.3 RIGHT JOIN
Task – Perform a right join on tables orders and orderitems
Task – Perform a left join on tables product and orderitems

8.4 LEFT JOIN
Task – Perform a left join on tables product and category
Task – Perform a left join on tables employees and orders

8.5 CROSS JOIN
Task – Perform a cross join on tables product and category
8.6 SELF-JOIN
Task – using the employees table perform a self-join. You can break up the table as needed.

















