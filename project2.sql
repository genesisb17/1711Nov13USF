CREATE USER project2 IDENTIFIED BY password1;
grant create table to project2;
create table user1
(
  U_ID number,
  primary key(U_ID),  
  username varchar2(50),
  password varchar2(50)
);
create table projects
(
  P_ID number,
  primary key(P_ID),
  Description VARCHAR2(50)

);
create table resumes
(
  r_ID number,
  primary key(r_ID),  
  constraint fk_1 FOREIGN KEY(U_ID) REFERENCES user1(U_ID),
  constraint fk_2 FOREIGN KEY(P_ID) REFERENCES projects(P_ID)
);