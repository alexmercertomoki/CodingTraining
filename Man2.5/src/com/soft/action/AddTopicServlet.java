package com.soft.action;

import java.io.IOException;

import com.soft.domain.User;


public class AddTopicServlet extends HttpServlet{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1117900116968832648L;


	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		request.setCharacterEncoding("UTF-8");

		String title = request.getParameter("title");
		String content01 = request.getParameter("content01");

		System.out.println("*****************");
		System.out.println(title);
		System.out.println(content01);
		System.out.println("*****************");
		
		
		User user = (User)request.getSession().getAttribute("user");
		if(user==null){
			// δ��¼ ��ת����Ҫ��¼��ҳ�� login.jsp
		}
		//	������� ����
		
		
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/ShowUsers");
		dispatcher.forward(request, response);
		return ;
	}
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		doPost(request,response);
		
	}
//	public static void main(String[] args) {
//		String file = "1235.txt";
//		
//		String[] arr = file.split("[15]");
//		for(String str : arr){
//			System.out.println(str);
//		}
//	}
	
}
