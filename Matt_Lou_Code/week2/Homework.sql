--SQL WORKBOOK ASSIGNMENT GENESIS BONDS

--2 - select all employees
select * From employee;

select * From employee
where lastname = 'King';

select * From employee
where firstname = 'Andrew' and Reportsto is null;

select * From album
order by title desc;

select firstname from customer
order by city;

insert into genre (genreid, name)
values (26, 'songs');

insert into genre(genreid, name)
values(27, 'japanese');
select * from genre;

select * from employee;
insert into employee
values(9, 'Lou', 'Matty', 'CEO', null, '21-Jan-40', '12-NOV-12', '15420 Livingston ave',
'Lutz', 'FL', 'USA', 32456, '+1 (523)123-1234', '+1 (123)456-1234', 'matty@yahoo.com');
insert into employee
values(10, 'so', 'much', 'secondCEO', null, '12-Oct-61', '04-OCT-10', '15420 Livingston ave',
'Lutz', 'FL', 'USA', 33663, '+1 (123)523-9873', '+1 (234)879-1228', 'mattyboy@yahoo.com');

--2.3 Insert into
select * from customer;
insert into customer
values(60, 'matt', 'lou', null , '123 weroih florida', 'livingston', 'fl', 'USA', 23875, '+32 3284-235',
'235-12487', 'type@yahoo.edu', 3);
insert into customer
values(61, 'matt', 'lou','google', '123 weroih', 'livingston', 'fl', 'USA', 23875, '+32 3284-235',
'235-12487', 'type@yahoo.edu', 5);

--2.4update
select * from customer
where firstname like 'A%';
update customer
set firstname = 'Robert', lastname = 'Walter'
where customerid = 32;


select * from artist;
update artist
set name = 'CCR'
where name = 'Creedence Clearwater Revival';

--2.5 LIKE Task – Select all invoices with a billing address like “T%”
select * from invoice;
select * from invoice
where billingaddress like 'T%';

--2.6 between
--Task – Select all invoices that have a total between 15 and 50
select total
from invoice
where total between 15 and 50;
--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
select * from employee;
select *
from employee
where hiredate between '01-JUN-03' and '01/MAR/04';

--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter 
--(There may be constraints that rely on this, find out how to resolve them).
select * from customer
where firstname like 'R%';
--constraint was imposed, had to go into customer table -> action -> constraint -> disable related foreign keys
delete from customer
where firstname = 'Robert' and lastname = 'Walter';

--3.1 System Defined Functions
--Task – Create a function that returns the current time.
create or replace function curtime
return date
is
begin 
  return CURRENT_TIMESTAMP;
end;
/
select curTime from dual;

--Task – create a function that returns the length of a mediatype from the mediatype table
------------------------------------------------------------------------------------
select * from mediatype;
create or replace function mediatype_length
return int
is
begin
  return len();
end;
/
select mediatype_length from dual;

--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices
select * from invoice;
create or replace procedure average
is
begin
  select AVG(total) from invoice;
end average;
/
--Task – Create a function that returns the most expensive track





create view artistdemo as
select * from Artist
where name like 'A%';

select count(*) from albumdemo;

create view albumdemo as
select * from album where albumid <=26;

select * from albumdemo;

-- example of an inner join, equi join; do a right join to see artists, al and art is from the view
-- use as to create alias 
select al.TITLE as ALBUM, art.NAME as "ARTIST NAME", tr.NAME as "TRACK NAME", gen.name as "GENRE",
med.NAME as "MEDIATYPEID", pl.TRACKID as "TRACKID", invl
from album al
inner join artist art on art.ARTISTID = al.ARTISTID
inner join track tr on tr.ALBUMID = al.ALBUMID
inner join genre gen on tr.genreid = gen.genreid
inner join mediatype med on tr.mediatypeid = med.mediatypeid
inner join playlisttrack pl on tr.TRACKID = pl.trackid
inner join playlist play on play.playlistid = pl.playlistid
inner join invoiceline invl on invl.unitprice = tr.unitprice
inner join customer cust on  inv.customerid = cust.customerid
inner join invoice inv on inv.invoiceid = inl.invoiceid
inner join employee emp on emp.employeeid = cust.supportrepid
;

--select playlist id, count of tracks on each playlist:
select playlistid, count(trackid) as tracks from playlisttrack group by playlistid;

select t1.name, count(*) from playlist t1,playlisttrack
where t1.playlistid = playlisttrack.playlistid
group by t1.name;

create view employeeshort as
select * from employee
where employeeid < 5;

select * from employeeshort;

--dummy stuff
select * from dual;


update employee
set lastname = 'Bonds'
where firstname = 'Andrew';