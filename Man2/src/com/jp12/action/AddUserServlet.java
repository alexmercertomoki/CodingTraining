package com.jp12.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jp12.service.JPUserService;
import com.jp12.domain.JPUser;

public class AddUserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8488110552466685341L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		request.setCharacterEncoding("utf-8");

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String companyId = request.getParameter("companyId");

		String msg = "";
		
		// У�� �û����Ƿ�Ϊ��
		if(username==null || username.trim().length()<1){
			msg = "�û������Ϸ������������롣";
			request.setAttribute("msg", msg);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/adduser.jsp");
			dispatcher.forward(request, response);
			return;
			
		}
		
		// У�� �û����Ƿ���� ���ݿ�
		// sql��� myuser
		// select * from myuser where name='����1'
		
		JPUserService service = new JPUserService();
		if(service.findUserByName(username)){
			msg = "��������û����Ѿ����ڣ����������롣";
			request.setAttribute("msg", msg);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/adduser.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		// ���������Ƿ���ͬ
		if(!password.equals(password2)){
			msg = "������������벻ͬ�����������롣";
			request.setAttribute("msg", msg);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/adduser.jsp");
			dispatcher.forward(request, response);
			return;
			
		}
		
		// ע���û�
		JPUser jpuser = new JPUser();
		jpuser.setName(username);
		jpuser.setPassword(password);
		jpuser.setCompanyId(Long.parseLong(companyId));
		
		service.add(jpuser);
		
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
