package LeetCode;

public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}

	ListNode(int x, ListNode nv) {
		val = x;
		next = nv;
	}
}