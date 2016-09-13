package com.h71;

/*
This file: Plus.java
Programmer: Bilei Huang (bhuang@andrew.cmu.edu)
Course/Section: 95-712
Assignment: Generate a random tree.
Description: Plus is a kind of node which refers to Plus calculation
Last Modified: 10/23/2014
Known Bugs: No bugs at present.
Compiler: JDK 1.6
*/
public class Plus extends Binop {
	//null parameter
	public Plus() {
    	super();
    }
	//calling father's method
	public Plus(Node l, Node r) {
		super(l, r);
	}
    //returning its value
	public double eval() {
		return lChild.eval() + rChild.eval();
	}
	
	//get printed
	public String toString() {
		return "(" + lChild.toString() + " + " + rChild.toString() + ")";
	}
	
}
