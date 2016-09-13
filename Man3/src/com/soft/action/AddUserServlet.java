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
		
//		 �ļ��ς�����
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
				
				// �õ����еı�������Ŀǰ��������FileItem
				List<FileItem> fileItems = upload.parseRequest(request);
				Iterator<FileItem> iter = fileItems.iterator();
				// ������
				
				// ���δ���ÿ������
				while (iter.hasNext()) {
					FileItem item = (FileItem) iter.next();
					
					if(item.isFormField()){
						// ���item�������ı���
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
					    
					    System.out.print("������Ϊ:"+name+"����ֵΪ:"+value);
					}
					else{
						// ���item���ļ��ϴ�����
						
						// ����ļ�����·��
						String fileName = item.getName();
						if (fileName != null) {
							File fullFile = new File(item.getName());							
														
							// ����ļ��������ϴ�
							String[] arr = item.getName().split("[.]");
							
							String newFileName = TimeUtil.getCurrDateTime()+"."+arr[arr.length-1];
							
							File fileOnServer = new File(UploadUtil.getUploadPath(),
									newFileName);
							// ����ͷ��·�� upload
							String filepath = UploadUtil.uploadfilepath +"/"+newFileName;
							
							user.setFilepath(filepath);
							
							item.write(fileOnServer);
							
							System.out.println("�ļ�"+fileOnServer.getName()+"�ϴ��ɹ�");
							
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
		
		
		
		// ��ȡ������ֵ
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
//		// �����У��
//		if(!password.equals(password2)){
//			RequestDispatcher dispatcher = request
//			.getRequestDispatcher("adduser.jsp");
//			dispatcher.forward(request, response);
//			return ;
//		}
		
//		System.out.println(username);
		
		// �������� ��װ У�� �ύ���ݣ���������
		UserService service = new UserService();
		// У�� �û��Ƿ����
		// sql select * from bbs_user where username='admin'
		
		boolean flag = service.findUserByUserName(username);
		// �û������� 
		if(flag){
			
			String msg = "�û����Ѿ����ڣ�����������!";
			
			request.setAttribute("msg", msg);
			
			RequestDispatcher dispatcher = request
			.getRequestDispatcher("adduser.jsp");
			dispatcher.forward(request, response);
			return ;
		}
		
		// ��װ
		user.setUsername(username);
		user.setPassword(password);
		user.setProvinceId(Long.parseLong(provinceId));
		user.setInterest(interest);
		
		service.add(user);
		
		// ҳ�����ת
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
