package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeZigzagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (root == null) {
			return ret;
		}

		int level = 0;
		Stack<TreeNode> cur = new Stack<TreeNode>();
		Stack<TreeNode> next = new Stack<TreeNode>();
		cur.add(root);
		while (cur.size() > 0) {
			++level;
			int levelSize = cur.size();
			List<Integer> levelRet = new ArrayList<Integer>();
			for (int i = 0; i < levelSize; ++i) {
				TreeNode curNode = cur.pop();
				levelRet.add(curNode.val);
				if (level % 2 == 1) {
					if (curNode.left != null) {
						next.push(curNode.left);
					}
					if (curNode.right != null) {
						next.push(curNode.right);
					}
				} else {
					if (curNode.right != null) {
						next.push(curNode.right);
					}
					if (curNode.left != null) {
						next.push(curNode.left);
					}
				}
			}
			ret.add(levelRet);
			cur = next;
			next = new Stack<TreeNode>();
		}
		return ret;
	}
}
