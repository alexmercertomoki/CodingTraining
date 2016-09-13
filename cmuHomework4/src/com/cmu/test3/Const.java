package com.cmu.test3;

/*
This file: Const.java
Programmer: Bilei Huang (bhuang@andrew.cmu.edu)
Course/Section: 95-712
Assignment: recursive formula maker which makes 5 caculations using tree structure
Description:Const is a kind of node which refers to a constant
Last Modified: 10/2/2014
Known Bugs: No bugs at present.
Compiler: JDK 1.6
*/
public class Const extends Node {
	private double value;

	public Const(double d) {
		value = d;
	}
	public Const() {
		value = 0;
	}

	public double eval() {
		return value;
	}
	public String toString(){
		return value+"";
		//return String.valueOf(value);
	}
}
