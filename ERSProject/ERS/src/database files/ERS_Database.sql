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
		DROP USER Sensus_DBAdmin CASCADE;



/****************************************************************
    Create Database
*****************************************************************/

CREATE USER sensus_dbadmin
IDENTIFIED BY sensus2016
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to ExpReimSys;
GRANT resource to ExpReimSys;
GRANT create session TO ExpReimSys;
GRANT create table TO ExpReimSys;
GRANT create view TO ExpReimSys;

conn sensus_dbadmin/sensus2016

/***************************************************************
    Create Tables
****************************************************************/

CREATE TABLE ERS_REIMBURSEMENT(
    Reimb_ID NUMBER NOT NULL,
    Reimb_Amount NUMBER,
    Reimb_Submitted TIMESTAMP ,
    Reimb_Resolved TIMESTAMP,
    Reimb_Description VARCHAR2(50),
    Reimb_Receipt BLOB,
    Reimb_Author NUMBER NOT NULL,
    Reimb_Resolver NUMBER NOT NULL,
    Reimb_Status_ID NUMBER NOT NULL,
    Reimb_Type_ID NUMBER NOT NULL
    
    CONSTRAINT PK_ERS_REIMBURSEMENT PRIMARY KEY  (Reimb_ID)
);

CREATE TABLE ERS_REIMBURSEMENT_STATUS(
  Reimb_Status_ID NUMBER NOT NULL,
  Reimb_Status VARCHAR2(10)
  
  CONSTRAINT PK_ERS_REIMBURSEMENT_STATUS PRIMARY KEY (Reimb_Status_ID)
);

CREATE TABLE ERS_REIMBURSEMENT_TYPE(
  Reimb_Type_ID NUMBER NOT NULL,
  Reimb_Type VARCHAR2(10)

  CONSTRAINT PK_ERS_REIMBURSEMENT_TYPE PRIMARY KEY (Reimb_Type_ID)
);

CREATE TABLE ERS_USERS(
  Ers_Users_ID NUMBER NOT NULL,
  Ers_UserName VARCHAR2(50) UNIQUE NOT NULL,
  Ers_PassWord VARCHAR2(50) NOT NULL,
  User_First_Name VARCHAR2(100),
  User_Last_Name VARCHAR2(100),
  User_Email VARCHAR2(150) UNIQUE NOT NULL,
  User_Role_ID NUMBER NOT NULL

  CONSTRAINT PK_ERS_USERS PRIMARY KEY (Ers_Users_ID)
);

CREATE TABLE ERS_USER_ROLES(
  Ers_User_Role_ID NUMBER NOT NULL,
  User_Role VARCHAR2(10)
);

/************************************************************
    Create Foreign Keys
*************************************************************/
ALTER TABLE ERS_REIMBURSEMENT ADD CONSTRAINT ERS_USERS_FK_AUTH
    FOREIGN KEY (Reimb_Author) REFERENCES ERS_USERS (User_Role_ID)  ;

ALTER TABLE ERS_REIMBURSEMENT ADD CONSTRAINT ERS_USERS_FK_RESLVR
    FOREIGN KEY (Reimb_Resolver) REFERENCES ERS_USERS (User_Role_ID)  ;

ALTER TABLE ERS_REIMBURSEMENT ADD CONSTRAINT ERS_REIMBURSEMENT_STATUS_FK
    FOREIGN KEY (Reimb_Status_ID) REFERENCES ERS_REIMBURSEMENT_STATUS (Reimb_Status_ID)  ;

ALTER TABLE ERS_REIMBURSEMENT ADD CONSTRAINT ERS_REIMBURSEMENT_TYPE_FK
    FOREIGN KEY (Reimb_Type_ID) REFERENCES ERS_REIMBURSEMENT_TYPE (Reimb_Type_ID)  ;

ALTER TABLE InvoiceLine ADD CONSTRAINT FK_InvoiceLineInvoiceId
    FOREIGN KEY (InvoiceId) REFERENCES Invoice (InvoiceId)  ;

ALTER TABLE InvoiceLine ADD CONSTRAINT FK_InvoiceLineTrackId
    FOREIGN KEY (TrackId) REFERENCES Track (TrackId)  ;

ALTER TABLE PlaylistTrack ADD CONSTRAINT FK_PlaylistTrackPlaylistId
    FOREIGN KEY (PlaylistId) REFERENCES Playlist (PlaylistId)  ;

ALTER TABLE PlaylistTrack ADD CONSTRAINT FK_PlaylistTrackTrackId
    FOREIGN KEY (TrackId) REFERENCES Track (TrackId)  ;

ALTER TABLE Track ADD CONSTRAINT FK_TrackAlbumId
    FOREIGN KEY (AlbumId) REFERENCES Album (AlbumId)  ;

ALTER TABLE Track ADD CONSTRAINT FK_TrackGenreId
    FOREIGN KEY (GenreId) REFERENCES Genre (GenreId)  ;

ALTER TABLE Track ADD CONSTRAINT FK_TrackMediaTypeId
    FOREIGN KEY (MediaTypeId) REFERENCES MediaType (MediaTypeId)  ;


