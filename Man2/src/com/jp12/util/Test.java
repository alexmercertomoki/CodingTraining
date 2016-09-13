package com.jp12.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// List 链表 
		// Map	存储 键值对 key-value
		// List<Company> list 
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("3");
		list.add("5");
		list.add("7");
		list.add("9");
		list.add("11");
//		
//		for(int i=0;i<list.size();i++){
//			System.out.println(list.get(0));
//		}
//		
//		for(String str : list){
//			System.out.println(str);
//		}
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("11月1日", "3个1");
		map.put("11月11日", "4个1");
		map.put("11月11日11时11分11秒111毫秒", "13个1");
		
		for(String key : map.keySet()){
//			System.out.println(key+"\t");
//			String value = map.get(key);
//			System.out.println(value);
		}
		
		
		// 超市采购
		// 张庭硕 1.白菜 2.萝卜 3.娃娃菜
		// 牛肖鹏 1.地瓜 2.香蕉 3.土豆 4.番茄 5.5c5s
		// 刘铁龙 1.肉	2.海鲜 3.巧克力 4.蛋糕
		// 杜智   1.臭豆腐 2.烤地瓜 
		
		Map<String,List<String>> map2 = new HashMap<String,List<String>>();
		List<String> list2 = new ArrayList<String>();
		String name = "";
		
		name = "张庭硕";
		list2.add("白菜");
		list2.add("萝卜");
		list2.add("娃娃菜");
		
		map2.put(name, list2);
		
		list2 = new ArrayList<String>();
//		list2.clear();
		
		name = "牛肖鹏";
		list2.add("地瓜");
		list2.add("香蕉");
		list2.add("土豆");
		list2.add("番茄");
		list2.add("5c5s");
		
		map2.put(name, list2);
		
		
//		for(String key : map2.keySet()){
//			System.out.println(key);
//			List<String> list3 = map2.get(key);
//			for(String s : list3){
//				System.out.println(s+",");
//			}
//			System.out.println();
//			System.out.println("============");
//		}
		
		
		// long int boolean float double byte short char 基本数据类型
		// Long 封装类 装箱和拆箱
		long t = Long.parseLong("38");
		
		int t2 = Integer.parseInt("12");
		
		String t3 = String.valueOf(3);
		
		String t4 = String.valueOf(3.5);
		
		float t5 = 5.4f;
		
		
		
		// String 
		
		
		

	}

}
