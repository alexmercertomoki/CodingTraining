<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="com.soft.domain.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>结果页面</title>
</head>
<body>
<%
	User user = (User)request.getAttribute("user");
	if(user!=null ){
		out.print("<br />");
		out.print("用户名:"+user.getUsername());
		out.print("<br />");
		out.print("密码:"+user.getPassword());
		out.print("<br />");
	}
%>



</body>
</html>