--SELECT Queries--
select * from Employee;
select * from EMPLOYEE where LASTNAME='King';
select * from employee where FIRSTNAME='Andrew' AND REPORTSTO=NULL;

--Order By--
select * from ALBUM order BY Title DESC;
select firstname from Customer order by CITY asc;

--Insert Into--
insert into GENRE (Genreid, name) values (918, 'Bachata');
insert into Employee (employeeid, lastname, firstname, title, reportsto, birthdate, hiredate,address,city,state,country,postalcode,phone,fax,email) values (1129,'diaz','alex','artist',NULL,TO_DATE('15-MAR-96', 'DD-MON-RR'),TO_DATE('15-NOV-16', 'DD-MON-RR'),'670 Shepherd Avenue', 'Brooklyn', 'NY', 'United States', '11208', '3477689349', null, 'alexd@gmail.com');
insert into Employee (employeeid, lastname, firstname, title, reportsto, birthdate, hiredate,address,city,state,country,postalcode,phone,fax,email) values (1130,'doe','John','artist',NULL,TO_DATE('29-NOV-96', 'DD-MON-RR'),TO_DATE('18-NOV-16', 'DD-MON-RR'),'1400 Washington Avenue', 'Albany', 'NY', 'United States', '12203', '3477689349', null, 'johnd@gmail.com');
insert into Customer (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId) VALUES (931, 'Joe', 'Budden', 'Money Team', '541 Broadway Street', 'Manhattan', 'NY', 'United States', '10443', '3477090195', '+55 (12) 3923-5566', 'jbud@gmail.com', 3);
insert into Customer (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId) VALUES (898, 'FIA', 'Papa', 'Phiota', '1931 Phiota Avenue', 'Phiotasia', 'Phiotalandia', 'United States', '19319', '3471898931', '3471898931 + 31', 'phiota@gmail.com', 3);

--Update--
UPDATE customer SET firstname = 'Robert', LASTNAME = 'Walter' where firstname='Aaron' and LASTNAME = 'Mitchell';
UPDATE artist set name = 'CCR' where name='Creedence Clearwater Revival';

--LIKE--
select * from  INVOICE where BILLINGADDRESS like 'T%';

--BETWEEN--
select * from invoice where TOTAL between 15 AND 20;
select * from employee where HIREDATE between TO_DATE('01-JUN-03', 'DD-MON-RR') AND TO_DATE('01-MAR-04', 'DD-MON-RR');

--DELETE--
Alter TABLE invoiceline ADD constraint fk_invoicelineinvoiceid;
Delete from INVOICELINE where INVOICELINEID = 268 OR INVOICELINEID = 245 or INVOICELINEID=290 or INVOICELINEID=342 or invoicelineid=50 or invoicelineid=61 or invoicelineid=116;
DELETE from invoice where customerid=32;
UPDATE customer set SUPPORTREPID=null where firstname='Robert' and lastname='Walter';
DELETE FROM customer where firstname='Robert' and lastname='Walter';
/

--Create Functions--
create or replace FUNCTION CURRENT_TIME 
RETURN TIMESTAMP 
is 
X TIMESTAMP;
BEGIN
SELECT convert(X,current_timestamp) into X FROM artist;
RETURN X;
END;
/

CREATE OR REPLACE FUNCTION returnAverage 
RETURN INT AS
average int;
BEGIN
  select AVG(TOTAL) into average from INVOICE;

  RETURN average;
  
END;
/

CREATE OR REPLACE FUNCTION mostExpensive
RETURN INT AS
mostExp int;
BEGIN

  select MAX(UNITPRICE) INTO mostExp from TRACK;

  RETURN mostExp; 

END;
/


CREATE OR REPLACE FUNCTION averagePrice
return number is
average number;
begin

  select AVG(UNITPRICE) into average from INVOICELINE;
  
  return average;
  
END;
/

create or replace function allEmployees
return table as
allemployees table;
begin

  select * into allemployees from EMPLOYEE;

  return allemployees;

end;
/


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



/*
7.1 AFTER/FOR Triggers
Task - Create an after insert trigger on the categories table fired after a new record is inserted into the table.
*/
CREATE OR REPLACE TRIGGER insrt_cat
after insert on categories
for each row
begin 
dbms_output.put_line('categories has been updated');
end;
/

/*
Task – Create an after update trigger on the categories table that fires after a row is inserted in the table
*/
CREATE OR REPLACE TRIGGER update_cat
after update on categories
for each row
begin 
dbms_output.put_line('categories has been updated');
end;
/

/*
Task – Create an after delete trigger on the categories table that fires after a row is deleted from the table.
*/
CREATE OR REPLACE TRIGGER delete_cat
after delete on categories
for each row
begin 
dbms_output.put_line('categories has been updated');
end;
/


/*
8.1 INNER JOIN
Task – Perform an inner join on tables product and category
Task – Perform an inner join on tables employee and orders
*/
select product.name, category.descript
from product inner join category on product.catid = category.catid;

select employees.name, orders.employeeid
from employees inner join orders on employees.employeeid = orders.employeeid;
/

/*
8.2 OUTER JOIN
Task – Perform an outer join on tables products and orderitems
Task – Perform an outer join on tables employee and orders
*/
select product.name, orderitem.orderid
from product outer join orderitem on product.productid = orderitem.productid;

select employees.name, orders.orderid
from employees outer join orders on employees.employeeid = orders.employeeid;
/

/*
8.3 RIGHT JOIN
Task – Perform a right join on tables orders and orderitems
Task – Perform a left join on tables product and orderitems
*/
select orders.orderid, orderitems.quantity
from orders right join orderitems on orders.orderid = orderitems.orderid;

select product.name, orderitem.orderid
from product right join orderitem on product.productid = orderitem.productid;
/

/*
8.4 LEFT JOIN
Task – Perform a left join on tables product and category
Task – Perform a left join on tables employees and orders
*/
select product.name, category.name
from product left join category on product.catid = category.catid;

select employees.name, orders.orderid
from employees left join orders on employees.employeeid = orders.employeeid;
/

/*
8.5 CROSS JOIN
Task – Perform a cross join on tables product and category
*/
select product.name, category.name
from product cross join category on product.catid = category.catid;
/

/*
8.6 SELF-JOIN
Task – using the employees table perform a self-join. You can break up the table as needed.
*/
select product.name, products.name
from product, products where product.catid = product.catid;
/


/*
Create a view that displays all columns
*/
create view all_employees
as 
select * from employees;
/

/*
Task – Create a view on the products table that only displays only the name of the product and the description.
*/
create view name_descript
as
select name, descript from product;
/


/*
10.1 Clustered Indexes
Task – Create a clustered index on of table of your choice
*/
CREATE CLUSTER employees
   (department NUMBER(4))
SIZE 512 
STORAGE (initial 100K next 50K);

CREATE INDEX idx_personnel ON CLUSTER employees;

