package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PathSum2 {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		Stack<Integer> curPath = new Stack<Integer>();
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		pathSumFromNode(root, sum, 0, curPath, ret);
		return ret;
	}

	private void pathSumFromNode(TreeNode curNode, int sum, int curSum, Stack<Integer> curPath, List<List<Integer>> ret) {
		if (curNode == null) {
			return;
		}

		curSum += curNode.val;
		curPath.push(curNode.val);
		if (curNode.left == null && curNode.right == null && curSum == sum) {
			ret.add(new ArrayList<Integer>(curPath));
		}

		pathSumFromNode(curNode.left, sum, curSum, curPath, ret);
		pathSumFromNode(curNode.right, sum, curSum, curPath, ret);
		curPath.pop();
	}
}
