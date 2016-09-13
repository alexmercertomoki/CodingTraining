package com.soft.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soft.domain.User;
import com.soft.service.UserService;

public class DelUserAjaxServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
//		System.out.println("doPost");
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/plain;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		
		// ���ղ��� id
		
		String id = request.getParameter("id");
		
		UserService service = new UserService();
		User user = new User();
		user.setId(Long.parseLong(id));
		service.delete(user);
		
		// ����IDȥ���ݿ��в�ѯ���� ��û��
		
		// ����ɾ��
		PrintWriter out = response.getWriter();
		String resval = "ok";
		// û�� ���� no
		// resval = "no";
		
		out.print(resval);
		
		
		
		
		
//		RequestDispatcher dispatcher = request
//				.getRequestDispatcher("ShowUsers");
//		dispatcher.forward(request, response);
		return ;
	}
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		doPost(request,response);
		
	}
	
}
