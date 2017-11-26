--Trent Smith [9:10 AM] 
--2.1
SELECT * FROM CHINOOK.EMPLOYEE;
SELECT * FROM CHINOOK.EMPLOYEE WHERE LASTNAME = 'King';
SELECT * FROM CHINOOK.EMPLOYEE WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;

--2.2
SELECT * FROM CHINOOK.ALBUM ORDER BY TITLE DESC;
SELECT FIRSTNAME FROM CHINOOK.CUSTOMER ORDER BY CITY ASC;
--2.3
INSERT INTO CHINOOK.GENRE VALUES(27,'KILL LA KILL');
INSERT INTO CHINOOK.GENRE VALUES(26,'trent');

INSERT INTO CHINOOK.EMPLOYEE(EMPLOYEEID,LASTNAME,FIRSTNAME,TITLE)VALUES (9,'TRENT','SMITH','DICTACTOR OF THE WORLD');
INSERT INTO CHINOOK.EMPLOYEE(EMPLOYEEID,LASTNAME,FIRSTNAME,TITLE)VALUES (10,'SON','GOKU','GANGSTA');

INSERT INTO CHINOOK.CUSTOMER(FIRSTNAME,LASTNAME,COMPANY,EMAIL)VALUES('RICK','SANCHEZ','TRENTS CORP','EXAMPLE');
INSERT INTO CHINOOK.CUSTOMER(FIRSTNAME,LASTNAME,COMPANY,EMAIL) VALUES('PROFESSOR','FARNSWORTH','TRENTS CORP','EXAMPLE');

--2.4
UPDATE CHINOOK.CUSTOMER SET FIRSTNAME = 'Robert', LASTNAME = 'Walter' WHERE FIRSTNAME ='Aaron' AND LASTNAME = 'Mitchell';
UPDATE CHINOOK.ARTIST SET NAME = 'CCR' WHERE NAME = 'Creedence Clearwater Revival';
SELECT * FROM CHINOOK.ARTIST;
--2.5
SELECT * FROM CHINOOK WHERE ADDRESS LIKE 'T%';

--2.7
alter table CHINOOK.INVOICE DROP CONSTRAINT FK_INVOICECUSTOMERID;
DELETE CHINOOK.CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';
--3.0
--3.1
--4.1
CREATE OR REPLACE PROCEDURE B_B0
AS
BEGIN
  SELECT FIRSTNAME,LASTNAME INTO DUAL FROM CHINOOK.EMPLOYEE;
END;
--4.2
CREATE OR REPLACE PROCEDURE B_B
AS
BEGIN
  UPDATE CHINOOK.EMPLOYEE SET CITY ='TAMPA' WHERE EMPLOYEEID =8;
END;

CREATE OR REPLACE PROCEDURE B_B1
AS
BEGIN
  SELECT FIRSTNAME,LASTNAME INTO FROM EMPLOYEE WHERE TITLE LIKE '%Manager';
END;

--4.3

--5.0
START TRANSACTION;
DELETE INVOICE WHERE INVOICEID = 3;
COMMIT;

create or replace PROCEDURE FIVEZERO
AS
BEGIN 
  START TRANSACTION;
    INSERT INTO customer values();
  COMMIT;
END;

--6.1
create or replace TRIGGER sixoneatrigger
AFTER INSERT ON employee
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('INSERT ON ABLUM');
END;

create or replace TRIGGER sixonebtrigger
AFTER INSERT ON album
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('INSERT ON ABLUM');
END;

create or replace TRIGGER sixonectrigger
AFTER delete ON CUSTOMER
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('DELETE ON CUSTOMER');
END;
--7.0
--7.1
SELECT FIRSTNAME from CUSTOMER
INNER JOIN  INVOICE on INVOICE.invoiceid = CUSTOMER.CUSTOMERID;
--7.2
SELECT FIRSTNAME,LASTNAME,INVOICE.INVOICEID,INVOICE.TOTAL from CUSTOMER
FULL OUTER JOIN  INVOICE on INVOICE.invoiceid = CUSTOMER.CUSTOMERID;
--7.3
SELECT name,album.TITLE from artist
RIGHT JOIN ALBUM ON artist.ARTISTID = ALBUM.ARTISTID;
--7.4
SELECT * FROM ARTIST 
CROSS JOIN album order by Name asc;
--7.5
select * from employee;
--1.0
--1.1 Done
--1.2
create user OFFICESUPPLY identified by t3326434;
--2.1
CREATE TABLE OFFICESUPPLY.employee
(
   EmployeeID number Primary Key not null,
   USERNAME VARCHAR(20) NOT NULL,
   PASSWORD VARCHAR(20) NOT NULL,
   NAME VARCHAR(25) NOT NULL,
   DEPARTMENT VARCHAR(2) NOT NULL,
   MANAGER NUMBER NOT NULL
)

CREATE TABLE OFFICESUPPLY.Orders
(
   OrderID number Primary Key not null,
   OrderDate date not null,
   Status char not null,
FOREIGN KEY (OrderID) REFERENCES Employee (EmployeeId)
)

CREATE TABLE OFFICESUPPLY.OrderItem
(
  FOREIGN KEY (OrderID) REFERENCES officesupply.employee (EmployeeId),
  FOREIGN KEY (ProductID) REFERENCES officesupply.Orders (OrderID),
  Quanity NUMBER NOT NULL
)

CREATE TABLE OFFICESUPPLY.Category
(
  CATID PRIMARY KEY NOT NULL,
  NAME VARCHAR(80) NULL,
  DESCRIPT VARCHAR(255) NULL
)
CREATE TABLE OFFICESUPPLY.PRODUCT
(
PRODUCTID PRIMARY KEY NOT NULL,
FOREIGN KEY (ProductID)REFERENCES CATID,
name varchar(80) null,
Descript varchar(255) null,
UnitCost number null,
Foreign key (Supportid) references suppid
)

create table OFFICESUPPLY.supplier
(
suppid primary key not null,
name varchar(80)
)

--3.1
select * from officesupply.employee;
select * from officesupply.employee where department = 'HR';
select * from officesupply.employee where department = 'HR' AND username = 'jsmith';
select * from officesupply.employee where MANAGER = TRUE AND username = 'jsmith';
--3.2
select name from officesupply.product order by name asc;
select name from officesupply.product order by name desc;
select * from officesupply.category order by name;
--3.3
insert into officesupply.employee()values();
insert into officesupply.employee()values();
insert into officesupply.employee()values();
--3.4
update officesupply.PRODUCT set name = 'ruler';
update officesupply.category set descript =' ' where descript ='computer' and descript = 'cleaning supply';
--3.5
select username from officesupply.employee where username like 'j%';
select name from officesupply.product where name like 'o%';
--3.6
select name from officesupply.PRODUCT where unitprice between 3 and 10;
select name from officesupply.PRODUCT where unitprice between 500 and 800;
--3.7
delete officesupply.CATEGORY WHERE NAME ='audio visual';