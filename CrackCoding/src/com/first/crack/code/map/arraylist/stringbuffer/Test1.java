package com.first.crack.code.map.arraylist.stringbuffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Test1 {
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    String[] a={"aa","ab","aa","ab","aa","ab","aa","ab"} ;
	    String[] b={"ab","aa","ab","aa","ab","aa","ab","aa"} ;
	    ArrayList x;
	    x=merge(a,b);
	    String[] y={"1","2","3"};
	    
	    Iterator i=x.iterator();
	    while(i.hasNext())
	    {
	    	System.out.print(i.next());
	    }
	    
	    
	  
	}
	public static ArrayList<String> merge(String[] words,String[] morewords){
	    ArrayList<String> sentence =new ArrayList<String>();
	    for(String w:words){
	    	sentence.add(w);
	    }
	    for(String w:morewords){
	    	sentence.add(w);
	    }
	    
		return sentence;
		
	}
	public String mkst(String[] words){
		StringBuffer sentence =new StringBuffer();
		for(String w : words){
			sentence.append(w);
		}
		// careful must return toStirng();
		return sentence.toString();
	}
	
	public HashMap<Integer, Student> buildMap(Student[] students){
		HashMap<Integer, Student> a =new HashMap<>();
		for(Student s: students){
			a.put(1, s);// id and student obj 
		}
		
		return a;
		
	}
	
}
