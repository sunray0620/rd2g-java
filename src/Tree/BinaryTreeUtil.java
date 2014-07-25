package Tree;

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

	public static int numOfNodesInTreeRrcv(TreeNode cur) {
		if (cur == null) {
			return 0;
		}
		int numOfLeftTree = numOfNodesInTreeRrcv(cur.left);
		int numOfRightTree = numOfNodesInTreeRrcv(cur.right);
		return numOfLeftTree + 1 + numOfRightTree;
	}
}
