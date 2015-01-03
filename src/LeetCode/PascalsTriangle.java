package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		for (int i = 1; i <= numRows; ++i) {
			if (i == 1) {
				List<Integer> newList = new ArrayList<Integer>();
				newList.add(1);
				ret.add(newList);
				continue;
			}
			List<Integer> curList = new ArrayList<Integer>();
			curList.add(1);
			List<Integer> prevList = ret.get(ret.size() - 1);
			for (int j = 0; j < i - 2; ++j) {
				curList.add(prevList.get(j) + prevList.get(j + 1));
			}
			curList.add(1);
			ret.add(curList);
		}
		return ret;
	}
}
