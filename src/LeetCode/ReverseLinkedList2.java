package LeetCode;

public class ReverseLinkedList2 {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode reverseBetween(ListNode head, int m, int n) {
		int posCount = 1;
		// Set up two pointers, itr2 is always one step faster than itr1
		ListNode itr1 = null;
		ListNode itr2 = head;

		// Move itr2 to pos m, itr1 to m - 1;
		for (; posCount < m; ++posCount) {
			itr1 = itr2;
			itr2 = itr2.next;
		}

		// Save two pointers for further use.
		ListNode newHeadFrom = itr1;
		ListNode newTailFrom = itr2;

		// Move itr to n + 1, itr 1 to n
		// Reverse list as iterating.
		while (posCount < n + 1) {
			ListNode next = itr2.next;
			itr2.next = itr1;
			itr1 = itr2;
			itr2 = next;
			posCount++;
		}

		//
		newTailFrom.next = itr2;
		// Note the corner case.
		if (newHeadFrom == null) {
			return itr1;
		} else {
			newHeadFrom.next = itr1;
			return head;
		}
	}
}
