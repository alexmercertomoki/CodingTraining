package com.cmu.equals;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
This file: TimeCrisis.java
Programmer: Bilei Huang (bhuang@andrew.cmu.edu)
Course/Section: 95-712
Assignment: write an equal method to 
Description:test method of the program
Last Modified: 10/2/2014
Known Bugs: No bugs at present.
Compiler: JDK 1.6
*/


// the time class given in the ppt
 class Time {
    int hour;
    int minute;
    int second;
    //constructor initiation
    Time() { setTime(0, 0, 0); }
    Time(int h) { setTime(h, 0, 0); }
    Time(int h, int m) { setTime(h, m, 0); }
    Time(int h, int m, int s) { setTime(h, m, s); }
    Time setTime(int h, int m, int s) {
        setHour(h);
        setMinute(m);
        setSecond(s);
        return this;
    }
    //set method
    Time setHour(int h) {
        hour = (( h >= 0 && h < 24 ) ? h : 0 );
        return this;
    }
    Time setMinute(int m) {
        minute = (( m >= 0 && m < 60 ) ? m : 0 );
        return this;
    }
    Time setSecond(int s) {
        second = ((s >= 0 && s < 60 ) ? s : 0 );
        return this;
    }
    //getmethod to get time 
    int getHour() { return hour; }
    int getMinute() { return minute; }
    int getSecond() { return second; }
    //print out time
    public String toString() {
        return  "" +(  ( hour == 12 || hour == 0 ) ? 12 : hour % 12)  +
            ":" + ( minute < 10 ? "0" : "" ) + minute +
            ":" + ( second < 10 ? "0" : "" ) + second +
            ( hour < 12 ? "AM" : "PM" ) ;
   
    }

   //equal method which tests whether two times are equal
   public boolean equals(Time t){
	   
	  
   	  if(t.hour==this.hour&&t.minute==this.minute&&t.second==this.second)
   	  {
   		 
         return true;
   	  }
   	  else 
   	  return false;
   	  
	
   	  
   }
 }     
 
 		public class TimeCrisis {
 		    public static void main(String[] args) {
 		    	//initiate 3 times
 		    	Time t1=null;
 		    	Time t2=null;
 		    	Time t3=null;
 		    	//get 3 times from user
 		    	Scanner keyboard = new Scanner(System.in);
 		    	int h,m,s;
 		    	System.out.println("please enther the 3 times to test equal():");
 		    	
 		    	try {
 		    		//catch inputmismactch : you can enter only integer
 		    		//get time1
 		    		System.out.println("please enther the time1:");
					System.out.println("hour:");
					h = keyboard.nextInt();
					System.out.println("minute:");
					m = keyboard.nextInt();
					System.out.println("second:");
					s = keyboard.nextInt();
					t1 = new Time(h, m, s);
					//get time2
					System.out.println("please enther the time2:");
					System.out.println("hour:");
					h = keyboard.nextInt();
					System.out.println("minute:");
					m = keyboard.nextInt();
					System.out.println("second:");
					s = keyboard.nextInt();
					t2 = new Time();
					t2.setHour(h).setMinute(m).setSecond(s);
					//get time3
					System.out.println("please enther the time3:");
					System.out.println("hour:");
					h = keyboard.nextInt();
					System.out.println("minute:");
					m = keyboard.nextInt();
					System.out.println("second:");
					s = keyboard.nextInt();
					t3 = new Time();
					t3.setHour(h).setMinute(m).setSecond(s);
					System.out.println("t1 is " + t1);
					System.out.println("t2 is " + t2);
					System.out.println("t3 is " + t3);
					
				}
 		    	
 		    	//how to deal with exception
 		    	catch (InputMismatchException e) {
 		    		System.out.println("You should enter INTEGER:for hour 0-23 ,minute:0-59, second:0-59");
 		    		System.exit(0);	
				}
 		    	//test equal
				if(t1.equals(t2)){
					//reflexive test
					if(t1.equals(t1)){
						System.out.println("it is reflexsive");
					}
					//symmetric 
					if(t2.equals(t1))
					{   
						System.out.println(" it is symmetric ");
					}
					//transitive test
					if(t2.equals(t1)&&t2.equals(t3))
					{
						if(t1.equals(t3)){
						System.out.println(" it is transitive ");
						}
					}
 		    		System.out.println(" t1 and t2 are equal ");
 		    		
				}
				//if not equal print out
 		    	else{
 		    		System.out.println(" t1 and t2 are not equal ");
 		    	}
 		    	
 		    }

 		}
