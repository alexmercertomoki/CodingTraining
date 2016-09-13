package com.cmu.calculates1;

/*
This file: Binop.java
Programmer: Bilei Huang (bhuang@andrew.cmu.edu)
Course/Section: 95-712
Assignment: recursive formula maker which makes 5 caculations using tree structure
Description:binop is a kind of node which refers to a kind of calculation
Last Modified: 10/2/2014
Known Bugs: No bugs at present.
Compiler: JDK 1.6
*/

public class Binop extends Node {
	// the left branch and the right branch of the tree
	protected Node lChild, rChild;
	
    //adding the branch when initiated
	public Binop(Node l, Node r) {
		lChild = l;
		rChild = r;
	}
}