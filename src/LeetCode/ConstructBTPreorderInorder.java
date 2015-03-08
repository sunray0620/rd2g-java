package LeetCode;

public class ConstructBTPreorderInorder {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int sz = preorder.length;
		if (sz <= 0) {
			return null;
		}
		return buildSubTree(preorder, 0, sz - 1, inorder, 0, sz - 1);
	}

	public TreeNode buildSubTree(int[] preorder, int pl, int pu, int[] inorder, int il, int iu) {
		if (pl > pu) {
			return null;
		}

		int curValue = preorder[pl];
		TreeNode curNode = new TreeNode(curValue);
		// Find this value in in-order array.
		int inPos = findVal(curValue, inorder, il, iu);
		int leftSize = inPos - il;
		int rightSize = iu - inPos;
		curNode.left = buildSubTree(preorder, pl + 1, pl + leftSize, inorder, il, inPos - 1);
		curNode.right = buildSubTree(preorder, pu - rightSize + 1, pu, inorder, inPos + 1, iu);

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

	public static void main(String[] args) {
		int[] preorder = new int[] { 1, 2 };
		int[] inorder = new int[] { 2, 1 };
		ConstructBTPreorderInorder cbt = new ConstructBTPreorderInorder();
		cbt.buildTree(preorder, inorder);
	}
}
