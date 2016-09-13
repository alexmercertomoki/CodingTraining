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

/**
 * @author Yixin Wan
 *
 */
public class Binop extends Node {
	
	protected Node lChild, rChild;

	/**
	 * @param l
	 * @param r
	 */
	public Binop(Node l, Node r) {
		lChild = l;
		rChild = r;
	}
	
	
}
