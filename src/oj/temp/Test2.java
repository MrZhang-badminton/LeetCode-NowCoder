package oj.temp;


import utils.ds.ListNode;

public class Test2 {

	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return null;
		}

		ListNode p = head, q = head.next;
		if(q == null) {
			return head;
		}
		while (q != null && q.val == p.val) {
			q = q.next;
		}
		if(q == head.next) {
			p.next = deleteDuplicates(q);
		} else {
			p = deleteDuplicates(q);
		}

		return p;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
//		ListNode n3 = new ListNode(1);
//		ListNode n4 = new ListNode(2);
//		ListNode n5 = new ListNode(3);
		n1.next = n2;
//		n2.next = n3;
//		n3.next = n4;
//		n4.next = n5;

		ListNode p = deleteDuplicates(n1);
		while (p != null) {
			System.out.println(p.val);
			p = p.next;
		}
	}
}
