package LeetCode;

import java.util.Stack;

public class BSTIterator {

	Stack<TreeNode> s;
	TreeNode pitr;

	public BSTIterator(TreeNode root) {
		pitr = root;
		s = new Stack<TreeNode>();
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		if (pitr != null || !s.empty()) {
			return true;
		} else {
			return false;
		}
	}

	/** @return the next smallest number */
	public int next() {
		while (pitr != null || !s.empty()) {
			if (pitr != null) {
				s.push(pitr);
				pitr = pitr.left;
			} else {
				pitr = s.pop();
				int ret = pitr.val;
				pitr = pitr.right;
				return ret;
			}
		}
		// Should never get here;
		return -1;
	}

}
