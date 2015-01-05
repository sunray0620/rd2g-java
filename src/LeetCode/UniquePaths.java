package LeetCode;

public class UniquePaths {
	public int uniquePaths(int m, int n) {
		int[][] wt = new int[m][n];
		for (int i = 0; i < m; wt[i++][0] = 1)
			;
		for (int j = 0; j < n; wt[0][j++] = 1)
			;
		for (int i = 1; i < m; ++i) {
			for (int j = 1; j < n; ++j) {
				wt[i][j] = wt[i - 1][j] + wt[i][j - 1];
			}
		}
		return wt[m - 1][n - 1];
	}
}
