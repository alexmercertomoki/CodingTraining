<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>表单</title>
</head>
<body>

<%
    // 	page request session application 会话
	String msg = (String)request.getAttribute("msg");
	if(msg!=null){
		out.print(msg+"<br />");
	}
%>

<form action="First" method="post">
	
	用户名:<input type="text" name="username" value="" />
	<br />
	密码:<input type="password" name="password" value="" />
	<input type="submit" name="submit" value="提交" />
	<a target=""></a>
</form>

</body>
</html>