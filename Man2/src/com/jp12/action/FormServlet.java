package com.jp12.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8488110552466685341L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		request.setCharacterEncoding("utf-8");
		
		// 获取参数的值
		String name = request.getParameter("name");
		String birthday = request.getParameter("birthday");
		String sex = request.getParameter("sex");
		String[] interest = request.getParameterValues("interest");
		
		String degree = request.getParameter("degree");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String intro = request.getParameter("intro");
		String department = request.getParameter("department");


		request.setAttribute("name", name);
		request.setAttribute("birthday", birthday);
		request.setAttribute("sex", sex);
		request.setAttribute("interest", interest);
		request.setAttribute("degree", degree);
		request.setAttribute("tel", tel);
		request.setAttribute("email", email);
		request.setAttribute("intro", intro);
		request.setAttribute("department", department);
		
		
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/index2.jsp");
		dispatcher.forward(request, response);
		return ;
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		doPost(request, response);
	}

}
