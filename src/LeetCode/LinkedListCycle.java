package LeetCode;

public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		if (head == null) {
			return false;
		}

		ListNode slowerItr = head;
		ListNode fasterItr = head;
		while (true) {
			if (fasterItr.next == null || fasterItr.next.next == null) {
				return false;
			}
			slowerItr = slowerItr.next;
			fasterItr = fasterItr.next.next;
			if (slowerItr == fasterItr) {
				return true;
			}
		}
	}
}