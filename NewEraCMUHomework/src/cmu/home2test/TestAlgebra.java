package cmu.home2test;

import java.util.*;

//provided by Steve
public class TestAlgebra {
	static int numIndepVars = 3;
	static int maxDepth = 5;
	static Random rand = new Random();

	public static void main(String[] args) {
		double[] data = new double[3];
		data[0] = 3.14;
		data[1] = 2.78;
		data[2] = 1.0;
		Node[] ops = { new Plus(), new Minus(), new Multiply(), new Division() };
		OperatorFactory o = new OperatorFactory(ops);
		TerminalFactory t = new TerminalFactory(numIndepVars);
		Node root = o.getOperator(rand);
		root.addRandomKids(o, t, maxDepth, rand);
		String s = root.toString();
		System.out.println(s + " = " + root.eval(data));
	}
}