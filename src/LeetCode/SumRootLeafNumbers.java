package LeetCode;

public class SumRootLeafNumbers {
	public int sumNumbers(TreeNode root) {
		int[] nums = new int[2];
		sumNumbersRecursive(root, nums);
		return nums[1];
	}

	public void sumNumbersRecursive(TreeNode curNode, int[] nums) {
		if (curNode == null) {
			return;
		} else if (curNode.left == null && curNode.right == null) {
			nums[0] = nums[0] * 10 + curNode.val;
			nums[1] += nums[0];
			nums[0] /= 10;
			return;
		}

		nums[0] = nums[0] * 10 + curNode.val;
		sumNumbersRecursive(curNode.left, nums);
		sumNumbersRecursive(curNode.right, nums);
		nums[0] /= 10;
	}
}
