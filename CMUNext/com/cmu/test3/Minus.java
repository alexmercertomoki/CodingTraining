package com.cmu.test3;

public class Minus extends Binop {
	public Minus(Node l, Node r) {
		super(l, r);
	}

	public double eval() {
		return lChild.eval() - rChild.eval();
	}
	public String toString(){
    	
    	return "-";
    	
    }
}
