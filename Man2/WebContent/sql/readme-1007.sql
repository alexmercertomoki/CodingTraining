1.SQL
结构化的查询语言


1)MS SQLServer 微软的 .NET
2)Oracle 	Java
3)MySQL		PHP	==>> LAMP


SQL 语法
-- SQLServer 2005
1.创建表
create table myuser(
	id int primary key not null,
	name varchar(50),
	password varchar(50)
)

-- 主键设定为自动增长
create table usertest(
	id int identity(1,1) primary key not null,
	name varchar(100),
	password varchar(100)
)



2.删除表
drop table myuser;

3.修改表
-- 添加列
-- 修改列的数据类型
-- 修改列的名字
-- 删除列


4.操作数据
-- 插入数据
1)insert into myuser values('1','张三','111111');

2)insert into myuser (id,name,password) values('1','张三','111111');

3)insert into myuser (name,password) values('张三','111111');

-- 修改数据
update myuser set name='李四' ,password='111'


-- 删除数据
delete from myuser where id='1'

-- 查询数据
select * from myuser 

select name,password from myuser

like %任意字符 _单个的任意字符 
=
>=
<=
!=
top

聚合函数
sum 求和
max 求最大值
min 求最小值
count 求记录条数
avg 求平均值

group by 分组

order by 排序


