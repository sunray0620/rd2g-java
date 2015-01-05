package LeetCode;

import java.util.HashMap;

public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] ret = new int[2];
		for (int i = 0; i < numbers.length; ++i) {
			int curValue = numbers[i];
			int valueToFind = target - numbers[i];
			if (map.containsKey(valueToFind)) {
				ret[0] = map.get(valueToFind);
				ret[1] = i + 1;
			}
			map.put(curValue, i + 1);
		}
		return ret;
	}
}
