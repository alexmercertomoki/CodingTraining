package com.jp12.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFirstServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8488110552466685341L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		request.setCharacterEncoding("utf-8");
		
		String username = request.getParameter("username");
		
		String[] subject = request.getParameterValues("subject");
		
		for(String str : subject){
			System.out.println(str);
		}
		
		request.setAttribute("username", username);
		
		
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/index2.jsp");
		dispatcher.forward(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		doPost(request, response);
	}

}
