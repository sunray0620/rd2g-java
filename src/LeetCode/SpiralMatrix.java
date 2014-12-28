package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> ret = new ArrayList<Integer>();
		int m = matrix.length;
		if (m == 0) {
			return ret;
		}
		int n = matrix[0].length;

		int ml = 0;
		int mu = m - 1;
		int nl = 0;
		int nu = n - 1;

		for (; ml <= mu && nl <= nu;) {
			for (int i = nl; i <= nu && ml <= mu; ++i)
				ret.add(matrix[ml][i]);
			ml += 1;

			for (int i = ml; i <= mu && nl <= nu; ++i)
				ret.add(matrix[i][nu]);
			nu -= 1;

			for (int i = nu; i >= nl && ml <= mu; --i)
				ret.add(matrix[mu][i]);
			mu -= 1;

			for (int i = mu; i >= ml && nl <= nu; --i)
				ret.add(matrix[i][nl]);
			nl += 1;
		}
		return ret;
	}

	public static void main(String[] args) {
		int m = 7;
		int n = 1;
		int[][] matrix = new int[m][n];
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				matrix[i][j] = (i + 1) * 10 + j + 1;
			}
		}
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				System.out.print(String.format("%d, ", matrix[i][j]));
			}
			System.out.println();
		}
		System.out.println();

		List<Integer> ret = spiralOrder(matrix);
		for (int i = 0; i < ret.size(); ++i) {
			System.out.print(String.format("%d, ", ret.get(i)));
		}
	}
}
