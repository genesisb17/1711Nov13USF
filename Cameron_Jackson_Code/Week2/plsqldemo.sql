-- STORED PROCEDURE
SET 
CREATE OR REPLACE PROCEDURE helloWorld
AS 
BEGIN 
dbms_output.put_line('Hello database world!');
END;
/

execute helloWorld;
/

SELECT * FROM artist
WHERE artistid = 6;

CREATE SEQUENCE ART_SEQ
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

update artist set name = 'Bloopers' where artistid = 501;
commit;
select name from artist where artistid=501;
/

CREATE OR REPLACE PROCEDURE get_artist_by_id(art_id IN NUMBER, art_name OUT VARCHAR2)
IS
BEGIN 
select name into art_name from artist where artistid = art_id;
END;
/

CREATE OR REPLACE PROCEDURE get_all_artists(
  cursorParam OUT SYS_REFCURSOR)
IS
BEGIN
  OPEN cursorParam FOR SELECT * FROM artist;
  CLOSE cursorParam;
END;
/

CREATE INDEX artist_name
ON artist(name);