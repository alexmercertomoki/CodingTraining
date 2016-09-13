package com.cmu.glyphtest.cool;

abstract class Glyph {
	abstract void draw(); 
	
	Glyph() {
		
		System.out.println("Glyph() before draw"); 
		
		draw();
		
		System.out.println("Glyph() after draw");
	
	} 
	
}	