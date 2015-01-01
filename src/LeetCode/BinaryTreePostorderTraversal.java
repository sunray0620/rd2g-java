package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> ret = new ArrayList<Integer>();
		Stack<TreeNode> ns = new Stack<TreeNode>();
		Stack<Boolean> seen = new Stack<Boolean>();
		TreeNode itr = root;
		while (itr != null || ns.size() > 0) {
			if (itr != null) {
				ns.push(itr);
				seen.push(false);
				itr = itr.left;
			} else {
				boolean curseen = seen.pop();
				TreeNode curnode = ns.pop();
				if (!curseen) {
					ns.push(curnode);
					seen.push(true);
					itr = curnode.right;
				} else {
					ret.add(curnode.val);
				}
			}
		}

		return ret;
	}
}
