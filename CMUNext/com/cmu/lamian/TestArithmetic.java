package com.cmu.lamian;



import java.util.Random;

public class TestArithmetic {
	
	static Random random = new Random();
	
	public static void main(String[] args) {
		
		for (int i = 0; i < 5; i++) {
			Node n = randOperator( randOperator( randConstant(), randConstant() ), randOperator( randConstant(), randConstant() ) );
			printResult(n);
		}
		
		
//		Node node2 = new Divide(randConstant(), new Const(0));
//		System.out.println(node2.eval());
	}
	
	
	public static Binop randOperator(Node l, Node r) {
		int operator = random.nextInt(4);
		switch (operator) {
		case 0:
			return new Plus(l, r);
		case 1:
			return new Minus(l, r);
		case 2:
			return new Mult(l, r);
		case 3:
			return new Divide(l, r);
		default:
			return null;
		}
	}
	
	public static Node randConstant() {
		int constant = random.nextInt(20) + 1; // generate constant integers randomly in the range from 1 to 20
		return new Const(constant);
	}
	
	public static void printResult(Node node) {
		
		
		double result = node.eval();
		int round = (int) (result * 10);
		
		if (result * 10 - (double) round != 0) {
			System.out.print(node.toString() + " = " );
			System.out.printf( "%.2f", node.eval() );
			System.out.println();
		} else {
			System.out.print(node.toString() + " = " );
			System.out.printf( "%.1f", node.eval() );
			System.out.println();		
		}
		
	}
	
}
