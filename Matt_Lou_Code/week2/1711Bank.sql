create table users(
U_ID number primary key,
-- not more than 30 characters
-- password is blue because sql recognizes the name, but can be used
FIRSTNAME VARCHAR2(30) NOT NULL,
LASTNAME VARCHAR2(30) NOT NULL,
USERNAME VARCHAR2(30) NOT NULL, 
PASSWORD VARCHAR2(20) NOT NULL

);

--DECIMAL(total number of digits, decimal points)
--primary key, foreign key, not null, unique, CHECK, DEFAULT
CREATE TABLE ACCOUNTS(
ACC_ID NUMBER PRIMARY KEY,
USER_ID NUMBER NOT NULL,
BALANCE DECIMAL(12,2) NOT NULL,

CONSTRAINT FK_USERID FOREIGN KEY(USER_ID) REFERENCES USERS(U_ID)
);


-- INTRO TO PL/SQL = PROCEDURAL LANGUAGE EXTENSION OF SQL
-- SEQUENCE
CREATE SEQUENCE U_SEQ
START WITH 1
INCREMENT BY 1;
/
--TRIGGER
--dual is a dummy table

--create a new acc_trigger and new.ACC_ID
CREATE OR REPLACE TRIGGER U_TRIGGER
BEFORE INSERT ON USERS
FOR EACH ROW
BEGIN
SELECT U_SEQ.NEXTVAL INTO :new.U_ID FROM DUAL;
END;
/

--CREATE A SEQUENCE AT 100 AND INCREMENT BY 1 EVERYTIME AN ACCOUNT IS CREATED
CREATE SEQUENCE A_SEQ
START WITH 100
INCREMENT BY 1;
--THIS TRIGGER WHEN AN ACCOUNT IS CREATED TO ADD INTO THE ACCOUNTS ACC_ID
CREATE OR REPLACE TRIGGER A_TRIGGER
BEFORE INSERT ON ACCOUNTS
FOR EACH ROW
BEGIN
SELECT A_SEQ.NEXTVAL INTO :new.ACC_ID FROM DUAL;
END;
/

--TESTING DML
INSERT INTO USERS(FIRSTNAME, LASTNAME, USERNAME, PASSWORD)
VALUES('Gen', 'Bo', 'genbo', '123');

select * from users;

update users
set FIRSTNAME = 'Matty', LASTNAME = 'Lou'
where USERNAME = 'genbo' and PASSWORD = '123';

select * from accounts;
select * from users;
select username from users;
commit;

select * from users
where username = 'mattyboy' and password = '123';

delete from users;
delete from accounts;
commit;
