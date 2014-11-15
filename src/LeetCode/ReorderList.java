package LeetCode;

/*
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * You must do this in-place without altering the nodes' values.
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */

public class ReorderList {

	/**
	 * Predefined data structure
	 */
	class ListNode {
		int val;
		ListNode next;

		public ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public void reorderList(ListNode head) {
		// Count list length
		int listLen = 0;
		for (ListNode itr = head; itr != null; itr = itr.next, ++listLen)
			;
		// Construct array of reference
		ListNode[] nodes = new ListNode[listLen];
		ListNode itr = head;
		for (int i = 0; i < listLen; ++i) {
			nodes[i] = itr;
			itr = itr.next;
		}
		// Start.
		for (int i = 0; i < (listLen - 1) / 2; ++i) {
			ListNode n1 = nodes[i];
			ListNode n2 = nodes[i + 1];
			ListNode n3 = nodes[listLen - i - 2];
			ListNode n4 = nodes[listLen - i - 1];

			n1.next = n4;
			n4.next = n2;
			n3.next = null;
		}
	}

	/**
	 * Debug function
	 */
	public void printList(ListNode head) {
		ListNode itr = head;
		for (; itr != null; itr = itr.next) {
			System.out.print(String.format("\t%d", itr.val));
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ListNode head = null;
		int testLen = 3;
		for (int i = 0; i < testLen; ++i) {
			// ListNode n = new ListNode(testLen - i);
			// n.next = head;
			// head = n;
		}

		ReorderList rl = new ReorderList();
		rl.printList(head);
		rl.reorderList(head);
		rl.printList(head);

	}
}
