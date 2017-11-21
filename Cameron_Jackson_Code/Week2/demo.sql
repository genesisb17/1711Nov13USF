--SELECT * FROM artist
--WHERE LOWER(Name) LIKE '%the%';
--
--SELECT COUNT(*) FROM artist;
--
--CREATE VIEW employeeshort AS
--SELECT * FROM employee
--WHERE employeeid < 5;
--
--SELECT * FROM employeeshort;
--
--SELECT * FROM dual;
--
--UPDATE employee
--SET lastname='Bonds'
--WHERE firstname = 'Andrew';

create view artistdemo as
select * from artist
where name like 'A%';

select count(*) from artistdemo;

create view albumdemo as 
select * from album 
where albumid <=26;

select * from albumdemo;

select al.title, art.name
from albumdemo al
inner join artistdemo art
on art.ARTISTID = al.ARTISTID;

select al.title as ALBUM, art.name AS "ARTIST NAME", tr.name AS "TRACK NAME"
from album al
inner join artist art on art.ARTISTID = al.ARTISTID
inner join track tr on tr.ALBUMID = al.ALBUMID;

-- IN CLASS ASSIGNMENT
create view my_library as
select al.title as ALBUM, art.name AS "ARTIST NAME", tr.name as "TRACK NAME",
gen.name as GENRE, mt.name as MEDIA, pl.name as PLAYLIST, il.unitprice as PRICE,
(c.firstname||' '||c.lastname) as "PURCHASER",
(e.firstname||' '||e.lastname) as "SUPPORT REP"
from album al
inner join artist art on art.ARTISTID = al.ARTISTID
inner join track tr on tr.ALBUMID = al.ALBUMID
inner join genre gen on tr.GENREID = gen.GENREID
inner join playlisttrack plt on plt.TRACKID = tr.TRACKID
inner join playlist pl on pl.PLAYLISTID = plt.PLAYLISTID
inner join mediatype mt on mt.MEDIATYPEID = tr.MEDIATYPEID
inner join invoiceline il on il.TRACKID = tr.TRACKID
inner join invoice iv on iv.invoiceid = il.invoiceid
inner join customer c on c.customerid = iv.customerid
inner join employee e on e.employeeid = c.supportrepid
order by al.title asc;

-- display playlist id and display number of songs for each playlist
select PLAYLISTID as "PLAYLIST ID", count(TRACKID) as "NUM TRACKS" 
from playlisttrack group by PLAYLISTID order by PLAYLISTID asc;

select name, count(plt.trackID) as "Number of Tracks" from PLAYLIST
join PLAYLISTTRACK plt on plt.PLAYLISTID = PLAYLIST.PLAYLISTID
group by name;
--inner join playlisttrack plt on plt.PLAYLISTID = pl.PLAYLISTID
--inner join track tr on tr.TRACKID = plt.TRACKID;

