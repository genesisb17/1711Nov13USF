-- create users table with defined attributes
CREATE TABLE USERS(
  U_ID          NUMBER,
  FIRST_NAME    VARCHAR(20)   NOT NULL,
  LAST_NAME     VARCHAR(30)   NOT NULL,
  EMAIL_ADDRESS VARCHAR(254)  NOT NULL UNIQUE,
  USERNAME      VARCHAR(20)   NOT NULL UNIQUE,
  PASSWORD      VARCHAR(20)   NOT NULL,
  CONSTRAINT pk_users PRIMARY KEY (U_ID)
);

-- create accounts table with defined attributes
CREATE TABLE ACCOUNTS(
  ACCT_ID   NUMBER,
  ACCT_TYPE VARCHAR(20) NOT NULL,
  BALANCE   DECIMAL(12,2) NOT NULL,
  CONSTRAINT pk_accounts PRIMARY KEY (ACCT_ID)
);

-- resolve the (M:M) relationship for users and accounts to individual (1:M)
-- relationships; allows for joint accounts
CREATE TABLE ACCOUNT_REGISTRAR(
  U_ID      NUMBER,
  ACCT_ID   NUMBER,
  PRIVILEGE VARCHAR(20),
  CONSTRAINT fk_userid FOREIGN KEY (U_ID) REFERENCES USERS,
  CONSTRAINT fk_acctid FOREIGN KEY (ACCT_ID) REFERENCES ACCOUNTS,
  CONSTRAINT pk_accountregistrar PRIMARY KEY (U_ID, ACCT_ID)
);

-- create sequence: autoincrement u_id in users table
CREATE SEQUENCE UID_SEQ
START WITH 1
INCREMENT BY 1;
/

-- create trigger: call uid_seq when new user is inserted into users table
CREATE OR REPLACE TRIGGER USER_TRIGGER
BEFORE INSERT ON USERS
FOR EACH ROW

BEGIN
  SELECT UID_SEQ.NEXTVAL 
  INTO :new.U_ID 
  FROM DUAL;
END;
/
COMMIT;

-- create sequence: autoincrement acct_id in accounts table
CREATE SEQUENCE ACCTID_SEQ
START WITH 10000
INCREMENT BY 1;
/

-- create trigger: call acctid_seq when new account is inserted into accounts
-- table
CREATE OR REPLACE TRIGGER ACCT_TRIGGER
BEFORE INSERT ON ACCOUNTS
FOR EACH ROW

BEGIN
  SELECT ACCTID_SEQ.NEXTVAL
  INTO :new.ACCT_ID
  FROM DUAL;
END;
/
COMMIT;