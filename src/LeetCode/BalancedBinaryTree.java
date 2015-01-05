package LeetCode;

public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		int ret = isBalancedFromNode(root);
		return ret != -1;
	}

	public int isBalancedFromNode(TreeNode curNode) {
		if (curNode == null) {
			return 0;
		}

		int leftDepth = isBalancedFromNode(curNode.left);
		if (leftDepth == -1) {
			return -1;
		}
		int rightDepth = isBalancedFromNode(curNode.right);
		if (rightDepth == -1) {
			return -1;
		}

		if (Math.abs(leftDepth - rightDepth) > 1) {
			return -1;
		}

		return Math.max(leftDepth, rightDepth);
	}
}
