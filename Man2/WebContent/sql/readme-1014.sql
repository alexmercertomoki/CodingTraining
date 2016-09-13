index.jsp
form 
表单域
<input type="text" name="username" value=""/>

action="MyFirst" 

web.xml

Servlet.java

	获取request当中的参数/表单域的值
	request.getParameter("表单域的名字");
	
	request.setAttribute("属性的名字", username);

index2.jsp
	
	String username = (String)request.getAttribute("属性的名字");

	out.print(username);


MVC

		
View	视图层 jsp

Ctrl	控制层 servlet

Model	模型层 
		
		service	业务层
		dao		数据持久化层


domain	实体类



