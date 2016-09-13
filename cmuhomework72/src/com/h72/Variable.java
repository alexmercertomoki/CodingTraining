package com.h72;

import java.util.Random;


/*
This file: Variable.java
Programmer: Bilei Huang (bhuang@andrew.cmu.edu)
Course/Section: 95-712
Assignment: this is a variable node which chooses one data from the dataset
Description: variable is a kind of node which refers to a constant
Last Modified: 10/16/2014
Known Bugs: No bugs at present.
Compiler: JDK 1.6
*/


public class Variable extends Node {
	//the index of variable 
	int idx;
    //set the index of the variable
	public Variable(int i) {
		idx = i;
	}
    // return the value of the variable 
	public double eval(double[] data) {
		return data[idx];
	}
    
	// if get printed 
	public String toString() {
		String s = "X" + idx;
		return s;
	}
    // nothing in the addrandomkids, it is a KID 
	public void addRandomKids(OperatorFactory o, TerminalFactory t,int maxDepth, Random rand) {
	}
	
	//return the depth
	@Override
	public int mySize() {
		// TODO Auto-generated method stub
		return depth ;
	}
}
