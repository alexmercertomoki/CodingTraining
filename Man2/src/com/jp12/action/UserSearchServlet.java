package com.jp12.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jp12.domain.Company;
import com.jp12.domain.JPUser;
import com.jp12.service.CompanyService;
import com.jp12.service.JPUserService;


public class UserSearchServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8488110552466685341L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		request.setCharacterEncoding("utf-8");
		
		// 显示myuser表中的数据
		
		JPUserService service = new JPUserService();
		
		List<JPUser> list = service.findAllUser();
		
		request.setAttribute("list", list);
		
		CompanyService service_c = new CompanyService();
		List<Company> list_c = service_c.findAllCompany();
		
		Map<Long,String> map = new HashMap<Long,String>();
		// key value 键值对 
		for(Company c : list_c){
			map.put(c.getId(), c.getName());
		}
		
		request.setAttribute("map", map);
		
		
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/index3.jsp");
		dispatcher.forward(request, response);
		return;
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		doPost(request, response);
	}

}
