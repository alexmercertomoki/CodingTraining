package com.soft.util;

/**
 * �����ļ��ϴ���ʵ����
 * @author: sitinspring(junglesong@gmail.com)
 * @date: 2008-4-4-����10:20:47
 */
public final class UploadUtil{
	/**
	 * �ϴ�·��
	 */
	private static String uploadPath;
	
	public static final String uploadfilepath = "upload";

	/**
	 * ȡ���ϴ�·��
	 * @return
	 */
	public static String getUploadPath() {
		return uploadPath;
	}

	/**
	 * �����ϴ�·��
	 * @param uploadPath
	 */
	public static void setUploadPath(String uploadPath) {
		UploadUtil.uploadPath = uploadPath+uploadfilepath+"/";
	}	
}