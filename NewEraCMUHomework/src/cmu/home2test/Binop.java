package cmu.home2test;

import java.util.*;

public abstract class Binop extends Node {
	protected Node lChild, rChild;

	public Binop() {
		depth = 0;
		lChild = null;
		rChild = null;
	}

	public Binop(Node l, Node r) {
		lChild = l;
		rChild = r;
		depth = 0;
	}

	public void addRandomKids(OperatorFactory o, TerminalFactory t,
			int maxDepth, Random rand) {
		if (depth < maxDepth - 1) {
			int m = rand.nextInt(o.getNumOps() + t.getNumIndepVars()); 
			if (m < o.getNumOps()) {
				setChild(o.getOperator(rand), 1);
				lChild.addRandomKids(o, t, maxDepth, rand);
			} else {
				setChild(t.getTerminal(rand), 1);
			}
			m = rand.nextInt(o.getNumOps() + t.getNumIndepVars()); 
			if (m < o.getNumOps()) {
				setChild(o.getOperator(rand), 2);
				rChild.addRandomKids(o, t, maxDepth, rand);
			} else {
				setChild(t.getTerminal(rand), 2);
			}
		}

	}

	public void setChild(Node n, int position) { 
		
		if (position == 1) {
			lChild = n;
			lChild.depth = depth + 1;
		}
		if (position == 2) {
			rChild = n;
			rChild.depth = depth + 1;
		}
	}
}
