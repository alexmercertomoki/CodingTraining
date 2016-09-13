package com.cmuHomework3;

	/*
	This file: TestFraction
	Programmer: Bilei Huang (bhuang@andrew.cmu.edu)
	Course/Section: 95-712
	Assignment: Something to calculate  fractions
	Description: Enter Frations they can add together or change to decimal or output
	Last Modified: 9/18/2014
	Known Bugs: No bugs at present.
	Compiler: JDK 1.6
	*/

public class TestFraction {
	//Tests given
	public static void main(String[] args) {
	Fraction f1 = new Fraction();
	Fraction f2 = new Fraction(1, 1);
	Fraction f3 = new Fraction(3, 6);

	System.out.println("f1 = " + f1);
	System.out.println("f2 = " + f2);
	System.out.println("f3 = " + f3);
	System.out.println("f1 + f2 = " +     f1.add(f2));
	System.out.println("f2 in decimal is: " + f2.toDecimal());
	
	   }
    }
