package LeetCode;

public class SearchRotatedSortedArray {

	public int search(int[] A, int target) {
		int l = 0;
		int u = A.length - 1;
		for (; l <= u;) {
			int m = (l + u) >> 1;
			if (target == A[m])
				return m;
			if (A[m] > A[l]) {
				if (target > A[m]) {
					l = m + 1;
				} else if (target >= A[l]) {
					u = m - 1;
				} else {
					l = m + 1;
				}
			} else if (A[m] < A[l]) {
				if (target >= A[l]) {
					u = m - 1;
				} else if (target > A[m]) {
					l = m + 1;
				} else {
					u = m - 1;
				}
			} else {
				++l;
			}
		}
		return -1;
	}

}
