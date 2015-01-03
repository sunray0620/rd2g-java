package LeetCode;

import java.util.List;

public class Triangle {

	public int minimumTotal(List<List<Integer>> triangle) {
		int len = triangle.size();
		int wt[][] = new int[len][len];
		wt[0][0] = triangle.get(0).get(0);
		for (int i = 1; i < len; ++i) {
			for (int j = 0; j <= i; ++j) {
				if (j == 0) {
					wt[i][j] = wt[i - 1][j] + triangle.get(i).get(j);
				} else if (j == i) {
					wt[i][j] = wt[i - 1][j - 1] + triangle.get(i).get(j);
				} else {
					int sum1 = wt[i - 1][j] + triangle.get(i).get(j);
					int sum2 = wt[i - 1][j - 1] + triangle.get(i).get(j);
					wt[i][j] = Math.min(sum1, sum2);
				}
			}
		}

		int min = Integer.MAX_VALUE;
		for (int j = 0; j < len; ++j) {
			min = Math.min(min, wt[len - 1][j]);
		}
		return min;
	}
}
