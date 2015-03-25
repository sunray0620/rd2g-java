package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations2 {

	public List<List<Integer>> permuteUnique(int[] num) {
		Arrays.sort(num);
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		permuteRecursive(num, 0, ret);
		return ret;
	}

	public void permuteRecursive(int[] num, int startPos, List<List<Integer>> ret) {
		if (startPos == num.length) {
			ret.add(arrayToList(num));
			return;
		}
		Set<Integer> seenValues = new HashSet<Integer>();

		for (int i = startPos; i < num.length; ++i) {
			if (seenValues.contains(num[i])) {
				continue;
			}
			seenValues.add(num[i]);
			swap(num, startPos, i);
			permuteRecursive(num, startPos + 1, ret);
			swap(num, startPos, i);
		}
	}

	private List<Integer> arrayToList(int[] num) {
		List<Integer> newList = new ArrayList<Integer>(num.length);
		for (int i = 0; i < num.length; ++i) {
			newList.add(num[i]);
		}
		return newList;
	}

	private void swap(int[] num, int i, int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}

}
