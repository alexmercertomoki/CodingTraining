/** 
 * @author Bilei Huang
 *Let's evolve a generation of tree with this evolver 
 *This file: Evolver.java
 Programmer: Bilei Huang (bhuang@andrew.cmu.edu)
 Course/Section: 95-712
 Assignment: Evolver which we use to get a generation of trees and evolve it ..  
 Description:This file generates a generation of trees and replace the trees with a new generation 1 time 

 Last Modified:11/19/2014
 Known Bugs: No bugs at present.
 Compiler: JDK 1.7
*/

/*
This file: Evolver.java
Programmer: Bilei Huang (bhuang@andrew.cmu.edu)
Course/Section: 95-712
Assignment: Evolver which we use to get a generation of trees and evolve it ..  
Description:This file generates a generation of trees and replace the trees with a new generation 1 time 

Last Modified:11/19/2014
Known Bugs: No bugs at present.
Compiler: JDK 1.7
*/

import java.util.Random;

public class Evolver {
	//attributes we need to have 
	/**
	 * private Attributes used: a generation,  a dataset, a random number
	 */
	private Generation g;
	private DataSet ds; 
	private Random r;
	
	// constructor when calling we start to create a new set of generation 
	/**
	 * Constructor : setting the attributes 
	 * @param  g
	 * @param  ds
	 * @param  r 
	 */
	Evolver(Generation g,DataSet ds, Random r){
	   this.g=g;
	   this.ds=ds;
	   this.r=r;
	}

	//getter setters
	public Generation getG() {
		return g;
	}
	public void setG(Generation g) {
		this.g = g;
	}
	public DataSet getDs() {
		return ds;
	}
	public void setDs(DataSet ds) {
		this.ds = ds;
	}
	public Random getR() {
		return r;
	}
	public void setR(Random r) {
		this.r = r;
	}
	
/**
 * This is the method we generate a new generation...
 * @param   g   generation g we need to 
 * @param treeNum how many trees do we have in the Generation 
 * @param rand a random number  
 * @return g   the new generation 
 */
	// make new generation method to create a new generation 
	 public Generation makeNewGeneration(Generation g,int treeNum,Random rand){
		 // temporary tree to hold new generations 
		GPTree gptTemp[] = new GPTree[treeNum];
		// getting new set of trees recursively 
		for(int i=0;i<treeNum;i++){
			//getting better trees
			gptTemp[i]= g.chooseTreeProportionalToFitness();
		}
		//cross them over to get new trees.
	    for(int i=1;i<treeNum;i++){
		TestGPTree.crossover(gptTemp[i], gptTemp[i-1], rand);
	     }
	    
		
		//set the new  population  gpt temp
		this.g.setPopulation(gptTemp);
		//return the tree array
		return g;
	}
	 /**
	  * Where we evolve our trees and print our the best trees we have 
	  * Evolving multiple times easily with this method
	  */
	void Evolve(){	
		
		// we get the new generation 
		Generation gR = makeNewGeneration(g, g.getPopulation().length, r);
		// evaluate all the trees in the generation
		gR.evalAll(ds);
	    // printout the best 
		gR.printBestTree();
		
		
	}

}
