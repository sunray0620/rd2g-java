package LeetCode;

public class PartitionList {

	public ListNode partition(ListNode head, int x) {
		ListNode h1 = null;
		ListNode t1 = null;
		ListNode h2 = null;
		ListNode t2 = null;

		ListNode itr = head;
		for (; itr != null;) {
			ListNode cur = itr;
			itr = itr.next;
			cur.next = null;

			if (cur.val < x) {
				if (h1 == null) {
					h1 = cur;
					t1 = cur;
				} else {
					t1.next = cur;
					t1 = t1.next;
				}
			} else {
				if (h2 == null) {
					h2 = cur;
					t2 = cur;
				} else {
					t2.next = cur;
					t2 = t2.next;
				}
			}
		}

		if (h1 != null) {
			t1.next = h2;
			return h1;
		} else {
			return h2;
		}
	}

}
