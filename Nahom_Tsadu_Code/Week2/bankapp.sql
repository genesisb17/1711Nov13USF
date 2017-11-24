create table users(
  user_id number primary key,
  firstname varchar2(30) not null, 
  lastname varchar2(30) not null,
  username varchar2(30) unique not null,
  password varchar2(20) not null
);

create table account(
account_id number primary key,
user_id number not null,
balance decimal(12, 2),
constraint fk_user_id foreign key(user_id) references users(user_id)
);

create sequence u_seq
start with 1
increment by 1;

create or replace trigger u_trigger
before insert on users
for each row 
begin
select u_seq.nextval into :new.user_id from dual;
end;


insert into users(firstname, lastname, username, password)
values('genesis', 'bonds', 'genbo', '123');
insert into users(firstname, lastname, username, password)
values('nahom', 'tsadu', 'ntsadu', '456');



