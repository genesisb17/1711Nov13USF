-- 2.1 SELECT
SELECT * FROM Employee; 
SELECT * FROM Employee WHERE Lastname = 'King'; 
SELECT * FROM Employee
WHERE Firstname = 'Andrew' AND Reportsto = NULL;
/
-- 2.2 ORDER BY
SELECT * FROM Album
ORDER BY Title DESC;
SELECT * FROM Customer 
ORDER BY City ASC;
/
-- 2.3 INSERT INTO
INSERT INTO Genre (NAME) VALUES ('Soul'); 
SELECT * FROM Genre;
INSERT INTO Genre (NAME) VALUES ('Nu-Wave');
SELECT * FROM Genre;
INSERT INTO Employee (EmployeeID, Lastname, Firstname, Title, Reportsto,
Birthdate, Hiredate, Address, City, State, Country, Postalcode,
Phone, Fax, Email)
VALUES (9,'Henkleboss', 'Sonny', 'Store Greeter', 1, TO_DATE('01-JAN-23', 'DD-MON-YY'), 
TO_DATE('01-JAN-65','DD-MON-YY'), '1234 Too Cool Ave S', 'SwagCity', 'AB', 
'Canada', 'T2K 1A1', '+ (000) 867-5309', '+ (888) 654-3121', 
'toooldforemail@nope.com');
SELECT * FROM Employee;
INSERT INTO Employee (EmployeeID, Lastname, Firstname, Title, Birthdate, 
Hiredate, Address, City, State, Country, Postalcode, Phone, 
Email)
VALUES (10, 'Liston', 'Lonnie', 'Entertainer', TO_DATE('28-DEC-40', 'DD-MON-YY'), 
TO_DATE('12-DEC-12', 'DD-MON-YY'), '25 Imma Singer St.', 'Los Angeles', 'CA', 
'United States', '90028', '+ (201) 123-4567', 'hitmeup@email.com');
SELECT * FROM Employee;
/
-- 2.4 UPDATE
SELECT * FROM Customer;
UPDATE Customer
SET Firstname = 'Robert', Lastname = 'Walker'
WHERE Firstname = 'Aaron' AND Lastname = 'Mitchell';
SELECT * FROM Artist
ORDER BY Name ASC; 
UPDATE Artist
SET Name = 'CCR'
WHERE Name = 'Creedence Clearwater Revival';
/
-- 2.5 LIKE
SELECT * FROM Invoice
WHERE BillingAddress LIKE 'T%';
/
-- 2.6 BETWEEN
SELECT * FROM Invoice
WHERE Total BETWEEN 15 AND 50;
SELECT * FROM Employee 
WHERE HireDate 
BETWEEN TO_DATE('01-JUN-03', 'DD-MON-YY') 
AND TO_DATE('01-MAR-04', 'DD-MON-YY');
/
-- 2.7 DELETE
-- Drop and Add constraint for Invoice
ALTER TABLE Invoice DROP CONSTRAINT FK_InvoiceCustomerID;
ALTER TABLE Invoice ADD CONSTRAINT FK_InvoiceCustomerID 
FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID)
ON DELETE CASCADE;
-- Drop and Add constraint for Invoice line
ALTER TABLE Invoiceline DROP CONSTRAINT FK_InvoicelineInvoiceID;
ALTER TABLE Invoiceline ADD CONSTRAINT FK_InvoicelineInvoiceID 
FOREIGN KEY (InvoiceID) REFERENCES Invoice(InvoiceID)
ON DELETE CASCADE;
-- Delete the Customer
DELETE FROM Customer
WHERE Firstname = 'Robert' AND Lastname = 'Walker';
SELECT * FROM Invoice
WHERE CustomerID=32;
SELECT * FROM Customer
WHERE CustomerID=32;
/
-- 3.1 SYSTEM DEFINED FUNCTIONS
SET SERVEROUTPUT ON;
CREATE OR REPLACE FUNCTION GET_TIME
RETURN DATE IS
BEGIN
  RETURN SYSDATE;
END;
/

DECLARE
  my_date DATE;
BEGIN
  my_date := GET_TIME();
  SYS.DBMS_OUTPUT.PUT_LINE('Date: '||my_date);
END;
/

CREATE OR REPLACE FUNCTION MEDIA_LENGTH(idx INT)
RETURN INT IS len INTEGER;
BEGIN
  SELECT LENGTH(Name) INTO len
  FROM Mediatype
  WHERE MediatypeID = idx;
  RETURN len;
END;
/

SELECT MEDIA_LENGTH(2) FROM dual;
/
 
-- 3.2 SYSTEM DEFINED AGGREGATE FUNCTIONS
CREATE OR REPLACE FUNCTION INV_AVG
RETURN NUMBER IS avg_invoice NUMBER(7,2);
BEGIN 
  SELECT AVG(total) INTO avg_invoice
  FROM Invoice;
  RETURN avg_invoice;
END;
/

SELECT INV_AVG() FROM dual;
/

CREATE OR REPLACE FUNCTION HIGHEST_PRICE
RETURN NUMBER IS max_price NUMBER(7,2);
BEGIN
  SELECT MAX(unitprice) INTO max_price
  FROM Track;
  RETURN max_price;
END;
/

SELECT HIGHEST_PRICE() FROM dual;
/

-- 3.3 USER DEFINED SCALAR FUNCTIONS
CREATE OR REPLACE FUNCTION AVG_INVOICELINE(idx NUMBER)
RETURN NUMBER IS line_avg NUMBER(7,2);
BEGIN
  SELECT AVG(unitprice) INTO line_avg
  FROM Invoiceline 
  WHERE invoiceid = idx
  GROUP BY invoiceid;
  RETURN line_avg;
END;
/

SELECT AVG_INVOICELINE(87) FROM dual;
/

-- 3.4 USER DEFINED TABLED VALUED FUNCTIONS
CREATE OR REPLACE FUNCTION FIND_EMP_BDAY RETURN SYS_REFCURSOR
IS 
emp_name SYS_REFCURSOR;
BEGIN
  OPEN emp_name FOR
  SELECT * FROM Employee WHERE birthdate > DATE '1968-01-01';
  CLOSE emp_name;
  RETURN emp_name;
END;
/

SELECT FIND_EMP_BDAY() FROM dual;
/

-- 4.1 BASIC STORED PROCEDURE
CREATE OR REPLACE PROCEDURE EMP_NAME (names OUT SYS_REFCURSOR)
IS 
BEGIN
OPEN names FOR
SELECT firstname, lastname FROM Employee;
CLOSE names;
END;
/

DECLARE
  c_names SYS_REFCURSOR;
  f_name Employee.firstname%TYPE;
  l_name Employee.lastname%TYPE;
BEGIN
  emp_name(names => c_names);
  LOOP
  FETCH c_names INTO f_name, l_name;
  DBMS_OUTPUT.PUT_LINE(f_name || ' | ' || l_name);
  EXIT WHEN c_names%NOTFOUND;
  END LOOP;
END;
/
-- 4.2 STORED PROCEDURE INPUT PARAMETERS
CREATE OR REPLACE PROCEDURE EMP_PERSONAL_UPDATE(
  EMP_ID IN EMPLOYEE.EMPLOYEEID%TYPE,
  EMP_ADDR IN EMPLOYEE.ADDRESS%TYPE,
  EMP_CITY IN EMPLOYEE.CITY%TYPE,
  EMP_STATE IN EMPLOYEE.STATE%TYPE,
  EMP_COUNTRY IN EMPLOYEE.COUNTRY%TYPE,
  EMP_POSTALCODE IN EMPLOYEE.POSTALCODE%TYPE,
  EMP_PHONE IN EMPLOYEE.PHONE%TYPE,
  EMP_FAX IN EMPLOYEE.FAX%TYPE,
  EMP_EMAIL IN EMPLOYEE.EMAIL%TYPE
)
AS
BEGIN
UPDATE Employee 
SET 
Employee.address = EMP_addr,
Employee.city = EMP_city,
Employee.state = EMP_state,
Employee.country = EMP_country,
Employee.postalcode = EMP_postalcode,
Employee.phone = EMP_phone,
Employee.fax = EMP_fax,
Employee.email = EMP_email
WHERE Employee.employeeid = EMP_ID;
END;
/

execute EMP_PERSONAL_UPDATE(10, '10 Flap Lane', 'Tallahassee', 'FL', 'USA', '32300', '+ (123) 456-7890', '000-000-0000', 'emailme@emailme.com');
select * from employee where employeeid = 10;
/

CREATE OR REPLACE PROCEDURE 
GET_MANAGERS(emp_id IN Employee.employeeid%TYPE, 
             emp_managers OUT SYS_REFCURSOR)
AS
BEGIN
OPEN emp_managers FOR
SELECT firstname, lastname FROM Employee WHERE employeeid = 
(SELECT reportsto FROM Employee WHERE employeeid=emp_id);
CLOSE emp_managers;
END;
/

declare
  c_managers SYS_REFCURSOR;
begin
  get_managers(emp_id => 7, emp_managers => c_managers);
end;
/

select firstname, lastname from employee where employeeid=
(SELECT reportsto from employee where employeeid=6);

-- 4.3 STORED PROCEDURE OUTPUT PARAMETERS
CREATE OR REPLACE PROCEDURE 
GET_CUST_INFO(cust_id IN Customer.customerid%TYPE,
              cust_name OUT Customer.firstname%TYPE,
              cust_comp OUT Customer.company%TYPE)
AS
f_name Customer.firstname%TYPE;
l_name Customer.lastname%TYPE;
BEGIN
select firstname, lastname into f_name, l_name from
Customer where customerid=cust_id;
cust_name:=f_name || ' ' || l_name;
select company into cust_comp from Customer
where customerid=cust_id;
END;
/

SET SERVEROUTPUT ON;
declare
c_id Customer.customerid%TYPE;
c_name Customer.firstname%TYPE;
c_comp Customer.company%TYPE;
begin
c_id:=12;
get_cust_info(cust_id => c_id,
              cust_name => c_name,
              cust_comp => c_comp);
DBMS_OUTPUT.PUT_LINE(c_name || ' | ' || c_comp);
end;
/
-- 5 TRANSACTIONS
-- Delete Invoice from invoiceid
DECLARE
  invc_id Invoiceline.invoiceid%TYPE;
BEGIN
invc_id := 63;
DELETE FROM Invoiceline WHERE invoiceid = invc_id;
DELETE FROM Invoice WHERE invoiceid = invc_id;
END;
/

select * from Invoice where invoiceid = 63;

-- Insert into customer from stored procedure
CREATE OR REPLACE PROCEDURE INSERT_CUSTOMER(
  cust_rec IN Customer%ROWTYPE
)
AS
BEGIN
  INSERT INTO Customer Values cust_rec;
END;
/

declare
  new_cust Customer%ROWTYPE;
begin
  new_cust:=(59, 'Rosham', 'Bojangles', 'Best Company',
             '222 An Address', 'ACITY', 'ST', 'CN', '232432', 
             '+ (123) 234-2341', '+ (123) 234-2341', 'email@email.com',
             12);
  insert_customer(cust_rec => new_cust);
end;
/
-- 6.1 TRIGGERS
CREATE TABLE LOGS (
  LOG_ID NUMBER PRIMARY KEY,
  EMP_ID NUMBER,
  STAMP DATE
);
/

CREATE SEQUENCE LOG_SEQ
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER LOG_TRIGGER
BEFORE INSERT ON Logs
FOR EACH ROW
BEGIN
  SELECT LOG_SEQ.NEXTVAL INTO :NEW.LOG_ID FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER EMP_TRIGGER
AFTER INSERT ON Employee
FOR EACH ROW
BEGIN
  INSERT INTO Logs(emp_id, stamp) 
  VALUES(:NEW.EMPLOYEEID, SYSDATE);  
END;
/

insert into employee(employeeid, lastname, firstname, title) 
values (11, 'Finkle', 'Brinkle', 'Store Guy');
/

