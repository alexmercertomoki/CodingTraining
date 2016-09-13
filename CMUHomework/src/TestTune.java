
class Tune {
	Tune() {
		System.out.println("hello tune");
	}

	public void play() {
		System.out.println("Tune.play()");
	}
}

class ObnoxiousTune extends Tune {

	ObnoxiousTune() {
	}

	public void play() {
		System.out.println("ObnoxiousTune.play()");
	}
}
public class TestTune{
public static void main(String[] args) { 
	
	
	Tune t1 = new Tune();
    Tune t2 = new ObnoxiousTune(); 
    t1.play(); 
    t2.play();
    
  }
}