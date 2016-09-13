<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>跳转后的页面</title>
</head>
<body>

<%
	String username = 
		(String)request.getAttribute("username");// Object

	out.print("在index.jsp页面接收到的值是:"+username);
		
	String name = 
		(String)request.getAttribute("name");// Object

	out.print("在homework.html页面接收到的值name:"+name+"<br />");
		
	String birthday = 
		(String)request.getAttribute("birthday");// Object

	out.print("在homework.html页面接收到的值birthday:"+birthday+"<br />");
		
	String sex = 
		(String)request.getAttribute("sex");// Object

	out.print("在homework.html页面接收到的值sex:"+sex+"<br />");
		
	String degree = 
		(String)request.getAttribute("degree");// Object

	out.print("在homework.html页面接收到的值degree:"+degree+"<br />");
		
	String tel = 
		(String)request.getAttribute("tel");// Object

	out.print("在homework.html页面接收到的值tel:"+tel+"<br />");
		
	String email = 
		(String)request.getAttribute("email");// Object

	out.print("在homework.html页面接收到的值email:"+email+"<br />");
		
	String intro = 
		(String)request.getAttribute("intro");// Object

	out.print("在homework.html页面接收到的值intro:"+intro+"<br />");
		
	String department = 
		(String)request.getAttribute("department");// Object

	out.print("在homework.html页面接收到的值department:"+department+"<br />");
	
	
	
%>

</body>
</html>