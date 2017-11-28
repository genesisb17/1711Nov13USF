-- STORED PROCEDURE
CREATE OR REPLACE PROCEDURE helloWorld
AS 
BEGIN
dbms_output.put_line('Hello database world!');
END;
/

execute helloWorld;
