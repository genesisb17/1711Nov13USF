insert into accounts (acc_type, user_id, balance) 
values ('checking', 4, 0);
select * from users where username = 'jpc';

update users set firstname = 'cam' where user_id = 3;
commit;
update users set firstname = 'Can', lastname = 'Jack', username = 'jpc', pass = 'jpc' where user_id = 3;

insert into users (firstname, lastname, username, pass)
values ('Tommy', 'Hilfiger', 'tommyhil', 'hilfiger');

select * from accounts where user_id = 1;

update users set pass = 'bjobs' where username = 'bob';

commit;

