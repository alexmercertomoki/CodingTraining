		/*
		This file: TypingSpeedTest
		Programmer: Bilei Huang (bhuang@andrew.cmu.edu)
		Course/Section: 95-712
		Assignment: First Java Program to test typing speed.
		Description: Type in a certain string it can calculate the time spent.
		Method: Define two Scanners to hold the "start" and something you want to type in; 
		Using two Date value to calculate the time before typing and the time right after typing;
		Substracting the two values, we get the millisenconds used to type.
		Last Modified: 08/31/2014
		Known Bugs: No bugs at present.
		Compiler: JDK 1.6
		*/
package com.cmuHomework1;
		
import java.util.Date;
import java.util.Scanner;
		

public class TypingSpeedTest {
	
	public static void main(String[] args) {
		 //Scanner hold what is typed 
		 Scanner start = new Scanner(System.in);
		 Scanner typing = new Scanner(System.in);
		 //String to save what's typed
		 String startOut="";
		 String typingIn="";
		 //d1 is starting time , d2 is ending time
		 Date d1;
		 Date d2;
		 //t1,t2,tResult to calculate the difference between starting and ending time
		 long t1,t2,tResult;
		 System.out.println("Typing speed tester : Please input start and enter to start ");
		 //to get startout info 
		 startOut=start.nextLine(); 
		 if(startOut.equals("start")){
			 System.out.println("Start Typing");
			 //typing begins,time calculates
			 d1=new Date();
			 t1=d1.getTime();
			 typingIn =typing.nextLine();
			 d2=new Date();
			 t2=d2.getTime();
			 tResult=t2-t1;
			 //print out the result
			 System.out.println("you used :"+tResult+" miliseconds to type "+"'"+typingIn+"'");
			 
		 }
         //if you don't input "start" to start out right,the program ends
		 else   
		 {
			 System.out.println("Sorry,you did't input the right thing to start");
     	     System.exit(0);
		 }
	}

}
