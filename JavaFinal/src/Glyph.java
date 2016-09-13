

class Glyph {
	void draw() {}
	Glyph() {
		System.out.println("before");
		draw();
		System.out.println("after");
	 }
}
