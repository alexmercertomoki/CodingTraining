package com.cmu.calculates1;

public class Plus extends Binop {
	
	public Plus(Node l, Node r) {
		super(l, r);
	}

	public double eval() {
		return lChild.eval() + rChild.eval();
	}
	
	
	public String toString() {
		return "(" + lChild.toString() + " + " + rChild.toString() + ")";
	}
	
}
