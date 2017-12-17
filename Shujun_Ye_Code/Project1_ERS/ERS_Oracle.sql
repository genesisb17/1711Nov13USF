
/*******************************************************************************
   ERS Database
   Script: ERS_Oracle.sql
   Description: Creates and populate the ERS database.
   DB Server: Oracle
   Author: Shujun Ye
********************************************************************************/

/*******************************************************************************
   Drop database if it exists
********************************************************************************/
DROP USER ers CASCADE;

/*******************************************************************************
   Create database
********************************************************************************/
CREATE USER ers
IDENTIFIED BY p4ssw0rd
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to ers;
GRANT resource to ers;
GRANT create session TO ers;
GRANT create table TO ers;
GRANT create view TO ers;

conn ers/p4ssw0rd

/*******************************************************************************
   Create Tables
********************************************************************************/
CREATE TABLE ERS_REIMBURSEMENT
(
	REIMB_ID NUMBER NOT NULL,
	REIMB_AMOUNT NUMBER NOT NULL,
	REIMB_SUBMITTED TIMESTAMP NOT NULL,
	REIMB_RESOLVED TIMESTAMP,
	REIMB_DESCRIPTION VARCHAR2(250),
	REIMB_RECEIPT BLOB,
	REIMB_AUTHOR NUMBER NOT NULL,
	REIMB_RESOLVER NUMBER,
	REIMB_STATUS_ID NUMBER NOT NULL,
	REIMB_TYPE_ID NUMBER NOT NULL,
	CONSTRAINT ERS_REIMBURSEMENT_PK PRIMARY KEY (REIMB_ID)
);

CREATE TABLE ERS_USERS
(
	ERS_USERS_ID NUMBER NOT NULL,
	ERS_USERNAME VARCHAR2(50) NOT NULL UNIQUE,
	ERS_PASSWORD VARCHAR2(50) NOT NULL,
	USER_FIRST_NAME VARCHAR2(100) NOT NULL,
	USER_LAST_NAME VARCHAR2(100) NOT NULL,
	USER_EMAIL VARCHAR2(150) NOT NULL UNIQUE,
	USER_ROLE_ID NUMBER NOT NULL,
	CONSTRAINT ERS_USERS_PK PRIMARY KEY (ERS_USERS_ID)
);

CREATE TABLE ERS_REIMBURSEMENT_STATUS
(
	REIMB_STATUS_ID NUMBER NOT NULL,
	REIMB_STATUS VARCHAR2(10) NOT NULL,
	CONSTRAINT REIMB_STATUS_PK PRIMARY KEY (REIMB_STATUS_ID)
);

CREATE TABLE ERS_REIMBURSEMENT_TYPE
(
	REIMB_TYPE_ID NUMBER NOT NULL,
	REIMB_TYPE VARCHAR2(10) NOT NULL,
	CONSTRAINT REIMB_TYPE_PK PRIMARY KEY (REIMB_TYPE_ID)
);

CREATE TABLE ERS_USER_ROLES
(
	ERS_USER_ROLE_ID NUMBER NOT NULL,
	USER_ROLE VARCHAR2(10) NOT NULL,
	CONSTRAINT ERS_USER_ROLES_PK PRIMARY KEY (ERS_USER_ROLE_ID)
);

/*******************************************************************************
   Create Foreign Keys
********************************************************************************/
ALTER TABLE ERS_REIMBURSEMENT ADD CONSTRAINT ERS_USERS_FK_AUTH
	FOREIGN KEY (REIMB_AUTHOR) REFERENCES ERS_USERS (ERS_USERS_ID);

ALTER TABLE ERS_REIMBURSEMENT ADD CONSTRAINT ERS_USERS_FK_RESLVR
	FOREIGN KEY (REIMB_RESOLVER) REFERENCES ERS_USERS (ERS_USERS_ID);

ALTER TABLE ERS_REIMBURSEMENT ADD CONSTRAINT ERS_REIMBURSEMENT_STATUS_FK
	FOREIGN KEY (REIMB_STATUS_ID) REFERENCES ERS_REIMBURSEMENT_STATUS (REIMB_STATUS_ID);

ALTER TABLE ERS_REIMBURSEMENT ADD CONSTRAINT ERS_REIMBURSEMENT_TYPE_FK
	FOREIGN KEY (REIMB_TYPE_ID) REFERENCES ERS_REIMBURSEMENT_TYPE (REIMB_TYPE_ID);

ALTER TABLE ERS_USERS ADD CONSTRAINT USER_ROLES_FK
	FOREIGN KEY (USER_ROLE_ID) REFERENCES ERS_USER_ROLES (ERS_USER_ROLE_ID);

/*******************************************************************************
   Create Sequences and Triggers for auto-increment fields
********************************************************************************/
CREATE SEQUENCE REIMB_ID_SEQ
START WITH 100000
INCREMENT BY 1;

CREATE OR REPLACE TRIGGER REIMB_ID_TRIGGER
BEFORE INSERT ON ERS_REIMBURSEMENT
FOR EACH ROW
BEGIN
	SELECT REIMB_ID_SEQ.NEXTVAL INTO :NEW.REIMB_ID FROM DUAL;
	:NEW.REIMB_SUBMITTED := LOCALTIMESTAMP;
END;
/
CREATE SEQUENCE ERS_USERS_ID_SEQ
START WITH 200000
INCREMENT BY 1;

CREATE OR REPLACE TRIGGER ERS_USERS_ID_TRIGGER
BEFORE INSERT ON ERS_USERS
FOR EACH ROW
BEGIN
	SELECT ERS_USERS_ID_SEQ.NEXTVAL INTO :NEW.ERS_USERS_ID FROM DUAL;
END;
/

/*******************************************************************************
   Create a stored procedure for updating request status
********************************************************************************/
CREATE OR REPLACE PROCEDURE update_reimbursement_status (id IN NUMBER,
	resolver IN NUMBER, status IN NUMBER)
AS
BEGIN
	UPDATE ERS_REIMBURSEMENT SET REIMB_RESOLVED = LOCALTIMESTAMP,
	REIMB_RESOLVER = resolver, REIMB_STATUS_ID = status WHERE REIMB_ID = id;
END;
/

/*******************************************************************************
   Populate Fixed Data into STATUS, TYPE, and ROLES Tables
********************************************************************************/
INSERT INTO ERS_REIMBURSEMENT_STATUS (REIMB_STATUS_ID, REIMB_STATUS)
VALUES (100, 'Pending');

INSERT INTO ERS_REIMBURSEMENT_STATUS (REIMB_STATUS_ID, REIMB_STATUS)
VALUES (200, 'Approved');

INSERT INTO ERS_REIMBURSEMENT_STATUS (REIMB_STATUS_ID, REIMB_STATUS)
VALUES (300, 'Denied');

INSERT INTO ERS_REIMBURSEMENT_TYPE (REIMB_TYPE_ID, REIMB_TYPE)
VALUES (1001, 'Lodging');

INSERT INTO ERS_REIMBURSEMENT_TYPE (REIMB_TYPE_ID, REIMB_TYPE)
VALUES (1002, 'Travel');

INSERT INTO ERS_REIMBURSEMENT_TYPE (REIMB_TYPE_ID, REIMB_TYPE)
VALUES (1003, 'Food');

INSERT INTO ERS_REIMBURSEMENT_TYPE (REIMB_TYPE_ID, REIMB_TYPE)
VALUES (1004, 'Other');

INSERT INTO ERS_USER_ROLES (ERS_USER_ROLE_ID, USER_ROLE)
VALUES (1, 'Employee');

INSERT INTO ERS_USER_ROLES (ERS_USER_ROLE_ID, USER_ROLE)
VALUES (2, 'Manager');

/*******************************************************************************
   Populate Employee Tables
********************************************************************************/
INSERT INTO ERS_USERS (ERS_USERNAME, ERS_PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)
VALUES ('admin', 'admin', 'Erin', 'Tucker', 'erin.tucker@gmail.com', 2);

INSERT INTO ERS_USERS (ERS_USERNAME, ERS_PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)
VALUES ('katieboyce', 'Katie123', 'Katherine', 'Boyce', 'katie.boyce@gmail.com', 2);

INSERT INTO ERS_USERS (ERS_USERNAME, ERS_PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)
VALUES ('bradwalsh', 'Brad123', 'Brandon', 'Walsh', 'brad.walsh@outlook.com', 1);

INSERT INTO ERS_USERS (ERS_USERNAME, ERS_PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)
VALUES ('carlambrose', 'Carl123', 'Carlos', 'Ambrose', 'cambrose@gmail.com', 1);

INSERT INTO ERS_USERS (ERS_USERNAME, ERS_PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)
VALUES ('mikecampbell', 'Mike123', 'Michael', 'Campbell', 'mcampbell@gmail.com', 1);

INSERT INTO ERS_USERS (ERS_USERNAME, ERS_PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)
VALUES ('alexpatel', 'Alex123', 'Alexander', 'Patel', 'apatel@hotmail.com', 1);
