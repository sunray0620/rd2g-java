package LeetCode;

public class BinaryTreeMaxPathSum {
	int globalMax;

	public int maxPathSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		globalMax = Integer.MIN_VALUE;
		maxPathSumFromNode(root);
		return globalMax;
	}

	public int maxPathSumFromNode(TreeNode cur) {
		if (cur == null) {
			return 0;
		}
		int leftMax = Math.max(maxPathSumFromNode(cur.left), 0);
		int rightMax = Math.max(maxPathSumFromNode(cur.right), 0);
		globalMax = Math.max(globalMax, leftMax + cur.val + rightMax);
		return Math.max(leftMax, rightMax) + cur.val;
	}
}
