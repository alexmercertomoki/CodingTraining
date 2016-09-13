<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>cookie信息显示页面</title>
</head>
<body>
<h3>cookie信息显示页面</h3>


<%
	Cookie[] cookies = request.getCookies();
	out.print(cookies.length+"\n");
	for (Cookie cookie : cookies) {
		if("username".equals(cookie.getName().toString())){
			out.print(cookie.getName()+"<<==>>"+cookie.getValue()+"<br />");
		}
	}
%>


</body>
</html>