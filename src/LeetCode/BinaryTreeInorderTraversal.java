package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> ret = new ArrayList<Integer>();
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode itr = root;
		while (s.size() > 0 || itr != null) {
			if (itr != null) {
				s.push(itr);
				itr = itr.left;
			} else {
				itr = s.pop();
				ret.add(itr.val);
				itr = itr.right;
			}
		}
		return ret;
	}
}
