/*create table person
(
	id int not null,
	name varchar(255) not null, 
	location varchar(255),
	birth_date timestamp,
	primary key(id)
);*/

insert into person(id,name,location,birth_date)values(1001,'Tara','London',sysdate());
insert into person(id,name,location,birth_date)values(1002,'James','New York',sysdate());
insert into person(id,name,location,birth_date)values(1003,'Pieter','Amsterdam',sysdate());