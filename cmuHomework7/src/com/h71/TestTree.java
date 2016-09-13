package com.h71;

/*
 This file: Test.java
 Programmer: Bilei Huang(Code is given by Steve) (bhuang@andrew.cmu.edu)
 Course/Section: 95-712
 Assignment: get fitness of a tree
 Description:  get a tree and print its fitness
 Last Modified: 10/24/2014
 Known Bugs: minor bugs
 and also the result is a bit strange.
 Compiler: JDK 1.6
 */

import java.util.*;


public class TestTree {
	// number of variables and depth and random
	static int numIndepVars;
	static int maxDepth = 2;
	static Random rand = new Random();
 
	public static void main(String[] args) {
		//data of x 
		double[] data = null;
		//data of y
		double y;
        //two lists to hold x and y
		LinkedList<double[]> ltreeVariabledata = new LinkedList<double[]>();
		LinkedList<Double> ltyvariable = new LinkedList<Double>();
		//get value from the file 
		double ydata;
        // operators 
		Node[] ops = { new Plus(), new Minus(), new Multiply(), new Division() };
		DataSet ds = new DataSet("data.txt");
		DataRow drm = new DataRow();
        //number of independent variables
		numIndepVars = ds.NumIndepentVar;
        //get data in the  dataset
		Iterator<DataRow> itr = ds.da.iterator();
        // get data
		while (itr.hasNext()) {
			drm = itr.next();
			data = drm.x;
			ydata = drm.y;
			ltreeVariabledata.add(data);
			ltyvariable.add(ydata);
		
		}
        //factories
		OperatorFactory o = new OperatorFactory(ops);
		TerminalFactory t = new TerminalFactory(numIndepVars);
		// get GPtree
		GPTree gpt = new GPTree(o, t, maxDepth, rand);
		//print tree
		System.out.println(gpt);
		//print fitness
		System.out.println(new Fitness(gpt, ltreeVariabledata, ltyvariable));

	}

}
