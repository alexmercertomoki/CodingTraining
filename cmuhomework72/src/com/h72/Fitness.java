package com.h72;

import java.util.Iterator;
import java.util.LinkedList;

public class Fitness {
	    double xTreedata;
	    double ydata;
	    double sum=0;
	   Fitness(GPTree g,LinkedList<double[]> x, LinkedList y){
		
	 
		 Iterator<double[]> itrx=x.iterator();
		 Iterator<Double> itry=y.iterator();
		 
		 
		 while(itrx.hasNext()){
//		      System.out.println();
			 ydata=itry.next();
			 xTreedata=g.eval(itrx.next());
			 sum += Math.pow((xTreedata - ydata),2);
			
	     }
		 
      }
		@Override
		public String toString() {
			
			return sum+"";
		}
	    
	    
}