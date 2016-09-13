package p3;

import java.util.Arrays;

public class AnotherOne {
	public static int[] merge(int A[], int m, int B[], int n) {
	    int[] H=new int[m+n];
	    for (int i=0;i<m;i++){
	        H[i]=A[i];
	    }
	    for (int i=m;i<(m+n);i++){
	        H[i]=B[i-m];
	    }
	    Arrays.sort(H);
		return H;
	}
	
	public static void main(String[] args) {
		int[]B ={};
		int[]A ={2};
		int a=1;
		int b=0;
		int[] U=merge(A,a,B,b);
		for(int i=0;i<a+b;i++){
		System.out.print(U[i]+" ");
		}
		
	}
}
