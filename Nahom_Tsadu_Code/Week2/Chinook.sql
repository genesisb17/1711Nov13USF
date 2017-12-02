--Nahom Tsadu
--in-class join assignment

select customer.firstname, 
       invoiceline.quantity, 
       invoice.total, 
       mediatype.name as "MEDIA TYPE", 
       track.name as "TRACK NAME", 
       album.title as "ALBUM TITLE",
       genre.name as "GENRE",
       playlist.name as "PLAYLIST"
from customer
inner join invoice on invoice.customerid = customer.customerid
inner join invoiceline on invoiceline.invoiceid = invoice.invoiceid
inner join track on track.trackid = invoiceline.trackid
inner join album on album.albumid = track.trackid
inner join mediatype on mediatype.mediatypeid = track.mediatypeid
inner join genre on genre.genreid = track.genreid
inner join playlisttrack on playlisttrack.trackid = track.trackid
inner join playlist on playlist.playlistid = playlisttrack.playlistid;

select playlisttrack.playlistid, count(playlisttrack.trackid) from playlisttrack;

--inner join playlisttrack on pla
select playlisttrack.playlistid, count(playlisttrack.trackid) from playlisttrack group by playlisttrack.playlistid;
--ylisttrack.playlistid = playlist.playlistid;


--track.name, album.name 
--inner join track on track.trackid = invoice.trackid
--inner join album on album.albumid = track.albumid;

--SQL WORKBOOK ASSIGNMENT DUE 12/1

-- 2.1 SELECT
select * from employee;
select * from employee where employee.lastname = 'King';
select * from employee 
  where employee.firstname = 'Andrew' 
  and employee.reportsto is null;

-- 2.2 ORDER BY
select * from album order by album.title desc;
select customer.firstname from customer order by customer.firstname asc;

-- 2.3 INSERT INTO
insert into genre values (26, 'Dubstep');
insert into employee 
values(9, 
       'Appleseed', 
       'Johnny', 
       'Sales Support Agent', 
       2, 
       '25-FEB-93', 
       '01-MAY-02', 
       '15420 Livingston Avenue', 
       'Tampa', 
       'FL', 
       'United States', 
       '28262', 
       '(704) 942-5664', 
       null, 
       'japp@gmail.com');
insert into customer
values(60,
       'Kobe',
       'Bryant',
       null,
       '5408 Main street',
       'Charleston',
       'SC',
       'United States',
       '29388',
       '(829) 347-2214',
       null,
       'kb24@gmail.com',
       3);

-- 2.4 UPDATE
update customer
  set customer.firstname = 'Robert',
      customer.lastname = 'Walter'
  where customer.firstname = 'Aaron'
  and customer.lastname = 'Mitchell';
update artist
  set artist.name = 'CCR'
  where artist.name = 'Creedence Clearwater Revival';

-- 2.5 LIKE
select * from invoice where invoice.billingaddress like 'T%';

-- 2.6 BETWEEN
select * from invoice where invoice.total between 15 and 50;
select * from employee where employee.hiredate between '01-JUN-03' and '01-MAR-04';

-- 2.7 DELETE
alter table invoice
modify (customerid null);
update invoice
  set invoice.customerid = null
  where invoice.customerid = 
      (select customer.customerid from customer 
       where customer.firstname = 'Robert' 
       and customer.lastname = 'Walter');
delete from customer 
  where customer.firstname = 'Robert' 
  and customer.lastname = 'Walter';
  
-- 3.0 SQL FUNCTIONS
-- 3.1 System Defined Functions
create or replace function
getCurrentTime return timestamp
as
begin
return current_timestamp();
end getCurrentTime;

select getCurrentTime() from dual;

create or replace function
getLength(some_string string) return number
as
begin
return length(some_string);
end getLength;

select getLength(mediatype.name) from mediatype;

-- 3.2 System Defined Aggregate Functions
create or replace function
getInvoiceTotals return number
as result number;
begin
select sum(invoice.total) into result from invoice;
return result;
end getInvoiceTotals;

select getInvoiceTotals() from dual;

create or replace function
getMostExpensiveTracks return sys_refcursor
as myCursor sys_refcursor;
begin
open myCursor for select * from track 
  where track.unitprice in 
  (select greatest(track.unitprice) from track);
return myCursor;
end getMostExpensiveTracks;

select getMostExpensiveTracks() from dual;

