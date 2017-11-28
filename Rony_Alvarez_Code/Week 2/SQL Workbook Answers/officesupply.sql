CREATE TABLE EMPLOYEES(
  EmployeeID NUMBER PRIMARY KEY not null, 
  UserName varchar(20) not null, 
  Password varchar(20) not null, 
  Name varchar(25) not null, 
  Department char(2) not null, 
  Manager number not null
);


CREATE TABLE ORDERS(
  OrderID number PRIMARY KEY not null, 
  EmployeeID number not null, 
  OrderDate date not null, 
  Status char not null,
  CONSTRAINT FK_EMPLOYEEID FOREIGN KEY(EMPLOYEEID) REFERENCES EMPLOYEES(EMPLOYEEID)
);
/

CREATE TABLE ORDERITEM(
  OrderID NUMBER not null, 
  ProductID NUMBER not null, 
  Quantity number not null,
  CONSTRAINT PK_ORDERITEM PRIMARY KEY (ORDERID, PRODUCTID),
  CONSTRAINT FK_ORDERID FOREIGN KEY(ORDERID) REFERENCES ORDERS(ORDERID)
);
/

CREATE TABLE CATEGORY(
  CatID number PRIMARY KEY not null, 
  Name varchar(80) null, 
  Descript varchar(255) null
);
/

CREATE TABLE PRODUCT(
ProductID number PRIMARY KEY not null, 
CatID number not null, 
Name varchar(80) null, 
Descript varchar(255) null,
UnitCost number null, 
SuppID number not null
);
/

CREATE TABLE SUPPLIER(
SuppID number PRIMARY KEY not null, 
Name varchar(80) null
);
/
ALTER TABLE PRODUCT ADD CONSTRAINT FK_CATID FOREIGN KEY(CATID) REFERENCES CATEGORY(CATID);





