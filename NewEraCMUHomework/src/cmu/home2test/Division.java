package cmu.home2test;

// Division is the '/' Operator
public class Division extends Binop {
public Division() {
    	super();
    }
public Division (Node l, Node r) {
        super(l, r);
    }
     
    public double eval(double [] data) {
    	if (rChild.eval(data) == 0 ){
    	System.out.println("Error");
    	}
    	return lChild.eval(data) / rChild.eval(data);
    }
    public String toString(){
    	String str = "(" + lChild.toString() + "/" + rChild.toString() + ")";
    	return str;
    }
}