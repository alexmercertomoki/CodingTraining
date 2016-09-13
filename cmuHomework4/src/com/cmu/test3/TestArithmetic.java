package com.cmu.test3;
/*
This file: TestArithmetic.java
Programmer: Bilei Huang (bhuang@andrew.cmu.edu)
Course/Section: 95-712
Assignment: recursive formula maker which makes 5 calculations using tree structure
Description: test of the program to get 5 calculations
Last Modified: 10/2/2014
Known Bugs: No bugs at present.
Compiler: JDK 1.6
*/
import java.util.Random;

public class TestArithmetic {
	//random number generator
	static Random r = new Random();
	
	public static void main(String[] args) {
		//5 times generates
		for(int loop=0;loop<5;loop++){
		//4 integers for 4 constants
		int a[]= new int[4];
		//3 marks to get 3 calculations 
		int mark1,mark2,mark3;
		
		//4nodes and 3 binops
		Node n[]= new Const[4];
		Binop b[]=new Binop[3];
		
		//initiating consts
		for(int i=0;i<4;i++){
			 //from 1-20 we get 
			 a[i]=r.nextInt(20)+1;
			 //put them into array
			 n[i]=new Const(a[i]);
			 
		}
		
		for(int j=0;j<2;j++){
			//generate the first calculation of const1 2
			if(j==0){
			//four kinds of calcs we get one of them
			mark1=r.nextInt(4);
			if(mark1==0)
			{
				b[j]=new Plus(n[0],n[1]);
			}
			
			if(mark1==1){
				b[j]=new Minus(n[0],n[1]);
			}
			
			if(mark1==2){
				b[j]=new Multiply(n[0],n[1]);
			}
			
			if(mark1==3){
				b[j]=new Division(n[0],n[1]);
			}
			
			}
			
			//generate the second calculation of const3 4
			if(j==1)
			{   
				//get one of the 4 calcs
				mark2=r.nextInt(4);
				if(mark2==0)
				{
					b[j]=new Plus(n[2],n[3]);
				}
				
				if(mark2==1){
					b[j]=new Minus(n[2],n[3]);
				}
				
				if(mark2==2){
					b[j]=new Multiply(n[2],n[3]);
				}
				
				if(mark2==3){
					b[j]=new Division(n[2],n[3]);
				}
				}	
				
			}
			
			
			
			//we the mark 3 for the "center mark"
			mark3=r.nextInt(4);
			
			if(mark3==0){
				b[2]=new Plus(b[0],b[1]);
			}
			
			if(mark3==1){
				b[2]=new Minus(b[0],b[1]);
			}
			
			if(mark3==2){
				b[2]=new Multiply(b[0],b[1]);
			}
			
			if(mark3==3){
				b[2]=new Division(b[0],b[1]);
			}
			//print out the value
			  System.out.println("("+n[0]+b[0]+n[1]+")"+b[2]+"("+n[2]+b[1]+n[3]+")"+"="+b[2].eval());
			
		}
	}
}












