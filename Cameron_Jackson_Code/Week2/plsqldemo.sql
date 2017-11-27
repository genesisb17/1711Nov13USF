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
