package Tree;

public class BinaryTreeUtil {

	public static void traverseInOrder(TreeNode curNode) {
		if (curNode == null) {
			return;
		}
		traverseInOrder(curNode.left);
		System.out.print(String.format("%1$10s", curNode.data));
		traverseInOrder(curNode.right);
	}

	public static void traversePreOrder(TreeNode curNode) {
		if (curNode == null) {
			return;
		}
		System.out.print(String.format("%1$10s", curNode.data));
		traverseInOrder(curNode.left);
		traverseInOrder(curNode.right);
	}

	public static void traversePostOrder(TreeNode curNode) {
		if (curNode == null) {
			return;
		}
		traverseInOrder(curNode.left);
		traverseInOrder(curNode.right);
		System.out.print(String.format("%1$10s", curNode.data));
	}
}
