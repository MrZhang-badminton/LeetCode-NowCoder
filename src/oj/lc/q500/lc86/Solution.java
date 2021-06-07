package oj.lc.q500.lc86;

import utils.ds.ListNode;

public class Solution {
	public static ListNode partition(ListNode head, int x) {
		ListNode pHead = new ListNode(-1);
		pHead.next = head;
		ListNode pHead2 = new ListNode(-1);
		ListNode tail = pHead2;
		ListNode p = pHead;
		while (p.next != null) {
			if (p.next.val < x) {
				ListNode q = p.next;
				ListNode next = q.next;
				q.next = null;
				tail.next = q;
				tail = tail.next;
				p.next = next;
			} else {
				p = p.next;
			}
		}
		tail.next = pHead.next;
		return pHead2.next;
	}

	public static void main(String[] args) {
		ListNode head = ListNode.createList(new int[]{1, 4, 3, 2, 5, 2});
		ListNode.printListNode(partition(head, 3));
	}
}
