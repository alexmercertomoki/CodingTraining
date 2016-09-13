package com.h71;
/*
This file: Multiply.java
Programmer: Bilei Huang (bhuang@andrew.cmu.edu)
Course/Section: 95-712
Assignment: Generate a random tree.
Description: Multiply is a kind of node which refers to Multiply calculation
Last Modified: 10/23/2014
Known Bugs: No bugs at present.
Compiler: JDK 1.6
*/
public class Multiply extends Binop {
	//call father
	public Multiply() {
    	super();
    }
	//calling father's method
	public Multiply(Node l, Node r) {
		super(l, r);
	}
    //getting its value 
	public double eval() {
		return lChild.eval() * rChild.eval();
	}
	//get printed
	public String toString() {
		return "(" + lChild.toString() + " * " + rChild.toString() + ")";
	}
	
	 public double eval(double [] data) {
	        return lChild.eval(data) * rChild.eval(data);
	 }
}
