package oj.lc.q500.lc92;

import utils.ds.ListNode;

public class Solution {

	/**
	 * 定位 -> 前后合并 -> 将目标字符串，在对应地方头插入链表
	 *
	 * @param head
	 * @param left
	 * @param right
	 * @return
	 */
	public static ListNode reverseBetween2(ListNode head, int left, int right) {
		ListNode pHead = new ListNode(-1);
		pHead.next = head;
		ListNode l = pHead, e = pHead;
		for (int i = 0; i < left - 1; i++) {
			l = l.next;
		}
		for (int i = 0; i < right; i++) {
			e = e.next;
		}

		ListNode cur = l.next;
		l.next = e.next;
		e.next = null;
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = l.next;
			l.next = cur;
			cur = next;
		}
		return pHead.next;
	}


	public static void main(String[] args) {
		ListNode.printListNode(reverseBetween2(ListNode.getList(new int[]{1, 2, 3, 4, 5}), 1, 4));
	}
}
