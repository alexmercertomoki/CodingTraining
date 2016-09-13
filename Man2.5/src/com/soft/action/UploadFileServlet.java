package com.soft.action;

import java.io.File;
import java.util.ArrayList;
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

import com.soft.util.UploadUtil;

/**
 * 用于文件上传处理的Servlet
 * @author sitinspring
 *
 * @date 2008-2-12
 */
public class UploadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 56890894234786L;

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		request.setCharacterEncoding("UTF-8");

		// 文件上傳部分
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		
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
					    System.out.print("表单域名为:"+name+"表单域值为:"+value);
					}
					else{
						// 如果item是文件上传表单域
						
						// 获得文件名及路径
						String fileName = item.getName();
						if (fileName != null) {
							File fullFile = new File(item.getName());							
														
							// 如果文件存在则上传
							
							File fileOnServer = new File(UploadUtil.getUploadPath(),
									fullFile.getName());
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
		

	    // 跳回原頁面
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/web/page/uploadtoserver.jsp");
		dispatcher.forward(request, response);
		return;
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		doPost(request, response);
	}
}
