<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="com.soft.domain.*" %>
<%@ page language="java" import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示所有用户</title>
</head>
<body>

<table width="400px" border="1px" cellspacing="0px" cellpadding="4px">
	<tr>
		<th>编号</th>
		<th>用户名</th>
		<th>密码</th>
		<th>操作</th>
	</tr>
	<%
		List<User> list = (List<User>)request.getAttribute("list1");
		if(list!=null && list.size()>0){
			for(User user : list){
				out.print("<tr>");
				out.print("<td>"+user.getId()+"</td>");
				out.print("<td>"+user.getUsername()+"</td>");
				out.print("<td>"+user.getPassword()+"</td>");
				out.print("<td><a href='DelUser?iee="+user.getId()+"&aaa=123'>删除</a></td>");
				out.print("</tr>");
			}
		}
	%>
	
	
</table>

</body>
</html>