package p12;

public class ClimbingStairs {
	
	  public static int climbStairs(int n) { // Âú×ãì³²¨ÄÇÆõ      if 3 , 4 five , six we can from the previous 3,4,5,6 ways total .
		  
		  int i=1,j=2,a,b;
		  b=n/2;
		  for(a=1;a<b;a++){
//			  System.out.println(i+"    "+j+"     ");
			  i=i+j;
			  j=i+j;
		  }
		  if(n%2==0){
		    return j;
		  }
		  else if(n==1)
	        return i;
		  else 
			return i+j;
	  }
	
	public static void main(String args[]){ 
		
		//System.out.println(args); // empty array
		int i=5,j;
		j=climbStairs(i);
		System.out.println(j);
		
		
	}

}
