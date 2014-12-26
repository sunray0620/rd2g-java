package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset2 {

	public static List<List<Integer>> subsetsWithDup(int[] num) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		ret.add(new ArrayList<Integer>());
		List<Integer> tempRet = new ArrayList<Integer>();
		Arrays.sort(num);
		subsets(num, 0, tempRet, ret);
		return ret;
	}

	public static void subsets(int[] num, int startPos, List<Integer> tempRet, List<List<Integer>> ret) {
		int numLength = num.length;
		if (startPos == numLength) {
			return;
		}

		//
		for (int i = startPos; i < numLength; ++i) {
			if (i > startPos && num[i] == num[i - 1]) {
				continue;
			}
			// Add ith element into set;
			tempRet.add(num[i]);
			ret.add(new ArrayList<Integer>(tempRet));
			subsets(num, i + 1, tempRet, ret);
			tempRet.remove(tempRet.size() - 1);
		}
	}

	public static void main(String[] args) {
		int[] testNum = new int[] { 0 };
		subsetsWithDup(testNum);

	}
}
