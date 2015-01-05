package LeetCode;

public class UniquePaths2 {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] wt = new int[m][n];
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (obstacleGrid[i][j] == 1) {
					wt[i][j] = 0;
				} else if (i == 0 && j == 0) {
					wt[i][j] = 1;
				} else {
					int n1 = i <= 0 ? 0 : wt[i - 1][j];
					int n2 = j <= 0 ? 0 : wt[i][j - 1];
					wt[i][j] = n1 + n2;
				}
			}
		}
		return wt[m - 1][n - 1];
	}
}
