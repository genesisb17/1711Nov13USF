/*
2.1 SELECT
Task – Select all records from the Employee table.
Task – Select all records from the Employee table where last name is King.
Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
*/

select * from employee;
select * from employee where LASTNAME = 'King';
select * from employee where FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;

/*
2.2 ORDER BY
Task – Select all albums in Album table and sort result set in descending order by title.
Task – Select first name from Customer and sort result set in ascending order by city
*/
select * from Album order by TITLE desc;
select FIRSTNAME from CUSTOMER order by CITY asc;

/*
2.3 INSERT INTO
Task – Insert two new records into Genre table
Task – Insert two new records into Employee table
Task – Insert two new records into Customer table
*/
insert into GENRE (GENREID, NAME) VALUES (26, 'Bachata');
insert into GENRE (GENREID, NAME) VALUES (27, 'Balada');
insert into EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME) VALUES (9, 'Rony', 'Alvarez');
insert into EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME) VALUES (10, 'David', 'Alcazar');
insert into CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL) VALUES (60, 'Carlos', 'Martinez', 'cmartinez@gmail.com');
insert into CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL) VALUES (61, 'Carlos', 'Arriola', 'carriola@gmail.com');

/* 
2.4 UPDATE
Task – Update Aaron Mitchell in Customer table to Robert Walter
Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
*/
UPDATE CUSTOMER SET FIRSTNAME = 'Robert', LASTNAME = 'Walter' WHERE CUSTOMERID = 32;
UPDATE ARTIST SET NAME = 'CCR' WHERE ARTISTID = 76;

/*
2.5 LIKE
Task – Select all invoices with a billing address like “T%”
*/
select * from INVOICE where BILLINGADDRESS like 'T%';

/*
2.6 BETWEEN
Task – Select all invoices that have a total between 15 and 50
Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
*/
select * from INVOICE where TOTAL BETWEEN 15 and 50;
select * from EMPLOYEE where HIREDATE BETWEEN '01-JUN-2003' and '01-MAR-2004';\

/*
2.7 DELETE
Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
*/
DELETE FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';


/*
3.1 System Defined Functions
Task – Create a function that returns the current time.
Task – create a function that returns the length of a mediatype from the mediatype table
*/
CREATE OR REPLACE FUNCTION current_time
RETURN DATE IS
l_sysdate date;
BEGIN
  select sysdate into l_sysdate from dual;

  RETURN l_sysdate;
END;

select CURRENT_TIME() from dual;


/*
3.2 System Defined Aggregate Functions
Task – Create a function that returns the average total of all invoices
Task – Create a function that returns the most expensive track
*/
CREATE OR REPLACE FUNCTION returnAverage 
RETURN INT AS
average int;
BEGIN
  select AVG(TOTAL) into average from INVOICE;

  RETURN average;
  
END;

select returnAverage() from dual;


CREATE OR REPLACE FUNCTION mostExpensive
RETURN INT AS
mostexp int;
BEGIN

  select MAX(UNITPRICE) INTO mostexp from TRACK;

  RETURN mostexp; 

END;

select MOSTEXPENSIVE from dual;


/* 
3.3 User Defined Scalar Functions
Task – Create a function that returns the average price of invoiceline items in the invoiceline table
*/
CREATE OR REPLACE FUNCTION averageprice
return number is
average number;
begin

  select AVG(UNITPRICE) into average from INVOICELINE;
  
  return average;
  
end;

select averageprice() from dual;



/************************************************************************************
3.4 User Defined Table Valued Functions
Task – Create a function that returns all employees who are born after 1968.
*/************************************************************************************
create or replace function allemployees
return table as
allemployees table;
begin

  select * into allemployees from EMPLOYEE;

  return allemployees;

end;




/*
4.1 Basic Stored Procedure
Task – Create a stored procedure that selects the first and last names of all the employees.
*/
CREATE OR REPLACE 
PROCEDURE PROCE
AS
  TYPE FIRST_NAME IS TABLE OF EMPLOYEE.FIRSTNAME%TYPE;
  TYPE LAST_NAME IS TABLE OF EMPLOYEE.LASTNAME%TYPE;
  FIRST_NAMES FIRST_NAME;
  LAST_NAMES LAST_NAME;
BEGIN
  SELECT FIRSTNAME, LASTNAME BULK COLLECT INTO FIRST_NAMES, LAST_NAMES FROM EMPLOYEE;
END;
/

--DROP PROCEDURE PROCE
--EXECUTE PROCE();
--SET SERVEROUTPUT ON;


/*
4.2 Stored Procedure Input Parameters
Task – Create a stored procedure that updates the personal information of an employee.
Task – Create a stored procedure that returns the managers of an employee.
*/
CREATE OR REPLACE PROCEDURE UPDATE_INFO
AS
BEGIN
  UPDATE EMPLOYEE SET CITY = 'Tampa' WHERE EMPLOYEEID = 9;
END;
/

--EXECUTE UPDATE_INFO;


CREATE OR REPLACE PROCEDURE RETURN_MANAGERS(REPORTS_TO IN NUMBER)
AS
R_T NUMBER;
BEGIN
  SELECT REPORTSTO INTO R_T FROM EMPLOYEE WHERE EMPLOYEEID = REPORTS_TO;
  DBMS_OUTPUT.PUT_LINE( R_T );
END;
/

--EXEC RETURN_MANAGERS(3);



/*
4.3 Stored Procedure Output Parameters
Task – Create a stored procedure that returns the name and company of a customer.
*/
CREATE OR REPLACE PROCEDURE NAME_COMPANY(CUST_ID IN NUMBER, CUST_NAME OUT CUSTOMER.FIRSTNAME%TYPE, CUST_COMPANY OUT CUSTOMER.COMPANY%TYPE)
AS
BEGIN
  SELECT FIRSTNAME, COMPANY INTO CUST_NAME, CUST_COMPANY FROM CUSTOMER WHERE CUSTOMERID = CUST_ID;
END;

-- TESTING
DECLARE
CUSTU_NAME CUSTOMER.FIRSTNAME%TYPE;
CUSTU_COMPANY CUSTOMER.COMPANY%TYPE;
BEGIN
  NAME_COMPANY(5,CUSTU_NAME,CUSTU_COMPANY);
  DBMS_OUTPUT.PUT_LINE('THE CUSTOMER NAME IS -> '||CUSTU_NAME||' AND THE COMPANY IS -> '||CUSTU_COMPANY);
END;
/



/*
TRANSACTIONS
Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
*/
-- FIRST I DELETED THE CONTRAINT AND CREATE A NEW ON CASCADE DELETE CONTRAINT
ALTER TABLE INVOICELINE
DROP CONSTRAINT FK_INVOICELINEINVOICEID;

ALTER TABLE INVOICELINE
ADD CONSTRAINT FK_INVOICELINEINVOICEIDD
  FOREIGN KEY (INVOICEID)
  REFERENCES INVOICE(INVOICEID)
  ON DELETE CASCADE
/

-- NOW I CREATE THE PROCUDERE
CREATE OR REPLACE PROCEDURE DELETE_INVOICE(INVOICE_ID IN NUMBER)
AS
BEGIN
  
  DELETE FROM INVOICE WHERE INVOICEID = INVOICE_ID;
    
END;
/

EXEC DELETE_INVOICE(3);


/*
Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
*/
CREATE OR REPLACE PROCEDURE INSERT_NEW_ROW(CUSTOMER_ID IN CUSTOMER.CUSTOMERID%TYPE, FIRST_NAME IN CUSTOMER.FIRSTNAME%TYPE, LAST_NAME IN CUSTOMER.LASTNAME%TYPE, E_MAIL IN CUSTOMER.EMAIL%TYPE) 
AS
BEGIN

  SET TRANSACTION NAME 'FIRST_TRANS';
  INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL) VALUES (CUSTOMER_ID, FIRST_NAME, LAST_NAME, E_MAIL);
  COMMIT;

END;
/

EXEC INSERT_NEW_ROW(62, 'RONY', 'ALVAREZ', 'ronyalvarez@gmail.com');



--6.0 triggers
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
create or replace TRIGGER EMP_TRIGGER
AFTER INSERT ON EMPLOYEE
FOR EACH ROW
BEGIN
dbms_output.put_line('employee has been inserted');
END;
/

--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER insrt_alb
after update on album
for each row
begin 
dbms_output.put_line('album has been updated');
end;
/

CREATE OR REPLACE TRIGGER customer_after_delete
AFTER DELETE ON customer
FOR EACH ROW
begin 
dbms_output.put_line('row from customer has been deleted');
end;
/

-- 7.0 joins
-- 7.1 INNER Task – Create an inner join that joins customers and orders and 
-- specifies the name of the customer and the invoiceId.
select customer.firstname, invoice.invoiceid
from customer inner join invoice on customer.customerid = invoice.customerid;

-- 7.2 OUTER
-- Task – Create an outer join that joins the customer and invoice table, 
-- specifying the CustomerId, firstname, lastname, invoiceId, and total.
select customer.customerid, customer.firstname, customer.lastname, invoice.invoiceId, invoice.total
from customer full outer join invoice on customer.customerid = invoice.customerid;

-- 7.3 RIGHT
-- Task – Create a right join that joins album and artist specifying artist name and title.
select artist.name
, album.title
from album right join artist on artist.artistid = album.artistid;

-- 7.4 cross 
-- Create a cross join that joins album and artist and sorts by artist name in ascending order.
select album.title, artist.name
from artist cross join album
order by artist.name
 asc;
 
-- 7.5 self
-- Perform a self-join on the employee table, joining on the reportsto column.
SELECT a.employeeid AS "Emp_ID", a.firstname AS "Employee Name",
b.reportsto AS "Supervisor ID"
FROM employee a, employee b
WHERE a.employeeid = b.employeeid;



/*
1.2 Create Company Database using DDL
Task – Create a user and name it “OfficeSupply” using DDL (SQL Script in SQL Developer)
*/
CREATE USER OfficeSupply IDENTIFIED BY p4ssw0rd;
grant connect to OfficeSupply;
grant RESOURCE to OfficeSupply;

/*
2.1 Create Tables for OfficeSupply
Task – Using the DDL, create a table named “Employees” with following attributes and datatypes: 
EmployeeID(PK number, not null), UserName(varchar(20), not null), Password(varchar(20), not null), 
Name(varchar(25), not null), Department(char(2), not null), Manager(number, not null).
*/
CREATE TABLE EMPLOYEES(
  EmployeeID NUMBER PRIMARY KEY not null, 
  UserName varchar(20) not null, 
  Password varchar(20) not null, 
  Name varchar(25) not null, 
  Department char(2) not null, 
  Manager number not null
);


/*
Task – Using the DDL, create a table named “Orders” with following attributes and datatypes:
OrderID(PK, number, not null), EmployeeID(FK, number, not null), OrderDate(date, not null), Status(char, not null).
*/
CREATE TABLE ORDERS(
  OrderID number PRIMARY KEY not null, 
  EmployeeID number not null, 
  OrderDate date not null, 
  Status char not null,
  CONSTRAINT FK_EMPLOYEEID FOREIGN KEY(EMPLOYEEID) REFERENCES EMPLOYEES(EMPLOYEEID)
);
/


/*
Task – Using the DDL, create a table named “OrderItem” with the following attributes and datatypes:
OrderID(PK, FK, number, not null), ProductID(PK, FK, number, not null), Quantity(number, not null).
*/
CREATE TABLE ORDERITEM(
  OrderID NUMBER not null, 
  ProductID NUMBER not null, 
  Quantity number not null,
  CONSTRAINT PK_ORDERITEM PRIMARY KEY (ORDERID, PRODUCTID),
  CONSTRAINT FK_ORDERID FOREIGN KEY(ORDERID) REFERENCES ORDERS(ORDERID)
);
/


/*
Task – Using DDL, create a table named “Category” with the following attributes and datatypes:
CatID(PK, number, not null), Name(varchar(80), null), Descript(varchar(255), null)
*/
CREATE TABLE CATEGORY(
  CatID number PRIMARY KEY not null, 
  Name varchar(80) null, 
  Descript varchar(255) null
);
/


/*
Task – Using DDL, create a table named “Product” with the following attributes and datatypes:
ProductID(PK, number, not null), CatID(FK, number, not null), Name(varchar(80), null), Descript(varchar(255), null),
UnitCost(number, null), SuppID(FK, number, not null).
*/
CREATE TABLE PRODUCT(
ProductID number PRIMARY KEY not null, 
CatID number not null, 
Name varchar(80) null, 
Descript varchar(255) null,
UnitCost number null, 
SuppID number not null
);
/


/*
Task – Using DDL, create a table named “Supplier” with the following attributes and datatypes:
SuppID(PK, number, not null), Name(varchar(80), null).
*/
CREATE TABLE SUPPLIER(
SuppID number PRIMARY KEY not null, 
Name varchar(80) null
);
/


/*
2.2 Creating Relationships
Task – Create a 1:N relationship between Employees(PK) and Orders(FK)
Task – Create a 1:N relationship between Orders(PK) and OrderItem(FK)
Task – Create a 1:N relationship between Product(PK) and OrderItem(FK)
Task – Create a 1:N relationship between Supplier(PK) and Product(FK)
Task – Create a 1:N relationship between Category(PK) and Product(FK)
*/
ALTER TABLE ORDERITEM ADD CONSTRAINT FK_PRODUCTID FOREIGN KEY(PRODUCTID) REFERENCES PRODUCT(PRODUCTID);
ALTER TABLE PRODUCT ADD CONSTRAINT FK_SUPPID FOREIGN KEY(SUPPID) REFERENCES SUPPLIER(SUPPID);
ALTER TABLE PRODUCT ADD CONSTRAINT FK_CATID FOREIGN KEY(CATID) REFERENCES CATEGORY(CATID);


/*
PERFORMING SQL QUERIES
*/
INSERT INTO "OFFICESUPPLY"."CATEGORY" (CATID, NAME) VALUES ('1', 'Office Supplies')
INSERT INTO "OFFICESUPPLY"."CATEGORY" (CATID, NAME) VALUES ('2', 'Art Supplies')
INSERT INTO "OFFICESUPPLY"."CATEGORY" (CATID, NAME) VALUES ('3', 'Cleaning Supplies')
INSERT INTO "OFFICESUPPLY"."CATEGORY" (CATID, NAME) VALUES ('4', 'Computer Supplies ')
INSERT INTO "OFFICESUPPLY"."CATEGORY" (CATID, NAME) VALUES ('5', 'Desk Accessories ')
INSERT INTO "OFFICESUPPLY"."CATEGORY" (CATID, NAME) VALUES ('6', 'Writing Supplies')
INSERT INTO "OFFICESUPPLY"."CATEGORY" (CATID, NAME) VALUES ('7', 'Printer Supplies')

alter table employees modify manager varchar(5);
INSERT INTO "OFFICESUPPLY"."EMPLOYEES" (EMPLOYEEID, USERNAME, PASSWORD, NAME, DEPARTMENT, MANAGER) VALUES ('1', 'dclark', 'drc', 'dclark', 'HR', 'False')
INSERT INTO "OFFICESUPPLY"."EMPLOYEES" (EMPLOYEEID, USERNAME, PASSWORD, NAME, DEPARTMENT, MANAGER) VALUES ('2', 'jsmith', 'js', 'jsmith', 'IT', 'True')
INSERT INTO "OFFICESUPPLY"."EMPLOYEES" (EMPLOYEEID, USERNAME, PASSWORD, NAME, DEPARTMENT, MANAGER) VALUES ('3', 'mjones', 'mj', 'mjones', 'HR', 'True')
INSERT INTO "OFFICESUPPLY"."EMPLOYEES" (EMPLOYEEID, USERNAME, PASSWORD, NAME, DEPARTMENT, MANAGER) VALUES ('4', 'klink', 'kl', 'klink', 'IT', 'False')


alter table product modify productid varchar(10);
















