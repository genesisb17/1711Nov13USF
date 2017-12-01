--2.1
select * from employee;
select * from employee where lastname = 'King';
select * from employee where firstname = 'Andrew' and reportsto is null;

--2.2
select * from albums order by title desc;
select firstname from customer order by city;

--2.3
insert into genre (genreid, name) values (26, 'Blue Grass');
insert into genre (genreid, name) values (27, 'Funk');
insert into employee (employeeid, firstname, lastname) values (9, 'John', 'Doe');
insert into employee (employeeid, firstname, lastname) values (10, 'Jane', 'Smith');
insert into customer (customerid, firstname, lastname, email) values (60, 'Bob', 'Vila', 'BobVila@gmail.com');
insert into customer (customerid, firstname, lastname, email) values (61, 'Mickey', 'Mouse', 'copyright@disney.com');

--2.4
update customer set firstname = 'Robert', lastname = 'Walter' where lastname = 'Mitchell';
update artist set name = 'CCR' where name like 'Creed%';

--2.5
select * from invoice where billingaddress like 'T%';

--2.6
select * from invoice where total between 15 and 50;
select * from employee where hiredate between '01-JUN-03' and '01-MAR-04';

--2.7
alter table invoice drop constraint fk_invoicecustomerid;
alter table invoice add constraint fk_invoicecustomerid
foreign key (customerid) references customer(customerid) on delete cascade;

alter table invoiceline drop constraint fk_invoicelineinvoiceid;
alter table invoiceline add constraint fk_invoicelineinvoiceid
foreign key (invoiceid) references invoice(invoiceid) on delete cascade;

delete from customer where lastname = 'Walter';

--3.1
create or replace function get_time return timestamp
is begin
return localtimestamp;
end;
/
select get_time from dual;

create or replace function name_length(a in varchar2) return int
is begin
return(length(a));
end;
/

select name_length(m.name) from mediatype m;

--3.2
create or replace function average
return number
is n number;
d number;
begin
select sum(total) into n from invoice;
select count(total) into d from invoice;
return n / d;
end;
/

select average from dual;

create or replace function name_length(m in mediatype%rowtype) return number
is
n number;
begin
select length(m.name) into n from dual;
return n;
end;
/

--3.3

create or replace function avg_invoice return number is
n number;
begin
select avg(unitprice * quantity) into n from invoiceline;
return n;
end;
/

select avg_invoice from dual;

--3.4
create or replace function get_employees return sys_refcursor as
c1 sys_refcursor;
begin
open c1 for select * from employee where birthdate > '31-DEC-1968';
return c1;
end;
/

--4.1
create or replace procedure employee_names is
c1 sys_refcursor;
begin
open c1 for select firstname, lastname from employee;
end;
/

--4.2
create or replace procedure update_employee (id in number, phone_number in number) is
begin
update employee set phone = phone_number where employeeid = id;
end;
/

--4.3
create or replace procedure get_info (id in number, name out varchar, co out varchar) is
begin
select firstname || ' ' || lastname into name from customer where customerid = id;
select company into co from customer where customerid = id;
end;
/

--5.0
alter table invoiceline drop constraint fk_invoicelineinvoiceid;

alter table invoiceline add constraint fk_invoicelineinvoiceid foreign key(invoiceid) references invoice(invoiceid) on delete cascade;

create or replace procedure delete_invoice (id in number) is
begin
delete from invoice where invoiceid = id;
commit;
end;
/

create or replace procedure add_customer is
begin
insert into customer (customerid, firstname, lastname, email) values (1000000, 'Bob', 'Vila', 'ThisOldHouse@gmail.com');
commit;
end;
/

--6.1

create or replace trigger after_employee
after insert on employee for each row
begin
SYS.DBMS_OUTPUT.PUT('hi');
end;
/

create or replace trigger after_album
after update on album for each row
begin
SYS.DBMS_OUTPUT.PUT('ho');
end;
/

create or replace trigger after_customer
after delete on customer for each row
begin
SYS.DBMS_OUTPUT.PUT('he');
end;
/

--7.1
select c.firstname || ' ' || c.lastname as name, i.invoiceid from customer c natural join invoice i;

--7.2
select c.customerid, c.firstname, c.lastname, i.invoiceid, i.total from customer c full outer join invoice i on c.customerid = i.customerid;

--7.3
select ar.name, ab.title from artist ar right join album ab on ab.artistid = ar.artistid;

--7.4
select ar.name, ab.title from artist ar cross join album ab order by ar.name asc;

--7.5
select * from employee e1 join employee e2 on e1.reportsto = e2.employeeid;

select * from artist natural join album;

--After this point teh workbook requests that we repeat all of this after making our own database.  its busy work.

--***************************************************************

select il.INVOICELINEID as invoice_line, i.invoiceid as invoice, 
t.name as track, al.TITLE as album, ar.name as artist, g.name as genre, 
m.NAME as format, c.firstname as customer, p.name as playlist, 
e.firstname as employee
from invoiceline il 
join invoice i on il.invoiceid = i.invoiceid 
join track t on il.TRACKID = t.trackid 
join album al on t.albumid = al.ALBUMID
join artist ar on ar.ARTISTID = al.artistid
join genre g on g.genreid = t.genreid
join mediatype m on m.mediatypeid = t.mediatypeid
join customer c on c.customerid = i.CUSTOMERID
join playlisttrack pt on pt.trackid = t.trackid
join playlist p on p.playlistid = pt.playlistid
join employee e on e.employeeid = c.supportrepid;


select playlistid, count(*) from playlisttrack group by playlistid;

create or replace procedure hello_world is
begin
dbms_output.put_line('Hello World!');
end;
/

execute hello_world;

create sequence art_seq
start with 500
increment by 1;
/

create or replace trigger art_trig
before insert on artist
for each row begin
select art_seq.nextval into :new.artistid from dual;
end;
/

select * from artist where name like 'Van%';

create table test(
test_id number not null,
constraint PK_TEST primary key (test_id)
);

insert into test values (105);

create or replace function get_max_id return number as
max_id number;
begin
select max(artistid) into max_id from artist;
return max_id;
end;
/

select get_max_id() from dual;

create or replace procedure get_name_by_id(art_id in number, art_name out varchar) is
begin
select name into art_name from artist where artistid = art_id;
end;
/

create or replace procedure get_all_artists(
  cursorparam out sys_refcursor)
  is
  begin
  open cursorparam for select * from artist;
  end;
  /
  
  create index artist_name
  on artist(name);











