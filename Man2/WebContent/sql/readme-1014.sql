index.jsp
form 
����
<input type="text" name="username" value=""/>

action="MyFirst" 

web.xml

Servlet.java

	��ȡrequest���еĲ���/�����ֵ
	request.getParameter("���������");
	
	request.setAttribute("���Ե�����", username);

index2.jsp
	
	String username = (String)request.getAttribute("���Ե�����");

	out.print(username);


MVC

		
View	��ͼ�� jsp

Ctrl	���Ʋ� servlet

Model	ģ�Ͳ� 
		
		service	ҵ���
		dao		���ݳ־û���


domain	ʵ����



