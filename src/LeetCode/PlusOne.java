package LeetCode;

public class PlusOne {
	public int[] plusOne(int[] digits) {
		int numLen = digits.length;
		int retNumLen = numLen + 1;
		for (int i = 0; i < numLen; ++i) {
			if (digits[i] != 9) {
				retNumLen -= 1;
				break;
			}
		}

		int[] ret = new int[retNumLen];
		int i = numLen - 1, j = retNumLen - 1;
		int carryOver = 1;
		for (; i >= 0; --j, --i) {
			int curRet = digits[i] + carryOver;
			ret[j] = curRet % 10;
			carryOver = curRet / 10;
		}
		if (j == 0)
			ret[0] = carryOver;

		return ret;
	}
}
