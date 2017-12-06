--- get artist by id procedure 
CREATE OR REPLACE PROCEDURE get_artist_by_id(
  art_id IN NUMBER, 
  art_name OUT VARCHAR2)
IS
BEGIN 
select name into art_name from artist where artistid = art_id;
END;
/
DECLARE  art_name VARCHAR2(200);
  BEGIN
  get_artist_by_id(1, art_name);
  DBMS_OUTPUT.PUT_LINE('name :  '|| art_name);
end;
/

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

create or replace procedure get_all_artists(
  cursorParam OUT SYS_REFCURSOR)
is
begin
  OPEN cursorParam for select * from artist;
end;
/

--Performance enhancing method allowing faster retrieval of records
create index artist_name 
ON artist(name);