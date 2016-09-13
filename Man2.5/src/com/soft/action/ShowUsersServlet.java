package com.soft.action;

import java.io.IOException;
import java.util.HashMap;
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

public class ShowUsersServlet extends HttpServlet{
	
	private int pagecount = 3;
	
	

	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
//		System.out.println("doPost");
		request.setCharacterEncoding("UTF-8");
		
		String currpage = request.getParameter("currpage");
		// 分页的起始记录数
		int start = 0;
		
		if(currpage!=null){
			start = (Integer.parseInt(currpage)-1) * pagecount;
		}
		else{
			currpage = "1";
		}
		
		UserService service = new UserService();
		
		//	记录总数
		int sumcount = 0;
		List<User> list_count = service.findAllUsers();
		if(list_count!=null){
			sumcount = list_count.size();
		}
		
		int sumpage = 1;
		
		// 处理
//		sumcount = sumcount + pagecount-1;
		
		// Math工具类 取整，四舍五入，向前取整
		// 用if判断一下 sumcount%pagecount
		
		if(sumcount%pagecount==0){
			sumpage = sumcount/pagecount;
		}
		else{
			sumpage = sumcount/pagecount + 1 ;
		}
		
		request.setAttribute("sumpage", sumpage);
		request.setAttribute("currpage", Integer.parseInt(currpage));
		
		
		List<User> list = service.findUsersByPage(start,pagecount);
		request.setAttribute("list", list);
		
		
		// 封装
		// 1.当前是第几页
		// 2.每页显示多少条记录
		// 3.总记录数
		// 4.总页数
		// 5.集合 查询的结果 where条件
		
		
//		select * from bbs_user limit 0,3; (1-1)*3
//		-- 当前第几页 每页显示多少条
//		select * from bbs_user limit 3,3; (2-1)*3
		
		
		ProvinceService service_province = new ProvinceService();
		List<Province> list_province = service_province.findAllProvinces();
		
		Map<Long,String> map = new HashMap<Long,String>();
		
		for(Province p : list_province){
			long key = p.getId();
			String value = p.getName();
			map.put(key, value);
		}
		request.setAttribute("map", map);
		
		
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("showusers.jsp");
		dispatcher.forward(request, response);
		return ;
	}
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		doPost(request,response);
		
	}
	
}
