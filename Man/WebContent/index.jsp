<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP首页</title>
</head>
<body>
JSP首页
&nbsp;&nbsp;
<a href="ShowPage?page=form">表单</a> <!--  page = form -->
<br />
<a href="ShowUsers">显示所有用户信息</a>
<br />
<%
	int age = 5;
	System.out.print(age);
	out.print(age);
	for(int i=0;i<10;i++){
		out.print(i+"\t");
	}
%>

<%	
	out.print("<br />");
	out.print("<table>");
	for(int i=0;i<5;i++){
		out.print("<tr>");
			out.print("<td>"+i+"</td>");
			out.print("<td>"+(i+5)+"</td>");
		out.print("</tr>");
	}
	out.print("</table>");
	
	age = 200;
	
	out.print("<br />");
	out.print("<table width='100%' border='2px' height='"+age+"px'>");
	for(int i=0;i<5;i++){
		out.print("<tr>");
			out.print("<td>"+i+"</td>");
			out.print("<td>"+(i+5)+"</td>");
		out.print("</tr>");
	}
	out.print("</table>");
	
%>





</body>
</html>