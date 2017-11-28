create view artistdemo as
select * from artist
where name like 'A%';

select count(*) from artist demo;

create view albumdemo as
select * from album where albumid<=26;

select * from albumdemo;


--join, equal join because use equal sign
select al.TITLE as ALBUM,art.name as "ARTIST NAME",tr.NAME as "TRACK NAME", gen.name as "GENRE",
pl.NAME, emp.CITY

from album al
inner join artist art on art.ARTISTID=al.ARTISTID
inner join track tr on tr.ALBUMID=al.ALBUMID;
inner join genre gen on tr.genreid=gen.genreid
inner join playlisttrack plt on tr.trackid=plt.trackid
inner join playlist pl on pl.PLAYLISTID=plt.PLAYLISTID
inner join mediatype mt on mt.MEDIATYPEID=tr.MEDIATYPEID
inner join invoiceline inl on inl.TRACKID=tr.tr.TRACKID
inner join invoice inv on inv.INVOICEID = inl.INVOICEID
inner join customer cust on inv.CUSTOMERID=cust.CUSTOMERID
inner join employee emp on emp.EMOLOYEEID=cust.SUPPORTERID;


--select playlist id, number of tracks for each playlist
select playlistid, count(trackid) as tracks from PLAYLISTTRACK group by playlistid;

select name, count(play.trackID) as "Number of Tracks" from PLAYLIST
join PLAYLISTTRACK play on play.playlistID=playlist.playlistid
group by name;

--11/22/2017
create sequence ART_SEQ
START WITH 500
INCREMENT BY 1;
/
CREATE OR REPLACE TRIGGER ART_TRIGGER
BEFORE INSERT ON ARTIST
FOR EACH ROW
BEGIN 
SELECT ART_SEQ.NEXTVAL INTO :NEW.ARTISTID FROM DUAL;
END;
/
COMMIT;
