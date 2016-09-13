package com.cmu.calculates1;

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
