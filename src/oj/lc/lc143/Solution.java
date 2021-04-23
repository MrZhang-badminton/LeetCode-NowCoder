package oj.lc.lc143;

import utils.ds.ListNode;

public class Solution {

	public static void main(String[] args) {
		ListNode head = ListNode.getList(new int[]{1, 2, 3, 4});
		reorderList(head);
		ListNode.printListNode(head);
	}

	public static void reorderList(ListNode head) {
		ListNode pHead = new ListNode(-1, head);
		ListNode slow = pHead, fast = pHead, post = slow.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next;
			if (fast != null) {
				fast = fast.next;
			}
		}
		ListNode head2 = slow.next;
		slow.next = null;

//		head = reverse(head);
		head2 = reverse(head2);
		head = merge(head,head2);
	}

	public static ListNode reverse(ListNode head){
		ListNode pHead = new ListNode(-1,null);
		while(head!= null){
			ListNode p = head;
			head = head.next;

			p.next = pHead.next;
			pHead.next = p;
		}
		return pHead.next;
	}
	public static ListNode merge(ListNode head1, ListNode head2){
		ListNode pHead = new ListNode(01,null);
		ListNode tail = pHead;
		while(head1!= null || head2!=null){
			ListNode p;
			if(head1!= null){
				p = head1;
				head1 = head1.next;
				p.next = tail.next;
				tail.next = p;
				tail = tail.next;
			}
			if(head2 != null){
				p = head2;
				head2 = head2.next;
				p.next = tail.next;
				tail.next = p;
				tail = tail.next;
			}
		}
		return pHead.next;
	}
}
