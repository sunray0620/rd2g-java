package LeetCode;

public final class MaxProductSubarray {
	/*
	 * Find the contiguous subarray within an array
	 * (containing at least one number)
	 * which has the largest product.
	 * 
	 * For example, given the array [2,3,-2,4],
	 * the contiguous subarray [2,3] has the largest product = 6.
	 */

	public int maxProduct(int[] A) {
		int gMax = Integer.MIN_VALUE;
		int curMax = 1;
		int curMin = 1;
		for (int i = 0; i < A.length; ++i) {
			int mx = curMax;
			int mn = curMin;
			curMax = Math.max(Math.max(mx * A[i], mn * A[i]), A[i]);
			curMin = Math.min(Math.min(mx * A[i], mn * A[i]), A[i]);
			System.out.println(String.format("cur %d - max: %d - min: %d", A[i], curMax, curMin));
			gMax = Math.max(gMax, curMax);
		}
		return gMax;
	}

	public static void main(String[] args) {
		int[] testArray = new int[] { -1, -2, -9, -6 };
		MaxProductSubarray mps = new MaxProductSubarray();
		mps.maxProduct(testArray);
	}
}
