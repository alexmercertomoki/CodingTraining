package com.jp12.action;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jp12.domain.Company;
import com.jp12.service.CompanyService;

public class ShowPageServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8488110552466685341L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		request.setCharacterEncoding("utf-8");
		
		String page = request.getParameter("page");
		
		if("adduser".equals(page)){
			
			CompanyService service = new CompanyService();
			List<Company> list =  service.findAllCompany();
			
			request.setAttribute("list", list);
		}
		
		if(page!=null && page.trim().length()>0){
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/"+ page +".jsp");
			dispatcher.forward(request, response);
			return ;	
		}
		RequestDispatcher dispatcher = request
			.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
		return ;
		
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		doPost(request, response);
	}

}
