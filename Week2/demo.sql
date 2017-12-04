SELECT * FROM playlisttrack;
SELECT al.TITLE AS ALBUM,
  art.NAME      AS "ARTIST NAME" ,
  tr.NAME       AS "TRACK NAME",
  gen.name      AS "GENRE",
  pl.NAME,
  emp.CITY
FROM album al
INNER JOIN artist art
ON art.ARTISTID = al.ARTISTID
INNER JOIN track tr
ON tr.ALBUMID = al.ALBUMID
INNER JOIN genre gen
ON tr.genreid = gen.genreid
INNER JOIN playlisttrack plt
ON tr.TRACKID = plt.TRACKID
INNER JOIN playlist pl
ON pl.PLAYLISTID = plt.PLAYLISTID
INNER JOIN mediatype mt
ON mt.MEDIATYPEID = tr.MEDIATYPEID
INNER JOIN invoiceline inl
ON inl.TRACKID = tr.TRACKID
INNER JOIN invoice inv
ON inv.INVOICEID = inl.INVOICEID
INNER JOIN customer cust
ON inv.CUSTOMERID = cust.CUSTOMERID
INNER JOIN employee emp
ON emp.EMPLOYEEID = cust.SUPPORTREPID ;
-- view playlist id and tracks per playlist
SELECT PLAYLISTID,
  COUNT(TRACKID) AS TRACKS
FROM PLAYLISTTRACK
GROUP BY PLAYLISTID;
-- select playlist name , count of tracks in each playlist:
SELECT name,
  COUNT(play.trackID) AS "Number of Tracks"
FROM PLAYLIST
JOIN PLAYLISTTRACK play
ON play.PLAYLISTID = PLAYLIST.PLAYLISTID
GROUP BY NAME;
SELECT t1.name,
  COUNT(*)
FROM playlist t1,
  playlisttrack
WHERE t1.PLAYLISTID = playlisttrack.PLAYLISTID
GROUP BY t1.NAME;


------------------ PL/SQL --------------------
-- max id from artist table function
CREATE OR REPLACE FUNCTION get_max_id
  RETURN NUMBER
AS
  max_id NUMBER;
BEGIN
  SELECT MAX(artistid) INTO max_id FROM artist;
  RETURN max_id;
END;
/



select get_num_artists from dual;

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
  SELECT COUNT(*) INTO total FROM artist;
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
CREATE OR REPLACE PROCEDURE get_artist_by_id(
      art_id IN NUMBER,
      art_name OUT VARCHAR2)
  IS
  BEGIN
    SELECT name INTO art_name FROM artist WHERE artistid = art_id;
  END;
/


DECLARE
  art_name VARCHAR2(200);
BEGIN
  get_artist_by_id(50, art_name);
  DBMS_OUTPUT.PUT_LINE('name :  '|| art_name);
END;
/



-- get all artists procedure
CREATE OR REPLACE PROCEDURE get_all_artists(
      cursorParam OUT SYS_REFCURSOR)
  IS
  BEGIN
    OPEN cursorParam FOR SELECT * FROM artist;
  END;
/
-- An index is a performance-tuning method of allowing faster
-- retrieval of records. An index creates an entry for each 
-- value that appeasrs in the indexed columns.
CREATE INDEX artist_name
ON artist(name);

