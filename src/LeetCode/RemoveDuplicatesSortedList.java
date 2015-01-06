package LeetCode;

public class RemoveDuplicatesSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return null;
		}

		ListNode itr = head;
		while (itr.next != null) {
			if (itr.next.val != itr.val) {
				itr = itr.next;
			} else {
				itr.next = itr.next.next;
			}
		}
		return head;
	}
}
