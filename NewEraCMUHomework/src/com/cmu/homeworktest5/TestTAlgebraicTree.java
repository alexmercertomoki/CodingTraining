package com.cmu.homeworktest5;


/*
This file: TestAlgebraicTree.java
Programmer: Bilei Huang (bhuang@andrew.cmu.edu)
Course/Section: 95-712
Assignment: Choosing variable or a constant and form a calculation
Description: This a class testing choosing variables between constants and calculate out the result
Last Modified: 10/16/2014
Known Bugs: No bugs at present.
Compiler: JDK 1.6
*/

import java.util.Random;


public class TestTAlgebraicTree {
	//random number
    static Random r = new Random();
    //count number
    int count;
    //datasets
    static double data1[]={1,2,3};
    static double data2[]={4,5,6};
    static double d[];
	public static void main(String[] args) {
		//initiate variables:dataset1 
		System.out.println("first we choose dataset1 (1,2,3)");
		d=data1;
		TestTAlgebraicTree t=new TestTAlgebraicTree();
		t.count=0;
		//get the tree
		Node n = t.ChooseMethod(t.ChooseMethod(t.RConsts(),t.RConsts()),t.ChooseMethod(t.RConsts(),t.RConsts()));
		t.ShowResult(n);
		System.out.println("Variable has been used for "+t.count+" time(s) in test 1 Tree1");
		
		//initiate dataset2
		System.out.println("seconde we choose dataset2 (4,5,6)");
		d=data2;
		TestTAlgebraicTree t1=new TestTAlgebraicTree();
		t1.count=0;
		//get dataset2,print out tree2
		Node n1 = t1.ChooseMethod(t1.ChooseMethod(t1.RConsts(),t1.RConsts()),t1.ChooseMethod(t1.RConsts(),t1.RConsts()));
		t.ShowResult(n1);
		System.out.println("Variable has been used for "+t1.count+" time(s) in test2 Tree2");
		
	}
	
	public Node RConsts() {
	   //choose flip a coin heads or tails 50% rate we get a variable
		if(r.nextInt(2)==1){
		int con = (int) (Math.random()*20 + 1); // generate constant integers randomly in the range from 1 to 20
		return new Const(con);
		}
		
		else{
		//get how many variables have been used
		this.count++;
	    return new Variable(d);
		}
	}
	
	public Binop ChooseMethod(Node left, Node right) {
		//adding operator
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
			System.out.println("it's impossible haha!^^");
		    return null;
		}
	
     public void ShowResult(Node n) {
		//print out the tree and the value in format 
		System.out.print(n.toString() + " = ");
		System.out.printf( "%.2f\n", n.eval() );	
		
	 }

}
