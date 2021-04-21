package oj.lc.q500.lc82;

import utils.ds.ListNode;

public class Solution {

	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return null;
		}else if(head.next == null){
			return head;
		}

		ListNode p = head.next;
		while (p != null && p.val == head.val) {
			p = p.next;
		}

		if (p == null) {
			return null;
		} else if (p == head.next) {
			head.next = deleteDuplicates(p);
			return head;
		} else {
			return deleteDuplicates(p);
		}

	}

	public static void main(String[] args) {
		ListNode.printListNode(deleteDuplicates(ListNode.getList(new int[]{1, 2, 3, 3, 4, 4, 5})));
	}
}
