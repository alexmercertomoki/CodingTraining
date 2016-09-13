package com.cmu.test3;

public class Division extends Binop {
	public Division(Node l, Node r) {
		super(l, r);
	}

	public double eval() {
		return lChild.eval() / rChild.eval();
	}	
	public String toString(){
    	
    	return "/";
    	
    }
}
