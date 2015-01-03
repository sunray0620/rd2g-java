package LeetCode;

public class ReverseNodesKGroup {

	public static void printLinkedList(ListNode head) {
		ListNode itr = head;
		while (itr != null) {
			System.out.print(String.format("%d, ", itr.val));
			itr = itr.next;
		}
		System.out.println();
	}

	public static ListNode reverseKGroup(ListNode head, int k) {
		ListNode h1 = null;
		ListNode h2 = head;

		while (true) {
			// Probe go k steps to see if the end is reached.
			ListNode itr = h2;
			for (int i = 0; i < k; ++i) {
				if (itr == null) {
					return head;
				}
				itr = itr.next;
			}

			// Start reverse this group
			ListNode prev = h1;
			ListNode cur = h2;
			for (int i = 0; i < k; ++i) {
				ListNode next = cur.next;
				cur.next = prev;
				prev = cur;
				cur = next;
			}
			ListNode t1 = prev;
			ListNode t2 = cur;

			// Reconnect this group.
			if (h1 == null) {
				head = t1;
			} else {
				h1.next = t1;
			}
			h2.next = t2;
			h1 = h2;
			h2 = t2;
		}
	}

	public static void main(String[] args) {
		int testSize = 9;
		int groupSize = 8;
		ListNode head = null;
		for (int i = 0; i < testSize; ++i) {
			head = new ListNode(testSize - i, head);
		}
		printLinkedList(head);

		head = reverseKGroup(head, groupSize);
		printLinkedList(head);
	}
}
