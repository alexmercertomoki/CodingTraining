create table myuser(
	id int identity(1,1) primary key not null,
	name varchar(50),
	password varchar(50),
	companyId int
);


insert into myuser (name,password) values('����1','123456');
insert into myuser (name,password) values('����2','123456');
insert into myuser (name,password) values('����2','123456');
insert into myuser (name,password) values('����2','123456');
insert into myuser (name,password) values('Ǯ��2','123456');


select * from myuser ;

create table mycompany(
	id int identity(1,1) primary key not null,
	name varchar(50)
);

	insert into mycompany (name) values('����Ͱ�');
	insert into mycompany (name) values('�Ѻ�');
	insert into mycompany (name) values('����');
	insert into mycompany (name) values('����');

