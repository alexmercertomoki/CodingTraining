package com.soft.util;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * ������-����ʱ�����ڴ���
 * @author sitinspring
 *
 * @date 2008-1-31
 */
public final class TimeUtil{
	/**
	 * ˽�й��캯������ֹ������ʵ��
	 *
	 */
	private TimeUtil(){
		
	}
	
	/**
	 * ȡ���ַ�����ʽ�ĵ�ǰʱ��
	 * @return
	 */
	public static String getCurrDateTime() {
		Date date = new Date();
		Format formatter = new SimpleDateFormat("yyyyMMdd-HHmmss-SSSS");
		return formatter.format(date);
	}
	
	
	/**
	 * ��ʱ��Ϊ��������ID
	 * @param name
	 * @return
	 */
	public static synchronized String getIdByTime(String name){
		return name+"-"+getCurrDate()+"-"+getCurrTime()+getRandomNumber();
	}
	
	/**
	 * ȡ���ַ�����ʽ�ĵ�ǰ����
	 * @return
	 */
	public static String getCurrDate() {
		Date date = new Date();
		Format formatter = new SimpleDateFormat("yyyy.MM.dd");
		return formatter.format(date);
	}

	/**
	 * ȡ���ַ�����ʽ�ĵ�ǰʱ��
	 * @return
	 */
	public static String getCurrTime() {
		Date date = new Date();
		Format formatter = new SimpleDateFormat(".HH.mm.ss");
		return formatter.format(date);
	}
	
	public static String getRandomNumber(){
		Random random=new Random();
		String retval=String.valueOf(random.nextInt(100));
		return retval;
	}
	
}