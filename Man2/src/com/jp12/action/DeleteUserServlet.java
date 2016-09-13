package com.jp12.action;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jp12.service.JPUserService;
import com.jp12.domain.JPUser;

public class DeleteUserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8488110552466685341L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		
		JPUser user = new JPUser();
		user.setId(Long.parseLong(id));
		
		JPUserService service = new JPUserService();
		service.delete(user);
		
		
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
