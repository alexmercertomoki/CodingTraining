1.文件的上传

	1)在表单中需要有一个 file类型的 input标签
	2)form当中 增加 enctype="multipart/form-data"
	3)第三方jar的引入
	4)新建Servlet 仿照示例代码编写
	5)上传路径修改为固定路径 \要使用\\进行转义



Session 会话





-- 保存cookie
Cookie cookie = new Cookie("st_code", "2b2b873bfac6f767");
cookie.setMaxAge(10000);
response.addCookie(cookie);
-- 取出cookie
Cookie[] cookies = request.getCookies();
for (Cookie cookie : cookies) {
System.out.println(cookie.getName()+"\n"+cookie.getValue());
}


if("username".equals(cookie.getName().toString())){
			out.print("cookie:"+cookie.getName());
			out.print("的值是:");
			out.print(cookie.getValue());
			out.print("\n");
			//return;
		}