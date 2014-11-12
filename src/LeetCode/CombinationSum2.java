package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public final class CombinationSum2 {

	/*
	 * Given a collection of candidate numbers (C) and a target number (T),
	 * find all unique combinations in C where the candidate numbers sums to T.
	 * 
	 * Each number in C may only be used once in the combination.
	 * 
	 * Note:
	 * All numbers (including target) will be positive integers.
	 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
	 * The solution set must not contain duplicate combinations.
	 * For example, given candidate set 10,1,2,7,6,1,5 and target 8,
	 * A solution set is:
	 * [1, 7]
	 * [1, 2, 5]
	 * [2, 6]
	 * [1, 1, 6]
	 */
	public List<List<Integer>> combinationSum2(int[] num, int target) {
		Arrays.sort(num);
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		Stack<Integer> s = new Stack<Integer>();
		generateSubset2(num, 0, target, 0, s, ret);
		return ret;
	}

	private void generateSubset2(int[] num, int start, int target, int curSum, Stack<Integer> s, List<List<Integer>> ret) {
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
			generateSubset2(num, i + 1, target, curSum + num[i], s, ret);
			s.pop();
		}
	}
}
