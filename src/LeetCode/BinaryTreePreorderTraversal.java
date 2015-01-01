package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> ret = new ArrayList<Integer>();
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode itr = root;
		while (s.size() > 0 || itr != null) {
			if (itr != null) {
				ret.add(itr.val);
				s.push(itr);
				itr = itr.left;
			} else {
				itr = s.pop();
				itr = itr.right;
			}
		}
		return ret;
	}
}
