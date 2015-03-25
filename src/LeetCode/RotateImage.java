package LeetCode;

public class RotateImage {
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		int il = 0;
		int iu = n - 1;
		int jl = 0;
		int ju = n - 1;

		while (il < iu) {
			int szOfRotate = iu - il;
			for (int offset = 0; offset < szOfRotate; ++offset) {
				int rotateTemp = matrix[il][jl + offset];
				matrix[il][jl + offset] = matrix[iu - offset][jl];
				matrix[iu - offset][jl] = matrix[iu][ju - offset];
				matrix[iu][ju - offset] = matrix[il + offset][ju];
				matrix[il + offset][ju] = rotateTemp;
			}
			il += 1;
			iu -= 1;
			jl += 1;
			ju -= 1;
		}
	}

	public static void main(String[] args) {
		int n = 1;
		int[][] tm = new int[n][n];
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				tm[i][j] = (i + 1) * 10 + j + 1;
			}
		}
		printMatrix(tm);

		RotateImage ri = new RotateImage();
		ri.rotate(tm);
		printMatrix(tm);
	}

	private static void printMatrix(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				System.out.print(String.format("%d  ", matrix[i][j]));
			}
			System.out.println();
		}
		System.out.println();
	}

}
