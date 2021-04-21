package basealogrithm.sort;

import utils.ds.ListNode;

/**
 * 链表快排
 *
 * @author Peter Hua
 * @date 2021年04月22日00:48:53
 */
public class LinkQuickSort {

	public static void main(String[] args) {
		ListNode.printListNode(quickSort(ListNode.getList(new int[]{9, 8, 2, 4, 3, 1, 5, 10, 6, 7})));

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
}
