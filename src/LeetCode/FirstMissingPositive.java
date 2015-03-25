package LeetCode;

public class FirstMissingPositive {
	public int firstMissingPositive(int[] A) {
		for (int i = 0; i < A.length; ++i) {
			while (A[i] > 0 && A[i] <= A.length && A[A[i] - 1] != A[i]) {
				swap(A, i, A[i] - 1);
			}
		}

		int i;
		for (i = 0; i < A.length; ++i) {
			if (A[i] != i + 1) {
				return i + 1;
			}
		}
		return i + 1;
	}

	private void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	public static void main(String[] args) {
		int[] testnums = new int[] { 3, 4, -1, 1 };
		FirstMissingPositive fmp = new FirstMissingPositive();
		int ret = fmp.firstMissingPositive(testnums);
		System.out.println(ret);
	}
}
