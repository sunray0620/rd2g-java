package LeetCode;

public class MergeSortedArray {
	public void merge(int A[], int m, int B[], int n) {
		int ai = m - 1;
		int bi = n - 1;
		int ci = m + n - 1;
		for (; ai >= 0 && bi >= 0;) {
			if (A[ai] >= B[bi]) {
				A[ci--] = A[ai--];
			} else {
				A[ci--] = B[bi--];
			}
		}

		for (; bi >= 0;) {
			A[ci--] = B[bi--];
		}
	}
}
