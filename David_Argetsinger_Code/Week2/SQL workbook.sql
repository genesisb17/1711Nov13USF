-- sql workbook assignment David Argetsinger
--2.1 select all employees
Select * from employee;
SELECT * from employee where lastname='King';
select * from employee where firstname='Andrew' and reportsto is null;
--2.2 order by
SELECT * FROM Album Order by Title desc;
select firstname from customer order by city desc;
--2.3 insert into
insert into genre values (26,'madeup');
insert into genre values (27,'madeup2');
select * from employee;
insert into employee values('9','fake','mkfaky', 'fakestaff', '6','09-Dec-92','09-DEC-92','1111 fake st','FAKE', 'FA', 'fakeada','T2B 1N5', '+1 (999) 333-3333','+1 (999) 333-3333','fake@gmail.com');
insert into employee values('10','fakeer','mkfakyer', 'fakestaff', '6','09-Dec-92','09-DEC-92','1111 fake st','FAKE', 'FA', 'fakeadaer','T2B 1N5', '+1 (999) 333-3333','+1 (999) 333-3333','fakeer@gmail.com');
select * from genre;
--2.4update
select * from customer where customerid=32;
update customer set firstname='Robert',lastname='Walter' where customerid=32;
--alternatively could've donefirstname= || lastname= 
select * from artist where artistid='76';
update artist set name='CCR' where artistid='76';
--2.5 like
select * from INVOICE where BILLINGADDRESS like 'T%';
--2.6 between
select * from INVOICE where TOTAL between '15' and '50';
select * from employee where HIREDATE between '01-JUN-03' and '01-MAR-04';
--alter table customer drop constraint FK_CUSTOMERSUPPORTREPID;
--alter table customer add constraint FK_CUSTOMERSUPPORTREPID  FOREIGN KEY (SUPPORTREPID)  REFERENCES employee(EMPLOYEEID) on delete cascade;
--2.7delete
alter table invoice drop constraint FK_INVOICECUSTOMERID;
alter table invoice add constraint FK_INVOICECUSTOMERID  FOREIGN KEY (CUSTOMERID)  REFERENCES customer(customerid) on delete cascade;
alter table invoiceline drop constraint FK_INvoicelineinvoiceid;
alter table invoiceline add constraint FK_INvoicelineinvoiceid  FOREIGN KEY (INVOICEID)  REFERENCES invoice(invoiceid) on delete cascade;

select * from customer where firstname='Robert';
select* from invoice where CUSTOMERID='32';
delete from customer where firstname='Robert' and lastname ='Walter';

--sql functions
--3.1
CREATE OR REPLACE FUNCTION dateplease
return date
is
begin
return (SYSDATE);
END;
/

DECLARE
  my_date date;
BEGIN
  my_date:=dateplease;
  SYS.DBMS_OUTPUT.PUT_LINE(my_date);
END;
--or 
select dateplease from dual;

-- media type
/
CREATE OR REPLACE FUNCTION medialength (A IN varchar2)
return INTEGER
is
begin
return (length(a));
END;
/
select medialength(m.name) from mediatype m;
/	
--3.2 system aggregate function


CREATE OR REPLACE FUNCTION averge 
return number
is ave number;
ave2 number;
cursor c1 is select sum(total) from invoice;
cursor c2 is select count(total) from invoice;
begin
open c1;
open c2;
fetch c1 into ave;
fetch c2 into ave2;
return ave/ave2;
END;
/
select averge from dual;
/

CREATE OR REPLACE FUNCTION expensive 
return number
is ave number;
cursor c1 is select max(unitprice) from invoiceline;
begin
open c1;
fetch c1 into ave;
return ave;
END;
/
select EXPENSIVE from dual;
/

-- 3.3user def scalar functions 
CREATE OR REPLACE FUNCTION avergePrice 
return number
is ave number;
cursor c1 is select avg(unitprice) from invoiceline;
begin
open c1;
fetch c1 into ave;
return ave;
END;
/
select avergePrice from dual;
/
--3.4 Task – Create a function that returns all employees who are born after 1968.
create or replace function emp1968 return sys_refcursor is
v_curs sys_refcursor;
begin
open v_curs for select * from employee where birthdate > '01-JAN-68'; 	
return v_curs;
end;
/
select emp1968 from dual;
/

--4.1 
--4.2
--4.3
--5.0

--6.1
CREATE OR REPLACE TRIGGER timestame
   AFTER INSERT OR UPDATE OR DELETE ON EMPLOYEE
   FOR EACH ROW
   DECLARE
      Time_now DATE;
   BEGIN
   Time_now := SYSDATE;
   IF INSERTING THEN 
   DBMS_OUTPUT.PUT_LINE('Successful input! at:');
   DBMS_OUTPUT.PUT_LINE(Time_now);
    END IF;
   IF DELETING THEN  
   DBMS_OUTPUT.PUT_LINE('Successful delete! at:');
   DBMS_OUTPUT.PUT_LINE(Time_now);
    END IF;
   IF UPDATING ('FIRSTNAME') THEN
   DBMS_OUTPUT.PUT_LINE('Successful NAME update! at:');
   DBMS_OUTPUT.PUT_LINE(Time_now);
    END IF;
END;
/	

--7.1
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
select Firstname,lastname,invoiceid from customer
inner join invoice on customer.customerid = invoice.customerid;


--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
select CUSTOMER.CUSTOMERID,CUSTOMER.FIRSTNAME,CUSTOMER.LASTNAME,invoice.INVOICEID, invoice.TOTAL from CUSTOMER
LEFT OUTER JOIN invoice on customer.customerid = invoice.customerid;
/

--7.3 Task – Create a right join that joins album and artist specifying artist name and title.
select ARTIST.NAME,ALBUM.TITLE from album right join ARTIST on ARTIST.ARTISTID = album.ARTISTID
/
--7.4 Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.

select * from album cross join artist order by artist.name
/
--7.5
--Task – Perform a self-join on the employee table, joining on the reportsto column
select * from employee e1 join employee e2 on (e1.REPORTSTO=e2.employeeid);
/










--- select sum(total)  into NUM from table

SELECT SESSIONTIMEZONE, CURRENT_DATE FROM DUAL;
BEGIN
  DBMS_OUTPUT.put_line ('Hello World!');
END;

DECLARE
  l_message  
  VARCHAR2 (100) := 'Hello World!';
BEGIN
  DBMS_OUTPUT.put_line (l_message);
END;








select * from artist where lower(name) like '%t_e%';

-- underscore is a placeholder wildcared 
-- percent is anything goes 
-- lower is a system defined function!
-- aggrogate  takes some stuff in and does stuff to it 
select count(*) from artist;
create view employeeshort as
select * from employee where employeeid <5;
--dummy table can be used as a placeholder for syntax 
select * from dual; 
update employee set lastname ='bonds' where firstname='Andrew';
delete from employee
where lastname='bonds';

/
update artist set name='CCR' where artistid='76';
/
select * from artist where ARTISTID=500;
/
commit;



CREATE or replace procedure get_all_artists(
		cursorParam OUT SYS_REFCURSOR)
	is
	begin
		open cursorParam for select * from employee where birthdate > '01-JAN-68';
	END;
/

select * from employee where birthdate > '01-JAN-68';
/


create or replace function emp1968 return sys_refcursor is
v_curs sys_refcursor;
begin
open v_curs for select * from employee where birthdate > '01-JAN-68'; 	
return v_curs;
end;
/
select emp1968 from dual;
/


select Firstname,Lastname from employee where birthdate > '01-January-1968';
/
for select * from employee;