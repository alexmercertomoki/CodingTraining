package com.soft.action;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.soft.domain.User;
import com.soft.service.UserService;
import com.soft.util.TimeUtil;
import com.soft.util.UploadUtil;


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
			// 未登录 跳转到需要登录的页面 login.jsp
		}
		//	添加帖子 发帖
		
		
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
