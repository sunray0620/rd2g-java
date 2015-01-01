package LeetCode;

import java.util.Stack;

public class RecoverBST {
	public void recoverTree(TreeNode root) {
		int errorFound = 0;
		TreeNode[] errorNodes = new TreeNode[2];
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode prev = null;
		TreeNode itr = root;
		while (itr != null || s.size() > 0) {
			if (itr != null) {
				s.push(itr);
				itr = itr.left;
			} else {
				itr = s.pop();
				//
				if (prev != null && itr.val < prev.val) {
					if (errorFound == 0) {
						errorNodes[0] = prev;
						errorNodes[1] = itr;
						++errorFound;
					} else {
						errorNodes[1] = itr;
						break;
					}
				}
				//
				prev = itr;
				itr = itr.right;
			}
		}

		// Swap the value
		int temp = errorNodes[0].val;
		errorNodes[0].val = errorNodes[1].val;
		errorNodes[1].val = temp;
	}

}
