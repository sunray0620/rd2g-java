package LeetCode;

public class ValidateBST {
	public boolean isValidBST(TreeNode root) {
		return isValidBstFromNode(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	private boolean isValidBstFromNode(TreeNode cur, long minLimit, long maxLimit) {
		if (cur == null) {
			return true;
		}
		if (cur.val < minLimit || cur.val > maxLimit) {
			return false;
		}
		long newMaxLimit = (long) cur.val - 1;
		long newMinLimit = (long) cur.val + 1;

		boolean leftTrue = isValidBstFromNode(cur.left, minLimit, newMaxLimit);
		boolean rightTrue = isValidBstFromNode(cur.right, newMinLimit, maxLimit);
		return leftTrue && rightTrue;
	}
}
