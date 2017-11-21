SELECT * FROM artist
WHERE LOWER(Name) LIKE '%the%';

SELECT COUNT(*) FROM artist;

CREATE VIEW employeeshort AS
SELECT * FROM employee
WHERE employeeid < 5;

SELECT * FROM employeeshort;

SELECT * FROM dual;

UPDATE employee
SET lastname='Bonds'
WHERE firstname = 'Andrew';

