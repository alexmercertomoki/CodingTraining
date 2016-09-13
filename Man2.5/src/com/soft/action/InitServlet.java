package com.soft.action;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soft.util.UploadUtil;

/**
 * ��ʼ������
 * @author Administrator
 *
 */
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = -7444606086930580188L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		doPost(request, response);
	}

	public void init() throws ServletException {
		// ȡ��ʵ�������ַ
		ServletContext sct = getServletContext();
		String realPath = sct.getRealPath("/");
		
		// �����ϴ�·��
		UploadUtil.setUploadPath(realPath);
	}
}
