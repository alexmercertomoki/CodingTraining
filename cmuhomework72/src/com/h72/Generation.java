package com.h72;

/*
This file: Generation.java
Programmer: Bilei Huang(Code is basically given by Steve) (bhuang@andrew.cmu.edu)
Course/Section: 95-712
Assignment: get a tree which randomly calculates and fitness
Description: generate trees
Last Modified: 10/30/2014
Known Bugs: Serious bug: ABOUT 70% of the times it gets null pointerException which is still not handled yet,other times it works fine
and also the result is a bit strange.
Compiler: JDK 1.6
*/

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

/** A container of GPTrees. */

public class Generation {
	//number of trees tree population and fitness number 
    private int numTrees;
    private GPTree[] population;
    private double[] fitness;

    //constructor to get all the trees and store them in 
    Generation(int numTrees, OperatorFactory o, TerminalFactory t, int m, Random r) {
        this.numTrees = numTrees;
        population = new GPTree[numTrees];
        fitness = new double[numTrees];
        for (int i = 0; i < numTrees; i++)
        population[i] = new GPTree(o, t, m, r);
    }
    Generation(int n) {
        numTrees = n;
        population = new GPTree[numTrees];
        fitness = new double[numTrees];
    }


    /** Evaluate each tree in this generation, and set each tree's fitness value. */
    //evaluation 
    public void evalAll(DataSet theDs) {
    	//using linked list to get data
    	LinkedList<double[]> ltreeVariabledata = new LinkedList<double[]>();
		LinkedList<Double> ltyvariable = new LinkedList<Double>();
		double xdata[];	
		double ydata; 
		Iterator<DataRow> itr = theDs.da.iterator();
		DataRow drg = new DataRow();
        //while there is data move on 
    	while (itr.hasNext()) {
    		drg = itr.next();
			xdata = drg.x;
			ydata = drg.y;
			ltreeVariabledata.add(xdata);
			ltyvariable.add(ydata);
		}
    	//get all the fitness
    	for (int i = 0; i < numTrees; i++) {
    	 Fitness f= new Fitness(population[i], ltreeVariabledata, ltyvariable);
    	 fitness[i]=f.sum;
        }
    	
    	
    }
    //get all the trees 
    public GPTree getTree(int i) {
        return population[i];
    }

    //get the best tree there is 
    public void printBestTree() {
    	 //i and j 
    	 int i,j=0;
    	 double  min;
    	 //go through 500 trees
    	 min=fitness[0];
    	 for (i = 0; i < numTrees; i++){
    		  //if the fitness
    	      if(min>fitness[i]){
    	    	  //if finess number less than min we let min hold it.
    	    	  min=fitness[i];
    	    	  j=i;
    	      }
    	 }
    	 System.out.println("We get the best tree there is :"+ population[j]);
    	 System.out.println("Fitness:"+ min);
    	
    }
    //get number of trees
    public int getNumTrees() { return numTrees; }
    //get all the trees there is 
    public void printGeneration() {
        for (int i = 0; i < numTrees; i++) {
            System.out.println(population[i]);
        }
    }
}
