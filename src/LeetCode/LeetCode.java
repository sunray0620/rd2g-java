package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LeetCode {
	
	// TODO: Separate them into different classes.
	/*************************
	 * Valid Number
	 * 
	 * @param s
	 * @return
	 *************************/
	public boolean isNumber(String s) {
		s = s.trim();
		if (s.length() == 0)
			return false;

		if (s.indexOf('e') == -1) {
			return isReal(s);
		} else if (s.indexOf('e') != s.lastIndexOf('e')) {
			return false;
		} else {
			String[] parts = s.split("e");
			if (parts.length != 2)
				return false;
			return isReal(parts[0]) && isInt(parts[1]);
		}
	}

	private boolean isReal(String s) {
		if (s.indexOf('+') == 0 || s.indexOf('-') == 0) {
			s = s.substring(1);
		}
		if (s.length() == 0)
			return false;

		if (s.indexOf('.') == -1) {
			return isAllDigit(s);
		} else if (s.indexOf('.') != s.lastIndexOf('.')) {
			return false;
		} else {
			String[] parts = s.split("\\.");
			if (parts.length != 1 && parts.length != 2)
				return false;
			for (int i = 0; i < parts.length; ++i) {
				if (!isAllDigit(parts[i]))
					return false;
			}
		}

		return true;
	}

	private boolean isInt(String s) {
		if (s.indexOf('+') == 0 || s.indexOf('-') == 0) {
			s = s.substring(1);
		}
		if (s.length() == 0) {
			return false;
		}
		return isAllDigit(s);
	}

	private boolean isAllDigit(String s) {
		for (int i = 0; i < s.length(); ++i) {
			if (!Character.isDigit(s.charAt(i)))
				return false;
		}
		return true;
	}

	/****************************
	 * Sqrt(x)
	 * 
	 * @param x
	 * @return
	 ****************************/
	public int sqrt(int x) {
		int maxResult = 46341;
		int minResult = 0;
		while (minResult < maxResult - 1) {
			int m = (maxResult + minResult) / 2;
			if (m * m <= x)
				minResult = m;
			else
				maxResult = m;
		}
		return minResult;
	}

	/*************************
	 * Combination Sum
	 * 
	 * @param candidates
	 * @param target
	 * @return
	 **************************/
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

	/*************************
	 * Combination Sum II
	 * 
	 * @param num
	 * @param target
	 * @return
	 **************************/
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
