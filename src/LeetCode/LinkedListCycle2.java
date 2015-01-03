package LeetCode;

public class LinkedListCycle2 {
	public ListNode detectCycle(ListNode head) {
		if (head == null) {
			return head;
		}

		//
		ListNode slow = head;
		ListNode fast = head;
		while (true) {
			if (fast.next == null || fast.next.next == null) {
				return null;
			}
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				break;
			}
		}

		//
		ListNode itr1 = head;
		ListNode itr2 = fast;
		while (itr1 != itr2) {
			itr1 = itr1.next;
			itr2 = itr2.next;
		}
		return itr1;
	}
}
