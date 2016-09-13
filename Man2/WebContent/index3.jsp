<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*" %>
<%@ page language="java" import="com.jp12.domain.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>跳转后的页面</title>
</head>
<body>

<a href="ShowPage?page=adduser">添加用户</a>
<br />
<table border="1px">
	<tr>
		<th>编号</th>
		<th>用户名</th>
		<th>密码</th>
		<th>所属公司</th>
		<th>操作</th>
	</tr>

<%
	List<JPUser> list = (List<JPUser>)request.getAttribute("list");
	Map<Long,String> map = (Map<Long,String>)request.getAttribute("map");
	if(list!=null){
		for(JPUser u : list){
			out.print("<tr>");
			out.print("<td>"+u.getId()+"</td>");
			out.print("<td>"+u.getName()+"</td>");
			out.print("<td>"+u.getPassword()+"</td>");
			out.print("<td>"+map.get(u.getCompanyId())+"</td>");
			out.print("<td><a href='ShowUser?id="+u.getId()+"'>修改</a> &nbsp; <a href='DeleteUser?id="+u.getId()+"'>删除</a></td>");
			out.print("</tr>");
		}
	}
	
%>
</table>
</body>
</html>