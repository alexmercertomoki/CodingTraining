package com.h71;

/*
This file: TerminalFactory.java
Programmer: Bilei Huang (bhuang@andrew.cmu.edu)
Course/Section: 95-712
Assignment:  Generate a random tree.
Description: Adding kids to the operator
Last Modified: 10/23/2014
Known Bugs: No bugs at present.
Compiler: JDK 1.6
*/

import java.util.*;

public class TerminalFactory {
	//the number of independent variable which we get in the main to get the variable or the constant 
	//between 0-1
	private int nIdV;
    //get the indepent variable number
	public TerminalFactory(int n) {
		nIdV = n;
	}
    // get the terminals which are digits
	public Node getTerminal(Random r) {
        // get from (this time : 0-3)
		int i = r.nextInt(nIdV+1);
		//create a new node 
		Node o;
		// if it is from 0-2
		if (i < nIdV) {
		    //initiate a new variable
			o = new Variable(i);
		} else
			//initiate a new constant
			o = new Const(r.nextDouble());
		// return the node
		return o;
	}
    //getter for independent variable range(3 this time)
	public int getNumIndepVars() {
		return nIdV;
	}
}