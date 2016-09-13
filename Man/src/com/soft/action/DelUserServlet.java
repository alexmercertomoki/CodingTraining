package com.soft.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soft.domain.User;
import com.soft.service.UserService;

public class DelUserServlet extends HttpServlet{
	

	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
//		System.out.println("doPost");
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("iee");
		
		UserService service = new UserService();
		User user = new User();
		user.setId(Long.parseLong(id));
		service.delete(user);
		
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("ShowUsers");
		dispatcher.forward(request, response);
		return ;
	}
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		doPost(request,response);
		
	}
	
}
