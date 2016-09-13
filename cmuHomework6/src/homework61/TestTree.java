package homework61;

/*
This file: Test.java
Programmer: Bilei Huang(Code is given by Steve) (bhuang@andrew.cmu.edu)
Course/Section: 95-712
Assignment: get a tree which randomly calculates
Description: variable is a kind of node which refers to a constant
Last Modified: 10/23/2014
Known Bugs: Serious bug: ABOUT 70% of the times it gets null pointerException which is still not handled yet,other times it works fine
and also the result is a bit strange.
Compiler: JDK 1.6
*/

import java.util.Random;


// *Citation:This code is mainly given by Steve, if this is Cheating (>.<) expel him too ^-^
public class TestTree {
	//0-2 is variable, 3 is constant
	static int numIndepVars = 3;
	//maxDepth  of the tree 
	static int maxDepth = 5;
	//random seed 
	static Random rand = new Random();
    //main
	public static void main(String[] args) {
		//set the new set of data
		double[] data = new double[3];
		data[0] = 3.14;
		data[1] = 2.78;
		data[2] = 1.0;
		//create a new node array
		Node[] ops = { new Plus(), new Minus(), new Multiply(), new Division() };
		//generating operators and terminals(consts or variables)
		OperatorFactory o = new OperatorFactory(ops);
		TerminalFactory t = new TerminalFactory(numIndepVars);
		//root of a tree
		Node root = o.getOperator(rand);
		//add leaves 
		root.addRandomKids(o, t, maxDepth, rand);
		
		//print out ..
		//Sorry for the bug, Just show me some mercy
		try {
			//set it to a string 
			String s = root.toString();
			System.out.println(s + " = ");
			System.out.printf("%.2f\n",root.eval(data));
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			System.out.println("It just happens, sadly T-T  BUGS...Keep on trying it for 5 times, it will be fine sometimes > <");
		}
	}
}
