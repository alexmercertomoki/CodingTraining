package homework61;

import java.util.Random;
/*
This file: Node.java
Programmer: Bilei Huang (bhuang@andrew.cmu.edu)
Course/Section: 95-712
Assignment: Generate a random tree.
Description: node is a "leaf" in the tree
Last Modified: 10/23/2014
Known Bugs: No bugs at present.
Compiler: JDK 1.6
*/


public abstract class Node  implements Cloneable{
	//depth of the node
	int depth;
	// for the value to be calculated implemented in kid node
	public abstract double eval(double[] data);
	//adding kids
	public abstract void addRandomKids(OperatorFactory o, TerminalFactory t, int maxDepth, Random r);
	
	//constructor of node without doing anything
    public Node() {
    	
    }
    //return an error message
    public double eval() {
        System.out.println("Error: eval Node");
        return 0;
    }
    
    //the Clone method
    public Object clone() {
		Object o = null;
		//clone the object
		try {
			o = super.clone();
		} 
		//if can't be cloned
		catch (CloneNotSupportedException e) {
			System.out.println("Node can't be cloned");
		}
		return o;
	}
    
	
}
