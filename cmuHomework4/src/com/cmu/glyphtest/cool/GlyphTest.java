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

class RoundGlyph extends Glyph {
	int radius = 1;
	
    //if no parameter 
	RoundGlyph(){
		//if no parameter the radius should be 1
		System.out.println("RoundGlyph(), radius="+ radius); 
	}
	//r initiated with a parameter
	RoundGlyph(int r) {
	//here: the radius should be 1: we print it out
	System.out.println("RoundGlyph(), radius="+ radius); 
	radius = r;
	//radius == 5 printed out
	System.out.println("RoundGlyph(), radius="+ radius); 
	}
	//draw method shows the radius
    void draw() {
	System.out.println("RoundGlyph.draw(), radius=" + radius);
	}
}

    public  class GlyphTest {
	public static void main(String[] args) {
		//one without parameter and one with parameter we test the program
		new RoundGlyph(); 
		new RoundGlyph(5); 
		
		}
	}
