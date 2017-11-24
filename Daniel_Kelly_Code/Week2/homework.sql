--SQL WORKBOOK ASSIGNMENT DANIEL KELLY

--2.1 - select all employees

SELECT *
FROM employee;

SELECT *
FROM employee
WHERE lastname = 'King';

SELECT *
FROM employee
where firstname = 'Andrew' AND reportsto IS NULL;

--2.2

SELECT *
FROM album
ORDER BY title DESC;

SELECT firstname
FROM customer
ORDER BY city;

--2.3

INSERT INTO genre (GENREID, NAME)
VALUES (26, 'Kpop');

INSERT INTO genre(GENREID,NAME)
VALUES (27, 'Emo');

INSERT INTO customer (customerid, firstname, lastname, email)
VALUES (60, 'Daniel', 'Kelly', 'dbkelly@gmail.com');

INSERT INTO customer (customerid, firstname, lastname, email)
VALUES (61, 'Ashley', 'Moore', 'aidenpouge@gmail.com');

--2.4

UPDATE customer
SET firstname = 'Robert', lastname = 'Walter'
WHERE firstname = 'Aaron' , lastname = 'Mitchell';

UPDATE ARTIST
SET name = 'CCR'
WHERE name = 'Creedence Clearwater Revival';

--2.5 

SELECT *
FROM invoice
WHERE BILLINGADDRESS LIKE 'T%';

--2.6 

SELECT *
FROM invoice
WHERE total BETWEEN 15 AND 50;

SELECT *
FROM employee
WHERE hiredate BETWEEN '01-Jun-03' AND '01-MAR-04';

--2.7
ALTER TABLE Customer DISABLE CONSTRAINT FK_CUSTOMERSUPPORTREPID;
ALTER TABLE invoice DISABLE CONSTRAINT FK_INVOICECUSTOMERID;
DELETE FROM customer where firstname = 'Robert' AND lastname = 'Walter';
ALTER TABLE Customer ENABLE CONSTRAINT FK_CUSTOMERSUPPORTREPID;
--ALTER TABLE invoice ENABLE CONSTRAINT FK_INVOICECUSTOMERID;


CREATE FUNCTION get_time()
RETURN TIMESTAMP
BEGIN
select current_timestamp
FROM dual;
RETURN current_timestamp
END;


--class examples
create view employeeshort as
select * from employee
where employeeid < 5;

select * from employeeshort;

select* from dual;

update employee 
set lastname = 'Bonds'
where firstname = 'Andrew';

create view artistdemo as
select * from artist
where name like 'A%';

select count(*) from artistdemo;

create view albumdemo as
select * from album where albumid <=26;

select * from albumdemo;

select al.TITLE as ALBUM, art.NAME as "ARTIST NAME", tr.NAME as "TRACK NAME"
from album al
inner join artist art on art.ARTISTID = al.ARTISTID
inner join track tr on tr.albumid = al.albumid
inner join mediatype mt on mt.mediatypeid = tr.mediatypeid
inner join PLAYLISTTRACK plt on plt.TRACKID = tr.TRACKID
inner join playlist pl on pl.playlistid = plt.playlistid
inner join invoiceline ivl on ivl.trackid = tr.trackid
inner join invoice iv on iv.invoiceid = ivl.invoiceid
inner join genre on genre.GENREID = tr.GENREID
inner join customer on customer.customerid = iv.CUSTOMERID
inner join employee on employee.employeeid = customer.SUPPORTREPID;
--join all tables together

--select playlist id, count number of tracks in each playlist
select playlistid, count(trackid)
FROM playlisttrack
GROUP BY playlistid;

select name, count(play.trackID) as "Number of Tracks" from playlist
join playlisttrack play on play.PLAYLISTID = playlist.PLAYLISTID
group by NAME;




