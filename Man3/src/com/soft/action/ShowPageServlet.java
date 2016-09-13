package com.soft.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soft.domain.User;
import com.soft.service.UserService;


public class ShowPageServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2116365120214044502L;


	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
//		System.out.println("doPost");
		request.setCharacterEncoding("UTF-8");
		
		String page = request.getParameter("page");
		
		// Ò³ÃæµÄÌø×ª
		RequestDispatcher dispatcher = request
				.getRequestDispatcher(page+".jsp");
		dispatcher.forward(request, response);
		return ;
	}
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		doPost(request,response);
		
	}
	
}
