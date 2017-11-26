/*
2.1 SELECT
Task – Select all records from the Employee table.
Task – Select all records from the Employee table where last name is King.
Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
*/

SELECT * FROM Employee;
SELECT * FROM Employee WHERE Lastname = 'King';
SELECT * FROM Employee WHERE Firstname = 'Andrew' and Reportsto is NULL;

/*
2.2 ORDER BY
Task – Select all albums in Album table and sort result set in descending order by title.
Task – Select first name from Customer and sort result set in ascending order by city
*/

/*
2.3 INSERT INTO
Task – Insert two new records into Genre table
Task – Insert two new records into Employee table
Task – Insert two new records into Customer table
*/

/* 
2.4 UPDATE
Task – Update Aaron Mitchell in Customer table to Robert Walter
Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
*/

/*
2.5 LIKE
Task – Select all invoices with a billing address like “T%”
*/

/*
2.6 BETWEEN
Task – Select all invoices that have a total between 15 and 50
Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
*/

/*
2.7 DELETE
Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
*/

/*
3.1 System Defined Functions
Task – Create a function that returns the current time.
Task – create a function that returns the length of a mediatype from the mediatype table
*/

/*
3.2 System Defined Aggregate Functions
Task – Create a function that returns the average total of all invoices
Task – Create a function that returns the most expensive track
*/

/* 
3.3 User Defined Scalar Functions
Task – Create a function that returns the average price of invoiceline items in the invoiceline table
*/

/************************************************************************************
3.4 User Defined Table Valued Functions
Task – Create a function that returns all employees who are born after 1968.
************************************************************************************/


/*
4.1 Basic Stored Procedure
Task – Create a stored procedure that selects the first and last names of all the employees.
*/

--DROP PROCEDURE PROCE
--EXECUTE PROCE();
--SET SERVEROUTPUT ON;

/*
4.2 Stored Procedure Input Parameters
Task – Create a stored procedure that updates the personal information of an employee.
Task – Create a stored procedure that returns the managers of an employee.
*/

--EXECUTE UPDATE_INFO;


--EXEC RETURN_MANAGERS(3);

/*
4.3 Stored Procedure Output Parameters
Task – Create a stored procedure that returns the name and company of a customer.
*/

-- TESTING
