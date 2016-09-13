
	class SingleNumber {
	
	public int SingleNumber(int A[], int n) {
		
	        // IMPORTANT: Please reset any member data you declared, as
	        // the same Solution instance will be reused for each test case.
		
	        int res = A[0];
	        for (int i=1;i<n;i++){
	            res = res ^ A[i];
	        }
	        return res;
	    }
	};