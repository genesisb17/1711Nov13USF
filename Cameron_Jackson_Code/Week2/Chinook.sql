-- 2.1 SELECT
SELECT * FROM Employee; 
SELECT * FROM Employee WHERE Lastname = 'King'; 
SELECT * FROM Employee
WHERE Firstname = 'Andrew' AND Reportsto = NULL;

-- 2.2 ORDER BY
SELECT * FROM Album
ORDER BY Title DESC;
SELECT * FROM Customer 
ORDER BY City ASC;

-- 2.3 INSERT INTO
-- INSERT INTO Genre (NAME) VALUES ('Soul'); 
-- INSERT INTO Genre (NAME) VALUES ('Nu-Wave');
SELECT * FROM Genre;
SELECT * FROM Employee; 
INSERT INTO Employee (Lastname, Firstname, Title, Reportsto,
Birthdate, Hiredate, Address, City, State, Country, Postalcode,
Phone, Fax, Email)
VALUES (Henkleboss, Sonny, 'Store Greeter', 1, DATE '1932-01-23', 
DATE '1967-01-23', '1234 Too Cool Ave S', 'SwagCity', 'AB', 'Canada',
'T2K 1A1', '+ (000) 867-5309', '+ (888) 654-3121', 
'toooldforemail@nope.com');
INSERT INTO Employee (Lastname, Firstname, Title, Birthdate, 
Hiredate, Address, City, State, Country, Postalcode, Phone, 
Email)
VALUES (Liston, Lonnie, 'Entertainment', DATE '1940-12-28', 
DATE '2012-12-12', '25 Imma Singer St.', 'Los Angeles', 'CA', 
'United States', '90028', '+ (201) 123-456', 'hitmeup@email.com');

