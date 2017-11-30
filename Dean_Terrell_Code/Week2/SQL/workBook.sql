--3.1.1
CREATE OR REPLACE FUNCTION getTime
RETURN varchar
IS time varchar(30);
BEGIN
SELECT TO_CHAR (Sysdate, 'MM-DD-YYYY HH24:MI:SS') into time
FROM DUAL;
RETURN time;
end;
/ 
begin
dbms_output.put_line(getTime());
end;
/

--3.1.2
CREATE OR REPLACE FUNCTION getMediaLength (medID IN number)
RETURN number
IS len number;
BEGIN
SELECT length(name) into len from mediatype where mediatypeid = medID;
RETURN len;
end;
/ 
begin
dbms_output.put_line(getMediaLength(3));
end;
/

--3.2.1
CREATE OR REPLACE FUNCTION avgInvoice
RETURN number
IS average number;
BEGIN
SELECT avg(total) into average from invoice;
RETURN average;
end;
/ 
begin
dbms_output.put_line(avgInvoice);
end;
/

--3.2.2
CREATE OR REPLACE FUNCTION mostExpensive
RETURN number
IS highest number;
BEGIN
SELECT max(unitprice) into highest from track;
RETURN highest;
end;
/ 
begin
dbms_output.put_line(mostExpensive);
end;
/

--3.3
CREATE OR REPLACE FUNCTION avgPrice
RETURN number
IS avgprice number;
BEGIN
SELECT avg(unitprice) into avgprice from invoiceline;
RETURN avgprice;
end;
/ 
begin
dbms_output.put_line(avgPrice);
end;
/

--3.3
CREATE OR REPLACE FUNCTION after1968
RETURN SYS_REFCURSOR
IS my_cursor SYS_REFCURSOR;
BEGIN
OPEN my_cursor FOR SELECT * FROM Employee where birthdate >= DATE '1968-01-01';
RETURN my_cursor;
end after1968;
/ 
select after1968 from dual;
/

--4.1
CREATE OR REPLACE PROCEDURE firstLast (details OUT SYS_REFCURSOR)
AS
BEGIN
open details for select firstname, lastname from Employee;
end;
/ 
variable mycursor refcursor;
exec firstLast(:mycursor);
print mycursor;
/

--4.2.1
CREATE OR REPLACE PROCEDURE updateEmployee (iden IN number)
AS
BEGIN
update Employee set title = 'Burger Flipper' where employeeid = iden;
end;
/ 
exec updateEmployee(3);
select * from Employee;
/

--4.2.2
CREATE OR REPLACE PROCEDURE getManagers (details OUT SYS_REFCURSOR)
AS
BEGIN
open details for select * from Employee where title like '%Manager';
end;
/ 
variable mycursor2 refcursor;
exec getManagers(:mycursor2);
print mycursor2;
/ 

--4.3
CREATE OR REPLACE PROCEDURE getDetails (details OUT SYS_REFCURSOR)
AS
BEGIN
open details for select * from Employee where title like '%Manager';
end;
/ 
variable mycursor2 refcursor;
exec getManagers(:mycursor2);
print mycursor2;
/ 