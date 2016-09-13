package com.jp12.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jp12.service.JPUserService;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8488110552466685341L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		request.setCharacterEncoding("utf-8");

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		JPUserService service = new JPUserService();
		boolean flag = service.findUserForLogin(username, password);
		if(flag){
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/index3.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		request.setAttribute("msg", "您输入的用户名或密码有误，请重新输入。");
		
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/login.jsp");
		dispatcher.forward(request, response);
		return;
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		doPost(request, response);
	}

}
