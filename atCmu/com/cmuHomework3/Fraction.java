package com.cmuHomework3;

		
public class Fraction {
	int numerator;
	int denominator;
    Fraction() {	
    	
    	//default value 1
    	numerator=1;
	    denominator=1;
	   
		
	}
	
    
   
	  Fraction(int n, int d) {
	    // Initiation : if denominator is 0 exit and you have to restart
		  if(d==0){
			  System.out.println("please restart and reenter devisor, it cannot be 0");
			  System.exit(0);
		  }
		numerator=n;
		denominator=d;
		//reduction of fraction using gcd
		int i=gcd(numerator,denominator);
	    if(i!=1){
	    	numerator= n/i;
	    	denominator=d/i;
	    }
	  
	}
	
	  //greatest common divisor:
	int gcd(int a, int b) { 
	if (b == 0)
	return (a);
	else
	return (gcd(b, a % b));
	}
    
	public String toString() {
		
	    // return the string 
		return  String.valueOf(numerator)+"/"+String.valueOf(denominator);
		
	}

	String toDecimal() {
	    // convert to decimal and return a string
		float i=(float)numerator/(float)denominator;
		return ""+i;
		
	}

	 Fraction add(Fraction f) {
	    // get the value of f do adding and return the new fraction
		int i,j;
		i=numerator;
		j=denominator;
		i=i*f.denominator;
		j=j*f.denominator;
	
		f.numerator=f.numerator*denominator;
		f.denominator=f.denominator*denominator;
		
		
		Fraction f1=new Fraction(f.numerator+i,j);
	    return  f1;
		
		
	}

}
