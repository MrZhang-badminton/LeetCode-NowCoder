package oj.lc.temp.lc148;

import utils.object.ListNode;

public class Solution {


	/**
	 * BubbleSort-LinkedList
	 * @param head
	 * @return
	 */
	public static ListNode sortList(ListNode head) {
		if (head == null) {
			return null;
		}
		int n = 0;
		ListNode p = head;
		while (p != null) {
			n++;
			p = p.next;
		}
		ListNode pHead = new ListNode(-1);
		pHead.next = head;
		for (int i = n - 1; i >= 1; i--) {
			p = pHead;
			for (int j = 0; j < i; j++) {
				ListNode pre = p.next, post = p.next.next;
				if (pre.val > post.val) {
					pre.next = post.next;
					p.next = post;
					post.next = pre;
				}
				p = p.next;
			}
		}
		return pHead.next;
	}

	/**
	 * 分治法，待完成
	 * @param head
	 * @return
	 */
	public static ListNode sortList2(ListNode head) {

		return null;
	}

	public static void main(String[] args) {
		ListNode head = ListNode.getList(new int[]{4, 2, 1, 3});
		ListNode.printListNode(sortList2(head));
	}
}
