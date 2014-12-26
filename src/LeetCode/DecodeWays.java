package LeetCode;

public class DecodeWays {

	private boolean validSingleDigit(String s, int i) {
		char ci = s.charAt(i);
		if (ci > '0' && ci <= '9') {
			return true;
		}
		return false;
	}

	private boolean validDoubleDigits(String s, int i) {
		char ci = s.charAt(i);
		char cj = s.charAt(i + 1);
		int num = (ci - '0') * 10 + (cj - '0');
		if (num >= 10 && num <= 26) {
			return true;
		}
		return false;
	}

	public int numDecodings(String s) {
		int stringLength = s.length();
		if (stringLength == 0)
			return 0;

		int[] rets = new int[stringLength];
		for (int i = 0; i < stringLength; ++i) {
			if (validSingleDigit(s, i)) {
				rets[i] += (i >= 1) ? rets[i - 1] : 1;
			}
			if (i > 0 && validDoubleDigits(s, i - 1)) {
				rets[i] += (i >= 2) ? rets[i - 2] : 1;
			}
		}
		return rets[stringLength - 1];
	}

}
