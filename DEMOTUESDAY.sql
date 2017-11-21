SELECT * FROM employee;

create view employeeshort as select * from employee where employeeid<5;

SELECT * FROM employeeshort;

UPDATE CHINOOK.EMPLOYEE SET LASTNAME = 'BONDS' WHERE FIRSTNAME = 'ANDREW';

DELETE FROM EMPLOYEE WHERE LASTNAME = 'BONDS';