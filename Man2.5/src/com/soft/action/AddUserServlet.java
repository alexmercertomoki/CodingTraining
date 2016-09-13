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


public class AddUserServlet extends HttpServlet{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1117900116968832648L;


	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
//		System.out.println("doPost");
		request.setCharacterEncoding("UTF-8");
		
		
		// ***********************************************************
		
//		 文件上傳部分
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);

		User user = new User();
		
		String username = "";
		String password = "";
		String interest = "";
		String provinceId = "";
		
		if (isMultipart == true) {
			try {
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				
				// 得到所有的表单域，它们目前都被当作FileItem
				List<FileItem> fileItems = upload.parseRequest(request);
				Iterator<FileItem> iter = fileItems.iterator();
				// 迭代器
				
				// 依次处理每个表单域
				while (iter.hasNext()) {
					FileItem item = (FileItem) iter.next();
					
					if(item.isFormField()){
						// 如果item是正常的表单域
						String name = item.getFieldName();
					    String value = item.getString();
					    if("username".equals(name)){
					    	value = new String(value.getBytes("ISO-8859-1"),"UTF-8");
					    	username = value;
					    }
					    else if("password".equals(name)){
					    	password = value;
					    }
					    else if("interest".equals(name)){
					    	interest = interest + value +",";
					    }
					    else if("provinceId".equals(name)){
					    	provinceId = value;
					    }
					    
					    System.out.print("表单域名为:"+name+"表单域值为:"+value);
					}
					else{
						// 如果item是文件上传表单域
						
						// 获得文件名及路径
						String fileName = item.getName();
						if (fileName != null) {
							File fullFile = new File(item.getName());							
														
							// 如果文件存在则上传
							String[] arr = item.getName().split("[.]");
							
							String newFileName = TimeUtil.getCurrDateTime()+"."+arr[arr.length-1];
							
							File fileOnServer = new File(UploadUtil.getUploadPath(),
									newFileName);
							// 设置头像路径 upload
							String filepath = UploadUtil.uploadfilepath +"/"+newFileName;
							
							user.setFilepath(filepath);
							
							item.write(fileOnServer);
							
							System.out.println("文件"+fileOnServer.getName()+"上传成功");
							
						}
					}
				}				
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("the enctype must be multipart/form-data");
		}
		
		// ********************************************************************
		
		
		
		// 获取参数的值
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//		String password2 = request.getParameter("password2");
//		
//		String provinceId = request.getParameter("provinceId");
//		
//		String sex = request.getParameter("sex");
//		
//		String[] interest = request.getParameterValues("interest");
//		
//		for(String str : interest){
//			System.out.println(str);
//		}
		
		
//		if(password==null || password2==null){
//			RequestDispatcher dispatcher = request
//			.getRequestDispatcher("adduser.jsp");
//			dispatcher.forward(request, response);
//			return ;
//		}
//		
//		// 密码的校验
//		if(!password.equals(password2)){
//			RequestDispatcher dispatcher = request
//			.getRequestDispatcher("adduser.jsp");
//			dispatcher.forward(request, response);
//			return ;
//		}
		
//		System.out.println(username);
		
		// 处理数据 封装 校验 提交数据，返回数据
		UserService service = new UserService();
		// 校验 用户是否存在
		// sql select * from bbs_user where username='admin'
		
		boolean flag = service.findUserByUserName(username);
		// 用户名存在 
		if(flag){
			
			String msg = "用户名已经存在，请重新输入!";
			
			request.setAttribute("msg", msg);
			
			RequestDispatcher dispatcher = request
			.getRequestDispatcher("adduser.jsp");
			dispatcher.forward(request, response);
			return ;
		}
		
		// 封装
		user.setUsername(username);
		user.setPassword(password);
		user.setProvinceId(Long.parseLong(provinceId));
		user.setInterest(interest);
		
		service.add(user);
		
		// 页面的跳转
		request.setAttribute("user", user);
		
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
