package basic.linkedlist;

import utils.LinkedListUtils;
import utils.node.ListNode;

/**
 * 给定一个奇数位升序，偶数位降序的链表，将其重新排列
 * <p>
 * 输入:
 * 1->8->3->6->5->4->7->2->null
 * <p>
 * 输出:
 * 1->2->3->4->5->6->7->8->null
 * <p>
 * <p>
 * 解法：
 * 1. 奇数位、偶数位的节点都摘下来，使用头插法分别放到两个链表中
 * 2. 将奇数链表翻转
 * 3. 合并两条链表
 *
 * @author Peter Hua
 * @date 2021年05月04日15:12:06
 */
public class OddAndEvenList {

	public static ListNode sort(ListNode head) {
		ListNode oHead = new ListNode(-1), eHead = new ListNode(-1);
		int count = 1;
		while (head != null) {
			ListNode tHead, next;
			if (count % 2 == 1) {
				tHead = oHead;
			} else {
				tHead = eHead;
			}
			count++;
			next = head.next;
			head.next = tHead.next;
			tHead.next = head;
			head = next;
		}
		oHead = oHead.next;
		eHead = eHead.next;
		oHead = reverse(oHead);
		ListNode retNode = merge(oHead, eHead);
		return retNode;
	}

	public static ListNode reverse(ListNode head) {
		ListNode pHead = new ListNode(-1);
		while (head != null) {
			ListNode next = head.next;
			head.next = pHead.next;
			pHead.next = head;
			head = next;
		}
		return pHead.next;
	}

	public static ListNode merge(ListNode head1, ListNode head2) {
		ListNode pHead = new ListNode(-1);
		ListNode tail = pHead;
		while (head1 != null && head2 != null) {
			ListNode next = head1.next;
			tail.next = head1;
			tail = tail.next;
			head1 = next;

			next = head2.next;
			tail.next = head2;
			tail = tail.next;
			head2 = next;
		}
		while (head1 != null) {
			ListNode next = head1.next;
			tail.next = head1;
			tail = tail.next;
			head1 = next;
		}

		while (head2 != null) {
			ListNode next = head2.next;
			tail.next = head2;
			tail = tail.next;
			head2 = next;
		}
		return pHead.next;
	}

	public static void main(String[] args) {
		ListNode head = LinkedListUtils.createList(new int[]{1, 8, 3, 6, 5, 4, 7, 2});
		head = sort(head);
		LinkedListUtils.printListNode(head);
	}
}
