package com.cmu.calculates1;

import java.util.Random;

/*
This file: TestArithmetic.java
Programmer: Bilei Huang (bhuang@andrew.cmu.edu)
Course/Section: 95-712
Assignment: recursive formula maker which makes 5 caculations using tree structure
Description:test method of the program
Last Modified: 10/2/2014
Known Bugs: No bugs at present.
Compiler: JDK 1.6
*/



public class TestArithmetic {
	//a random method to create some random numbers
	static Random r = new Random();
	
	
	public static void main(String[] args) {
		//do while for  5 times  to create 5
		int i=0;
		do{
		//get an instance of testArithmetic
		TestArithmetic t=new TestArithmetic();
		//n is node just like a tree which is created recursively calling ChooseMethod and Rconsts.
		Node n = t.ChooseMethod(t.ChooseMethod(t.RConsts(),t.RConsts()),t.ChooseMethod(t.RConsts(),t.RConsts()));
		//show result
		t.ShowResult(n);
		i++;
		}
		while(i<=4);
		
	}
	//creating a new constant
	public Node RConsts() {
		// create a number from 1-20
		int con = (int) (Math.random()*20 + 1); 
		return new Const(con);
	}
	
	public Binop ChooseMethod(Node left, Node right) {
		//get a certain way to calculate (4 ways)
		int aSwi = r.nextInt(4);
		if(aSwi==0)
			return new Plus( left, right);
		if(aSwi==1)
			return new Minus(left, right);
		if(aSwi==2)
			return new Multiply(left,  right);
		if(aSwi==3)
			return new Division(left, right);
		else 
			//joking^^
			System.out.println("it's impossible to get me printed haha!^^");
		    return null;
		}
	
     public void ShowResult(Node n) {
		//print node n calling its toString();
		System.out.print(n.toString() + " = ");
		//keep 2 decimals after . 
		System.out.printf( "%.2f\n", n.eval() );	
		
	 }
}
	

