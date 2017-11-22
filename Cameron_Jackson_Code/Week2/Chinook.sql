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
