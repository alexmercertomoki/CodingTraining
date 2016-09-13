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
 * Leaf node that holds a constant value for operation
 * 
 * @author Yixin Wan
 *
 */
public class Const extends Node {
	
	private double value;
	
	/**
	 * Constructor to initialize the constant value for operation
	 * 
	 * @param d constant value
	 */
	public Const(double d) {
		value = d;
	}
	
	public double eval() {
		return value;
	}
	
	public String toString() {
		return "" + value;
	}
}
