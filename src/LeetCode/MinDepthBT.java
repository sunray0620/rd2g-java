package LeetCode;

public class MinDepthBT {

	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return minDepthAtNode(root);
	}

	public int minDepthAtNode(TreeNode curNode) {
		if (curNode.left == null && curNode.right == null)
			return 1;

		int minDepthAtHere = Integer.MAX_VALUE;
		if (curNode.left != null) {
			minDepthAtHere = Math.min(minDepthAtHere, minDepthAtNode(curNode.left));
		}
		if (curNode.right != null) {
			minDepthAtHere = Math.min(minDepthAtHere, minDepthAtNode(curNode.right));
		}
		return minDepthAtHere + 1;
	}
}
