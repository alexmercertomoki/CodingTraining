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

		// List ���� 
		// Map	�洢 ��ֵ�� key-value
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
		map.put("11��1��", "3��1");
		map.put("11��11��", "4��1");
		map.put("11��11��11ʱ11��11��111����", "13��1");
		
		for(String key : map.keySet()){
//			System.out.println(key+"\t");
//			String value = map.get(key);
//			System.out.println(value);
		}
		
		
		// ���вɹ�
		// ��ͥ˶ 1.�ײ� 2.�ܲ� 3.���޲�
		// ţФ�� 1.�ع� 2.�㽶 3.���� 4.���� 5.5c5s
		// ������ 1.��	2.���� 3.�ɿ��� 4.����
		// ����   1.������ 2.���ع� 
		
		Map<String,List<String>> map2 = new HashMap<String,List<String>>();
		List<String> list2 = new ArrayList<String>();
		String name = "";
		
		name = "��ͥ˶";
		list2.add("�ײ�");
		list2.add("�ܲ�");
		list2.add("���޲�");
		
		map2.put(name, list2);
		
		list2 = new ArrayList<String>();
//		list2.clear();
		
		name = "ţФ��";
		list2.add("�ع�");
		list2.add("�㽶");
		list2.add("����");
		list2.add("����");
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
		
		
		// long int boolean float double byte short char ������������
		// Long ��װ�� װ��Ͳ���
		long t = Long.parseLong("38");
		
		int t2 = Integer.parseInt("12");
		
		String t3 = String.valueOf(3);
		
		String t4 = String.valueOf(3.5);
		
		float t5 = 5.4f;
		
		
		
		// String 
		
		
		

	}

}
