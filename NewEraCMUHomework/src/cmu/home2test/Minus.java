package cmu.home2test;

public class Minus extends Binop {
public Minus() {
    	super();
    }
public Minus(Node l, Node r) {
        super(l, r);
    }
    public double eval(double [] data) {// return the difference of the two nodes
        return lChild.eval(data) - rChild.eval(data);
    }
    public String toString(){//print as string
    	String str = "(" + lChild.toString() + "-" + rChild.toString() + ")";
    	return str;
    }
}
