package oj.lc.q500.lc23;

import utils.LinkedListUtils;
import utils.node.ListNode;

public class Solution {

	/**
	 * 往一个ansList分别合并链表
	 *
	 * @param heads
	 * @return
	 */
	public static ListNode mergeKLists(ListNode[] heads) {
		if (heads == null || heads.length == 0) {
			return null;
		}
		ListNode head = heads[0];
		return merge(heads, head, 1);
	}

	public static ListNode merge(ListNode[] heads, ListNode head, int index) {
		int n = heads.length;
		if (index >= n) {
			return head;
		}

		ListNode pHead = new ListNode(-1);
		ListNode tail = pHead;
		ListNode p = head, q = heads[index];
		while (p != null && q != null) {
			if (p.val < q.val) {
				tail.next = p;
				p = p.next;
			} else {
				tail.next = q;
				q = q.next;
			}
			tail = tail.next;
		}
		tail.next = (p != null) ? p : q;
		return merge(heads, pHead.next, ++index);
	}


	/**
	 * 归并合并
	 *
	 * @param heads
	 * @return
	 */
	public static ListNode mergeKLists2(ListNode[] heads) {
		return merge(heads, 0, heads.length - 1);
	}

	public static ListNode merge(ListNode[] heads, int l, int r) {
		if (l == r) {
			return heads[l];
		}
		if (l > r) {
			return null;
		}
		int mid = (l + r) >> 1;
		return mergeTwoLists(merge(heads, l, mid), merge(heads, mid + 1, r));
	}

	public static ListNode mergeTwoLists(ListNode head1, ListNode head2) {
		if (head1 == null || head2 == null) {
			return head1 != null ? head1 : head2;
		}

		ListNode pHead = new ListNode();
		ListNode tail = pHead, p = head1, q = head2;
		while (p != null && q != null) {
			if (p.val < q.val) {
				tail.next = p;
				p = p.next;
			} else {
				tail.next = q;
				q = q.next;
			}
			tail = tail.next;
		}
		tail.next = (p != null) ? p : q;
		return pHead.next;

	}

	public static void main(String[] args) {

		ListNode[] heads = new ListNode[]{
				LinkedListUtils.createList(new int[]{1, 2, 3, 4, 5}),
				LinkedListUtils.createList(new int[]{2, 5, 6, 66}),
				LinkedListUtils.createList(new int[]{4, 100, 101})
		};

		ListNode head = mergeKLists2(heads);
		LinkedListUtils.printListNode(head);

	}
}
