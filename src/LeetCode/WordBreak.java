package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {
	/*
	 * Given a string s and a dictionary of words dict,
	 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
	 * For example, given
	 * s = "leetcode",
	 * dict = ["leet", "code"]
	 * Return true because "leetcode" can be segmented as "leet code".
	 */

	public boolean wordBreak(String s, Set<String> dict) {
		// Scan dictionary to see the max length of all words
		int maxWordLen = 0;
		for (String wordInDict : dict) {
			maxWordLen = Math.max(maxWordLen, wordInDict.length());
		}

		// Initialize a working table to save progress.
		int wholeStringLen = s.length();
		boolean[][] wt = new boolean[wholeStringLen][wholeStringLen];
		// Initialize base cases: all words with one letter.
		for (int i = 0; i < wholeStringLen; ++i) {
			String possibleWord = s.substring(i, i + 1);
			if (dict.contains(possibleWord)) {
				wt[i][i] = true;
			}
		}

		// DP starts:
		for (int offset = 0; offset < wholeStringLen; ++offset) {
			for (int i = 0; i < wholeStringLen - offset; ++i) {
				int j = i + offset;
				// If word[i, j] is in dictionary, mark as true.
				if (j + 1 - i <= maxWordLen) {
					String possibleWholeWord = s.substring(i, j + 1);
					// System.out.println(String.format("%s", s.substring(i, j + 1)));
					if (dict.contains(possibleWholeWord)) {
						wt[i][j] = true;
						continue;
					}
				}

				// Check string[i, j] can be broken into word[i, k] and word[k + 1, j]
				for (int k = i; k < j; ++k) {
					// String as a whole
					// System.out.println(String.format("%s %s", s.substring(i, k + 1), s.substring(k + 1, j + 1)));
					boolean possibility = (wt[i][k] && wt[k + 1][j]);
					if (possibility) {
						wt[i][j] = true;
						break;
					}
				}
			}
		}

		return wt[0][wholeStringLen - 1];
	}

	public static void main(String[] args) {
		String s = "abcd";
		Set<String> dict = new HashSet<String>();
		dict.add("a");
		dict.add("abc");
		dict.add("b");
		dict.add("cd");

		WordBreak wb = new WordBreak();
		wb.wordBreak(s, dict);
	}

}
