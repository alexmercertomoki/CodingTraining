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
		// ��ҳ����ʼ��¼��
		int start = 0;
		
		if(currpage!=null){
			start = (Integer.parseInt(currpage)-1) * pagecount;
		}
		else{
			currpage = "1";
		}
		
		UserService service = new UserService();
		
		//	��¼����
		int sumcount = 0;
		List<User> list_count = service.findAllUsers();
		if(list_count!=null){
			sumcount = list_count.size();
		}
		
		int sumpage = 1;
		
		// ����
//		sumcount = sumcount + pagecount-1;
		
		// Math������ ȡ�����������룬��ǰȡ��
		// ��if�ж�һ�� sumcount%pagecount
		
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
		
		
		// ��װ
		// 1.��ǰ�ǵڼ�ҳ
		// 2.ÿҳ��ʾ��������¼
		// 3.�ܼ�¼��
		// 4.��ҳ��
		// 5.���� ��ѯ�Ľ�� where����
		
		
//		select * from bbs_user limit 0,3; (1-1)*3
//		-- ��ǰ�ڼ�ҳ ÿҳ��ʾ������
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
