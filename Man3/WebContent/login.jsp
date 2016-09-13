<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP登录页</title>
</head>
<body>
<form action="#" method="post">
	<table>
		<tr>
			<td>用户名:</td>
			<td><input type="text" name="username" value="" /></td>
		</tr>
		<tr>
			<td>密  码:</td>
			<td><input type="password" name="password" value="" /></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" name="submit" value="登录" />
				<input type="reset" name="reset" value="清空" />
			</td>
		</tr>
	</table>
</form>

</body>
</html>