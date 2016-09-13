package com.cmu.glyphtest.cool;

class RoundGlyph extends Glyph {
	int radius = 1;
	
	
	
	RoundGlyph(int r) {
	System.out.println("RoundGlyph(), radius="+ radius); 
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
		}
	}
