-- SQL WORKBOOK ASSIGNMENTS
-- Wezley Singleton

-- Select all records from the Employee table
SELECT * FROM employee;


-- Select all records from the Employee table where last name is King
SELECT * FROM employee
WHERE lastname = 'King';


-- Select all records from the Employee table where first name is Andrew and 
-- REPORTSTO is NULL
SELECT * FROM employee
WHERE firstname = 'Andrew' AND reportsto IS NULL;
-- IS NULL is used instead of 'reportsto = NULL'


-- Select all albums in Album table and sort result set in descending order 
-- by title
SELECT * FROM album
ORDER BY title DESC;


-- Select first name from Customer and sort result set in ascending order by 
-- city
SELECT firstname FROM customer
ORDER BY city ASC;


-- Insert two new records into Genre table
INSERT INTO genre (genreid, name) VALUES (26, 'Thriller');
INSERT INTO genre (genreid, name) VALUES (27, 'Action');

-- Insert two new records into Employee table
INSERT INTO employee 
(employeeid, lastname, firstname, title, reportsto, birthdate, hiredate, 
address, city, state, country, postalcode, phone, fax, email)

VALUES (9, 'Singleton', 'Wezley', 'Java Programmer', 6, '07-JUL-90', '13-NOV-17', 
'17761 Tropical Cove Dr', 'Tampa', 'FL', 'USA', 33647, '+1 (941) 445-0537', 
NULL, 'wezley.singleton@gmail.com');

INSERT INTO employee 
(employeeid, lastname, firstname, title, reportsto, birthdate, hiredate, 
address, city, state, country, postalcode, phone, fax, email)

VALUES (10, 'Singleton', 'Nicole', 'Social Media Marketer', 2, '13-OCT-89', 
'18-JUL-16', '17761 Tropical Cove Dr', 'Tampa', 'FL', 'USA', 33647, 
'+1 (954) 822-4944', NULL, 'nme1089@gmail.com');

-- Insert two new records into Customer table
INSERT INTO customer
(customerid, firstname, lastname, company, address, city, state, country, 
postalcode, phone, fax, email, supportrepid)

VALUES (60, 'Bill', 'Johnson', NULL, '123 Main St', 'Smalltown', 'NY', 'USA', 
42051, '+1 (555) 555-0123', NULL, 'billyjohn@email.com', 3);

INSERT INTO customer
(customerid, firstname, lastname, company, address, city, state, country, 
postalcode, phone, fax, email, supportrepid)

VALUES (61, 'Jack', 'Williams', 'Williams Landscaping', '9876 Willow Ln', 
'Othertown', 'PA', 'USA', 48657, '+1 (555) 123-4567', NULL, 
'jwilliams@williamslandscaping.com', 2);


-- Update Aaron Mitchell in Customer table to Robert Walter
UPDATE customer
SET firstname = 'Robert', lastname = 'Walter'
WHERE firstname = 'Aaron' AND lastname = 'Mitchell';


-- Update name of artist in the Artist table “Creedence Clearwater Revival” 
-- to “CCR”
UPDATE artist
SET name = 'CCR'
WHERE name = 'Creedence Clearwater Revival';


-- Select all invoices with a billing address like “T%”
SELECT * FROM invoice
WHERE billingaddress LIKE 'T%';


-- Select all invoices that have a total between 15 and 50
SELECT * FROM invoice
WHERE (total > 15) AND (total < 50);


-- Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM employee
WHERE (hiredate >= '01-JUN-2003') AND (hiredate <= '01-MAR-04');
-- NOTE: SQL DATE data type format can be either DD-MMM-YY or DD-MMM-YYYY


-- Delete a record in Customer table where the name is Robert Walter 
-- (There may be constraints that rely on this, find out how to resolve them).
-- its has two constraints
ALTER TABLE invoice
DROP CONSTRAINT FK_INVOICECUSTOMERID;

ALTER TABLE invoice
ADD CONSTRAINT FK_INVOICECUSTOMERID
FOREIGN KEY (CUSTOMERID)
REFERENCES customer(CUSTOMERID)
ON DELETE CASCADE;

ALTER TABLE invoiceline
DROP CONSTRAINT FK_INVOICELINEINVOICEID;

ALTER TABLE invoiceline
ADD CONSTRAINT FK_INVOICELINEINVOICEID
FOREIGN KEY (INVOICEID)
REFERENCES invoice(INVOICEID)
ON DELETE CASCADE;

DELETE FROM customer
WHERE firstname = 'Robert' AND lastname = 'Walter';


-- Create a function that returns the current time
CREATE OR REPLACE FUNCTION getCurrentTime
RETURN TIMESTAMP IS l_systimestamp TIMESTAMP;

BEGIN
  SELECT systimestamp
    INTO l_systimestamp
    FROM dual;
  RETURN l_systimestamp;
END;
/
SELECT getCurrentTime() FROM dual;


-- create a function that returns the length of a mediatype from the 
-- mediatype table
CREATE OR REPLACE FUNCTION getLengthOfMediaTypeName(mediatype_id NUMBER)
RETURN NUMBER IS l_lengthOfMediaTypeName NUMBER(3,0);

BEGIN
  DECLARE
    l_mediatype_name VARCHAR2(120);
  
  BEGIN 
    /* stores the name of the mediatype into 'l_mediatype_name' where the 
     * mediatypeid is equal to the value of parameter 'mediatype_id' */
    SELECT name INTO l_mediatype_name FROM mediatype
    WHERE mediatype_id = mediatypeid; 
    
    /* stores the length of the VARCHAR2 value in 'l_mediatype_name' into
     * the 'l_lengthOfMediaTypeName' variable */
    SELECT LENGTH(l_mediatype_name) 
    INTO l_lengthOfMediaTypeName 
    FROM dual;
  END;
  
  -- returns the value of 'l_lengthOfMediaTypeName'
  RETURN l_lengthOfMediaTypeName;
END;
/

/* You must include the WHERE clause, otherwise the result set has a 'length of
 * name' for each row, that is equal to the length of the name of the 
 * 'mediatype' whose 'mediatypeid' matches the parameter passed into the 
 * 'getLengthOfMediaTypeName()' function*/
SELECT name, getLengthOfMediaTypeName(3) AS "Length of name" FROM mediatype
WHERE mediatypeid = 3;