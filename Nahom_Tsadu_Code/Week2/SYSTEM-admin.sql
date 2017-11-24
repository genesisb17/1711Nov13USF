DROP USER awsuser CASCADE;

CREATE USER awsuser
IDENTIFIED BY awspw
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to awsuser;
GRANT resource to awsuser;
GRANT create session TO awsuser;
GRANT create table TO awsuser;
GRANT create view TO awsuser;

conn awsuser/awspw

CREATE TABLE ReimbursementStatus
(
    reimbursementStatusID NUMBER NOT NULL,
    reimbursementStatusName VARCHAR2(10),
    constraint pk_reimbursementStatus PRIMARY KEY(reimbursementStatusID)
);

CREATE SEQUENCE ReimbursementStatus_Sequence START
WITH 1000000000 INCREMENT BY 1;

INSERT INTO ReimbursementStatus 
VALUES (ReimbursementStatus_Sequence.nextval, 'Pending');

INSERT INTO ReimbursementStatus 
VALUES (ReimbursementStatus_Sequence.nextval, 'Processed');

commit;
exit;