1.�ļ����ϴ�

	1)�ڱ�����Ҫ��һ�� file���͵� input��ǩ
	2)form���� ���� enctype="multipart/form-data"
	3)������jar������
	4)�½�Servlet ����ʾ�������д
	5)�ϴ�·���޸�Ϊ�̶�·�� \Ҫʹ��\\����ת��



Session �Ự





-- ����cookie
Cookie cookie = new Cookie("st_code", "2b2b873bfac6f767");
cookie.setMaxAge(10000);
response.addCookie(cookie);
-- ȡ��cookie
Cookie[] cookies = request.getCookies();
for (Cookie cookie : cookies) {
System.out.println(cookie.getName()+"\n"+cookie.getValue());
}


if("username".equals(cookie.getName().toString())){
			out.print("cookie:"+cookie.getName());
			out.print("��ֵ��:");
			out.print(cookie.getValue());
			out.print("\n");
			//return;
		}