package com.h63;

/*
This file: Division.java
Programmer: Bilei Huang (bhuang@andrew.cmu.edu)
Course/Section: 95-712
Assignment: Generate a random tree.
Description:Division is a kind of node which refers to divide calculation
Last Modified: 10/23/2014
Known Bugs: No bugs at present.
Compiler: JDK 1.6
*/

public class Division extends Binop {
	//call fater
	public Division() {
    	super();
    }
	
	//calling the father's method
	public Division(Node l, Node r) {
		super(l, r);
	}
    // returning it's value
	public double eval() {
		return lChild.eval() / rChild.eval();
	}	
	//print out its value
	public String toString() {
		return "(" + lChild.toString() + " / " + rChild.toString() + ")";
	}
	
	 public double eval(double [] data) {
	    	if (rChild.eval(data) == 0 ){
	    	System.out.println("Error");
	    	}
	    	return lChild.eval(data) / rChild.eval(data);
	 }
}
