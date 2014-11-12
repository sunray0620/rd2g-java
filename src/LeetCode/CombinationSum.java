package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public final class CombinationSum {
	/*
	 * Given a set of candidate numbers (C) and a target number (T),
	 * find all unique combinations in C where the candidate numbers sums to T.
	 * 
	 * The same repeated number may be chosen from C unlimited number of times.
	 * 
	 * Note: All numbers (including target) will be positive integers.
	 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
	 * The solution set must not contain duplicate combinations.
	 * For example, given candidate set 2,3,6,7 and target 7,
	 * A solution set is: [7] [2, 2, 3]
	 */

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		Stack<Integer> s = new Stack<Integer>();
		generteSubset(candidates, 0, target, 0, s, ret);
		return ret;
	}

	private void generteSubset(int[] num, int start, int target, int curSum, Stack<Integer> s, List<List<Integer>> ret) {
		if (curSum == target) {
			// Add all values in stack to a new list, and add it to solution set
			ArrayList<Integer> newSet = new ArrayList<Integer>();
			for (Integer vint : s) {
				newSet.add(vint);
			}
			ret.add(newSet);
		}
		// Stop Criteria.
		if (curSum > target || start >= num.length)
			return;

		for (int i = start; i < num.length; ++i) {
			// Prevent duplicate solution list.
			if (i != start && num[i] == num[i - 1])
				continue;
			// Prepare for next cursive call
			s.push(num[i]);
			// Use i to use duplicate elements.
			generteSubset(num, i, target, curSum + num[i], s, ret);
			s.pop();
		}
	}
}
