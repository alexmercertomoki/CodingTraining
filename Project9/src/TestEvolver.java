/** 
 *  Let's evovle a tree
 *  @author Bilei
 *  This file: TestEvolver.java
    Programmer: Bilei Huang (bhuang@andrew.cmu.edu)
	Course/Section: 95-712
	Assignment: Testing the evolver method  
	Description:This file generates a generation of trees and calling evolver successively 5 times.get see 
	how each generation evolves 
	Last Modified:11/19/2014
	Known Bugs: No bugs at present.
	Compiler: JDK 1.7
 *
 */

/*
This file: TestEvolver.java
Programmer: Bilei Huang (bhuang@andrew.cmu.edu)
Course/Section: 95-712
Assignment: Testing the evolver method  
Description:This file generates a generation of trees and calling evolver successively 5 times.get see 
how each generation evolves 
Last Modified:11/19/2014
Known Bugs: No bugs at present.
Compiler: JDK 1.7
*/

import java.util.Random;

/*&
 * @ param test 
 */
public class TestEvolver {
	
	// constructor which  receive what we need to use for creating a generation of trees and a dataset to
	//evaluate
	/**
	 * 
	 * @param numTree
	 * @param o
	 * @param t
	 * @param rand
	 * @param ds
	 */
   TestEvolver(int numTree,OperatorFactory o,TerminalFactory t,Random rand,DataSet ds) {
	   
	  //creating a new generation of trees
	  Generation g=new Generation(numTree, o, t, 2, rand);
	  //evaluate all the trees in the generation 
	  g.evalAll(ds);
	  //tell others this is the original best 
	  System.out.println("ORININGAL BEST");
	  //print the best one in this very first generation
	  g.printBestTree();
	 //create a evolver 
	  Evolver a = new Evolver(g, ds, rand);
	  // run Evolve 10 times 
	  for(int i=0;i<10;i++){
		  a.Evolve();
	  } 
	  
   } 
  

}
