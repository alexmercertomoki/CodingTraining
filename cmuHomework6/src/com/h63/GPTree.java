package com.h63;

/*
This file: GPTree.java
Programmer: Bilei Huang(provided by professor) (bhuang@andrew.cmu.edu)
Course/Section: 95-712
Assignment: Generate a random tree.
Description:Const is a kind of node which refers to a constant
Last Modified:10/23/2014
Known Bugs: No bugs at present.
Compiler: JDK 1.6
*/
import java.util.Random;

//GP Tree provided by professor Steve
	public class GPTree {
		//define a root
	    private Node root;
	    //size
	    private int mySize;
	    //set root to null
	    GPTree() { root = null; }
	    //adding kids generating the tree
	    GPTree(OperatorFactory o, TerminalFactory t, int maxDepth, Random rand) {
	        root = o.getOperator(rand);
	        root.addRandomKids(o, t, maxDepth, rand);
	    }
	    //print method
	    public String toString() { return root.toString(); }
	    //return value
	    public double eval(double[] data) { return root.eval(data); }
	    
	    public int mySize() { 
	    	return root.mySize();
	    }
	}


