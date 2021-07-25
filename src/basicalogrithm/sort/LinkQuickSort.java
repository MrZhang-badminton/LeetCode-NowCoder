package basicalogrithm.sort;

import utils.ds.ListNode;

/**
 * 链表快排
 *
 * @author Peter Hua
 * @date 2021年04月22日00:48:53p.next = pivot;
 */
public class LinkQuickSort {

	public static void main(String[] args) {
		ListNode.printListNode(sortList(ListNode.getList(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1})));

	}

	public static ListNode quickSort(ListNode head) {
		if (head == null) {
			return null;
		}

		ListNode pivot = head;
		int pivotVal = head.val;
		head = head.next;
		ListNode lHead = new ListNode(-1);
		ListNode rHead = new ListNode(-1);
		ListNode lTail = lHead, rTail = rHead;

		while (head != null) {
			ListNode tNode = head.next;
			if (head.val <= pivotVal) {
				lTail.next = head;
				lTail = lTail.next;
				lTail.next = null;
			} else {
				rTail.next = head;
				rTail = rTail.next;
				rTail.next = null;
			}
			head = tNode;
		}
		lHead.next = quickSort(lHead.next);
		rHead.next = quickSort(rHead.next);
		ListNode p = lHead;
		while (p.next != null) {
			p = p.next;
		}
		p.next = pivot;
		pivot.next = rHead.next;

		return lHead.next;

	}

	public static ListNode sortList(ListNode head) {
		if (head == null) {
			return null;
		}

		ListNode pivot = null;
		if (head.next != null && head.next.next != null) {
			pivot = findMidNodeandRemove(head);
		} else {
			pivot = head;
			head = head.next;
		}
		int pivotVal = pivot.val;
		ListNode lHead = new ListNode(-1);
		ListNode rHead = new ListNode(-1);
		ListNode lTail = lHead, rTail = rHead;

		while (head != null) {
			ListNode tNode = head.next;
			if (head.val <= pivotVal) {
				lTail.next = head;
				lTail = lTail.next;
				lTail.next = null;
			} else {
				rTail.next = head;
				rTail = rTail.next;
				rTail.next = null;
			}
			head = tNode;
		}
		lHead.next = sortList(lHead.next);
		rHead.next = sortList(rHead.next);
		ListNode p = lHead;
		while (p.next != null) {
			p = p.next;
		}
		p.next = pivot;
		pivot.next = rHead.next;

		return lHead.next;

	}

	public static ListNode findMidNodeandRemove(ListNode head) {
		ListNode ppHead = new ListNode(-1);
		ListNode pHead = new ListNode(-1);
		ppHead.next = pHead;
		pHead.next = head;

		ListNode pre = ppHead, slow = pHead, fast = pHead;
		while (fast.next != null) {
			pre = pre.next;
			slow = slow.next;
			fast = fast.next;
			if (fast.next != null) {
				fast = fast.next;
			}
		}
		ListNode midNode = slow;
		pre.next = slow.next;
		slow.next = null;
		return slow;

	}
}
