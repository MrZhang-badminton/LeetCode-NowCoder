package oj.lc.q500.lc19;

import utils.ds.ListNode;

public class Solution {

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode slow = head, fast = head;
		int count = 0;
		while (fast != null && count < n + 1) {
			fast = fast.next;
			count++;
		}
		
		if (count == n) {
			//处理如果是第一个节点的情况
			return head.next;
		} else if (count != n + 1) {
			//如果其他情况则是链表长度小于n
			return head;
		}

		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next;
		return head;
	}

	public static void main(String[] args) {
		ListNode head = ListNode.createList(new int[]{1, 2, 3, 4, 5});
		ListNode.printListNode(removeNthFromEnd(head, 5));
	}
}
