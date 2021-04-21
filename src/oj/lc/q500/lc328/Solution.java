package oj.lc.q500.lc328;

import utils.ds.ListNode;

public class Solution {

	public static ListNode oddEvenList(ListNode head) {
		ListNode oddHead = new ListNode(-1);
		ListNode evenHead = new ListNode(-1);
		ListNode oddTail = oddHead, evenTail = evenHead;
		int count = 1;
		while (head != null) {
			ListNode tempNode = head.next;
			head.next = null;
			if(count % 2 == 1){
				oddTail.next = head;
				oddTail = oddTail.next;
			}else {
				evenTail.next = head;
				evenTail = evenTail.next;
			}
			head = tempNode;
			count++;
		}
		oddTail.next = evenHead.next;
		return oddHead.next;
	}



	public static void main(String[] args) {
		ListNode tempNode = ListNode.getList(new int[]{2,1,3,5,6,4,7});
		tempNode = oddEvenList(tempNode);
		ListNode.printListNode(tempNode);
	}
}
