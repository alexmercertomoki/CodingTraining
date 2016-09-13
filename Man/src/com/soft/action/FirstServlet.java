package com.soft.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soft.domain.User;
import com.soft.service.UserService;


public class FirstServlet extends HttpServlet{
	
	
	
	

	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
//		System.out.println("doPost");
		request.setCharacterEncoding("UTF-8");
		// ��ȡ������ֵ
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
//		System.out.println(username);
		
		// �������� ��װ У�� �ύ���ݣ���������
		UserService service = new UserService();
		// У�� �û��Ƿ����
		// sql select * from bbs_user where username='admin'
		
		boolean flag = service.findUserByUserName(username);
		// �û������� 
		if(flag){
			
			String msg = "�û����Ѿ����ڣ�����������!";
			
			request.setAttribute("msg", msg);
			
			RequestDispatcher dispatcher = request
			.getRequestDispatcher("form.jsp");
			dispatcher.forward(request, response);
			return ;
		}
		
		// ��װ
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		service.add(user);
		
		// ҳ�����ת
		request.setAttribute("user", user);
		
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("result.jsp");
		dispatcher.forward(request, response);
		return ;
	}
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		doPost(request,response);
		
	}
	
}
