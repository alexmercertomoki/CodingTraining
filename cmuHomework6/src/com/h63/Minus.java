package com.h63;

/*
This file: Minus.java
Programmer: Bilei Huang (bhuang@andrew.cmu.edu)
Course/Section: 95-712
Assignment: recursive formula maker which makes 5 caculations using tree structure
Description:Minus is a kind of node which refers to Minus calculation
Last Modified: 10/23/2014
Known Bugs: No bugs at present.
Compiler: JDK 1.6
*/


public class Minus extends Binop {
	//call father
	public Minus() {
    	super();
    }
	//calling father's method
	public Minus(Node l, Node r) {
		super(l, r);
	}
    // returning it's value
	public double eval() {
		return lChild.eval() - rChild.eval();
	}
	//get printed
	public String toString() {
		return "(" + lChild.toString() + " -" + rChild.toString() + ")";
	}
	 public double eval(double [] data) {
		 // return the difference of the two nodes
	        return lChild.eval(data) - rChild.eval(data);
	 }
}
