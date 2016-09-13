package com.cmu.calculates1;

public class Division extends Binop {
	public Division(Node l, Node r) {
		super(l, r);
	}

	public double eval() {
		return lChild.eval() / rChild.eval();
	}	
	
	public String toString() {
		return "(" + lChild.toString() + " / " + rChild.toString() + ")";
	}
}
