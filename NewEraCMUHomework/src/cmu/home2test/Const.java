package cmu.home2test;

import java.util.*;

public class Const extends Node {
    private double value;
    public Const(double d) { value = d; }
    public double eval(double [] data) { return value; 
    	}
    
    public String toString(){
    	String str = "" + value;
    	return str;
    	}
    public void addRandomKids (OperatorFactory o, TerminalFactory t, int maxDepth, Random rand){}
 
}