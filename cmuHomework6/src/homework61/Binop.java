package homework61;

import java.util.Random;

/*
This file: Binop.java
Programmer: Bilei Huang (bhuang@andrew.cmu.edu)
Course/Section: 95-712
Assignment: Generate a random tree.
Description:binop is a kind of node which refers to a kind of calculation
Last Modified: 10/23/2014
Known Bugs: No bugs at present.
Compiler: JDK 1.6
*/


public class Binop extends Node {
	
	// the left branch and the right branch of the tree
	protected Node lChild, rChild;
	// when the parameter is null set the children to null
	public Binop() {
		depth = 0;
		lChild = null;
		rChild = null;
	}
	
	
	
    //adding the branch when initiated
	public Binop(Node l, Node r) {
		lChild = l;
		rChild = r;
	}
	
	//add  random kids
	public void addRandomKids(OperatorFactory o, TerminalFactory t, int maxDepth, Random rand) {
		//if the depth is not the max 
		if (depth < maxDepth - 1) {
			//we get from 0 to the number of all nodes using random
			int m = rand.nextInt(o.getNumOps() + t.getNumIndepVars()); 
			// if m is less than  number of operators
			if (m < o.getNumOps()) {
				//set operators first on the left
				setChild(o.getOperator(rand), 1);
				//add child afterwards 
				lChild.addRandomKids(o, t, maxDepth, rand);
			} 
			//else we add a terminal on the left
			else {
				setChild(t.getTerminal(rand), 1);
			}
			//we get from 0 to the number of all nodes using random
			m = rand.nextInt(o.getNumOps() + t.getNumIndepVars()); 
			// if m is less than  number of operators 
			if (m < o.getNumOps()) {
				//set right child
				setChild(o.getOperator(rand), 2);
				//add kids later
				rChild.addRandomKids(o, t, maxDepth, rand);
			} 
			//set terminal nodes afterwards
			else {
				setChild(t.getTerminal(rand), 2);
			}
		}

	}
    //setter for setting Children
	public void setChild(Node n, int p) { 
		//left child
		if (p == 1) {
			lChild = n;
			lChild.depth = depth + 1;
		}
		//right child
		if (p == 2) {
			rChild = n;
			rChild.depth = depth + 1;
		}
	}
    
	@Override
	public double eval(double[] data) {
		// TODO Auto-generated method stub
		return 0;
	}
}