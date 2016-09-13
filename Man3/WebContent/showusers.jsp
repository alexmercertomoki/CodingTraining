<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="com.soft.domain.*" %>
<%@ page language="java" import="java.util.*" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示所有用户</title>
<script src="js/jquery-1.8.3.js" type="text/javascript"></script>
<script type="text/javascript">
		$(document).ready(function(){
			// alert("123");
		});
		
	function deluser(id){
		var id = id;
		var text=$.ajax(
		{
			type:"post",
			url:"<%=basePath %>DelUserAjax?id="+id,
			// data:"roleName="+roleName,// ["roleName:admin,id:5"],
			success:function(text){
				//alert(text);
				// 删除对应节点
				if("ok"==text){
					$("#list-"+id).remove();
				}
			}
		});
	}
			
			
			
		</script>

</head>
<body>
<a href="RegUser">添加用户</a>
<br />
<br />
<br />
<table width="100%" border="1px" cellspacing="0px" cellpadding="4px">
	<tr>
		<th>编号</th>
		<th>头像</th>
		<th>用户名</th>
		<th>密码</th>
		<th>所在省</th>
		<th>操作</th>
	</tr>
	<%
		List<User> list = (List<User>)request.getAttribute("list");
		if(list!=null && list.size()>0){
			// "+user.getFilepath()+"
			for(User user : list){
				out.print("<tr id='list-"+user.getId()+"'>");
				out.print("<td>"+user.getId()+"</td>");
				out.print("<td><img src='"+user.getFilepath()+"' width='50px' height='40px'/></td>");
				out.print("<td>"+user.getUsername()+"</td>");
				out.print("<td>"+user.getPassword()+"</td>");
				// UpdateUser?id=6&age=25
						
				Map<Long,String> map = (Map<Long,String>)request.getAttribute("map");		
				if(map!=null && map.size()>0){
					long key = user.getProvinceId();
					if(map.containsKey(key)){
						out.print("<td>"+map.get(key)+"</td>");												
					}
					else{
						out.print("<td>&nbsp;</td>");
					}
				}
				
				out.print("<td>");
				out.print("<a href='UpdateUser?id="+user.getId()+"'>修改</a>&nbsp;");
				out.print("<a href='DelUser?id="+user.getId()+"'>删除</a>&nbsp;");
				out.print("<a href='#' onclick='deluser("+user.getId()+")'>Ajax方式删除</a>");
				out.print("</td>");
				
				out.print("</tr>");
			}
		}
	%>
	<tfoot>
		<tr>
			<td colspan="10" align="right">
			
			<%
				Integer currpage = (Integer)request.getAttribute("currpage");
				if(currpage>1){
					out.print("<a href='ShowUsers?currpage=1'>首页</a>&nbsp;");
					out.print("<a href='ShowUsers?currpage="+(currpage-1)+"'>上一页</a>&nbsp;");					
				}
				
				Integer sumpage = (Integer)request.getAttribute("sumpage");
				for(int i=0;i<sumpage;i++){
					out.print("<a href='ShowUsers?currpage="+(i+1)+"'>"+(i+1)+"</a>&nbsp;");
					
				}
				
				
			%>
			</td>
		</tr>
	</tfoot>
	
</table>

</body>
</html>