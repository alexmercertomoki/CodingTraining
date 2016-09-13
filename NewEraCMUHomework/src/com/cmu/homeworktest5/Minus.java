package com.cmu.homeworktest5;

/*
This file: Minus.java
Programmer: Bilei Huang (bhuang@andrew.cmu.edu)
Course/Section: 95-712
Assignment: recursive formula maker which makes 5 caculations using tree structure
Description:Minus is a kind of node which refers to Minus calculation
Last Modified: 10/16/2014
Known Bugs: No bugs at present.
Compiler: JDK 1.6
*/


public class Minus extends Binop {
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
}
