package com.cmu.glyphtest.cool;

/*
This file: Glyph.java
Programmer: Bilei Huang (bhuang@andrew.cmu.edu)
Course/Section: 95-712
Assignment: test whether there is a certain moment radius == 1
Description: Minus is a kind of node which refers to Minus calculation
Last Modified: 10/2/2014
Known Bugs: No bugs at present.
Compiler: JDK 1.6
*/

abstract class Glyph {
	//draw implemented in subclass
	abstract void draw(); 
	//constructor of Glyph
	Glyph() {
		
		System.out.println("Glyph() before draw"); 
		
		draw();
		
		System.out.println("Glyph() after draw");
	
	} 
	
}	