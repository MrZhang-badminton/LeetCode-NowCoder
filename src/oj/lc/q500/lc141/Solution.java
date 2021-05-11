package oj.lc.q500.lc141;

import utils.ds.ListNode;

public class Solution {

	public static boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}
		ListNode slow = head, fast = head;
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
			if (fast != null) {
				fast = fast.next;
			}
			if (fast != null && fast == slow) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		ListNode head = ListNode.createList(new int[]{3, 2, 0, 4});
		ListNode p = head.next.next.next;
		p.next = head.next;
		System.out.println(hasCycle(head));
	}
}
