package UnitTests;

import Array.ArrayUtil;
import Tree.BinarySearchTree;
import Tree.BinaryTreeUtil;
import Tree.TreeNode;

public class ArrayTests {
	public static void main(String[] args) {
		TreeNode root = null;

		int[] testArray = ArrayUtil.generateRandomArray(20, 11, 20);
		for (int i = 0; i < testArray.length; ++i) {
			root = BinarySearchTree.insertNodeRcrv(root, testArray[i]);
		}

		int[] ret = BinaryTreeUtil.traverseInOrder(root);
		ArrayUtil.printArrayWithIndex(ret, 5);
		return;
	}
}
