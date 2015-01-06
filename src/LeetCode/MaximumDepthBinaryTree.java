package LeetCode;

public class MaximumDepthBinaryTree {
	public int maxDepth(TreeNode root) {
		return maxDepthFromNode(root);
	}

	private int maxDepthFromNode(TreeNode curNode) {
		if (curNode == null) {
			return 0;
		}
		int leftDepth = maxDepthFromNode(curNode.left);
		int rightDepth = maxDepthFromNode(curNode.right);
		return Math.max(leftDepth, rightDepth) + 1;
	}
}
