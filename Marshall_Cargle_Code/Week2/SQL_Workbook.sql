-- Revature Oracle SQL Workbook Marshall Cargle
--2.1 Select
select * from employee;
select * from employee where LASTNAME='King';
select * from employee where FIRSTNAME='Andrew' and REPORTSTO is NULL;

--2.2 Order By
select title from Album order by title DESC;
select Firstname from Customer order by CITY ASC;
--2.3 Insert Into
insert into Genre (GENREID) VALUES (26);
insert into Genre (GENREID, NAME) VALUES (27, 'thisname');
insert into Employee (EMPLOYEEID, FIRSTNAME, LASTNAME) VALUES (9, 'Marshall', 'Cargle');
insert into Employee (EMPLOYEEID, FIRSTNAME, LASTNAME) VALUES (10, 'Bob', 'John');
insert into Customer (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL) VALUES (60, 'Marshall', 'Cargle', 'thisemail');
insert into Customer (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL) VALUES (61, 'Bob', 'John', 'otheremail');
--2.4 Update
Update Customer set FIRSTNAME = 'Robert', LASTNAME ='Walter' where FIRSTNAME = 'Aaron' and LASTNAME = 'Mitchell';
Update Artist set NAME = 'CCR' where NAME='Creedence Clearwater Revival';
--2.5 Like
Select * from invoice where BILLINGADDRESS LIKE 'T%';
--2.6 Between
Select * from invoice where total between 15 and 50;
Select * from employee where hiredate between '01-June-2003' and '01-March-2004'; 
--2.7 Delete
alter table invoice drop constraint fk_invoicecustomerid;
alter table invoice add constraint fk_invoicecustomerid
foreign key (customerid) references customer(customerid) on delete cascade;

alter table invoiceline drop constraint fk_invoicelineinvoiceid;
alter table invoiceline add constraint fk_invoicelineinvoiceid
foreign key (invoiceid)references invoice(invoiceid) on delete cascade;

delete from customer where lastname = 'Walter';
select * from invoice where customerid = 32;

--3.1 System Defined Functions
--Get Current Time
Create or replace function get_date
return timestamp
IS
BEGIN
 return CURRENT_TIMESTAMP;
 END get_date;
 /
select get_date from dual;

-- Mediatype Length
Create or replace function mediatype_length(word in varchar2)
return number
IS cnumber number;
cursor c1 is
Select length(name) from mediatype where name=word;
BEGIN
open c1;
fetch c1 into cnumber;
return cnumber;

END mediatype_length;
/
select mediatype_length('MPEG audio file') from dual;

--3.2 System Defined Aggregate Functions
--Task - Create a function that returns the average total of all invoices
Create or replace function averages
return number
IS cnumber number;
cnumber2 number;
cursor c1 is 
SELECT SUM(total) from invoice;
cursor c2 is
SELECT count(total) from invoice;
BEGIN
open c1;
open c2;
fetch c1 into cnumber;
fetch c2 into cnumber2;
return cnumber/cnumber2;

END averages;
/
select averages from dual;

--Task - Create a fucntion that returns the most expensive track
Create or replace function highest
return number
IS cnumber number;
cursor c1 is 
SELECT MAX(unitprice) from track;
BEGIN
open c1;
fetch c1 into cnumber;
return cnumber;

END highest;
/
select highest from dual;

--3.3 User Defined Scalar Functions
Create or replace function averageline
return number
IS cnumber number;
cnumber2 number;
cursor c1 is 
SELECT SUM(unitprice) from invoiceline;
cursor c2 is
SELECT count(unitprice) from invoiceline;
BEGIN
open c1;
open c2;
fetch c1 into cnumber;
fetch c2 into cnumber2;
return cnumber/cnumber2;

END averageline;
/
select averageline from dual;

--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.
Create or replace function employeesAfter
RETURN SYS_REFCURSOR
IS
  theEmployees SYS_REFCURSOR;
BEGIN
  OPEN theEmployees
For select Firstname,Lastname from employee where birthdate > '01-January-1968';

return theEmployees;
end employeesAfter;
/
select employeesAfter from dual;
/

--4.0 Stored Procedures 4
--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE firstlast(firstname out varchar2, lastname OUT varchar2)
IS
BEGIN 
select firstname,lastname into firstname,lastname from employee;
END;
/
Execute firstlast;

--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
--Task – Create a stored procedure that returns the managers of an employee.

--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.

--5.0 Transactions 2
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table

--6.0 Triggers
--6.1 AFTER/FOR 3
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER insertTrigger
AFTER INSERT ON employee
FOR EACH ROW
BEGIN
  NULL;
END;
/
--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER updateTrigger
AFTER UPDATE ON ALBUM
FOR EACH ROW
BEGIN
  NULL;
END;
/
--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER updateTrigger
AFTER DELETE ON CUSTOMER
FOR EACH ROW
BEGIN
  NULL;
END;
/
--7.0 JOINS 5
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
select customer.firstname,customer.lastname,invoice.invoiceid
from customer
inner join invoice
on customer.customerid = invoice.customerid;
--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
select customer.customerid, customer.firstname,customer.lastname,invoice.invoiceid, invoice.total
from customer
full outer join invoice
on customer.customerid = invoice.customerid;
--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
select artist.name, album.title
from artist
right join album
on album.artistid = artist.artistid;
--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
select *
from artist
cross join album
order by artist.name ASC;
--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
select a.firstname, b.lastname, c.reportsto
from Employee a, employee b, employee c;

--Part II – Creating and working with your own custom database
--1.0	Creating the OfficeSupply Database
--1.1 Create Company Database using SSMS Interface
--Task – Create a user and name it “OfficeSupply” in Oracle Web Console
--Task – Delete the OfficeSupply user