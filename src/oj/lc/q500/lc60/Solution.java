package oj.lc.q500.lc60;

import utils.ds.ListNode;

/**
 * @date 2021年02月24日11:03:30
 */
public class Solution {

	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		ListNode ptrA = headA, ptrB = headB;
		while (ptrA != ptrB) {
			ptrA = ptrA.next != null ? ptrA.next : headB;
			ptrB = ptrB.next != null ? ptrB.next : headA;
		}
		return ptrA;
	}

	public static void main(String[] args) {
		ListNode head1 = ListNode.getList(new int[]{1, 2, 3, 4, 5, 6});
		ListNode head2 = ListNode.getList(new int[]{1, 2});
		head2.next.next = head1.next.next;
		System.out.println(getIntersectionNode(head1, head2).val);
	}
}
