package com.sorted.array.p2;

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
		int[]B ={1,3,5,7,9};
		int[]A ={2,4,6,8,10};
		int a=5;
		int b=5;
		int[] U=merge(A,a,B,b);
		for(int i=0;i<a+b;i++){
		System.out.print(U[i]+" ");
		}
		
	}
}
