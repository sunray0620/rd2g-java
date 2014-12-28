package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBSTs2 {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
	}

	public List<TreeNode> generateTrees(int n) {
		return generateTreesH(1, n);
	}

	public List<TreeNode> generateTreesH(int l, int u) {
		List<TreeNode> ret = new ArrayList<TreeNode>();
		if (l > u) {
			ret.add(null);
			return ret;
		}

		for (int i = l; i <= u; ++i) {
			List<TreeNode> leftTrees = generateTreesH(l, i - 1);
			List<TreeNode> rightTrees = generateTreesH(i + 1, u);
			for (int li = 0; li < leftTrees.size(); ++li) {
				for (int ri = 0; ri < rightTrees.size(); ++ri) {
					TreeNode newRoot = new TreeNode(i);
					newRoot.left = leftTrees.get(li);
					newRoot.right = rightTrees.get(ri);
					ret.add(newRoot);
				}
			}
		}
		return ret;
	}

}
