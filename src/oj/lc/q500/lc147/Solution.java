package oj.lc.q500.lc147;

import utils.object.ListNode;

public class Solution {
	public static ListNode insertionSortList(ListNode head) {
		ListNode pHead = new ListNode(-1);
		pHead.next = null;
		ListNode ptr;

		while (head != null) {
			ListNode temp = head;
			head = head.next;
			ptr = pHead;
			while (ptr.next != null && ptr.next.val <= temp.val) {
				ptr = ptr.next;
			}

			if (ptr.next == null) {
				temp.next = null;
				ptr.next = temp;
			} else {
				temp.next = ptr.next;
				ptr.next = temp;
			}
		}
		return pHead.next;
	}

	public static void main(String[] args) {
		ListNode head = ListNode.getList(new int[]{4, 3, 2, 1});
		ListNode.printListNode(insertionSortList(head));
	}
}
