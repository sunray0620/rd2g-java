package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class BinaryTreeLevelOrderTraversal2 {

	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (root == null) {
			return ret;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while (q.size() > 0) {
			List<Integer> levelRet = new ArrayList<Integer>();
			int levelSize = q.size();
			for (int i = 0; i < levelSize; ++i) {
				TreeNode curNode = q.poll();
				levelRet.add(curNode.val);
				if (curNode.left != null) {
					q.add(curNode.left);
				}
				if (curNode.right != null) {
					q.add(curNode.right);
				}
			}
			ret.add(levelRet);
		}
		Collections.reverse(ret);
		return ret;
	}
}
