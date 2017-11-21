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


select * from mediatype;




