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


public class LoginServlet extends HttpServlet{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1117900116968832648L;


	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{

		request.setCharacterEncoding("UTF-8");
		

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		// 登录成功之后保存 用户信息 
		request.getSession().setAttribute("user", user);
		
		
		User usertemp = (User)request.getSession().getAttribute("user");
		
		// 页面的跳转
//		request.setAttribute("user", user);
		
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
