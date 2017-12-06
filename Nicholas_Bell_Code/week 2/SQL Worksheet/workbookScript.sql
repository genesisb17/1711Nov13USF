--2.1 Select
--		Select all records from the Employee table:
			SELECT * FROM EMPLOYEE;
--		Select all records from the Employee table where the last name is King:
			SELECT * FROM EMPLOYEE 
			WHERE LASTNAME = 'King';
--		Select all records from the Employee table where the first name is Andrew and REPORTSTO is NULL
			SELECT * FROM EMPLOYEE 
			WHERE FIRSTNAME = 'Andrew' and REPOSRTSTO is NULL

--2.2 ORDER BY
--		3. Task – Select all albums in Album table and sort result set in descending order by title.
			SELECT * FROM ALBUM
			ORDER BY TITLE DESC;
--		4. Task – Select first name from Customer and sort result set in ascending order by city
			SELECT Firstname FROM customer
			ORDER BY city asc;
--4.2 2.3 INSERT INTO
--		5. Task – Insert two new records into Genre table
			insert into genre values (26, 'Country');
			insert into genre values (27, 'Big Band');
--		6. Task – Insert two new records into Employee table
			insert into EMPLOYEE values(9, 'Williams', 'John', 'Janitor',   1, date'1989-12-31', to_date(sysdate) ,'123 Main street', 'New York', 'NY', 'USA', '90210', '+1 (331) 477-2020', '+1 (921) 474-7474', 'jwill@chinookcorp.com');
			insert into EMPLOYEE values(10,  'Smith', 'Jacob', 'Secretary', 2, date'1990-07-22', to_date(sysdate) ,'456 3rd Ave',    'Sarasota',  'WI', 'USA', '77777', '+1 (401) 653-1010', '+1 (663) 098-3614', 'jsmithl@chinookcorp.com');
			
--7. Task – Insert two new records into Customer table
			insert into CUSTOMER values (60, 'Lily', 'Weasley', 'Hogwarts INC.', '1 Big Castle Ct.', 'London', 'ENG', 'Great Britain','00192', '+1 (763) 461-0967', '+1 (653) 888-0987','lilyw@hogwarts.com', 4);
			insert into CUSTOMER values (61, 'Stannis', 'Baratheon', 'ThronesRMine', '707 Dragonsstone Terrace', 'Island', 'KL', 'Westeros','00002', '+1 (710) 735-0148', '+1 (881) 226-5301', 'bigstan@westro.net', 3)
--7.2 2.4 UPDATE
		--8. Task – Update Aaron Mitchell in Customer table to Robert Walter
			select CUSTOMERID from customer
			where firstname = 'Aaron';
			--returns 1 result of CustomerID = 32

			update CUSTOMER set FIRSTNAME = 'Robert',
			lastname = 'Walter'
			where CUSTOMERID = 32;
		--9. Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
			update ARTIST set NAME = 'CCR'
			where NAME = 'Creedence Clearwater Revival';			
--9.2 2.5 LIKE
			--10. Task – Select all invoices with a billing address like “T%”
			select * from INVOICE
			where BILLINGADDRESS like 'T%';
			
--10.2 2.6 BETWEEN
		--11. Task – Select all invoices that have a total between 15 and 50
			select * from INVOICE
			where TOTAL BETWEEN 15 and 50;
		--12. Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
			select * from employee
			where HIREDATE between to_date('2003/06/01', 'yyyy/mm/dd') 
			and to_date('2004/03/01', 'yyyy/mm/dd');
--12.2 2.7 DELETE

		--13. Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
			DELETE from INVOICELINE
			where INVOICEID IN (select invoiceid from invoice
                  			where CUSTOMERID IN (SELECT customerid FROM CUSTOMER 
                                      				where firstname = 'Robert' and lastname = 'Walter'));

			delete from invoice
			where CUSTOMERID IN (SELECT customerid FROM CUSTOMER 
				where firstname = 'Robert' and lastname = 'Walter');

			delete from customer where firstname = 'Robert' and LASTNAME = 'Walter';


15. SQL Functions 6
16. In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database
16.2 3.1 System Defined Functions
		--17. Task – Create a function that returns the current time.
		create or replace function get_time
		return VARCHAR2 is thedate varchar2(20);
		begin
		thedate := (TO_CHAR (SYSDATE,'HH24:MI:SS'));
		return thedate;
		end get_time;
		/
		declare
		atime varchar2(20);
		begin
		atime := get_time();
		dbms_output.put_line(atime);
		end;
		/
		--18. Task – create a function that returns the length of a mediatype from the mediatype table
		create or replace function get_length
		(idnum in number)
		return number is
		  len number:=0;
		begin
		  select length(name) into len
		  from MEDIATYPE where MEDIATYPEID = idnum;
		return len;
		end get_length;
		/
		declare
		mtypelen number;
		begin
		mtypelen:= get_length(1);
		dbms_output.put_line('Length of mediatype id name is: ' || mtypelen);
		end;
		/
		--18.2 3.2 System Defined Aggregate Functions
		--19. Task – Create a function that returns the average total of all invoices 
		create or replace function get_avg
		return number is
		tot number;
		begin
		select avg(total) into tot from INVOICE;
		return tot;
		end get_avg;
		/
		declare
		thetotal number;
		begin
		thetotal := get_avg();
		DBMS_OUTPUT.put_line(thetotal);
		end;
		/

		--20. Task – Create a function that returns the most expensive track
		create or replace function get_max
		return number is
		themax number;
		begin
		select max(unitprice) into themax from track;
		return themax;
		end get_max;
		/
		declare
		mostexp number;
		begin
		mostexp := get_max();
		DBMS_OUTPUT.put_line(mostexp);
		end;
		/
--20.2 3.3 User Defined Scalar Functions
--21. Task – Create a function that returns the average price of invoiceline items in the invoiceline table
create or replace function get_avgiv
return number is
theavg number;
begin
select avg(unitprice) into theavg from INVOICELINE;
return theavg;
end get_avgiv;
/
declare
avgulp number;
begin
avgulp := get_avgiv();
DBMS_OUTPUT.put_line(avgulp);
end;
/

--21.2 3.4 User Defined Table Valued Functions
--22. Task – Create a function that returns all employees who are born after 1968.
create or replace type emp_type as object
(emp_id number, l_name varchar2(20), f_name varchar2(20), bday date);
/
create or replace type emp_table as table of emp_type;
/
create or replace function get_emps
return emp_table is
the_emps emp_table:= emp_table();
begin
for i in(select employeeid, lastname, firstname, birthdate 
from employee where birthdate > '01-JAN-69') loop
the_emps.extend;
the_emps(the_emps.count) := (emp_type(employeeid, lastname, firstname, birthdate));
end loop;
return the_emps;
end get_emps;
/

DECLARE
some_emps emp_table;
begin
some_emps := get_emps();
end;
/

23. 4.0 Stored Procedures 4
24.  In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
24.2 4.1 Basic Stored Procedure
25. Task – Create a stored procedure that selects the first and last names of all the employees.
25.2 4.2 Stored Procedure Input Parameters
26. Task – Create a stored procedure that updates the personal information of an employee.
27. Task – Create a stored procedure that returns the managers of an employee.
27.2 4.3 Stored Procedure Output Parameters
28. Task – Create a stored procedure that returns the name and company of a customer.
29. 5.0 Transactions 2
30. In this section you will be working with transactions. Transactions are usually nested within a stored procedure.
31. Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
32. Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
33. 6.0 Triggers
34. In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
34.2 6.1 AFTER/FOR 3
35. Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
36. Task – Create an after update trigger on the album table that fires after a row is inserted in the table
37. Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
38. 7.0 JOINS 5
39. In this section you will be working with combing various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
39.2 7.1 INNER
40. Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
40.2 7.2 OUTER
41. Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
41.2 7.3 RIGHT
42. Task – Create a right join that joins album and artist specifying artist name and title.
42.2 7.4 CROSS
43. Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
43.2 7.5 SELF
43.3 Task – Perform a self-join on the employee table, joining on the reportsto column.
