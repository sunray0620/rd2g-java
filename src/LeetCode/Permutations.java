package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	public List<List<Integer>> permute(int[] num) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		permuteRecursive(num, 0, ret);
		return ret;
	}

	public void permuteRecursive(int[] num, int startPos, List<List<Integer>> ret) {
		if (startPos == num.length) {
			ret.add(arrayToList(num));
		}
		for (int i = startPos; i < num.length; ++i) {
			swap(num, startPos, i);
			permuteRecursive(num, startPos + 1, ret);
			swap(num, startPos, i);
		}
	}

	private List<Integer> arrayToList(int[] num) {
		List<Integer> newList = new ArrayList<Integer>();
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
