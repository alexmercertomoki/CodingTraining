package com.cmu.lamian;

/**
 * This file: 
 * Programmer: Yixin Wan (yixinw@andrew.cmu.edu)
 * Course/Section: 95-712 A
 * Assignment: 
 * Description: 
 * Method:
 * Further details: 
 * Last Modified: mm/dd/yyyy
 * Known Bugs: 
 * Compiler: Eclipse Standard Luna (4.4) 
 */

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
