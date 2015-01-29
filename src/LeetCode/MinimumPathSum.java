package LeetCode;

public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] sum = new int[m][n];

		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (i == 0 && j == 0) {
					sum[i][j] = grid[i][j];
				} else if (i == 0) {
					sum[i][j] = sum[i][j - 1] + grid[i][j];
				} else if (j == 0) {
					sum[i][j] = sum[i - 1][j] + grid[i][j];
				} else {
					sum[i][j] = Math.min(sum[i - 1][j], sum[i][j - 1]) + grid[i][j];
				}
			}
		}
		return sum[m - 1][n - 1];
	}
}
