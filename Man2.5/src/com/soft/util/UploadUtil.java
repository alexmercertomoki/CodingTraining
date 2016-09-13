package com.soft.util;

/**
 * 用于文件上传的实用类
 * @author: sitinspring(junglesong@gmail.com)
 * @date: 2008-4-4-上午10:20:47
 */
public final class UploadUtil{
	/**
	 * 上传路径
	 */
	private static String uploadPath;
	
	public static final String uploadfilepath = "upload";

	/**
	 * 取得上传路径
	 * @return
	 */
	public static String getUploadPath() {
		return uploadPath;
	}

	/**
	 * 设置上传路径
	 * @param uploadPath
	 */
	public static void setUploadPath(String uploadPath) {
		UploadUtil.uploadPath = uploadPath+uploadfilepath+"/";
	}	
}