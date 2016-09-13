create table usertest(
	id int identity(1,1) primary key not null,
	name varchar(100),
	password varchar(100)
)

select * from usertest;

insert into usertest (name,password) values('张三','123456');

insert into usertest (name,password) values('张三10','123456');



create table myuser(
	id int identity(1,1) primary key not null,
	name varchar(50),
	password varchar(50)
)

insert into myuser values('1','张三1','123456');

insert into myuser values('2','张三2','123456');
insert into myuser values('3','王三2','123456');
insert into myuser values('4','赵三2','123456');
insert into myuser values('5','钱三2','123456');

insert into myuser values('张三1','123456');
insert into myuser values('张三2','123456');
insert into myuser values('王三2','123456');
insert into myuser values('赵三2','123456');
insert into myuser values('钱三2','123456');

select * from myuser;

update myuser set name='李四' 

update myuser set name='李四' ,password='111'


delete from myuser where id='1'

select * from myuser where name like '张%'

select * from myuser where name like '%2%'

select * from myuser where name like '_三%'

select * from myuser where name like '__三%'

select sum(id) from myuser 

select count(*) as countNumber from myuser 

select u.id  as 主键 from myuser u

group by 分组 having 

order by 排序

select * from myuser 

select count(*) as count ,password from myuser group by password 

select * from myuser order by password 

select * from myuser order by password desc



