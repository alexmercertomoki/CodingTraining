package p4;

public class LeaveSorted {

	static void MergeSort(int[] A, int m, int[] B, int n) {
		int h = m + n;
		int f = 0;
		int[] M = new int[h];
		int i = 0, j = 0;
	
        if(m==0){
        	for(int q=0;q<h;q++){
                A[q]=B[q];  // pointing to ... one by one.
      		}
           return;
        }
        if (n == 0)
        	return;
        
        
		while (f < m + n) {
			if (i < m && j < n) {
				if (A[i] < B[j]) {
					M[f] = A[i];
					f++;
					i++;
				} else {
					M[f] = B[j];
					f++;
					j++;
				}
			} else if (i < m || j < n) {
				if (j==n) {
					for (int a = 0; a <m - i; a++) {
						M[f + a] = A[i + a];
					}
					break;
				}
				
				else if(i==m){
					for (int a = 0; a <n - j ; a++) {
						M[f + a] = B[j + a];
					}
				break;

			  }
			}

		}
		
		for(int q=0;q<h;q++){
          A[q]=M[q];  // pointing to ... one by one.
		}
		
	}

	public static void main(String[] args) {
		int[] B = {1};
		int[] A = {0,0,0,0};
		int a = 0;
		int b = 1;
		MergeSort(A, a, B, b);
		
		for (int i = 0; i < a+b; i++) {
			System.out.print(A[i] + " ");
		}
		
	}

}
