package com.week3;

public class TwoDimensionIntArray {
	  public static void main(String[] args) {   
		  
		  int[][]a1 = {{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4}};
		  for (int[] element1 : a1)  {  
			  for (int element : element1)    {   // ******* good way to traversal
		      System.out.println(element);
	          }
	      }
	  }
}
