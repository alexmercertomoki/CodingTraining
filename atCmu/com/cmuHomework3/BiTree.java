package com.cmuHomework3;

	/*
	This file: BiTree(Binomial Tree)
	Programmer: Bilei Huang (bhuang@andrew.cmu.edu)
	Course/Section: 95-712
	Assignment: Creating a binomial tree to simulate stock growth or decrement
	Description: Enter the information : p current price, n time periods, u growth rate to create a binomial tree
	Last Modified: 9/18/2014
	Known Bugs: No bugs at present.
	Compiler: JDK 1.6
	*/

import java.math.BigDecimal;
import java.util.Scanner;



public class BiTree {
    //difine a two-dimension tree type float
	float[][] tree;
	//get the value p,n,u
	BiTree(float p,int n,float u){
		//create the rows of the tree
		tree =new float[n+1][] ;
		//ergodic
	for(int row=0;row<n+1;row++){
	   for(int line=0;line<=row;line++){
		   //create the lines of the tree which is equal to the length of the rows, +1 because it starts from 0
		   tree[row]=new float[row+1];
		   // out put the value , keep 2 after the ".", round half up, float value
		   System.out.print(new BigDecimal(p*Math.pow(u,line)* Math.pow((1/u),row-line)).setScale(2,BigDecimal.ROUND_HALF_UP).floatValue());
		   if(row!=line){
			//we don't have to print this at the end of each row so row==line stop printing this
			System.out.print("\t"); 
		   }
	   }
	   //get to next row 
	   System.out.println();
	  }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		float p,u;
		
		Scanner sc = new Scanner(System.in);
		
		// input any p, n , u as you want to create the tree
		System.out.println("please input p , n , u to create the Binomial Tree(Enter to go on to the next one)");
		
		System.out.println("p please:");
		p=sc.nextFloat();
		
		System.out.println("n please:");
		n=sc.nextInt();
		
		System.out.println("u please:");
		u=sc.nextFloat();
		
		new BiTree(p,n,u);

	}

}
