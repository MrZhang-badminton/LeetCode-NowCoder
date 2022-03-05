package oj.lc.q500.lc61;

import utils.LinkedListUtils;
import utils.node.ListNode;

/**
 * 旋转链表
 *
 * @date 2021年02月27日15:43:38
 */
public class Solution {
	public static ListNode rotateRight(ListNode head, int k) {
		if (head == null) {
			return null;
		}
		int count = 1;
		ListNode ptr = head;
		while (ptr.next != null) {
			count++;
			ptr = ptr.next;
		}
		k = k % count;
		ptr.next = head;
		for (int i = 0; i < count - k; i++) {
			ptr = ptr.next;
		}
		head = ptr.next;
		ptr.next = null;
		return head;
	}

	public static void main(String[] args) {
		ListNode head = LinkedListUtils.getList(new int[]{0, 1, 2});
		LinkedListUtils.printListNode(rotateRight(null, 0));
	}
}
