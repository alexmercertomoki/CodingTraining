package com.cmu.help;

import java.util.*;
import java.awt.event.KeyEvent;
import java.io.*;

import javax.swing.KeyStroke;

public class TypingSpeed {

	public static void main(String[] args) {
		
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Your job is to type the sentence \"I type very quickly\" as fast as you can.");
		System.out.println("When you are ready, press enter, type the sentence and press enter again.");
		
		Date time ;
		Date time2 ;
		long st=0;
		long et=0;
		long t=0;
//		KeyEvent k1;
//		KeyStroke k;
//		k.getKeyStrokeForEvent(k1);
//		//String start = keyboard.next();  start.equals("\n")
//		if (k1.getKeyCode()==KeyEvent.VK_ENTER) {
//			st = time.getTime();	
//		}
		keyboard.nextLine();
		time = new Date();
		st = time.getTime();	
    	
		
		
		String sentence = keyboard.nextLine();
		if (sentence.equals("I type very quickly")){
			time2 = new Date();
			et = time2.getTime();
		}
		else {
			System.out.println("Sorry!The sentence is incorrect! Program ended!");
		}
			
	    t = et-st;
		System.out.println("Congratulations! You  ");
		System.out.println(t);

	}
	
//	  public void keyPressed(KeyEvent e) {
//		  //   System.out.println("key Press:" + e.getKeyCode());
//		     if(e.getKeyCode()==KeyEvent.VK_ENTER){
//		     //do something
//		    }
//	 }
	  
}
