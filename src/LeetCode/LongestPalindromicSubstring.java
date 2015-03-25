package LeetCode;

public class LongestPalindromicSubstring {

	public String longestPalindrome(String s) {
		int strlen = s.length();
		if (strlen == 0 || strlen == 1) {
			return new String(s);
		}

		int maxLen = 0, maxI = 0, maxJ = 0;
		char[] strChars = s.toCharArray();
		boolean[][] wt = new boolean[strlen][strlen];
		for (int i = strlen - 1; i >= 0; --i) {
			wt[i][i] = true;
			for (int j = i + 1; j < strlen; ++j) {
				if (strChars[i] == strChars[j] && (i + 1 > j - 1 || wt[i + 1][j - 1])) {
					wt[i][j] = true;
					if (j - i + 1 > maxLen) {
						maxLen = j - i + 1;
						maxI = i;
						maxJ = j;
					}
				}
			}
		}

		return new String(strChars, maxI, maxJ - maxI + 1);
	}
}
