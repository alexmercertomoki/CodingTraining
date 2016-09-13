package cmu.home2test;

import java.util.*;

public class TerminalFactory {
	private int numIndepVars;

	public TerminalFactory(int n) {
		numIndepVars = n;
	}

	public Node getTerminal(Random rand) {

		int i = rand.nextInt(numIndepVars+1);
		Node o;
		if (i < numIndepVars) {
			o = new Variable(i);
		} else
			o = new Const(rand.nextDouble());
		return o;
	}

	public int getNumIndepVars() {
		return numIndepVars;
	}
}