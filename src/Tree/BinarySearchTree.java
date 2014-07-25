package Tree;

import java.util.Date;
import java.util.Random;

public class BinarySearchTree {

	public static TreeNode generateBST(int generateSize, int minValue, int maxValue) {
		Random rand = new Random((new Date()).getTime());

		TreeNode root = null;
		for (int i = 0; i < generateSize; ++i) {
			int newValue = minValue + rand.nextInt(maxValue + 1);
			insert(root, newValue);
		}
		return root;
	}

	public static void insert(TreeNode root, int newValue) {
		if (root == null) {
			root = new TreeNode(newValue, null, null);
		}
		TreeNode p = null;
		TreeNode cur = root;
		while (cur != null) {
			p = cur;
			if (newValue <= cur.data) {
				cur = cur.left;
			} else {
				cur = cur.right;
			}
		}

		if (newValue <= p.data) {
			p.left = new TreeNode(newValue, null, null);
		} else {
			p.right = new TreeNode(newValue, null, null);
		}
	}

	public static TreeNode insertNodeRcr(TreeNode curNode, int newValue) {
		if (curNode == null) {
			return new TreeNode(newValue, null, null);
		}
		if (newValue <= curNode.data) {
			curNode.left = insertNodeRcr(curNode.left, newValue);
		} else {
			curNode.right = insertNodeRcr(curNode.right, newValue);
		}
		return curNode;
	}
}
