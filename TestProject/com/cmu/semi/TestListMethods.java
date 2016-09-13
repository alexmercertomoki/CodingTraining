package com.cmu.semi;

/*
		This file:List Method
	Compiler: JDK 1.6
		*/
import java.lang.reflect.Method;

public class TestListMethods {
	
	
	public static void ListMethods(Object a){
		// method array 
		 Method[] meth;
		 // get all methods
		 meth=a.getClass().getMethods();
		 //string 
		 String str;
		 for (int i = 0; i < meth.length; i++) {
			 //let string hold the value, easy to compare
			    str=meth[i].getName();//every sentence getName()
			    //start with g  we  print
			    if(str.startsWith("g")){ 
				System.out.println("method with g at the beginning : " + str);
			    }
			}
		
		
		
	}
	public static void main(String[] args) {
		// generate  Integer :
		Integer i=new Integer(1);
		//use ListMethods()
		ListMethods(i);

	}

}
