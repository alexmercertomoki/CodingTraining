<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的第一个JSP页面</title>
</head>
<body>
<h3>我的第一个JSP页面</h3>

<form action="MyFirst" method="post">
	<table>
		<tr>
			<td>姓名:</td>
			<td><input type="text" name="username" value=""/></td>
		</tr>
		<tr>
			<td>考核科目:</td>
			<td>
				<input type="checkbox" name="subject" value="1"/>语文
				<input type="checkbox" name="subject" value="2"/>数学
				<input type="checkbox" name="subject" value="3"/>外语
				<input type="checkbox" name="subject" value="4"/>物理
				<input type="checkbox" name="subject" value="5"/>化学
				<input type="checkbox" name="subject" value="6"/>生物
			</td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" name="submit" value="提交"/></td>
		</tr>
	</table>
</form>


<form action="SaveCookie" method="post">
	<table>
		<tr>
			<td>姓名:</td>
			<td><input type="text" name="username" value=""/></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" name="submit" value="提交"/></td>
		</tr>
	</table>
</form>
<%
	

%>


<form action="UserSearch" method="post">
	<input type="submit" name="submit" value="显示所有用户" />
</form>



</body>
</html>