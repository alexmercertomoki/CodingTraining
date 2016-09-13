package com.cmu.test3;

import java.util.Random;

public class TestArithmetic {
	
	static Random r = new Random();
	
	public static void main(String[] args) {
		
		int a[]= new int[4];
		int mark1,mark2,mark3;
		
		Node n[]= new Const[4];
		Binop b[]=new Binop[3];
		
		for(int i=0;i<4;i++){
			 
			 a[i]=r.nextInt(20);
			 n[i]=new Const(a[i]);
			 
		}
		
		for(int j=0;j<2;j++){
			
			
			
			if(j==0){
			mark1=r.nextInt(4);
			if(mark1==0)
			{
				b[j]=new Plus(n[0],n[1]);
			}
			
			if(mark1==1){
				b[j]=new Minus(n[0],n[1]);
			}
			
			if(mark1==2){
				b[j]=new Multiply(n[0],n[1]);
			}
			
			if(mark1==3){
				b[j]=new Division(n[0],n[1]);
			}
			
			}
			
			
			if(j==1)
			{
				mark2=r.nextInt(4);
				if(mark2==0)
				{
					b[j]=new Plus(n[2],n[3]);
				}
				
				if(mark2==1){
					b[j]=new Minus(n[2],n[3]);
				}
				
				if(mark2==2){
					b[j]=new Multiply(n[2],n[3]);
				}
				
				if(mark2==3){
					b[j]=new Division(n[2],n[3]);
				}
				}	
				
			}
			
			
			
			
			mark3=r.nextInt(4);
			
			if(mark3==0){
				b[2]=new Plus(b[0],b[1]);
			}
			
			if(mark3==1){
				b[2]=new Minus(b[0],b[1]);
			}
			
			if(mark3==2){
				b[2]=new Multiply(b[0],b[1]);
			}
			
			if(mark3==3){
				b[2]=new Division(b[0],b[1]);
			}
			  System.out.println("("+n[0]+b[0]+n[1]+")"+b[2]+"("+n[2]+b[1]+n[3]+")"+"="+b[2].eval());
			
		}
	
}












