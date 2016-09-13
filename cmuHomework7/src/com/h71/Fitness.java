package com.h71;

import java.util.Iterator;
import java.util.LinkedList;

public class Fitness {
	    double xTreedata;
	    double ydata;
	    double sum;
	    Fitness(GPTree g,LinkedList x, LinkedList y){
		
	 
		 Iterator<double[]> itrx=x.iterator();
		 Iterator<Double> itry=y.iterator();
		 
		 
		 while(itrx.hasNext()){
//		      System.out.println();
			 ydata=itry.next();
			 xTreedata=g.eval(itrx.next());
			 sum += Math.pow((xTreedata - ydata),2);//
			
	     }
		
      }
		@Override
		public String toString() {
			
			return sum+"";
		}
	    
	    
}