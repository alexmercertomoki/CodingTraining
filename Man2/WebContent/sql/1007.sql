create table usertest(
	id int identity(1,1) primary key not null,
	name varchar(100),
	password varchar(100)
)

select * from usertest;

insert into usertest (name,password) values('����','123456');

insert into usertest (name,password) values('����10','123456');



create table myuser(
	id int identity(1,1) primary key not null,
	name varchar(50),
	password varchar(50)
)

insert into myuser values('1','����1','123456');

insert into myuser values('2','����2','123456');
insert into myuser values('3','����2','123456');
insert into myuser values('4','����2','123456');
insert into myuser values('5','Ǯ��2','123456');

insert into myuser values('����1','123456');
insert into myuser values('����2','123456');
insert into myuser values('����2','123456');
insert into myuser values('����2','123456');
insert into myuser values('Ǯ��2','123456');

select * from myuser;

update myuser set name='����' 

update myuser set name='����' ,password='111'


delete from myuser where id='1'

select * from myuser where name like '��%'

select * from myuser where name like '%2%'

select * from myuser where name like '_��%'

select * from myuser where name like '__��%'

select sum(id) from myuser 

select count(*) as countNumber from myuser 

select u.id  as ���� from myuser u

group by ���� having 

order by ����

select * from myuser 

select count(*) as count ,password from myuser group by password 

select * from myuser order by password 

select * from myuser order by password desc



