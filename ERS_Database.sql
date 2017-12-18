/****************************************************************
		Database Creation SQL File for Expense Reimbursement System
		Expense Reimbursement System Database (ERS)
		Script: ERS_Database.sql
		Description: Creates and populates the ERS Database with some data.
		DB Server: Oracle
		Author: Felix Abreu
*****************************************************************/


/****************************************************************
		Drop database if it exists.
		This ensures that we have a clean playing field for making 
		the database and we won't come across any issues.
*****************************************************************/
		DROP USER sensus_dbadmin CASCADE;



/****************************************************************
    Create Database
*****************************************************************/

CREATE USER sensus_dbadmin
IDENTIFIED BY sensus2016
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to sensus_dbadmin;
GRANT resource to sensus_dbadmin;
GRANT create session TO sensus_dbadmin;
GRANT create table TO sensus_dbadmin;
GRANT create view TO sensus_dbadmin;

conn sensus_dbadmin/sensus2016

/***************************************************************
    Create Tables
****************************************************************/
DROP TABLE ERS_REIMBURSEMENT;
DROP TABLE ERS_REIMBURSEMENT_STATUS;
DROP TABLE ERS_REIMBURSEMENT_TYPE;
DROP TABLE ERS_USERS;
DROP TABLE ERS_USER_ROLES;


CREATE TABLE ERS_REIMBURSEMENT
(
    Reimb_ID NUMBER NOT NULL,
    Reimb_Amount NUMBER NOT NULL,
    Reimb_Submitted TIMESTAMP NOT NULL,
    Reimb_Resolved TIMESTAMP,
    Reimb_Description VARCHAR2(250),
    Reimb_Receipt BLOB,
    Reimb_Author NUMBER NOT NULL,
    Reimb_Resolver NUMBER,
    Reimb_Status_ID NUMBER NOT NULL,
    Reimb_Type_ID NUMBER NOT NULL,

    CONSTRAINT ERS_REIMBURSEMENT_PK PRIMARY KEY  (Reimb_ID)

);

CREATE TABLE ERS_REIMBURSEMENT_STATUS(
  Reimb_Status_ID NUMBER NOT NULL,
  Reimb_Status VARCHAR2(10) NOT NULL,
  
  CONSTRAINT REIMB_STATUS_PK PRIMARY KEY (Reimb_Status_ID)
);

CREATE TABLE ERS_REIMBURSEMENT_TYPE(
  Reimb_Type_ID NUMBER NOT NULL,
  Reimb_Type VARCHAR2(10) NOT NULL,

  CONSTRAINT REIMB_TYPE_PK PRIMARY KEY (Reimb_Type_ID)
);

CREATE TABLE ERS_USERS(
  Ers_Users_ID NUMBER NOT NULL,
  Ers_UserName VARCHAR2(50) UNIQUE NOT NULL,
  Ers_PassWord VARCHAR2(50) NOT NULL,
  User_First_Name VARCHAR2(100) NOT NULL,
  User_Last_Name VARCHAR2(100) NOT NULL,
  User_Email VARCHAR2(150) UNIQUE NOT NULL,
  User_Role_ID NUMBER NOT NULL,

  CONSTRAINT ERS_USERS_PK PRIMARY KEY (Ers_Users_ID)
);

CREATE TABLE ERS_USER_ROLES(
  Ers_User_Role_ID NUMBER NOT NULL,
  User_Role VARCHAR2(10) NOT NULL,
  
  CONSTRAINT ERS_USER_ROLES_PK PRIMARY KEY (Ers_User_Role_ID)
);

/************************************************************
    Create Foreign Keys
*************************************************************/


ALTER TABLE ERS_REIMBURSEMENT ADD CONSTRAINT ERS_USERS_FK_AUTH
    FOREIGN KEY (Reimb_Author) REFERENCES ERS_USERS (Ers_Users_ID);

ALTER TABLE ERS_REIMBURSEMENT ADD CONSTRAINT ERS_USERS_FK_RESLVR
    FOREIGN KEY (Reimb_Resolver) REFERENCES ERS_USERS (Ers_Users_ID);

ALTER TABLE ERS_REIMBURSEMENT ADD CONSTRAINT ERS_REIMBURSEMENT_STATUS_FK
    FOREIGN KEY (Reimb_Status_ID) REFERENCES ERS_REIMBURSEMENT_STATUS (Reimb_Status_ID);

ALTER TABLE ERS_REIMBURSEMENT ADD CONSTRAINT ERS_REIMBURSEMENT_TYPE_FK
    FOREIGN KEY (Reimb_Type_ID) REFERENCES ERS_REIMBURSEMENT_TYPE (Reimb_Type_ID);

ALTER TABLE ERS_USERS ADD CONSTRAINT USER_ROLES_FK
    FOREIGN KEY (User_Role_ID) REFERENCES ERS_USER_ROLES (Ers_User_Role_ID) ;
    
    
    
/*************************************************************
  Create Sequences that will be triggered when creating primary keys
  for each table
*************************************************************/

CREATE SEQUENCE ERS_REIMBURSEMENT_SEQ
START WITH 31
INCREMENT BY 1;
/

CREATE SEQUENCE ERS_USERS_SEQ
START WITH 19
INCREMENT BY 1;
/

CREATE SEQUENCE ERS_REIMBURSEMENT_STATUS_SEQ
START WITH 18
INCREMENT BY 1;
/

CREATE SEQUENCE ERS_REIMBURSEMENT_TYPE_SEQ
START WITH 98
INCREMENT BY 1;
/

CREATE SEQUENCE ERS_USER_ROLES_SEQ
START WITH 412
INCREMENT BY 1;
/

/***************************************************
  Create triggers that will be called when inserting
  rows into each respective table
****************************************************/

CREATE OR REPLACE TRIGGER ERS_REIMBURSEMENT_TRIGGER
BEFORE INSERT ON ERS_REIMBURSEMENT
FOR EACH ROW
BEGIN
SELECT ERS_REIMBURSEMENT_SEQ.NEXTVAL INTO :new.Reimb_ID FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER ERS_REIMBURSEMENT_STAT_TRIG
BEFORE INSERT ON ERS_REIMBURSEMENT_STATUS
FOR EACH ROW
BEGIN
SELECT ERS_REIMBURSEMENT_STATUS_SEQ.NEXTVAL INTO :new.Reimb_Status_ID FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER ERS_REIMBURSEMENT_TYPE_TRIG
BEFORE INSERT ON ERS_REIMBURSEMENT_TYPE
FOR EACH ROW
BEGIN
SELECT ERS_REIMBURSEMENT_TYPE_SEQ.NEXTVAL INTO :new.Reimb_Type_ID FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER ERS_USERS_SEQ_TRIGGER
BEFORE INSERT ON ERS_USERS
FOR EACH ROW
BEGIN
SELECT ERS_USERS_SEQ.NEXTVAL INTO :new.Ers_Users_ID FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER ERS_USER_ROLES_TRIGGER
BEFORE INSERT ON ERS_USER_ROLES
FOR EACH ROW
BEGIN
SELECT ERS_USER_ROLES_SEQ.NEXTVAL INTO :new.Ers_User_Role_ID FROM DUAL;
END;
/

/***********************************************************

  Populate Table with some information 
************************************************************/
/*The steps below show the process of updating database with a user by
    1. Create entry into ERS_USER_ROLES.
        - In front end, user will have to choose if they are "Emp" or "FinMan".
        After choosing which one they are, they will be redirected to registration front end page
    2. Create entry into ERS_USERS 
        - In front end, user will have to populate a registration form with information. 
        SQL calls that will need to be made to make sure user is unique
            -existingAccount(User username)
            -existingAccount(User email)
    3. User can then submit reimbursement request once they've created their account. 
*/

INSERT INTO ERS_USER_ROLES (User_Role) VALUES('Emp');
INSERT INTO ERS_USER_ROLES (User_Role) VALUES('Finman');


INSERT INTO ERS_USERS (Ers_UserName, Ers_PassWord,User_First_Name, User_Last_Name, User_Email, User_Role_ID) VALUES('fabreu','password','Felix','Abreu','fetex123@gmail.com',413);
INSERT INTO ERS_USERS (Ers_UserName, Ers_PassWord,User_First_Name, User_Last_Name, User_Email, User_Role_ID) VALUES('genbon','password','Genesis','Bonds','genesis.bonds@gmail.com',414);

INSERT INTO ERS_REIMBURSEMENT_STATUS (Reimb_Status) VALUES ('Pending');
INSERT INTO ERS_REIMBURSEMENT_TYPE (Reimb_Type) VALUES('Travel');


INSERT INTO ERS_REIMBURSEMENT (Reimb_Amount, Reimb_Submitted, Reimb_Description, Reimb_Author, Reimb_Status_ID, Reimb_Type_ID) VALUES (19.31,TO_DATE('2017-12-03','YYYY-MM-DD'), 'Enthuware Software',19,18,98);



