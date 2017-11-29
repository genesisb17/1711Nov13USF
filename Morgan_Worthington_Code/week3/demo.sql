--PL/SQL
CREATE OR REPLACE FUNCTION get_max_id
  RETURN NUMBER
AS --Or AS, instructor says may not be a difference.
  max_id NUMBER;
BEGIN
  SELECT MAX(artistid) INTO max_id FROM artist;
  RETURN max_id;
END;
/

--call function (or use select from dual)
DECLARE
  max_id NUMBER;
BEGIN
  max_id:=get_max_id();
  DBMS_OUTPUT.PUT_LINE('max id is: '||max_id);
END;
/

--another example
CREATE OR REPLACE FUNCTION get_num_artists
  RETURN NUMBER
IS
  total NUMBER;
BEGIN
  SELECT COUNT(*) INTO total FROM artist;
  RETURN total;
END;
/

--get artist by id procedure
CREATE OR REPLACE PROCEDURE get_artist_by_id(
      art_id IN NUMBER,
      art_name OUT VARCHAR2)
  IS
  BEGIN
    SELECT name INTO art_name FROM artist WHERE artistid = art_id;
  END;
/


--get all artists procedure
CREATE OR REPLACE PROCEDURE get_all_artists(
    cursorParam OUT SYS_REFCURSOR)
IS
BEGIN
  OPEN cursorParam FOR SELECT * FROM artist;
END;
/

-- An index is a performance-tuning method of allowing faster
--retrieval of records. An index creates an entry for each
--value that appears in the indexed columns.

CREATE INDEX artist_name
ON artist(name);