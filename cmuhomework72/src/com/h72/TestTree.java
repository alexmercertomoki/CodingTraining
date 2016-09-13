package com.h72;

/*
 This file: TestTree.java
 Programmer: Bilei Huang(Code is given by Steve) (bhuang@andrew.cmu.edu)
 Course/Section: 95-712
 Assignment: get a tree which randomly calculates
 Description: variable is a kind of node which refers to a constant
 Last Modified: 10/23/2014
 Known Bugs: minor bugs there is 
 and also the result is a bit strange.
 Compiler: JDK 1.6
 */

import java.util.*;


public class TestTree {
    //tree number depth and random seed
	static int treeNum=500;
	static int maxDepth = 2;
	static Random rand = new Random();
	// I used split() to get rid of the space so make sure the data is correctly formated with  one space between x and y
	static DataSet ds = new DataSet("data.txt");
	
	public static void main(String[] args) {
	// fours kinds of operator nodes
	Node[] ops = { new Plus(), new Minus(), new Multiply(), new Division() };
	//number of independent variables get from data.txt
	int numIndepVars = ds.NumIndepentVar;
	//operator factory and terminal factory 
	OperatorFactory o = new OperatorFactory(ops);
	TerminalFactory t = new TerminalFactory(numIndepVars);
	// generation of 500 trees 
	Generation g1=new Generation(treeNum,o,t, maxDepth,rand);
	//get all the trees and the best tree
	g1.printGeneration();
	g1.printBestTree();
	
	}
	

}
