<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="com.soft.domain.*" %>
<%@ page language="java" import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改用户</title>
</head>
<body>
	<%
		User user = (User)request.getAttribute("user");
	
	%>
	<form action="DoUpdateUser" method="post">
	<input type="hidden" name="id" value="<%=user.getId() %>" />
		<table>
			<tr>
				<td>用户名:</td>
				<td><input type="text" name="username" value="<%=user.getUsername() %>" /></td>
			</tr>
			<tr>
				<td>原密码:</td>
				<td><input type="password" name="password" value="<%=user.getPassword() %>" /></td>
			</tr>
			<tr>
				<td>新密码:</td>
				<td><input type="password" name="password2" value="" /></td>
			</tr>
			<tr>
				<td>确认新密码:</td>
				<td><input type="password" name="password3" value="" /></td>
			</tr>
			<tr>
				<td>所在省:</td>
				<td>
					<select name="provinceId">
						<%
							List<Province> list = (List<Province>)request.getAttribute("list");
							if(list!=null && list.size()>0){
								long provinceId = user.getProvinceId();
								for(Province p : list){
									if(p.getId()==provinceId){
										out.print("<option value='"+p.getId()+"' selected>"+p.getName()+"</option>");					
									}
									else{
										out.print("<option value='"+p.getId()+"'>"+p.getName()+"</option>");
									}
									
								}
							}
						%>
					</select>
				</td>
			</tr>
			<tr>
				<td>爱好:</td>
				<td>
				<%
					List<String> list_interest = (List<String>)request.getAttribute("list_interest");
					
					Map<String,String> map = (Map<String,String>)request.getAttribute("map");
					
					if(list_interest!=null && list_interest.size()>0){
						for(String str : list_interest){
							String[] arr = str.split("[,]");
							String key = arr[0];
							String value = arr[1];
							if(map.containsKey(key)){
								out.print("<input type='checkbox' name='interest' value='"+key+"' checked/>"+value+"");
							}
							else{
								out.print("<input type='checkbox' name='interest' value='"+key+"' />"+value+"");
							}
							
							
						}
					}
				%>
					
					
				</td>
			</tr>
			
			
			<tr>
				<td>
					<input type="submit" name="submit" value="修改" />
					<input type="reset" name="reset" value="重置" />
				</td>
			</tr>
		</table>
	</form>

</body>
</html>