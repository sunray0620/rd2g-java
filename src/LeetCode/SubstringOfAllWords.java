package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringOfAllWords {

	public static void getNeedsCount(String[] L, HashMap<String, Integer> dict, int[] needsCount) {
		HashMap<String, Integer> wordsPool = new HashMap<String, Integer>();
		for (int i = 0; i < L.length; ++i) {
			String curWord = L[i];
			if (wordsPool.containsKey(curWord)) {
				int curCount = wordsPool.get(curWord);
				wordsPool.put(curWord, curCount + 1);
			} else {
				wordsPool.put(curWord, 1);
			}
		}

		//
		int idx = 0;
		for (String word : wordsPool.keySet()) {
			dict.put(word, idx);
			int curWordCount = wordsPool.get(word);
			needsCount[idx] = curWordCount;
			++idx;
		}
	}

	public static List<Integer> findSubstring(String S, String[] L) {
		List<Integer> ret = new ArrayList<Integer>();

		int wordLen = L[0].length();
		int hayStackLen = S.length();
		int stringArrayLen = L.length;

		// Put words into dictionary.
		HashMap<String, Integer> dict = new HashMap<String, Integer>();
		int[] needsCount = new int[stringArrayLen];
		getNeedsCount(L, dict, needsCount);
		int numOfWords = dict.size();

		for (int rmd = 0; rmd < wordLen; ++rmd) {
			// Some helper counter.
			int[] wordsCount = new int[numOfWords];
			int numOfSatisfiedWords = 0;
			int numOfPossibleWords = (hayStackLen - rmd) / wordLen;
			int[] wds = new int[numOfPossibleWords];
			for (int qt = 0; qt < numOfPossibleWords; ++qt) {
				String curWord = S.substring(qt * wordLen + rmd, (qt + 1) * wordLen + rmd);
				// Pop one from head;
				if (qt - stringArrayLen >= 0 && wds[qt - stringArrayLen] >= 0) {
					int wordIdx = wds[qt - stringArrayLen];
					if (wordsCount[wordIdx] == needsCount[wordIdx]) {
						numOfSatisfiedWords -= 1;
					}
					wordsCount[wordIdx] -= 1;
				}

				// Get current word
				if (dict.containsKey(curWord)) {
					int wordIdx = dict.get(curWord);
					wds[qt] = wordIdx;
					wordsCount[wordIdx] += 1;
					if (wordsCount[wordIdx] == needsCount[wordIdx]) {
						numOfSatisfiedWords += 1;
					}
				} else {
					wds[qt] = -1;
				}

				// If satisfied, add to result.
				if (numOfSatisfiedWords == numOfWords) {
					ret.add((qt - stringArrayLen + 1) * wordLen + rmd);
				}
			}
		}

		return ret;
	}

	public static void main(String[] args) {
		String sss = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
		int llen = 5;
		String[] lll = new String[llen];
		lll[0] = "fooo";
		lll[1] = "barr";
		lll[2] = "wing";
		lll[3] = "ding";
		lll[4] = "wing";
		// lll[1] = "aaaaaaaaaa";
		List<Integer> ret = findSubstring(sss, lll);
		for (int i = 0; i < ret.size(); ++i) {
			System.out.print(String.format("%d, ", ret.get(i)));
		}
		System.out.println();
	}
}
