package com.week3.homeworktest;

import java.math.BigDecimal;
import java.util.Scanner;



public class BiTree {
    
	float[][] tree;
	BiTree(float p,int n,float u){
		tree =new float[n+1][n+1] ;
	for(int row=0;row<n+1;row++){
	   for(int line=0;line<=row;line++){
		 //  System.out.print(String.format("%.3f", p*Math.pow(u,line)* Math.pow((1/u),row-line)));
		   System.out.print(new BigDecimal(p*Math.pow(u,line)* Math.pow((1/u),row-line)).setScale(2,BigDecimal.ROUND_HALF_UP).floatValue());
		   if(row!=line){
			System.out.print("   "); 
		   }
	   }
	   System.out.println();
	  }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		float p,u;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("please input p , n , u to create the Binomial Tree(Enter to go on to the next one)");
		
		System.out.println("p please:");
		p=sc.nextFloat();
		
		System.out.println("n please:");
		n=sc.nextInt();
		
		System.out.println("u please:");
		u=sc.nextFloat();
		
		BiTree b1= new BiTree(p,n,u);

	}

}
