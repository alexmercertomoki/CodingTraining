
class RGlyph extends Glyph {
	int r = 1;
	Integer ii = new Integer(5);
	
	void draw() {
		System.out.println("draw():" + r+":" + ii);
	}
	
	RGlyph(int r) {
		System.out.println("1r=" + this.r);
		this.r = r;
		System.out.println("2r=" + this.r);
		System.out.println("ii="+ii);
	}
}
