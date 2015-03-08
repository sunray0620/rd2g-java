package LeetCode;

public class ConvertSortedArr2BST {
	public TreeNode sortedArrayToBST(int[] num) {
		if (num.length <= 0)
			return null;
		return buildSubTree(num, 0, num.length - 1);
	}

	public TreeNode buildSubTree(int[] num, int l, int u) {
		if (l > u) {
			return null;
		}
		int m = (l + u) >> 1;
		TreeNode curNode = new TreeNode(num[m]);
		curNode.left = buildSubTree(num, l, m - 1);
		curNode.right = buildSubTree(num, m + 1, u);
		return curNode;
	}
}
