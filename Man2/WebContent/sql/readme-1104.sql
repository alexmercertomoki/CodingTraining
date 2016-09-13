1.公司表

添加，修改，删除，查询操作

id		主键 		自动增长
name	公司名称		varchar(100)
-- addtime	数据创建的时间 varchar(100)

domain
Company类
成员变量
private long id 
private String name

dao
CompanyDao类
add方法
update方法
delete方法
findAllCompany方法

service
CompanyService类
private CompanyDao dao
add方法
update方法
delete方法
findAllCompany方法


页面 add update show 

servlet


2.公司信息与用户 关联起来

注册用户，添加用户

选择，这个用户是属于哪个公司的。

公司ID存储在用户表中










