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

public class DoUpdateUserServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7064602981284866805L;


	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{

		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String password3 = request.getParameter("password3");
		String provinceId = request.getParameter("provinceId");
		
		// 校验密码合法性
		
		UserService service = new UserService();
		User user = service.findUserById(id);
		
//		User user = new User();
//		user.setId(Long.parseLong(id));
		
		user.setUsername(username);
		user.setPassword(password2);
		user.setProvinceId(Long.parseLong(provinceId));
		
		service.update(user);
		
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/ShowUsers");
		dispatcher.forward(request, response);
		return ;
	}
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		doPost(request,response);
		
	}
	
}
