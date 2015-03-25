package LeetCode;

import java.util.HashMap;

public class LongestConsecutiveSequence {

	public int longestConsecutive(int[] num) {
		int maxRange = 0;
		HashMap<Integer, Range> dict = new HashMap<Integer, Range>();
		for (int i = 0; i < num.length; ++i) {
			int v = num[i];
			if (dict.containsKey(v)) {
				continue;
			}

			Range itemRange = new Range(v, v);
			dict.put(v, itemRange);
			Range lowerRange = itemRange;
			Range higherRange = itemRange;

			if (dict.containsKey(v - 1)) {
				lowerRange = dict.get(dict.get(v - 1).low);
			}
			if (dict.containsKey(v + 1)) {
				higherRange = dict.get(dict.get(v + 1).high);
			}

			lowerRange.high = higherRange.high;
			higherRange.low = lowerRange.low;

			if (higherRange.high - higherRange.low + 1 > maxRange) {
				maxRange = higherRange.high - higherRange.low + 1;
			}
		}
		return maxRange;
	}

	class Range {
		int low;
		int high;

		Range(int lv, int hv) {
			low = lv;
			high = hv;
		}
	}

	public static void main(String[] args) {
		int[] testnums = new int[] { 100, 4, 200, 1, 3, 2 };
		LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
		int ret = lcs.longestConsecutive(testnums);
		System.out.println(ret);
	}
}
