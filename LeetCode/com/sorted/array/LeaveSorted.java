package com.sorted.array;

public class LeaveSorted {

	static int[] MergeSort(int[] A, int m, int[] B, int n) {
		int h = m + n;
		int f = 0;
		int[] M = new int[h];
		int i = 0, j = 0;

		if (m == 0) {
			return B;
		}
		if (n == 0)
			return A;

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
				if (m > n) {
					for (int a = 0; a <= m - n; a++) {
						M[i + j + a] = A[i + a];
					}
				} else
					for (int a = 0; a <= n - m; a++) {
						M[i + j + a] = B[j + a];
					}

				break;

			}

		}

		return M;

	}

	public static void main(String[] args) {
		int[] B = { 1, 3, 5, 7 };
		int[] A = { 2, 4, 6, 8, 20 };
		int a = 5;
		int b = 4;
		int[] U = MergeSort(A, a, B, b);
		for (int i = 0; i < a + b; i++) {
			System.out.print(U[i] + " ");
		}

	}

}
