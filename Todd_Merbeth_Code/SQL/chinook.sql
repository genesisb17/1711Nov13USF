--SELECT * FROM EMPOLYEE;
--SELECT * FROM EMPLOYEE WHERE LASTNAME = 'King';
--SELECT * FROM EMPLOYEE WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;
--SELECT * FROM ARTIST WHERE NAME LIKE 'A_c%'
--SELECT * FROM ARTIST WHERE lower(name) LIKE '%the%';
--SELECT count(*) FROM ARTIST;

--SELECT * FROM ALBUM ORDER BY TITLE DESC;
--SELECT FIRSTNAME FROM CUSTOMER ORDER BY CITY;

--INSERT INTO GENRE VALUES (26, 'House');
--INSERT INTO GENRE VALUES ('27', 'Trap');

--CREATE VIEW employeeshort as
--select * from employee where employeeid < 5;

--select * from employeeshort;

--select * from dual;

--insert into employee values('9', 'Mot', 'Tom', 'IT Staff', '1', '22-APR-70', '25-APR-04', '111 One Ave', 'Calgary', 'AB', 'Canada', 'T2P 5L3', '+1 (111) 111-1111', '+1 (222) 222-2222', 'tommot@chinookcorp.com');

--insert into employee values('10', 'Rob', 'Bob', 'IT Staff', '6', '10-JUN-72', '10-May-04', '222 Two St', 'Calgary', 'AB', 'Canada', 'T2P 4L2', '+1 (111) 111-1112', '+1 (222) 222-2223', 'bobrob@chinookcorp.com');

create view artistdemo as select * from artist where name like 'A%';

select count(*) from artistdemo;

create view albumdemo as
select * from album where albumid <= 26;

select * from artistdemo;

select al.TITLE, art.NAME from albumdemo al inner join artistdemo art on art.ARTISTID = al.ARTISTID;

select al.TITLE, art.NAME as "ARTIST NAME" , tr.name as "TRACK NAME", gen.name as "GENRE", pl.name as "PLAYLIST", 
mt.NAME as "MEDIATYPE", cus.CUSTOMERID as "CUSTOMERID", emp.employeeid as "EMPLOYEEID"
from album al 
inner join artist art on art.artistid = al.artistid
inner join track tr on tr.albumid = al.albumid
inner join genre gen on tr.genreid = gen.genreid
inner join playlisttrack plt on tr.trackid = plt.trackid
inner join playlist pl on pl.playlistid = plt.playlistid
inner join mediatype mt on mt.mediatypeid = tr.mediatypeid
inner join invoiceline invl on tr.trackid = invl.trackid
inner join invoice inv on invl.invoiceid = inv.invoiceid
inner join customer cus on inv.customerid = cus.customerid
inner join employee emp on emp.employeeid = cus.supportrepid;

--select playlist id, count of tracks in each playlist
select PLAYLISTID, count(playlistid) 
as tracks
from PLAYLISTTRACK
group by playlistid;

select t1.name, count(*) from playlist t1, playlisttrack
where t1.playlistid = playlisttrack.playlistid
group by t1.name;

commit;

update employee set reportsto = 6 where firstname = 'Tom';