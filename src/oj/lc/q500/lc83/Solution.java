package oj.lc.q500.lc83;

import utils.ds.ListNode;

public class Solution {
	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode p = head.next;
		while (p!= null && p.val == head.val) {
			p = p.next;
		}
		head.next = deleteDuplicates(p);
		return head;
	}

	public static void main(String[] args) {
		ListNode.printListNode(deleteDuplicates(ListNode.getList(new int[]{1, 2, 3, 3, 4, 4, 5})));
	}

}
