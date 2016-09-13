package com.cmu.glyphtest.cool.copy;

class RoundGlyph extends Glyph {
	int radius = 1;
	
	RoundGlyph(){
		System.out.println("RoundGlyph(), radius="+ radius); 
	}

	RoundGlyph(int r) {
		radius = r;
		System.out.println("RoundGlyph(), radius="+ radius); 
	}
	void draw() {
		System.out.println("RoundGlyph.draw(), radius=" + radius);
	}
}

public  class GlyphTest {
	public static void main(String[] args) {
		
		new RoundGlyph(5); 
		new RoundGlyph(); 
		
		
	}
}
