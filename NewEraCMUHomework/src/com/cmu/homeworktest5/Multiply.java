package com.cmu.homeworktest5;
/*
This file: Multiply.java
Programmer: Bilei Huang (bhuang@andrew.cmu.edu)
Course/Section: 95-712
Assignment: recursive formula maker which makes 5 caculations using tree structure
Description: Multiply is a kind of node which refers to Multiply calculation
Last Modified: 10/16/2014
Known Bugs: No bugs at present.
Compiler: JDK 1.6
*/
public class Multiply extends Binop {
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
}
