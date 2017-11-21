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

-- Mediatype Length -- unfinished
Create or replace function mediatype_length(word in varchar)
return int
IS this varchar(1,1);
BEGIN
Select name into this from MEDIATYPE where name=this; 
END mediatype_length;
/
select mediatype_length('MPEG audio file') from dual;