package LeetCode;

public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		return hasPathSumFromNode(root, sum, 0);
	}

	private boolean hasPathSumFromNode(TreeNode cur, int sum, int curSum) {
		if (cur == null) {
			return false;
		}
		curSum += cur.val;
		if (cur.left == null && cur.right == null && curSum == sum) {
			return true;
		}
		return hasPathSumFromNode(cur.left, sum, curSum) || hasPathSumFromNode(cur.right, sum, curSum);
	}
}
