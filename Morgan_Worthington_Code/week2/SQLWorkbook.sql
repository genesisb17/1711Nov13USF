
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
cutoff DATE;
BEGIN
SELECT TO_DATE('1968/01/01','yyyy/mm/dd') INTO cutoff FROM DUAL;
OPEN emps FOR SELECT * FROM EMPLOYEE WHERE BIRTHDATE>=cutoff;
RETURN emps;
END;
/

--output
DECLARE
  emps SYS_REFCURSOR;
  temp EMPLOYEE%ROWTYPE;
BEGIN
  --records are assign to cursor 'c_dbuser'
  SELECT BORN_AFTER_68 INTO emps FROM DUAL;
  
  LOOP
        --fetch cursor 'c_dbuser' into dbuser table type 'temp_dbuser'
	FETCH emps INTO temp;

        --exit if no more records
        EXIT WHEN emps%NOTFOUND;

        --print the matched username
        dbms_output.put_line(temp.FIRSTNAME);
        dbms_output.put_line(temp.LASTNAME);
  END LOOP;
  
  CLOSE emps;
END;
/

--4.1
-- -Create a stored procedure that selects the first and last names of all the employees.

CREATE OR REPLACE PROCEDURE EMP_NAMES
AS
BEGIN
SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
END;
/

--4.2
-- -Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE UPDATE_INFO(EMPID IN NUMBER, addr IN VARCHAR2, cit IN VARCHAR2, st IN VARCHAR2, nat IN VARCHAR2, post IN VARCHAR2, ph IN VARCHAR2, fa IN VARCHAR2, ema IN VARCHAR@)
AS
BEGIN
UPDATE EMPLOYEE
SET ADDRES=ADDR,
    CITY=CIT,
    STATE=ST,
    COUNTRY=NAT,
    POSTALCODE=POSE,
    PHONE=PH,
    FAX=FA,
    EMAIL=EMA
WHERE EMPLOYEEID=EMPID;
END;
/

--4.3
-- -Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE CUST_INFO (CUSTID IN NUMBER)
AS
BEGIN
SELECT FIRSTNAME, LASTNAME, COMPANY FROM CUSTOMER WHERE CUSTOMERID=CUSTID;
END;
/


--5.0
-- -Create a transaction that given a invoiceId will delete that invoice 
--(There may be constraints that rely on this, find out how to resolve them).
COMMIT;
DELETE FROM INVOICE WHERE INVOICEID=5;
ROLLBACK;

-- -Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE STOR_PROC
AS
BEGIN
COMMIT;
INSERT INTO CUSTOMER (FIRSTNAME,LASTNAME)
VALUES (Bruce, Wayne);
COMMIT;
END;
/

--6.1
-- -Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER INSERT_EMPLOYEE
AFTER INSERT ON EMPLOYEE
DECLARE
BEGIN
dbms_output.put_line('Employee inserted.');
END;
/

-- -Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER UPDATE_ALBUM
AFTER UPDATE ON ALBUM
DECLARE
BEGIN
dbms_output.put_line('Row inserted into Albums.');
END;
/

-- -Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER DELETE_CUSTOMER
AFTER DELETE ON CUSTOMER
DECLARE
BEGIN
dbms_output.put_line('Customer deleted.');
END;
/

--7.1
-- -Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT FIRSTNAME, LASTNAME, INVOICEID
FROM CUSTOMER
INNER JOIN INVOICE ON CUSTOMER.CUSTOMERID=INVOICE.CUSTOMERID;

--7.2
-- -Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT CUSTOMERID, FIRSTNAME, LASTNAME, INVOICEID, TOTAL
FROM CUSTOMER
FULL OUTER JOIN INVOICE ON CUSTOMER.SUPPORTREPID=INVOICE.INVOICEID;

--7.3
-- -Create a right join that joins album and artist specifying artist name and title.
SELECT NAME, TITLE
FROM ALBUM
RIGHT JOIN ARTIST ON ALBUM.ARTISTID=ARTIST.ARTISTID;

--7.4
-- -Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT *
FROM ALBUM
CROSS JOIN ARTIST ON ALBUM.ARTISTID=ARTIST.ARTISTID;

--7.5
-- -Perform a self-join on the employee table, joining on the reportsto column.
SELECT FIRSTNAME, LASTNAME
FROM EMPLOYEE e1, EMPLOYEE e2
WHERE e1.EMPLOYEEID=e2.REPORTSTO;

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

