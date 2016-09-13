package com.h71;

/*
This file: DataRow.java
Programmer: Bilei Huang (bhuang@andrew.cmu.edu)
Course/Section: 95-712
Assignment: Generate a random tree and calculate the fitness
Description: a row of data 
Last Modified: 10/30/2014
Known Bugs: No bugs at present.
Compiler: JDK 1.6
*/

public class DataRow {
    //get row of data from the file which is a y and an array of x
	double y;
    double[] x;
    
    //get y
	public Double getY() {
		return y;
	}
	//setter of y
	public void setY(Double y) {
		this.y = y;
	}
	//getter of x
	public double[] getX() {
		return x;
	}
	//setter of x
	public void setX(double[] x) {
		this.x = x;
	}
	
	//constructor
	public DataRow(double y, double[] x) {
		super();
		this.y = y;
		this.x = x;
	}
	public DataRow() {
	
		
	}
	
	
}
