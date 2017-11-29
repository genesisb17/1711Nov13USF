



--These commands will create the tables for our bank users--
CREATE TABLE USERS(
U_ID NUMBER PRIMARY KEY,
FIRSTNAME VARCHAR2(30) NOT NULL,
LASTNAME VARCHAR2(30) NOT NULL,
USERNAME VARCHAR2(30) UNIQUE NOT NULL,
PASSWORD VARCHAR2(20) NOT NULL
);

--this command creates an accounts table with acc_id as primary key, user_id, and balance. assigns foreign key to reference the primary key of Users table--
CREATE TABLE ACCOUNTS(
ACC_ID NUMBER PRIMARY KEY,
USER_ID NUMBER NOT NULL,
BALANCE DECIMAL(12,2) NOT NULL,
CONSTRAINT FK_USERID FOREIGN KEY(USER_ID) REFERENCES USERS(U_ID)
);

--CREATE sequence to be followed by primary keys in both tables. --

CREATE SEQUENCE U_SEQ
STARTS WITH 1
INCREMENT BY 1;
/

CREATE SEQUENCE AU_SEQ
STARTS WITH 1
INCREMENT BY 1;
/

--Create trigger calls for when to trigger the sequence to increment and then assign value to primary keys--

CREATE OR REPLACE TRIGGER u_trigger
BEFORE INSERT ON USERS
FOR EACH ROW
BEGIN
SELECT U_SEQ.NEXTVAL INTO :new.u_id FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER au_trigger
BEFORE INSERT ON ACCOUNTS
FOR EACH ROW
BEGIN
SELECT AU_SEQ.NEXTVAL INTO :new.acc_id FROM DUAL;
END;
/
