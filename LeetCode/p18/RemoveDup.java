package p18;



public class RemoveDup {
	
	public static int removeDuplicates(int[] A) {
         
		int size=0;
		
		if(A==null||A.length==0){
			return 0;
		}
		
        for(int i=1;i<A.length;i++){
            if(A[size]!=A[i]){
            	A[++size]=A[i];
            }
        }
        return ++size;
		
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A={1,1,1,1,1,1,1,1,1,2};
		int len;
		
		len=removeDuplicates(A);
		System.out.println(len);
		

	}

}
