package cmu.home2test;

import java.util.*;

public abstract class Node implements Cloneable {
	protected int depth;

	public abstract double eval(double[] data);

	public abstract void addRandomKids(OperatorFactory o, TerminalFactory t, int maxDepth, Random r);

	public Object clone() {
		Object o = null;
		try {
			o = super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("Node can't be cloned");
		}
		return o;
	}
}