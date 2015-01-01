package LeetCode;

import java.util.Stack;

public class FlattenBinaryTreeToLinkedList {
	public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(root);
		TreeNode itr = null;

		while (s.size() > 0) {
			TreeNode cur = s.pop();

			if (cur.right != null) {
				s.push(cur.right);
			}
			if (cur.left != null) {
				s.push(cur.left);
			}

			cur.left = cur.right = null;
			if (itr == null) {
				itr = root = cur;
			} else {
				itr.right = cur;
				itr = itr.right;
			}
		}
	}
}
