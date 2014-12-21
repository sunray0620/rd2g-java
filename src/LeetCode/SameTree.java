package LeetCode;

public class SameTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		return isSameNode(p, q);
	}

	public boolean isSameNode(TreeNode tn1, TreeNode tn2) {
		if (tn1 == null && tn2 == null)
			return true;
		else if (tn1 == null || tn2 == null)
			return false;
		else if (tn1.val != tn2.val)
			return false;
		return isSameNode(tn1.left, tn2.left) && isSameNode(tn1.right, tn2.right);
	}
}
