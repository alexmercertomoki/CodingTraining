package com.h71;

import java.util.Random;
/*
This file: Const.java
Programmer: Bilei Huang (bhuang@andrew.cmu.edu)
Course/Section: 95-712
Assignment: Generate a random tree.
Description:Const is a kind of node which refers to a constant
Last Modified:10/23/2014
Known Bugs: No bugs at present.
Compiler: JDK 1.6
*/

public class Const extends Node {
	//the value of the constant
	private double value;
    //initiation 
	public Const(double d) {
		value = d;
	}
	//default 0
	public Const() {
		value = 0;
	}
    //returning its own value
	public double eval() {
		return value;
	}
	//get printed 
	public String toString(){
		return value+"";
		
	}
	//nothing in the addrandom kids it is a KID
	@Override
	public void addRandomKids(OperatorFactory o, TerminalFactory t,
			int maxDepth, Random r) {
		// TODO Auto-generated method stub
		
	}
	//return value
	public double eval(double [] data) { 
		return value; 
	
	}
	//return the depth
	@Override
	public int mySize() {
		return depth;
		// TODO Auto-generated method stub
		
	}
}
