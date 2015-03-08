package LeetCode;

public class SearchRange {
	public int[] searchRange(int[] A, int target) {
		int[] ret = new int[] { -1, -1 };
		int sz = A.length;

		int l = -1;
		int u = sz;
		while (l < u - 1) {
			int m = (l + u) >> 1;
			if (A[m] < target) {
				l = m;
			} else {
				u = m;
			}
		}

		if (u == sz || A[u] != target) {
			return ret;
		}

		ret[0] = u;
		l = u;
		u = sz;
		while (l < u - 1) {
			int m = (l + u) >> 1;
			if (A[m] == target) {
				l = m;
			} else {
				u = m;
			}
		}
		ret[1] = l;
		return ret;
	}
}
