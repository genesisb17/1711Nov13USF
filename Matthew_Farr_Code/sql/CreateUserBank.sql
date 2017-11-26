CREATE USER Banking
IDENTIFIED BY p4ssw0rd
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to Banking;
GRANT resource to Banking;
GRANT create session TO Banking;
GRANT create table TO Banking;
GRANT create view TO Banking;