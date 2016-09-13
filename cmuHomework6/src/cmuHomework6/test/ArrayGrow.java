package cmuHomework6.test;

/*
This file: ArrayGrow.java
Programmer: Bilei Huang (bhuang@andrew.cmu.edu)
Course/Section: 95-712
Assignment: Grow an Array
Description:get an array and grow it by 4
Last Modified: 10/23/2014
Known Bugs: No bugs at present.
Compiler: JDK 1.6
*/

import java.lang.reflect.Array;

public class ArrayGrow {
	
	static Object arrayGrow(Object a) {
		//get the class of the object 
	    Class cl = a.getClass();
	    //if not an array return null
	    if (!cl.isArray())
	    	return null;
	    //get the value of the array
	    int[][] b=(int[][])a;
	    //get its Vertical length
	    int VertiLength = Array.getLength(b);
	    //get its horizontal length
	    int HoriLength = Array.getLength(b[0]);
	    //increase by 4
	    int newVLength = VertiLength +4 ;
	    int newHoriLength = HoriLength+4 ;
        
	    //create a new one
        int[][] c= new int[newVLength][newHoriLength];
	    
	    for(int i=0;i<VertiLength;i++){
	    	 //copy it 
	    	 System.arraycopy(b[i], 0, c[i],0,HoriLength);
	    }
	   
	    return c;
	    
	    }

	  
	  

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//initiate an array
		int[][] array= new int[2][3];
        //get the array
		int[][] i= (int[][]) arrayGrow(array);
		//print out the Vertical  and Horizontal length
		System.out.println(i.length);
		System.out.println(i[0].length);
		

	}

}
