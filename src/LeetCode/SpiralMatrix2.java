package LeetCode;

public class SpiralMatrix2 {
	public static int[][] generateMatrix(int n) {
		int[][] retMatrix = new int[n][n];

		int ml = 0;
		int mu = n - 1;
		int nl = 0;
		int nu = n - 1;

		int k = 0;
		for (; ml <= mu && nl <= nu;) {
			for (int i = nl; i <= nu && ml <= mu; ++i)
				retMatrix[ml][i] = ++k;
			ml += 1;

			for (int i = ml; i <= mu && nl <= nu; ++i)
				retMatrix[i][nu] = ++k;
			nu -= 1;

			for (int i = nu; i >= nl && ml <= mu; --i)
				retMatrix[mu][i] = ++k;
			mu -= 1;

			for (int i = mu; i >= ml && nl <= nu; --i)
				retMatrix[i][nl] = ++k;
			nl += 1;
		}
		return retMatrix;
	}

	public static void main(String[] args) {
		int n = 0;
		int[][] matrix = generateMatrix(n);
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				System.out.print(String.format("%d, ", matrix[i][j]));
			}
			System.out.println();
		}
		System.out.println();
	}
}
