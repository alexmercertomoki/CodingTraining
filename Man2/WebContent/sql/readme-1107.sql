create table myuser(
	id int identity(1,1) primary key not null,
	name varchar(50),
	password varchar(50),
	companyId int
);


insert into myuser (name,password) values('张三1','123456');
insert into myuser (name,password) values('张三2','123456');
insert into myuser (name,password) values('王三2','123456');
insert into myuser (name,password) values('赵三2','123456');
insert into myuser (name,password) values('钱三2','123456');


select * from myuser ;

create table mycompany(
	id int identity(1,1) primary key not null,
	name varchar(50)
);

	insert into mycompany (name) values('阿里巴巴');
	insert into mycompany (name) values('搜狐');
	insert into mycompany (name) values('网易');
	insert into mycompany (name) values('新浪');

