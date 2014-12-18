package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak2 {

	public boolean checkAvailability(String s, Set<String> dict) {
		// Scan dictionary to see the max length of all words

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

				String possibleWholeWord = s.substring(i, j + 1);
				// System.out.println(String.format("%s", s.substring(i, j + 1)));
				if (dict.contains(possibleWholeWord)) {
					wt[i][j] = true;
					continue;
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

	private HashSet<String> getHashSet(ArrayList<HashSet<String>> slns, int i, int j, int n) {
		return slns.get(i * n + j);
	}

	private ArrayList<HashSet<String>> initHashSets(int n) {
		ArrayList<HashSet<String>> slns = new ArrayList<HashSet<String>>(n * n);
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				slns.add(new HashSet<String>());
			}
		}
		return slns;
	}

	public List<String> wordBreak(String s, Set<String> dict) {
		if (!checkAvailability(s, dict)) {
			return new ArrayList<String>();
		}

		int wholeStringLen = s.length();
		ArrayList<HashSet<String>> slns = initHashSets(wholeStringLen);

		// Initialize a working table to save progress.
		for (int i = 0; i < wholeStringLen; ++i) {
			String possibleWord = s.substring(i, i + 1);
			if (dict.contains(possibleWord)) {
				getHashSet(slns, i, i, wholeStringLen).add(possibleWord);
			}
		}

		// DP starts:
		for (int offset = 0; offset < wholeStringLen; ++offset) {
			for (int i = 0; i < wholeStringLen - offset; ++i) {
				int j = i + offset;
				System.out.println(String.format("%d %d", i, j));
				HashSet<String> curHashSet = getHashSet(slns, i, j, wholeStringLen);
				// If word[i, j] is in dictionary, mark as true.
				String possibleWholeWord = s.substring(i, j + 1);
				// System.out.println(String.format("%s", s.substring(i, j + 1)));
				if (dict.contains(possibleWholeWord)) {
					curHashSet.add(possibleWholeWord);
				}

				// Check string[i, j] can be broken into word[i, k] and word[k + 1, j]
				for (int k = i; k < j; ++k) {
					// String as a whole
					// System.out.println(String.format("%s %s", s.substring(i, k + 1), s.substring(k + 1, j + 1)));
					HashSet<String> leftSentences = getHashSet(slns, i, k, wholeStringLen);
					HashSet<String> rightSentences = getHashSet(slns, k + 1, j, wholeStringLen);
					if (leftSentences != null && rightSentences != null) {
						for (String leftSen : leftSentences) {
							for (String rightSen : rightSentences) {
								curHashSet.add(leftSen + " " + rightSen);
							}
						}
					}
				}
			}
		}
		return new ArrayList<String>(getHashSet(slns, 0, wholeStringLen - 1, wholeStringLen));
	}

	public static void main(String[] args) {
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		Set<String> dict = new HashSet<String>();
		dict.add("a");
		dict.add("aa");
		dict.add("aaa");
		dict.add("aaaa");
		dict.add("aaaaa");
		dict.add("aaaaaa");
		dict.add("aaaaaaa");

		WordBreak2 wb2 = new WordBreak2();
		List<String> ret = wb2.wordBreak(s, dict);
		for (String ws : ret) {
			System.out.println(ws);
		}
		System.out.println("Done");
	}
}
