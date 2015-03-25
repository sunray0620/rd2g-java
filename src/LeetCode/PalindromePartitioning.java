package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
	boolean[][] wt;

	public List<List<String>> partition(String s) {
		List<List<String>> ret = new ArrayList<List<String>>();
		int strlen = s.length();
		if (strlen == 0) {
			return ret;
		}
		//
		char[] schar = s.toCharArray();
		wt = new boolean[strlen][strlen];
		for (int i = strlen - 1; i >= 0; --i) {
			for (int j = i; j < strlen; ++j) {
				if (i == j) {
					wt[i][j] = true;
				} else if (j == i + 1 && schar[i] == schar[j]) {
					wt[i][j] = true;
				} else if (schar[i] == schar[j] && wt[i + 1][j - 1]) {
					wt[i][j] = true;
				}
			}
		}
		//
		List<String> tempRet = new ArrayList<String>();
		generateResult(schar, 0, tempRet, ret);
		return ret;
	}

	private void generateResult(char[] schar, int startPos, List<String> tempRet, List<List<String>> ret) {
		int strlen = schar.length;
		if (startPos == strlen) {
			List<String> retToAdd = new ArrayList<String>(tempRet);
			ret.add(retToAdd);
			return;
		}

		for (int i = startPos; i < strlen; ++i) {
			if (wt[startPos][i]) {
				tempRet.add(new String(schar, startPos, i - startPos + 1));
				generateResult(schar, i + 1, tempRet, ret);
				tempRet.remove(tempRet.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		String testString = "efe";
		PalindromePartitioning pp = new PalindromePartitioning();
		List<List<String>> ret = pp.partition(testString);
		System.out.println(ret);
		return;

	}
}
