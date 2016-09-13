package com.cmu.homeworktest5;

/*
This file: Variable.java
Programmer: Bilei Huang (bhuang@andrew.cmu.edu)
Course/Section: 95-712
Assignment: this is a variable node which chooses one data from the dataset
Description: variable is a kind of node which refers to a constant
Last Modified: 10/16/2014
Known Bugs: No bugs at present.
Compiler: JDK 1.6
*/


public class Variable extends Node {
	//the value of the dataset and the value it refers to
	private double value;
	private double data[];
    //initiation 
	public Variable(double i[]) {
		data=i;
		int con = (int) (Math.random()*3);
		
		switch (con) {
		case 0:
			value=data[0];
			break;
		case 1:
			value=data[1];
			break;
		case 2:
			value=data[2];
			break;
		}
	}
	
    //returning its own value
	public double eval() {
		return value;
	}
	//get printed (x0 to x2)
	public String toString(){
		if(value==data[0])
		return "X0";
		if(value==data[1])
		return "x1";
		if(value==data[2])
		return "x2";
		else 
		return "";
		
	}
}
