package com.cmu.glyphtest.cool.copy;

abstract class Glyph {
	abstract void draw(); 
	
	Glyph() {
		
		System.out.println("Glyph() before draw"); 
		
		draw();
		
		System.out.println("Glyph() after draw");
	
	} 
	
}	