CREATE TABLE REIMBURSEMENT(
R_ID NUMBER PRIMARY KEY,
R_AMOUNT DECIMAL(12,2) NOT NULL,
R_SUBMITTED TIMESTAMP,
R_RESOLVED TIMESTAMP,
R_DESCRIPTION VARCHAR2(250),
R_RECEIPT BLOB,
R_AUTHOR NUMBER NOT NULL,
R_RESOLVER NUMBER,
R_STATUS_ID NUMBER DEFAULT 1,
R_TYPE_ID NUMBER NOT NULL
);

CREATE SEQUENCE RID_SEQ  --  Drop at end of project
START WITH 500
INCREMENT BY 1;
/
CREATE OR REPLACE TRIGGER RID_TRIGGER
BEFORE INSERT ON REIMBURSEMENT
FOR EACH ROW
BEGIN
SELECT RID_SEQ.NEXTVAL INTO :NEW.R_ID FROM DUAL; --DUAL IS DUMMY DATA TABLE
END;
/
CREATE OR REPLACE TRIGGER RSUB_TRIGGER
BEFORE INSERT ON REIMBURSEMENT
FOR EACH ROW
BEGIN
  SELECT CURRENT_TIMESTAMP INTO :NEW.R_SUBMITTED FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER RRES_TRIGGER
BEFORE UPDATE ON REIMBURSEMENT
FOR EACH ROW
BEGIN
  SELECT CURRENT_TIMESTAMP INTO :NEW.R_RESOLVED FROM DUAL;
END;
/
CREATE TABLE REIMBURSEMENT_STATUS(
R_STATUS_ID NUMBER PRIMARY KEY,
R_STATUS VARCHAR2(10) NOT NULL
);
/
CREATE TABLE REIMBURSEMENT_TYPE(
R_TYPE_ID NUMBER PRIMARY KEY,
R_TYPE VARCHAR2(10) NOT NULL
);
/

CREATE TABLE USERS(
USER_ID NUMBER PRIMARY KEY,
USERNAME VARCHAR2(50) UNIQUE NOT NULL,
PASSWORD VARCHAR2(50) NOT NULL,
FIRST_NAME VARCHAR2(100) NOT NULL,
LAST_NAME VARCHAR2(100) NOT NULL,
EMAIL VARCHAR2(150) NOT NULL,
ROLE_ID NUMBER NOT NULL
);
/
CREATE SEQUENCE UID_SEQ  --  Drop at end of project
START WITH 100
INCREMENT BY 1;
/
CREATE OR REPLACE TRIGGER UID_TRIGGER
BEFORE INSERT ON USERS
FOR EACH ROW
BEGIN
SELECT UID_SEQ.NEXTVAL INTO :NEW.USER_ID FROM DUAL;
END;
/
CREATE TABLE USER_ROLES(
ROLE_ID NUMBER PRIMARY KEY,
ROLE VARCHAR2(10) NOT NULL
);
/

CREATE OR REPLACE PROCEDURE rUpdate(
  rid IN REIMBURSEMENT.R_ID%TYPE,
  rres IN REIMBURSEMENT.R_RESOLVER%TYPE,
  rstatus IN REIMBURSEMENT.R_STATUS_ID%TYPE)
IS
BEGIN
  UPDATE REIMBURSEMENT SET R_RESOLVER = rres, R_STATUS_ID = rstatus WHERE R_ID = rid;
END;
/
select * from USERS where username = 'SQLUSER' and password = 'SQLPASS';