package cmu.home2test;

import java.util.Random;

public class Variable extends Node {
	// the index of variable 
	int index;

	public Variable(int i) {
		index = i;
	}

	public double eval(double[] data) {
		return data[index];
	}

	public String toString() {// print as string
		String str = "X" + index;
		return str;
	}

	public void addRandomKids(OperatorFactory o, TerminalFactory t,
			int maxDepth, Random rand) {
	}
}