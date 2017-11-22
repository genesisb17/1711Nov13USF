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











