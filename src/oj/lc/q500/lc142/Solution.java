package oj.lc.q500.lc142;

import utils.LinkedListUtils;
import utils.node.ListNode;

public class Solution {


	/**
	 * 双指针
	 *
	 * @param head
	 * @return
	 */
	public static ListNode detectCycle2(ListNode head) {
		if (head == null) {
			return null;
		}

		ListNode slow = head, fast = head;
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
			if (fast != null) {
				fast = fast.next;
			}
			if (fast == null) {
				return null;
			}
			if (fast != null && fast == slow) {
				fast = head;
				while (fast != slow) {
					slow = slow.next;
					fast = fast.next;

				}
				return slow;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		ListNode head = LinkedListUtils.createList(new int[]{3, 2, 0, -4});
		head.next.next.next.next = head.next;
		System.out.println(detectCycle2(head).val);
	}
}

