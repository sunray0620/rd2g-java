package UnitTests;

import java.util.Random;

import Tree.BinarySearchTree;
import Tree.BinaryTreeUtil;
import Tree.TreeNode;

public class ArrayTests {
	public static void main(String[] args) {
		Random rand = new Random();
		TreeNode root = null;
		for (int i = 0; i < 20; ++i) {
			root = BinarySearchTree.insertNode(root, rand.nextInt(100));
		}

		BinaryTreeUtil.printByLevel(root);
		System.out.println();

		while (root != null && root.left != null) {
			root = BinaryTreeUtil.rotateRight(root);
		}
		TreeNode itr = root;
		while (itr.right != null) {
			while (itr.right.left != null) {
				itr.right = BinaryTreeUtil.rotateRight(itr.right);
			}
			itr = itr.right;
		}

		BinaryTreeUtil.printByLevel(root);
		System.out.println();
	}
}
