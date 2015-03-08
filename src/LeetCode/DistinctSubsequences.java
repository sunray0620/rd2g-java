package LeetCode;

public class DistinctSubsequences {

	public int numDistinct(String S, String T) {
		int slen = S.length();
		int tlen = T.length();
		char[] schars = S.toCharArray();
		char[] tchars = T.toCharArray();
		if (slen < tlen) {
			return 0;
		}

		int[][] wt = new int[tlen][slen];
		if (schars[0] == tchars[0]) {
			wt[0][0] = 1;
		}
		for (int j = 1; j < slen; ++j) {
			if (schars[j] == tchars[0]) {
				wt[0][j] = wt[0][j - 1] + 1;
			} else {
				wt[0][j] = wt[0][j - 1];
			}
		}

		for (int i = 1; i < tlen; ++i) {
			for (int j = 1; j < slen; ++j) {
				wt[i][j] = wt[i][j - 1];
				if (schars[j] == tchars[i]) {
					wt[i][j] += wt[i - 1][j - 1];
				}
			}
		}
		return wt[tlen - 1][slen - 1];
	}

	public static void main(String[] args) {
		String ss = "bbb";
		String tt = "bb";
		DistinctSubsequences ds = new DistinctSubsequences();
		ds.numDistinct(ss, tt);
	}
}
