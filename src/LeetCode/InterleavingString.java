package LeetCode;

public class InterleavingString {

	public boolean isInterleave(String s1, String s2, String s3) {
		int strlen1 = s1.length();
		int strlen2 = s2.length();
		int strlen3 = s3.length();
		if (strlen1 + strlen2 != strlen3) {
			return false;
		}

		boolean[][] wt = new boolean[strlen1 + 1][strlen2 + 1];
		wt[0][0] = true;
		for (int i = 1; i <= strlen1; ++i) {
			if (s1.charAt(i - 1) == s3.charAt(i - 1)) {
				wt[i][0] = true;
			} else {
				break;
			}
		}

		for (int j = 1; j <= strlen2; ++j) {
			if (s2.charAt(j - 1) == s3.charAt(j - 1)) {
				wt[0][j] = true;
			} else {
				break;
			}
		}

		for (int i = 1; i <= strlen1; ++i) {
			for (int j = 1; j <= strlen2; ++j) {
				// i-1; j-1
				if (wt[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
					wt[i][j] = true;
				}
				if (wt[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
					wt[i][j] = true;
				}
			}
		}
		return wt[strlen1][strlen2];
	}

}
