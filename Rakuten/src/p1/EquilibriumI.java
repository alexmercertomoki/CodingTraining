package p1;

public class EquilibriumI {
	 public int solution(int[] A) {
	        // write your code in Java SE 8
		 int count1=0,count2=0,countU=0,countT=0;
		
//		 for(int i=0;i<A.length;i++){
//			 for(int j=0;j<i;j++){
//				 count1+=A[j];
//			 }
//			 for(int k=i+1;k<A.length;k++){
//				 count1+=A[k];
//			 }
//			 if(count1==count2){
//				 return i;
//			 }
//			 
//		  }
//		 return -1;
		 
		 for(int i=0;i<A.length;i++){
			 countT+=A[i];
		 }
		 for(int i=0;i<A.length;i++){
			 countU+=A[i];
			 count1=countU-A[i];
			 count2=countT-countU;
			 if(count1==count2){
				 return i;
			 }
			 
		 }
		 return -1;
		 
		 
	    }

	public static void main(String args[]){
		
		
		
		
	}
}
