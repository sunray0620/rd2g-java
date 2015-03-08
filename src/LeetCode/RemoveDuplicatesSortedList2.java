package LeetCode;

public class RemoveDuplicatesSortedList2 {

	public ListNode deleteDuplicates(ListNode head) {
		ListNode newhead = null;
		ListNode readyTail = null;

		ListNode itr1 = null;
		ListNode itr2 = head;

		while (itr2 != null) {
			int curValue = itr2.val;
			int curValueCount = 0;
			while (itr2 != null && itr2.val == curValue) {
				itr1 = itr2;
				itr2 = itr2.next;
				++curValueCount;
			}

			if (curValueCount == 1) {
				readyTail = itr1;
				if (newhead == null) {
					newhead = readyTail;
				}

			} else if (curValueCount > 1) {
				if (readyTail != null) {
					readyTail.next = itr2;
					itr1 = readyTail;
				}
			}
		}

		return newhead;
	}

}
