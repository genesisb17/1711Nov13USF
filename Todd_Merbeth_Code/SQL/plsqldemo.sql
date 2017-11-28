-- STORED PROCEDURE
CREATE OR REPLACE PROCEDURE helloWorld -- replace is to override
AS
BEGIN
dbms_output.put_line('Hello database world!');
END;
/  --  this ends each procedure, funtion, trigger, etc

execute helloWorld;

