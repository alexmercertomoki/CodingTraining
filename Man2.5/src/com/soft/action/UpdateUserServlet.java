package com.soft.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soft.domain.Province;
import com.soft.domain.User;
import com.soft.service.ProvinceService;
import com.soft.service.UserService;

public class UpdateUserServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7064602981284866805L;


	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
//		System.out.println("doPost");
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		
		UserService service = new UserService();
		User user = service.findUserById(id);
		
		if(user==null){
			
			String msg = "该信息已经不存在，请重新选择。";
			
			request.setAttribute("msg", msg);
			
			RequestDispatcher dispatcher = request
			.getRequestDispatcher("/ShowUsers");
			dispatcher.forward(request, response);
			return ;
		}
		
		request.setAttribute("user", user);
		
		ProvinceService service_province = new ProvinceService();
		List<Province> list = service_province.findAllProvinces();
		request.setAttribute("list", list);
		
		List<String> list_interest = new ArrayList<String>();
		list_interest.add("1,KTV");
		list_interest.add("2,爬山");
		list_interest.add("3,上网");
		list_interest.add("4,电影");
		list_interest.add("5,游戏");

		request.setAttribute("list_interest", list_interest);
		
		Map<String,String> map = new LinkedHashMap<String,String>();
		
		
		String interest = user.getInterest();
		String[] arr = interest.split("[,]");
		for(String str : arr){
			map.put(str, "");
		}
		request.setAttribute("map", map);
		
		
//		<input type="checkbox" name="interest" value="1" />KTV
//		<input type="checkbox" name="interest" value="2" />爬山
//		<input type="checkbox" name="interest" value="3" />上网
//		<input type="checkbox" name="interest" value="4" />电影
//		<input type="checkbox" name="interest" value="5" />游戏
		
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("updateuser.jsp");
		dispatcher.forward(request, response);
		return ;
	}
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		doPost(request,response);
		
	}
	
}
