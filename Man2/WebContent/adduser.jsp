<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="com.jp12.domain.*" %>
<%@ page language="java" import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户的页面</title>
</head>
<body>

<%
	String msg  =  (String)request.getAttribute("msg");
	if(msg!=null){
		out.print(msg+"<br />");
	}
%>

<form action="AddUser" method="post">
<table border="1px">
	<tr>
		<td>用户名:</td>
		<td><input type="text" name="username" value="" /></td>
	</tr>
	<tr>
		<td>密码:</td>
		<td><input type="password" name="password" value="" /></td>
	</tr>
	<tr>
		<td>密码确认:</td>
		<td><input type="password" name="password2" value="" /></td>
	</tr>
	<tr>
		<td>所属公司</td>
		<td>
			<select name="companyId">
				<%
					List<Company> list = (List<Company>)request.getAttribute("list");
					if(list!=null && list.size()>0){
						for(Company company :list){
							out.print("<option value='"+company.getId()+"'>"+company.getName()+"</option>");
						}
					}
				%>
				
				
			</select>
		</td>
	</tr>
	<tr>
		<td colspan="4"><input type="submit" name="submit" value="注册" /></td>
	</tr>
</table>
</form>

</body>
</html>