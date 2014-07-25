package Tree;

import java.util.Date;
import java.util.Random;

public class BinarySearchTree {

	public static TreeNode generateBST(int generateSize, int minValue, int maxValue) {
		Random rand = new Random((new Date()).getTime());

		TreeNode root = null;
		for (int i = 0; i < generateSize; ++i) {
			int newValue = minValue + rand.nextInt(maxValue + 1);
			insertNode(root, newValue);
		}
		return root;
	}

	public static TreeNode insertNode(TreeNode root, int newValue) {
		if (root == null) {
			return new TreeNode(newValue, null, null);
		}

		TreeNode cur = root;
		while (true) {
			if (newValue <= cur.data) {
				if (cur.left != null) {
					cur = cur.left;
				} else {
					cur.left = new TreeNode(newValue, null, null);
					return root;
				}
			} else {
				if (cur.right != null) {
					cur = cur.right;
				} else {
					cur.right = new TreeNode(newValue, null, null);
					return root;
				}
			}
		}
	}

	public static TreeNode insertNodeRcrv(TreeNode curNode, int newValue) {
		if (curNode == null) {
			return new TreeNode(newValue, null, null);
		}
		if (newValue <= curNode.data) {
			curNode.left = insertNodeRcrv(curNode.left, newValue);
		} else {
			curNode.right = insertNodeRcrv(curNode.right, newValue);
		}
		return curNode;
	}
}
