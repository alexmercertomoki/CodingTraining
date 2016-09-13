package com.h63;

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
	//Simiar to the 6-1
	static int numIndepVars = 3;
    static int maxDepth = 5;
    static Random rand = new Random();
    static double a;
    public static void main(String[] args) {
        double[] data = {3.14, 2.78, 1.0};
        Node[] ops = {new Plus(), new Minus(), new Multiply(), new Division()};
        try {
        	//I got bugs in the past file so have to catch
			OperatorFactory o = new OperatorFactory(ops);
			TerminalFactory t = new TerminalFactory(numIndepVars);
			//get GPtree 
			GPTree gpt = new GPTree(o, t, maxDepth, rand);
			a=gpt.eval(data);
			System.out.println(a);
			System.out.println(gpt + " = " + gpt.eval(data));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("It just happens, sadly T-T  BUGS...Keep on trying it for 5 times, it will be fine sometimes > <");
		}
    }

}
