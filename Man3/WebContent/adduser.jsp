<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="com.soft.domain.*" %>
<%@ page language="java" import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户</title>
</head>
<body>
	<form action="AddUser" method="post" enctype="multipart/form-data">
		<table>
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
				<td>性别:</td>
				<td>
					<input type="radio" name="sex" value="1" checked/>男
					<input type="radio" name="sex" value="2" />女
				</td>
			</tr>
			<tr>
				<td>爱好:</td>
				<td>
					<input type="checkbox" name="interest" value="1" />KTV
					<input type="checkbox" name="interest" value="2" />爬山
					<input type="checkbox" name="interest" value="3" />上网
					<input type="checkbox" name="interest" value="4" />电影
					<input type="checkbox" name="interest" value="5" />游戏
				</td>
			</tr>
			<tr>
				<td>所在省:</td>
				<td>
					<select name="provinceId">
						<option>-- 请选择 --</option>
						<%
							List<Province> list = (List<Province>)request.getAttribute("list");
							if(list!=null && list.size()>0){
								for(Province p : list){
									out.print("<option value='"+p.getId()+"'>"+p.getName()+"</option>");
								}
							}
						%>
					</select>
				</td>
			</tr>
			<tr>
				<td>头像:</td>
				<td>
					<input type="file" name="file1" value="请浏览..." />
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" name="submit" value="注册" />
					<input type="reset" name="reset" value="重置" />
				</td>
			</tr>
		</table>
	</form>

</body>
</html>