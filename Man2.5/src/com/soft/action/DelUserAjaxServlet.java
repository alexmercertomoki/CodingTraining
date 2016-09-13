package com.soft.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soft.domain.User;
import com.soft.service.UserService;

public class DelUserAjaxServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
//		System.out.println("doPost");
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/plain;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		
		// 接收参数 id
		
		String id = request.getParameter("id");
		
		UserService service = new UserService();
		User user = new User();
		user.setId(Long.parseLong(id));
		service.delete(user);
		
		// 根据ID去数据库中查询数据 有没有
		
		// 有则删除
		PrintWriter out = response.getWriter();
		String resval = "ok";
		// 没有 返回 no
		// resval = "no";
		
		out.print(resval);
		
		
		
		
		
//		RequestDispatcher dispatcher = request
//				.getRequestDispatcher("ShowUsers");
//		dispatcher.forward(request, response);
		return ;
	}
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		doPost(request,response);
		
	}
	
}
