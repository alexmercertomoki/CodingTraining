<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="com.jp12.domain.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改用户的页面</title>
</head>
<body>

<%
	String msg  =  (String)request.getAttribute("msg");
	if(msg!=null){
		out.print(msg+"<br />");
	}
	
	JPUser user = (JPUser)request.getAttribute("user");
	
%>

<form action="DoUpdateUser" method="post">
<table border="1px">
	<input type="hidden" name="id" value="<%=user.getId() %>"/>
	<tr>
		<td>用户名:</td>
		<td><input type="text" name="username" value="<%=user.getName() %>" readonly="readonly"/></td>
	</tr>
	<tr>
		<td>密码:</td>
		<td><input type="text" name="password" value="<%=user.getPassword() %>" /></td>
	</tr>
	<tr>
		<td>新密码:</td>
		<td><input type="password" name="password2" value="" /></td>
	</tr>
	<tr>
		<td>新密码确认:</td>
		<td><input type="password" name="password3" value="" /></td>
	</tr>
	<tr>
		<td colspan="4"><input type="submit" name="submit" value="修改" /></td>
	</tr>
</table>
</form>

</body>
</html>