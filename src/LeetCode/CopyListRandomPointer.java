package LeetCode;

class RandomListNode {
	int label;
	RandomListNode next;
	RandomListNode random;

	RandomListNode(int x) {
		this.label = x;
	}

	RandomListNode(int x, RandomListNode nv, RandomListNode rnv) {
		this.label = x;
		this.next = nv;
		this.random = rnv;
	}
};

public class CopyListRandomPointer {
	public static RandomListNode copyRandomList(RandomListNode head) {
		for (RandomListNode itr = head; itr != null;) {
			RandomListNode next = itr.next;
			RandomListNode newNode = new RandomListNode(itr.label);
			newNode.random = null;
			newNode.next = next;
			itr.next = newNode;
			itr = next;
		}

		for (RandomListNode itr = head; itr != null; itr = itr.next.next) {
			itr.next.random = (itr.random == null) ? null : itr.random.next;
		}

		RandomListNode newhead = null;
		RandomListNode newTail = null;
		for (RandomListNode itr = head; itr != null;) {
			RandomListNode originalNext = itr.next.next;
			RandomListNode nodeInNewList = itr.next;
			if (newTail == null) {
				newhead = nodeInNewList;
				newTail = nodeInNewList;
			} else {
				newTail.next = nodeInNewList;
				newTail = newTail.next;
			}
			itr.next = originalNext;
			itr = originalNext;
		}
		return newhead;
	}

	public static void main(String[] args) {
		int n = 10;
		RandomListNode head = null;
		for (int i = 0; i < n; ++i) {
			head = new RandomListNode(n - i, head, null);
		}

		for (RandomListNode itr = head; itr != null; itr = itr.next) {
			System.out.print(String.format("%d, ", itr.label));
		}
		System.out.println();
		System.out.println();

		RandomListNode newhead = copyRandomList(head);
		for (RandomListNode itr = head; itr != null; itr = itr.next) {
			System.out.print(String.format("%d, ", itr.label));
		}
		System.out.println();
		for (RandomListNode itr = newhead; itr != null; itr = itr.next) {
			System.out.print(String.format("%d, ", itr.label));
		}
		System.out.println();
	}
}
