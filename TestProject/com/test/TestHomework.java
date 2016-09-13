package com.test;
import java.math.BigInteger;

public class TestHomework {
	
		public static void main(String args[]) {
			
//			int factorial = 1;
//			for (int i = 2; i <= 40; i++) {
//				factorial *= i;
//				System.out.println(i + "! = " + factorial);
//			}
//			System.out.println("Now try it with BigIntegers");
//			
//		
			BigInteger bigFactorial = new BigInteger("1");
//			BigInteger b2 = new BigInteger("2");
//			BigInteger b3 = new BigInteger("1");
			BigInteger b2;
			for (int i = 2; i <= 50; i++) {
			//	   String.valueOf(i);  i+"" -------to string   or we can use biginteger value of
				b2= new BigInteger(String.valueOf(i));
				bigFactorial=bigFactorial.multiply(b2);
				System.out.println(i + "! = " + bigFactorial);
//				b2=b2.add(b3);
				
			};

		}
	

}
