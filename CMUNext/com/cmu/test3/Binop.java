package com.cmu.test3;

public class Binop extends Node {
	protected Node lChild, rChild;

	public Binop(Node l, Node r) {
		lChild = l;
		rChild = r;
	}
}