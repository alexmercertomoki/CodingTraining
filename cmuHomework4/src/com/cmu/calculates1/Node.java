package com.cmu.calculates1;
/*
This file: Node.java
Programmer: Bilei Huang (bhuang@andrew.cmu.edu)
Course/Section: 95-712
Assignment: recursive formula maker which makes 5 caculations using tree structure
Description: node is a "leaf" in the tree
Last Modified: 10/2/2014
Known Bugs: No bugs at present.
Compiler: JDK 1.6
*/

public abstract class Node {
	//constructor of node without doing anything
    public Node() {
    	
    }
    //return an error message
    public double eval() {
        System.out.println("Error: eval Node");
        return 0;
    }
}
