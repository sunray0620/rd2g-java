package LeetCode;

public class SortColors {
	public void sortColors(int[] A) {
		int end1 = -1;
		int end2 = -1;
		for (int i = 0; i < A.length; ++i) {
			if (A[i] == 1) {
				++end2;
				int temp = A[i];
				A[i] = A[end2];
				A[end2] = temp;
			} else if (A[i] == 0) {
				++end1;
				++end2;
				int temp = A[i];
				A[i] = A[end2];
				A[end2] = A[end1];
				A[end1] = temp;
			}
		}
	}
}
