package LeetCode;

public class ClimbingStairs {
	public int climbStairs(int n) {
		if (n == 1 || n == 2) {
			return n;
		}
		int[] ret = new int[n + 1];
		ret[0] = 0;
		ret[1] = 1;
		ret[2] = 2;
		for (int i = 3; i <= n; ++i) {
			ret[i] = ret[i - 1] + ret[i - 2];
		}
		return ret[n];
	}
}
