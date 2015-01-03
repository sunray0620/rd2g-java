package LeetCode;

public class InsertionSortList {

	public ListNode insertionSortList(ListNode head) {
		if (head == null) {
			return head;
		}

		ListNode pe = head;
		while (pe.next != null) {
			// Special case: current is the largest so far, then skip
			if (pe.next.val >= pe.val) {
				pe = pe.next;
				continue;
			}
			// Remove the current node from its original place.
			ListNode nodeToMove = pe.next;
			pe.next = nodeToMove.next;
			// Insert to in-order place.
			// - Case 1: current node is smaller than head.
			if (nodeToMove.val < head.val) {
				nodeToMove.next = head;
				head = nodeToMove;
				continue;
			}
			// - Case 2: find the place and insert.
			ListNode itr = head;
			while (itr.next.val < nodeToMove.val) {
				itr = itr.next;
			}
			nodeToMove.next = itr.next;
			itr.next = nodeToMove;
		}
		return head;
	}

}
