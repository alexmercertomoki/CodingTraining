package com.sample;

public class SeveralNumbers {
// what is wrong with 1.8
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] myArray = {0, 1, 2, 3, 5, 8};
		  int[] otherArray = myArray;//the same ref
		  otherArray[1] = otherArray[0]++;
		  System.out.println("myArray[0] = " + myArray[0]);
		  System.out.println("myArray[1] = " + myArray[1]);
	}

}
