��form�еı����ֵ ���ݵ�����һ��ҳ������ʾ����


1.��ҳ���ж���һ��form����д���ֱ���
	����homework.html
2.�½�һ��FormServlet(class) ����MyFirstServlet
	��Ҫ��web.xml�ļ��н�������
3.��FormServlet��ʹ��
	request.getParameter("username")
	request.getParameterValues("subject")
	��ȡ�����ֵ
	
	ʹ��
	request.setAttribute("username", username);
	�������ֵ���浽request����
	
	ע��ҳ����ת
	
4.�½�һ��ҳ�� result.jsp 
	��ҳ����ʹ��
	String username = 
		(String)request.getAttribute("username")
	��ȡrequest�������Ե�ֵ
	
5.��ҳ�� result.jsp�� 
	ʹ��out.print();��ӡ�����ȡ��ֵ
	

	