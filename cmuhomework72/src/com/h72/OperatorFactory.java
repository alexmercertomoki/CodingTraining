package com.h72;

/*
This file: OperatorFactory.java
Programmer: Bilei Huang (bhuang@andrew.cmu.edu)
Course/Section: 95-712
Assignment: form a tree randomly 
Description: Operator is how we generate an operator(+  -  *  / )
Last Modified: 10/23/2014
Known Bugs: No bugs at present.
Compiler: JDK 1.6
*/


import java.util.*;
//Generating operator
public class OperatorFactory {
	//node we have 
	private Node[] currentOps;
	// constructor get the current operators 
	OperatorFactory (Node [] n){ 
				currentOps = n;
			}
     		
			public Node getOperator(Random r) { 
				//randomly choose from 0-3 to get operator
				Node operator = currentOps[r.nextInt(4)];
				//clone one and return.
		    	return (Node)operator.clone();
			}
			
            //get the number of operators
			public int getNumOps() { 
				return currentOps.length;
			}

}

