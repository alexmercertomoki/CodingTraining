将form中的表单域的值 传递到另外一个页面中显示出来


1.在页面中定义一个form，编写各种表单域
	参照homework.html
2.新建一个FormServlet(class) 参照MyFirstServlet
	需要在web.xml文件中进行配置
3.在FormServlet中使用
	request.getParameter("username")
	request.getParameterValues("subject")
	获取表单域的值
	
	使用
	request.setAttribute("username", username);
	将表单域的值保存到request当中
	
	注意页面跳转
	
4.新建一个页面 result.jsp 
	在页面中使用
	String username = 
		(String)request.getAttribute("username")
	获取request当中属性的值
	
5.在页面 result.jsp中 
	使用out.print();打印输出获取的值
	

	