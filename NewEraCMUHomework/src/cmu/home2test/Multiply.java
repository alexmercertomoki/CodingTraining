package cmu.home2test;

public class Multiply extends Binop {
public Multiply() {
    	super();
    }
public Multiply(Node l, Node r) {
        super(l, r);
    }
    
    public double eval(double [] data) {
        return lChild.eval(data) * rChild.eval(data);
    }
    public String toString(){
    	String str = "(" + lChild.toString() + "*" + rChild.toString() + ")";
    	return str;
    }
}