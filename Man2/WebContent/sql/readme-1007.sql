1.SQL
�ṹ���Ĳ�ѯ����


1)MS SQLServer ΢��� .NET
2)Oracle 	Java
3)MySQL		PHP	==>> LAMP


SQL �﷨
-- SQLServer 2005
1.������
create table myuser(
	id int primary key not null,
	name varchar(50),
	password varchar(50)
)

-- �����趨Ϊ�Զ�����
create table usertest(
	id int identity(1,1) primary key not null,
	name varchar(100),
	password varchar(100)
)



2.ɾ����
drop table myuser;

3.�޸ı�
-- �����
-- �޸��е���������
-- �޸��е�����
-- ɾ����


4.��������
-- ��������
1)insert into myuser values('1','����','111111');

2)insert into myuser (id,name,password) values('1','����','111111');

3)insert into myuser (name,password) values('����','111111');

-- �޸�����
update myuser set name='����' ,password='111'


-- ɾ������
delete from myuser where id='1'

-- ��ѯ����
select * from myuser 

select name,password from myuser

like %�����ַ� _�����������ַ� 
=
>=
<=
!=
top

�ۺϺ���
sum ���
max �����ֵ
min ����Сֵ
count ���¼����
avg ��ƽ��ֵ

group by ����

order by ����


