--2.1 SELECT
SELECT * FROM EMPLOYEE;
/
SELECT * FROM EMPLOYEE
WHERE LASTNAME = 'King';
/
SELECT * FROM EMPLOYEE
WHERE FIRSTNAME = 'Andrew' AND REPORTSTO = NULL;
/
--2.2 ORDER BY
SELECT * FROM ALBUM
ORDER BY Title DESC;
/
SELECT FIRSTNAME FROM Customer
ORDER BY City ASC;
/
--2.3 INSERT INTO
INSERT INTO Genre 
(GENREID, NAME)
VALUES (0,'Hip-Hop');
/
INSERT INTO Genre (GENREID, NAME)
VALUES (1,'Metal');
/
INSERT INTO Employee (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE,
  COUNTRY, POSTALCODE, PHONE, FAX, EMAIL)
VALUES(9,'Alegria', 'Isai', 'Associate', 0, '20-Jan-1993', '13-Nov-2017','408 Liberty Lane', 'La Feria', 'TX', 'USA', '78559', '9564547100',
  '9567972121', 'eesighee');
  /
INSERT INTO Employee (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE,
  COUNTRY, POSTALCODE, PHONE, FAX, EMAIL)
VALUES(10,'Alvarez', 'Rony', 'Associate', 0, '31-Oct-1993', '13-Nov-2017','1200 University', 'Tampa', 'Fl', 'USA', '78549', '83124578390',
  '8312456732', 'ronyalvarez');
  /
INSERT INTO Customer(CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX,
  EMAIL, SUPPORTREPID)
VALUES(60,'David', 'Larry', 'Revature', '123 Lincoln Lane', 'Edinburg', 'TX', 'USA', '78549', '1234567890', '7895641234', 'larrydavid@gmail.com', 4);
/
INSERT INTO Customer(CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX,
  EMAIL, SUPPORTREPID)
VALUES(61,'Rodriguez', 'Mary', 'Best Buy','502 Palm Ave', 'La Feria', 'TX', 'USA', '78559', '9567975086', '9567974038','mrodriguez@aol.com', 2);
/
--2.4 UPDATE
UPDATE Customer
SET FIRSTNAME = 'Robert'
WHERE CustomerID = 32;
/
UPDATE Customer
SET LASTNAME = 'Walter'
Where CustomerID = 32;
/
UPDATE Artist
Set NAME = 'CCR'
WHERE ARTISTID = '76';
/
--2.5 Like
SELECT * FROM Invoice
WHERE BILLINGADDRESS LIKE '%T';
/
--2.6 Between
SELECT * FROM Invoice
WHERE Total BETWEEN 10 and 15;
/
SELECT * FROM EMPLOYEE 
WHERE HIREDATE BETWEEN 01-JUN-2003 and 01-MAR-2004;
/
--2.7 Delete (on delete casade constraint)


--3.0 SQL Functions 
--3.1 System defined functions
ALTER SESSION SET TIME_ZONE = '-5:0';
ALTER SESSION SET NLS_DATE_FORMAT = 'DD-MON-YYYY HH24:MI';
SELECT CURRENT_TIMESTAMP FROM DUAL;
/
--3.2 function returns the average total of all invoices 
CREATE OR REPLACE FUNCTION avgtotal 
RETURN number is
ret number;
begin
select avg(total) into ret from invoice;
return ret;
end;
/
--function to return most expensive track
create or replace function mostExpTrack
return number is
ret number;
begin
select max(unitprice) into ret from track;
end;
/
--3.3 user defined scalar functions
CREATE OR REPLACE FUNCTION avgprice 
RETURN number is
ret number;
begin
select avg(unitprice) into ret from invoiceline;
return ret;
end;
/
--3.4 user defined table valued functions
create or replace function emps1968
RETURN TABLE is
create table rettable(
    e_id number,
    firstn varchar2(20),
    lastn varchar2(20),
    tit varchar2(20),
    reports varchar2(20),
    bday date,
    hire date,
    addy varchar2(20),
    city varchar2(20),
    stat varchar2(20),
    cntry varchar2(20),
    post varchar2(20),
    phone varchar2(20),
    fax varchar2(20),
    email varchar2(20)

);

begin
select employee into rettable



return rettable;
end;
/

--4.0 stored procedures
--4.1 basic stored procedure
-- Create a stored procedure that selects the first and last names of all the employees.
create or replace procedure empnames
as 
type first_name is table of employee.firstname%type;
type last_name is table of employee.lastname%type;

first_names first_name;
last_names last_name;

begin
select firstname, lastname bulk collect into first_names, last_names 
from employee;
end;
/
--Create a stored procedure that updates the personal information of an employee.
create or replace procedure updateemp(emp_id number,firstn varchar2, lastn varchar2)
is
begin
  update employee set firstname = firstn where employeeid = emp_id;
  update employee set lastname = lastn where employeeid = emp_id;
end;
/
--Create a stored procedure that returns the managers of an employee.
create or replace procedure showmanager(emp_id number)
is
holder number;
begin
  SELECT reportsto into holder from employee where employeeid = emp_id;
  dbms_output.put_line('employee reports to '  + holder);
end;
/
--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
create or replace procedure showcust(cust_id number)
is
cust_first varchar2(20);
cust_last varchar2(20);
cust_comp varchar2(20);
begin
  select firstname into cust_first from customer where customerid = cust_id;
  select lastname into cust_last from customer where customerid = cust_id;
  select company into cust_comp from customer where customerid = cust_id;
  dbms_output.put_line('customer name is: ' + cust_first + cust_last);
  dbms_output.put_line('customer company is: ' + cust_comp);
end;
/
--5.0 transactions
-- transaction that given a invoiceId will delete that invoice (There may be 
--constraints that rely on this, find out how to resolve them).
-- delete invoice and create on cascade delete
ALTER TABLE INVOICELINE
DROP CONSTRAINT FK_INVOICELINEINVOICEID;

ALTER TABLE INVOICELINE
ADD CONSTRAINT FK_INVOICELINEINVOICEIDD
  FOREIGN KEY (INVOICEID)
  REFERENCES INVOICE(INVOICEID)
  ON DELETE CASCADE
/
-- create procedure
CREATE OR REPLACE PROCEDURE DELETE_INVOICE(INVOICE_ID IN NUMBER)
AS
BEGIN
  
  DELETE FROM INVOICE WHERE INVOICEID = INVOICE_ID;
    
END;
/
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
select artist.name, album.title
from album right join artist on artist.artistid = album.artistid;
-- 7.4 cross 
-- Create a cross join that joins album and artist and sorts by artist name in ascending order.
select album.title, artist.name
from artist cross join album
order by artist.name asc;
-- 7.5 self
-- Perform a self-join on the employee table, joining on the reportsto column.
SELECT a.employeeid AS "Emp_ID", a.firstname AS "Employee Name",
b.reportsto AS "Supervisor ID"
FROM employee a, employee b
WHERE a.employeeid = b.employeeid;
-- part 2
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
INSERT INTO "OFFICESUPPLY"."CATEGORY" (CATID, NAME) VALUES ('1', 'Office Supplies');
INSERT INTO "OFFICESUPPLY"."CATEGORY" (CATID, NAME) VALUES ('2', 'Art Supplies');
INSERT INTO "OFFICESUPPLY"."CATEGORY" (CATID, NAME) VALUES ('3', 'Cleaning Supplies');
INSERT INTO "OFFICESUPPLY"."CATEGORY" (CATID, NAME) VALUES ('4', 'Computer Supplies ');
INSERT INTO "OFFICESUPPLY"."CATEGORY" (CATID, NAME) VALUES ('5', 'Desk Accessories ');
INSERT INTO "OFFICESUPPLY"."CATEGORY" (CATID, NAME) VALUES ('6', 'Writing Supplies');
INSERT INTO "OFFICESUPPLY"."CATEGORY" (CATID, NAME) VALUES ('7', 'Printer Supplies');

alter table employees modify manager varchar(5);
INSERT INTO "OFFICESUPPLY"."EMPLOYEES" (EMPLOYEEID, USERNAME, PASSWORD, NAME, DEPARTMENT, MANAGER) VALUES ('1', 'dclark', 'drc', 'dclark', 'HR', 'False');
INSERT INTO "OFFICESUPPLY"."EMPLOYEES" (EMPLOYEEID, USERNAME, PASSWORD, NAME, DEPARTMENT, MANAGER) VALUES ('2', 'jsmith', 'js', 'jsmith', 'IT', 'True');
INSERT INTO "OFFICESUPPLY"."EMPLOYEES" (EMPLOYEEID, USERNAME, PASSWORD, NAME, DEPARTMENT, MANAGER) VALUES ('3', 'mjones', 'mj', 'mjones', 'HR', 'True');
INSERT INTO "OFFICESUPPLY"."EMPLOYEES" (EMPLOYEEID, USERNAME, PASSWORD, NAME, DEPARTMENT, MANAGER) VALUES ('4', 'klink', 'kl', 'klink', 'IT', 'False');

-- 3.1 SELECT
select * from employee;
/
select * from employee where department='HR';
/
select from employee where username='jsmith' and department ='HR';
/
select from employee where manager = 1 or department ='HR';
/
-- 3.2 order by
select name from product order by name asc;
/
select name from product order by name desc;
/
select * from category order by name;
/
-- 3.3 INSERT INTO
insert into employee (employeeid, username, password, department, manager)
values ('Isai', 'eesighee', 'p4ssw0rd','engineering',1);
insert into category(catid,name,descript) values (8,'Miscellaneous',null)
insert into supplier (suppid, name) values (3,'Office Depot');
insert into supplier (suppid, name) values (4,'Staples');
insert into supplier (suppid, name) values (5,'Dunder Mifflin');
/
-- 3.4 update
update product set unitcost = 3.00 where name='ruler';
update category set descript = 'stuff for computer' where name = 'computer supplies';
update category set descript = 'cleaning stuff' where name = 'cleaning supplies';
/
-- 3.5 like
select * from employee where username like 'j%';
select * from product where name like 'O%';
/
--3.6 between
select * from product 
where unitcost between 3 and 10;
select * from proudct 
where unitcost between 500 and 800;
/
-- 3.7 between 
delete from category
where name = 'audio visual';
delete from supplier
where name = 'Office Depot';
delete from supplier
where name = 'Staples';
delete from supplier
where name = 'Dunder Mifflin';
/
--4.0 SQL functions
-- 4.1 System Defined Scalar Functions
-- function to return legnth of string of description of laser pointer
create or replace function find_length_laser
return number 
is -- or as, no difference
  len number;
begin 
  select char_length(descript) into len from product where name ='Laser Pointer';
    return len;
  end;
/
-- function that changes username to upper case
create or replace function upper_username(uname varchar2)
return varchar2
is 
  upper_user varchar2;
begin 
  select upper(username) into upper_user from employee where username =uname;
    return upper_user;
  end;
/
-- function that gets the sum of the unitprice column from the products table
create or replace function sum_unitprice
return number
is 
  total number;
begin
  select sum(unitprice) into total from product;
end;
/
-- function that gets the count of all the products in the products table
create or replace function count_product
return number
is 
ret number;
begin 
select count * into ret from product;
end;
/
-- function that takes two inputs (unit price of products) and calculates the cost of the two products
create or replace function (id1 varchar2, id2 varchar2)
return number
is
ret number;
begin
select sum(unitcost) into ret from product where ProductID = id1 and ProductId = id2;
end;
/
-- function that returns whether or not a username belongs to a manager
create or replace function(uname varchar2)
return boolean
is
ret boolean;
select manager into ret from employee where username = uname;
end;
/
-- stored procedures
-- store procedure that returns all employees with the username, dept, 
-- and manager columns from the employees table. Call the procedure to get the result set.
create or replace procedure get_employees(
  cursorParam out SYS_REFCURSOR)
is
begin
  open cursorParam for select username, department, manager from employee;
end;
/
-- stored procedure that returns all the products with the name, 
-- and unitprice column from the products table.
create or replace procedure get_products(
  cursorParam out SYS_REFCURSOR)
is
begin
  open cursorParam for select name, unitprice from product;
end;
/
-- stored procedure that takes in a productID and gets the name 
-- and description of that productID
create or replace procedure get_products(
  cursorParam out SYS_REFCURSOR, prod_id in number)
is
begin
  open cursorParam for select name, description from product 
  where productid = prod_id;
end;
/
-- stored procedure that insert a new manager into the employees table
create or replace procedure insert_manager(
  emp_id in number, uname in varchar2, pass in varchar2, depart in varchar2)
is
man boolean;
begin
  man := true;
  insert into employee (employeeid, username, password, department, manager)
  where values (emp_id, uname, pass, depart, man);
end;
/
-- 5.3 Stored Procedure Output Parameters
-- stored procedure that calculates the value of the unit cost column in the 
-- products table and returns the total amount 
create or replace procedure calc_unitcost( total out number)
is
begin
  select sum(unitprice) into total from product;
end;
/
-- procedure that would return username and password based on employeeID
create or replace procedure ret_emp( emp_id in number ,uname out varchar2, pass out varchar2)
is
begin
  select username into uname from employee where employeeid = emp_id;
  select password into pass from employee where employeeid = emp_id;
end;
/

