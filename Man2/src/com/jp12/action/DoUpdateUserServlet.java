package com.jp12.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jp12.service.JPUserService;
import com.jp12.domain.JPUser;

public class DoUpdateUserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8488110552466685341L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		request.setCharacterEncoding("utf-8");

		String id = request.getParameter("id");
		
		String password2 = request.getParameter("password2");
		
		String password3 = request.getParameter("password3");
		
		// 校验两次输入的密码是否相同
		
		// 通过ID去查询User
		JPUserService service = new JPUserService();
		JPUser jpuser = service.findUserById(id);
		jpuser.setPassword(password2);
		
		service.update(jpuser);
		
		
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/UserSearch");
		dispatcher.forward(request, response);
		return;
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		doPost(request, response);
	}

}
