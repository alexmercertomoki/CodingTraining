package com.soft.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soft.domain.User;
import com.soft.service.UserService;


public class FirstServlet extends HttpServlet{
	
	
	
	

	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
//		System.out.println("doPost");
		request.setCharacterEncoding("UTF-8");
		// 获取参数的值
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
//		System.out.println(username);
		
		// 处理数据 封装 校验 提交数据，返回数据
		UserService service = new UserService();
		// 校验 用户是否存在
		// sql select * from bbs_user where username='admin'
		
		boolean flag = service.findUserByUserName(username);
		// 用户名存在 
		if(flag){
			
			String msg = "用户名已经存在，请重新输入!";
			
			request.setAttribute("msg", msg);
			
			RequestDispatcher dispatcher = request
			.getRequestDispatcher("form.jsp");
			dispatcher.forward(request, response);
			return ;
		}
		
		// 封装
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		service.add(user);
		
		// 页面的跳转
		request.setAttribute("user", user);
		
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("result.jsp");
		dispatcher.forward(request, response);
		return ;
	}
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		doPost(request,response);
		
	}
	
}
