
--SQL WORKBOOK ASSIGNMENT MORGAN WORTHINGTON


--2.1 
-- - select all employees
select * From employee;

--  - Select all records from the Employee table where last name is King.
select * from employee
where lastname='King';

-- - Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL
select * from employee
-- = is only for strings, if want another kind of field, use is
where firstname='Andrew' and reportsto is null;

--2.2
-- -Select all albums in Album table and sort result set in descending order by title
select * from album
order by title desc;

-- -Select first name from Customer and sort result set in ascending order by city
select firstname from customer
order by city;

--2.3
-- -Insert two new records into Genre table
insert into genre(genreid,name)
values(26,'Drone Metal');
insert into genre(genreid,name)
values(27,'Trip Hop');

-- -Insert two new records into Employee table
insert into employee(firstname, lastname,employeeid)
values('Leon','Trotsky',9);
insert into employee(firstname, lastname,employeeid)
values('Frida','Kahlo',10);

-- -Insert two new records into Customer table
insert into customer(firstname, lastname, customerid,email)
values('Alexander','Bell',60,'founder@att.net');
insert into customer(firstname, lastname, customerid,email)
values('Marcus','Aurelius',61,'emperor@rome.gov');

--2.4
-- -Update Aaron Mitchell in Customer table to Robert Walter
--Find the userid to change
select customerid From Customer
where lastname='Mitchell' and firstname='Aaron'; 
--update
Update Customer
Set lastname='Walter', firstname='Robert'
where customerid=32;

-- -Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE ARTIST
SET NAME='CCR'
WHERE NAME='Creedence Clearwater Revival';

--2.5
-- -Select all invoices with a billing address like “T%”
select * FROM INVOICE
WHERE BILLINGADDRESS LIKE 'T%';

--2.6
-- -Select all invoices that have a total between 15 and 50
select * from INVOICE
WHERE TOTAL BETWEEN 15 and 50;

-- -Select all employees hired between 1st of June 2003 and 1st of March 2004
--select * from EMPLOYEE
--WHERE HIREDATE >= '2003/06/01' AND HIREDATE <= '2004/03/01';
SELECT * FROM EMPLOYEE WHERE HIREDATE BETWEEN '1-JUN-2003' AND '1-MAR-2004';

--2.7
-- -Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
--ALTER TABLE INVOICE DROP FK_INVOICECUSTOMERID;
ALTER TABLE INVOICE 
DISABLE CONSTRAINT
FK_INVOICECUSTOMERID;
DELETE FROM CUSTOMER WHERE LASTNAME='Walter' and FIRSTNAME='Robert';

--3.1
-- -Create a function that returns the current time.
create or replace FUNCTION get_time2
RETURN TIMESTAMP IS mytime TIMESTAMP;

BEGIN
SELECT CURRENT_TIMESTAMP INTO mytime FROM DUAL;
RETURN mytime;
END;
/
SELECT get_time2() FROM DUAL;

-- -create a function that returns the length of a mediatype from the mediatype table
CREATE OR REPLACE FUNCTION MEDIALENGTH (KIND NUMBER)
RETURN NUMBER IS LEN NUMBER;
MNAME VARCHAR2(50);
BEGIN
SELECT NAME  INTO MNAME FROM MEDIATYPE where MEDIATYPEID = KIND;
LEN :=LENGTH(MNAME);
RETURN LEN;
END;
/
SHOW ERRORS FUNCTION MEDIALENGTH;
SELECT MEDIALENGTH(1) from DUAL;
SELECT MEDIALENGTH(5) from DUAL;
SELECT MEDIALENGTH(3) from DUAL;

--3.2
-- -Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION AVERAGE_INVOICE
RETURN NUMBER IS average NUMBER;
BEGIN
SELECT AVG(TOTAL) INTO average FROM INVOICE;
RETURN average;
END;
/
SELECT AVERAGE_INVOICE FROM DUAL;

-- -Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION EXPENSIVE_TRACK
RETURN NUMBER IS maximum NUMBER;
BEGIN
SELECT MAX(UNITPRICE) INTO maximum FROM TRACK;
RETURN maximum;
END;
/
SELECT EXPENSIVE_TRACK FROM DUAL;

--3.3
-- -Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION AVERAGE_TRACK_PER_INVOICE(INVOICE_ID NUMBER)
RETURN NUMBER IS average NUMBER;
BEGIN
SELECT AVG(UNITPRICE) INTO average FROM INVOICELINE WHERE INVOICEID=INVOICE_ID;
RETURN average;
END;
/
SELECT AVERAGE_TRACK_PER_INVOICE(298) FROM DUAL;

CREATE OR REPLACE FUNCTION AVERAGE_ALL_LINES
RETURN NUMBER IS average NUMBER;
BEGIN
SELECT AVG(UNITPRICE) INTO average FROM INVOICELINE;
RETURN average;
END;
/
SELECT AVERAGE_ALL_LINES FROM DUAL;

--3.4
-- -Create a function that returns all employees who are born after 1968.
CREATE OR REPLACE FUNCTION BORN_AFTER_68
RETURN sys_refcursor IS emps sys_refcursor;
BEGIN
OPEN emps for 'SELECT * FROM EMPLOYEE WHERE BIRTHDATE>1968';
RETURN emps;
END;
/
SHOW ERRORS FUNCTION BORN_AFTER_68;


-- in class demo
--create view employeeshort as
--select * from employee
--where employeeid < 5;

--select * from employeeshort;

--select * from dual;

--update employee 
--set lastname = 'Bonds'
--where firstname = 'Andrew';

--delete * from employee;
--where lastname='Bonds';

