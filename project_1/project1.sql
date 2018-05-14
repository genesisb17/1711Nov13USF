create table ERS_REIMBURSEMENT
(
  REIMB_ID number,
  primary key(REIMB_ID),
  REIMB_AMOUNT NUMBER,
  REIMB_SUBMITTED TIMESTAMP,
  REIMB_RESOLVED TIMESTAMP,
  REIMB_DESCRIPTION VARCHAR2(250),
  REIMB_RECIEPT BLOB,
  U_ID number not null,
  REIMB_STATUS_ID number not null,
  REIMB_TYPE_ID number not null,
  ERS_USER_ROLE_ID number not null,
  constraint fk_5 FOREIGN KEY(U_ID) REFERENCES ers_users(U_ID),
  constraint fk_2 FOREIGN KEY(REIMB_STATUS_ID) REFERENCES ERSREIMBURSEMENTSTATUS(REIMB_STATUS_ID),
  constraint fk_3 FOREIGN KEY(REIMB_TYPE_ID) REFERENCES ERS_REIMBURSEMENT_TYPE(REIMB_TYPE_ID),
  constraint fk_4 FOREIGN KEY(ERS_USER_ROLE_ID) REFERENCES ers_user_roles(ERS_USER_ROLE_ID)
);

create table ERSREIMBURSEMENTSTATUS
(
  REIMB_STATUS_ID number,
  primary key(REIMB_STATUS_ID),
  REIMB_STATUS VARCHAR2(10)
);

--ERS_REIMBURSEMENT
CREATE SEQUENCE ERS_REIMBURSEMENT_STATUS_SEQ
START WITH 1
INCREMENT BY 1;

--TRIGGER
CREATE OR REPLACE TRIGGER ERSREIMBURSEMENTSTATUS_trigger
BEFORE INSERT ON ERSREIMBURSEMENTSTATUS
FOR EACH ROW
  BEGIN
    SELECT ERS_REIMBURSEMENT_STATUS_SEQ.NEXTVAL INTO :new.REIMB_STATUS_ID FROM DUAL;
  END;

create table ERS_REIMBURSEMENT_TYPE
(
  REIMB_TYPE_ID number,
  primary key(REIMB_TYPE_ID),
  REIMB_TYPE varchar2(10)
);

--ERS_REIMBURSEMENT type
CREATE SEQUENCE ERSREIMBURSEMENTTYPE_SEQ
START WITH 1
INCREMENT BY 1;

--TRIGGER
CREATE OR REPLACE TRIGGER ERS_REIMBURSEMENT_TYPE_trigger
BEFORE INSERT ON ERS_REIMBURSEMENT_TYPE
FOR EACH ROW
BEGIN
SELECT ERSREIMBURSEMENTTYPE_SEQ.NEXTVAL INTO :new.REIMB_TYPE_ID FROM DUAL;
END;

create table ers_user_roles
(
  ERS_USER_ROLE_ID NUMBER,
  PRIMARY KEY(ERS_USER_ROLE_ID),
  USER_ROLE VARCHAR2(10)
)

CREATE SEQUENCE ers_user_roles_SEQ
START WITH 1
INCREMENT BY 1;

--TRIGGER
CREATE OR REPLACE TRIGGER ers_user_roles_trigger
BEFORE INSERT ON ers_user_roles
FOR EACH ROW
BEGIN
SELECT ers_user_roles_SEQ.NEXTVAL INTO :new.ERS_USER_ROLE_ID FROM DUAL;
END;


create table ers_users
(
  U_ID NUMBER,
  PRIMARY KEY(U_ID),
  FIRSTNAME VARCHAR2(30) NOT NULL,
  LASTNAME VARCHAR2(30) NOT NULL,
  USERNAME VARCHAR2(30) UNIQUE NOT NULL,
  PASSWORD VARCHAR2(20) NOT NULL,
  EMAIL VARCHAR2(150) UNIQUE,
  ERS_USER_ROLE_ID number,
  constraint fk_1 FOREIGN KEY(ERS_USER_ROLE_ID) REFERENCES ers_user_roles(ERS_USER_ROLE_ID)
);

CREATE SEQUENCE ers_users_SEQ
START WITH 1
INCREMENT BY 1;

--TRIGGER
CREATE OR REPLACE TRIGGER ers_users_trigger
BEFORE INSERT ON ers_users
FOR EACH ROW
BEGIN
SELECT ers_users_SEQ.NEXTVAL INTO :new.U_ID FROM DUAL;
END;

--ers users ready to go
INSERT INTO ers_users(FIRSTNAME,LASTNAME,USERNAME,PASSWORD,EMAIL)VAlueS('Trent','Smith','ssjtrent','p','email');
select * from ers_users;



--ERS_REIMBURSEMENT
CREATE SEQUENCE ERS_REIMBURSEMENT_SEQ
START WITH 1
INCREMENT BY 1;

--TRIGGER
CREATE OR REPLACE TRIGGER ERS_REIMBURSEMENT_trigger
BEFORE INSERT ON ERS_REIMBURSEMENT
FOR EACH ROW
BEGIN
  SELECT ERS_REIMBURSEMENT_SEQ.NEXTVAL INTO :new.REIMB_ID FROM DUAL;
END;