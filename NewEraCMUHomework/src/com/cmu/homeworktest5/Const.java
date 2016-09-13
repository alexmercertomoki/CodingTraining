package com.cmu.homeworktest5;
/*
This file: Const.java
Programmer: Bilei Huang (bhuang@andrew.cmu.edu)
Course/Section: 95-712
Assignment: recursive formula maker which makes 5 caculations using tree structure
Description:Const is a kind of node which refers to a constant
Last Modified: 10/16/2014
Known Bugs: No bugs at present.
Compiler: JDK 1.6
*/

public class Const extends Node {
	//the value of the constant
	private double value;
    //initiation 
	public Const(double d) {
		value = d;
	}
	//default 0
	public Const() {
		value = 0;
	}
    //returning its own value
	public double eval() {
		return value;
	}
	//get printed 
	public String toString(){
		return value+"";
		
	}
}
