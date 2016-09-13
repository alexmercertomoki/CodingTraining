package cmu.home2test;

// Plus is the '+' Operator
public class Plus extends Binop {
public Plus() {
    	super();
    }
public Plus(Node l, Node r) {
        super(l, r);
    }
    
    public double eval(double [] data) {
        return lChild.eval(data) + rChild.eval(data);// return the sum of two node
    }
    public String toString(){
    	String str = "(" + lChild.toString() + "+" + rChild.toString() + ")";// print as a format of "(1+2)"
    	return str;
    }
}