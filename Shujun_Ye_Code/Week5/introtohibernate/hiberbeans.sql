
/*******************************************************************************
   ERS Database
   Script: HIBBEANS_Oracle.sql
   Description: Creates and populate the ERS database.
   DB Server: Oracle
   Author: Shujun Ye
********************************************************************************/

/*******************************************************************************
   Drop database if it exists
********************************************************************************/
DROP USER hiberbeans CASCADE;

/*******************************************************************************
   Create database
********************************************************************************/
CREATE USER hiberbeans
IDENTIFIED BY p4ssw0rd
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to hiberbeans;
GRANT resource to hiberbeans;
GRANT create session TO hiberbeans;
GRANT create table TO hiberbeans;
GRANT create view TO hiberbeans;

conn hiberbeans/p4ssw0rd