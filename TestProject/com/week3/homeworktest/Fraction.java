package com.week3.homeworktest;

public class Fraction {
	int numerator;
	int denominator;
    Fraction() {	
    	
    	// numerator = denominator = 1
	    // add code here
    	numerator=1;
	    denominator=1;
	   
		
	}
	
	  Fraction(int n, int d) {
	    // add code here
		numerator=n;
		denominator=d;
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
		
	    // add code here 
		return  String.valueOf(numerator)+"/"+String.valueOf(denominator);
		
	}

	String toDecimal() {
	    // add code here
		float i=(float)numerator/(float)denominator;
		return ""+i;
		
	}

	 Fraction add(Fraction f) {
	    // add code here
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
