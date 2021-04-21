package oj.lc.q500.lc92;

import utils.ds.ListNode;

public class Solution {

	/**
	 * 时间复杂度O(n)、空间复杂度O(1)
	 * 遍历一遍
	 *
	 * @param head
	 * @param m
	 * @param n
	 * @return
	 */
	public static ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null) {
			return null;
		}

		ListNode pre = null, cur = head;
		while (m > 1) {
			pre = cur;
			cur = cur.next;
			m--;
			n--;
		}

		ListNode ptr = null, con = pre, tail = cur;

		while (n > 0) {
			ptr = cur.next;
			cur.next = pre;
			pre = cur;
			cur = ptr;
			n--;
		}
		if (con != null) {
			con.next = pre;

		} else {
			head = pre;
		}

		tail.next = cur;

		return head;
	}


	public static void main(String[] args) {
		ListNode.printListNode(reverseBetween(ListNode.getList(new int[]{1, 2, 3, 4, 5}), 1, 4));
	}
}
