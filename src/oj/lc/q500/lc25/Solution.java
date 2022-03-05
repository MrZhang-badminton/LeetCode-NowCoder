package oj.lc.q500.lc25;

import utils.LinkedListUtils;
import utils.node.ListNode;

/**
 * 每K个翻转链表
 * 设置pHead结点
 *
 * @date 2021年02月28日14:12:04
 */
public class Solution {
	public static ListNode reverseKGroup(ListNode head, int k) {
		ListNode pHead = new ListNode(-1);
		ListNode p = pHead;
		pHead.next = head;
		int count = k;
		while (p.next != null && count > 0) {
			p = p.next;
			count--;
		}

		if (count > 0) {
			return head;
		}

		pHead.next = reverseKGroup(p.next, k);
		p.next = null;

		while (head != null) {
			ListNode temp = head.next;
			head.next = pHead.next;
			pHead.next = head;
			head = temp;
		}
		return pHead.next;
	}

	public static void main(String[] args) {
		ListNode head = LinkedListUtils.getList(new int[]{1, 2, 3, 4, 5});
		LinkedListUtils.printListNode(reverseKGroup(head, 2));
	}
}
