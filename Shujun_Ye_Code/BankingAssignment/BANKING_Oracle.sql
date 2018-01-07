
/*******************************************************************************
   BANKING Database
   Script: BANKING_Oracle.sql
   Description: Creates the BANKING database.
   DB Server: Oracle
   Author: Shujun Ye
********************************************************************************/

/*******************************************************************************
   Drop database if it exists
********************************************************************************/
DROP USER banking CASCADE;
/*******************************************************************************
   Create database
********************************************************************************/
CREATE USER banking
IDENTIFIED BY p4ssw0rd
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to banking;
GRANT resource to banking;
GRANT create session TO banking;
GRANT create table TO banking;
GRANT create view TO banking;

conn banking/p4ssw0rd
