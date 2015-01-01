package LeetCode;

public class PopulatingNextRightPointers {
	public void connect(TreeLinkNode root) {
		connectCurrent(root, null);
	}

	public void connectCurrent(TreeLinkNode curNode, TreeLinkNode nextRight) {
		if (curNode == null) {
			return;
		}

		// Connect current node
		curNode.next = nextRight;

		// Prepare for next level
		TreeLinkNode childNextRight = null;
		for (; nextRight != null; nextRight = nextRight.next) {
			if (nextRight.left != null) {
				childNextRight = nextRight.left;
				break;
			} else if (nextRight.right != null) {
				childNextRight = nextRight.right;
				break;
			}
		}

		if (curNode.right != null) {
			connectCurrent(curNode.right, childNextRight);
			childNextRight = curNode.right;
		}
		if (curNode.left != null) {
			connectCurrent(curNode.left, childNextRight);
		}
	}
}
