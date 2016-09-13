public class MaxPath {
	public int maxPath(int[][] A) {
		if (A.length == 0 || A[0].length == 0) {
			return 0;
		}

		int m = A.length;
		int n = A[0].length;

		int[][] dp = new int[m + 1][n + 1];

		// init
		for (int i = 0; i <= m; i++) {
			dp[i][0] = 0;
		}
		for (int j = 0; j <= n; j++) {
			dp[m][j] = 0;
		}

		// dp
		for (int i = m - 1; i >= 0; i--) {
			for (int j = 1; j <= n; j++) {
				dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]) + A[i][j - 1];
			}
		}

		return dp[0][n];
	}

	public static void main(String[] args) {
		MaxPath test = new MaxPath();
		int[][] A = { { 1, 1, 0 }, { 2, 0, 0 }, { 0, 0, 3 } };
		System.out.println(test.maxPath(A));
	}
}
