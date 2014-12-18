package LeetCode;

/*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class IntersectionOfTwoLinkedLists {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	private int getLinkedListLength(ListNode head) {
		if (head == null) {
			return 0;
		}
		int length = 0;
		ListNode itr = head;
		while (itr != null) {
			length++;
			itr = itr.next;
		}
		return length;
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int listALen = getLinkedListLength(headA);
		int listBLen = getLinkedListLength(headB);

		ListNode itrA = headA;
		for (int i = 0; i < listALen - listBLen; ++i) {
			itrA = itrA.next;
		}
		ListNode itrB = headB;
		for (int i = 0; i < listBLen - listALen; ++i) {
			itrB = itrB.next;
		}

		for (; itrA != itrB;) {
			itrA = itrA.next;
			itrB = itrB.next;
		}
		return itrA;
	}

}