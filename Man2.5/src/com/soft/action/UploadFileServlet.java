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
 * �����ļ��ϴ������Servlet
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

		// �ļ��ς�����
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		
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
					    System.out.print("������Ϊ:"+name+"����ֵΪ:"+value);
					}
					else{
						// ���item���ļ��ϴ�����
						
						// ����ļ�����·��
						String fileName = item.getName();
						if (fileName != null) {
							File fullFile = new File(item.getName());							
														
							// ����ļ��������ϴ�
							
							File fileOnServer = new File(UploadUtil.getUploadPath(),
									fullFile.getName());
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
		

	    // ����ԭ���
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
