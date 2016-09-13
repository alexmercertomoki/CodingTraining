package p8;

public class Plusone {
	 public static int[] plusOne(int[] digits){
		 
		 int[] nd=new int[digits.length+1];
		 ++digits[digits.length-1];
		 for(int i=digits.length-1;i>=0;i--){
			
	       if(digits[i]==10){
	    	   if(digits[0]!=10){
	    	   digits[i]=0;
	    	   ++digits[i-1];  
	    	   }
	    	   else
	    	   {
	    		   nd[0]=1;
	    		   for(int j=1;j<nd.length;j++)
	    		   {
	    			   nd[j]=0;
	    		   }
	    		   return nd;
	    	   }
	       }	
	    } 
		 
		 return digits;
//		if(++digits[digits.length-1]>9){
//		   
//		}
	        
	   }
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] pl={1,0};
		int[] test;
		test=plusOne(pl);
		for(int i=0;i<test.length;i++){
			System.out.println(test[i]);
		}

	}

}
