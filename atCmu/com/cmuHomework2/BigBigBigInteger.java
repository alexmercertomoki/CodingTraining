package com.cmuHomework2;
/*
This file: BigBigBigInteger
Programmer: Bilei Huang (bhuang@andrew.cmu.edu)
Course/Section: 95-712
Assignment: Create integers big enough to express big numbers through 50!
Description: The program types out factorial all the way through 50! 
Method: Using class BigInteger to do the calculation and express
Last Modified: 09/10/2014
Known Bugs: No bugs at present.
Compiler: JDK 1.6
*/
import java.math.BigInteger;

public class BigBigBigInteger {
	
		public static void main(String args[]) {
			
            //define the BigInteger and initialize it 1
			BigInteger bigFactorial = new BigInteger("1");
			//define the second to hold i for multiplication
            BigInteger b2;
            //loop to 50
			for (int i = 2; i <= 50; i++) {
			    //convert i to string,transfer the value of i to b2
				b2= new BigInteger(String.valueOf(i));
				//bigFactorial multiplied by b2 
				bigFactorial=bigFactorial.multiply(b2);
				//output the result 
				System.out.println(i + "! = " + bigFactorial);

			};

		}
	

}
