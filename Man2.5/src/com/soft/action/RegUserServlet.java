package com.soft.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soft.domain.Province;
import com.soft.service.ProvinceService;


public class RegUserServlet extends HttpServlet{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1117900116968832648L;


	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{

		request.setCharacterEncoding("UTF-8");
		
		// 提取数据库中 省的信息
		ProvinceService service = new ProvinceService();
		List<Province> list = service.findAllProvinces();
		request.setAttribute("list", list);
		
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/ShowPage?page=adduser");
		dispatcher.forward(request, response);
		return ;
	}
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		doPost(request,response);
		
	}
	
}
