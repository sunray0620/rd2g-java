package LeetCode;

public class SymmetricTree {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		return isSymmetricNode(root.left, root.right);
	}

	public boolean isSymmetricNode(TreeNode n1, TreeNode n2) {
		if (n1 == null && n2 == null)
			return true;
		else if (n1 == null || n2 == null)
			return false;
		else if (n1.val != n2.val)
			return false;
		return isSymmetricNode(n1.left, n2.right) && isSymmetricNode(n1.right, n2.left);
	}
}
