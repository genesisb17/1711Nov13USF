
select * from playlisttrack;


select al.TITLE as ALBUM, art.NAME as "ARTIST NAME" , tr.NAME as "TRACK NAME", gen.name as "GENRE", 
pl.NAME, emp.CITY
from album al
inner join artist art on art.ARTISTID = al.ARTISTID
inner join track tr on tr.ALBUMID = al.ALBUMID
inner join genre gen on tr.genreid = gen.genreid
inner join playlisttrack plt on tr.TRACKID = plt.TRACKID
inner join playlist pl on pl.PLAYLISTID = plt.PLAYLISTID
inner join mediatype mt on mt.MEDIATYPEID = tr.MEDIATYPEID
inner join invoiceline inl on inl.TRACKID = tr.TRACKID
inner join invoice inv on inv.INVOICEID = inl.INVOICEID
inner join customer cust on inv.CUSTOMERID = cust.CUSTOMERID
inner join employee emp on emp.EMPLOYEEID = cust.SUPPORTREPID
; 

-- view playlist id and tracks per playlist 
SELECT PLAYLISTID, COUNT(TRACKID) as TRACKS FROM PLAYLISTTRACK  GROUP BY PLAYLISTID;


-- select playlist name , count of tracks in each playlist:
select name, count(play.trackID) as "Number of Tracks" from PLAYLIST
join PLAYLISTTRACK play on play.PLAYLISTID = PLAYLIST.PLAYLISTID
group by NAME;

select t1.name, count(*) from playlist t1, playlisttrack
where t1.PLAYLISTID = playlisttrack.PLAYLISTID
group by t1.NAME;

------------------ PL/SQL --------------------

-- max id from artist table function
CREATE OR REPLACE FUNCTION get_max_id
RETURN NUMBER
IS
  max_id NUMBER;
BEGIN
  
  SELECT MAX(artistid) INTO max_id FROM artist;
  RETURN max_id;
  
END;
/
--call function
DECLARE
  max_id NUMBER;
BEGIN
  
  max_id := get_max_id();
  
  DBMS_OUTPUT.PUT_LINE('max id is: ' || max_id);
  
END;
/
CREATE OR REPLACE FUNCTION get_num_artists
RETURN NUMBER
IS
  total NUMBER;
BEGIN
  select count(*) into total from artist;
  RETURN total;
  
END;
/
--call function
DECLARE
  total NUMBER;
BEGIN
  
  total := get_num_artists();
  
  DBMS_OUTPUT.PUT_LINE('total number of artists is: ' || total);
  
END;
/
--- get artist by id procedure 
CREATE OR REPLACE PROCEDURE get_artist_by_id(art_id IN NUMBER, art_name OUT VARCHAR2)
IS
BEGIN 
select name into art_name from artist where artistid = art_id;
END;
/
DECLARE 
  art_name VARCHAR2(200);
  BEGIN
  get_artist_by_id(1, art_name);
  DBMS_OUTPUT.PUT_LINE('name :  '|| art_name);
