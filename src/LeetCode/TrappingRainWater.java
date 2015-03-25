package LeetCode;

public class TrappingRainWater {
	public int trap(int[] A) {
		int ret = 0;
		int l = 0;
		int u = A.length - 1;

		while (l < u) {
			if (A[l] <= A[u]) {
				int i;
				for (i = l + 1; A[i] < A[l]; ++i) {
					ret += A[l] - A[i];
				}
				l = i;
			} else {
				int i;
				for (i = u - 1; A[i] < A[u]; --i) {
					ret += A[u] - A[i];
				}
				u = i;
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		int[] testNum = new int[] { 2, 0, 2 };
		TrappingRainWater trw = new TrappingRainWater();
		trw.trap(testNum);
	}
}
