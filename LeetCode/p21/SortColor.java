package p21;

public class SortColor {
	
	 public static void sortColors(int[] A) {
	        int i=-1,j=-1,k=-1;
	        
	        for(int len=0;len<A.length;len++){
	        	 if(A[len]==0){
	        		 A[++i]=2;
	        		 A[++j]=1;
	        		 A[++k]=0;
	        		 
	        	 }
	        	 else if(A[len]==1){ // be  careful it's else if
	        		 A[++i]=2;
	        		 A[++j]=1;
	        		 
	        	 }
	        	 else if(A[len]==2){
	        		 A[++i]=2;
	        	 }
	        }
	        for(int len=0;len<A.length;len++){
	        System.out.println(A[len]);
	        }
	 }
	
	public static void main(String args[]){
		int[] A={0,1,0,2,1};
		sortColors(A);
 	}

}
