package com.jp12.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveCookieServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8488110552466685341L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		request.setCharacterEncoding("utf-8");
		
		String username = request.getParameter("username");
		
		request.getSession().setAttribute("username", username);
		
		System.out.println("Servlet=>>"+username);
		
		Cookie cookie = new Cookie("username", username);
		cookie.setMaxAge(30000);
		response.addCookie(cookie);
		
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/cookie.jsp");
		dispatcher.forward(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		doPost(request, response);
	}

}
