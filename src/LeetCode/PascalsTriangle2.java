package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle2 {
	public List<Integer> getRow(int rowIndex) {
		int[][] wt = new int[rowIndex + 1][rowIndex + 1];
		wt[0][0] = 1;
		for (int i = 1; i <= rowIndex; ++i) {
			wt[i][0] = wt[i][rowIndex] = 1;
			for (int j = 1; j < rowIndex; ++j) {
				wt[i][j] = wt[i - 1][j - 1] + wt[i - 1][j];
			}
		}

		List<Integer> ret = new ArrayList<Integer>();
		for (int i = 0; i <= rowIndex; ++i) {
			ret.add(wt[rowIndex][i]);
		}
		return ret;
	}
}
