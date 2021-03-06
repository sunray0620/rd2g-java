package Tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeUtil {

	public static void traverseInOrderRcrv(TreeNode curNode) {
		if (curNode == null) {
			return;
		}
		traverseInOrderRcrv(curNode.left);
		System.out.print(String.format("%1$6s", curNode.data));
		traverseInOrderRcrv(curNode.right);
	}

	public static void traversePreOrderRcrv(TreeNode curNode) {
		if (curNode == null) {
			return;
		}
		System.out.print(String.format("%1$4s", curNode.data));
		traversePreOrderRcrv(curNode.left);
		traversePreOrderRcrv(curNode.right);
	}

	public static void traversePostOrderRcrv(TreeNode curNode) {
		if (curNode == null) {
			return;
		}
		traversePostOrderRcrv(curNode.left);
		traversePostOrderRcrv(curNode.right);
		System.out.print(String.format("%1$10s", curNode.data));
	}

	public static int[] traverseInOrder(TreeNode root) {
		int numOfNodes = numOfNodesInTreeRrcv(root);
		int[] ret = new int[numOfNodes];
		int idx = 0;

		TreeNode itr = root;
		Stack<TreeNode> s = new Stack<TreeNode>();
		while (itr != null || s.size() > 0) {
			if (itr != null) {
				s.push(itr);
				itr = itr.left;
			} else {
				itr = s.pop();
				ret[idx++] = itr.data;
				itr = itr.right;
			}
		}
		return ret;
	}

	public static int[] traversePreOrder(TreeNode root) {
		int numOfNodes = numOfNodesInTreeRrcv(root);
		int[] ret = new int[numOfNodes];
		int idx = 0;

		TreeNode itr = root;
		Stack<TreeNode> s = new Stack<TreeNode>();
		while (itr != null || s.size() > 0) {
			if (itr != null) {
				ret[idx++] = itr.data;
				s.push(itr);
				itr = itr.left;
			} else {
				itr = s.pop();
				itr = itr.right;
			}
		}
		return ret;
	}

	public static int[] traversePostOrder(TreeNode root) {
		int numOfNodes = numOfNodesInTreeRrcv(root);
		int[] ret = new int[numOfNodes];
		int idx = 0;

		TreeNode itr = root;
		Stack<TreeNode> s = new Stack<TreeNode>();
		Stack<Boolean> bs = new Stack<Boolean>();
		while (itr != null || s.size() > 0) {
			if (itr != null) {
				s.push(itr);
				bs.push(false);
				itr = itr.left;
			} else {
				Boolean isVisited = bs.pop();
				if (isVisited) {
					ret[idx++] = s.pop().data;
				} else {
					itr = s.peek().right;
					bs.push(true);
				}
			}
		}
		return ret;
	}

	public static void printByLevel(TreeNode root) {
		if (root == null) {
			System.out.println("(Empty Tree)");
			return;
		}
		Queue<TreeNode> q = new ArrayDeque<TreeNode>();
		q.add(root);
		while (q.size() > 0) {
			int qSize = q.size();
			for (int i = 0; i < qSize; ++i) {
				TreeNode cur = q.poll();
				System.out.print(String.format("[%1$12s]", cur.data));
				if (cur.left != null)
					q.add(cur.left);
				if (cur.right != null)
					q.add(cur.right);
			}
			System.out.println();
		}

	}

	public static TreeNode rotateRight(TreeNode curNode) {
		if (curNode == null || curNode.left == null) {
			return null;
		}
		TreeNode newHead = curNode.left;
		curNode.left = curNode.left.right;
		newHead.right = curNode;
		return newHead;
	}

	public static int numOfNodesInTreeRrcv(TreeNode cur) {
		if (cur == null) {
			return 0;
		}
		int numOfLeftTree = numOfNodesInTreeRrcv(cur.left);
		int numOfRightTree = numOfNodesInTreeRrcv(cur.right);
		return numOfLeftTree + 1 + numOfRightTree;
	}

	public static int heightOfTree(TreeNode cur) {
		if (cur == null) {
			return 0;
		}
		int leftHeight = heightOfTree(cur.left);
		int rightHeight = heightOfTree(cur.right);
		return Math.max(leftHeight, rightHeight) + 1;
	}
}
