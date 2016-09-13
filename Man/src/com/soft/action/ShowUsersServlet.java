package com.soft.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soft.service.UserService;
import com.soft.domain.User;

public class ShowUsersServlet extends HttpServlet{
	
	
	
	

	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		//System.out.println("doPost");
		request.setCharacterEncoding("UTF-8");
		
		UserService service = new UserService();
		List<User> list = service.findAllUsers();
		request.setAttribute("list1", list);
		
		
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("showusers.jsp");
		dispatcher.forward(request, response);
		return ;
	}
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		doPost(request,response);
		
	}
	
}
