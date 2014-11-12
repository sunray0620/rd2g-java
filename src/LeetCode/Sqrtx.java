package LeetCode;

public final class Sqrtx {
	/*
	 * Implement int sqrt(int x).
	 * Compute and return the square root of x.
	 */

	public int sqrt(int x) {
		int maxResult = 46341;
		int minResult = 0;
		while (minResult < maxResult - 1) {
			int m = (maxResult + minResult) / 2;
			if (m * m <= x)
				minResult = m;
			else
				maxResult = m;
		}
		return minResult;
	}
}
