package com.cmu.homeworktest5;

/*
This file: Division.java
Programmer: Bilei Huang (bhuang@andrew.cmu.edu)
Course/Section: 95-712
Assignment: recursive formula maker which makes 5 caculations using tree structure
Description:Division is a kind of node which refers to divide calculation
Last Modified: 10/16/2014
Known Bugs: No bugs at present.
Compiler: JDK 1.6
*/

public class Division extends Binop {
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
}
