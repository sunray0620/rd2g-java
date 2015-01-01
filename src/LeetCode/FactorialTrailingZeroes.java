package LeetCode;

public class FactorialTrailingZeroes {

	public int trailingZeroes(int n) {
		int ret = 0;
		for (int div = 5; n >= div; n = n / 5) {
			ret += (n / div);
		}
		return ret;
	}

}
