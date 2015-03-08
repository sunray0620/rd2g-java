package LeetCode;

public class ConstructBTInorderPostorder {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		int sz = inorder.length;
		if (sz <= 0) {
			return null;
		}
		return buildSubTree(inorder, 0, sz - 1, postorder, 0, sz - 1);
	}

	public TreeNode buildSubTree(int[] inorder, int il, int iu, int[] postorder, int pl, int pu) {
		if (pl > pu) {
			return null;
		}

		int curValue = postorder[pu];
		TreeNode curNode = new TreeNode(curValue);
		// Find this value in in-order array.
		int inPos = findVal(curValue, inorder, il, iu);
		int leftSize = inPos - il;
		int rightSize = iu - inPos;
		curNode.left = buildSubTree(inorder, il, inPos - 1, postorder, pl, pl + leftSize - 1);
		curNode.right = buildSubTree(inorder, inPos + 1, iu, postorder, pu - rightSize, pu - 1);

		return curNode;
	}

	private int findVal(int val, int[] array, int l, int u) {
		for (int i = l; i <= u; ++i) {
			if (array[i] == val) {
				return i;
			}
		}
		return -1;
	}
}
