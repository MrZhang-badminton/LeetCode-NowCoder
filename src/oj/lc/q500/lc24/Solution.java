package oj.lc.q500.lc24;

import utils.LinkedListUtils;
import utils.node.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
	/**
	 * 递归
	 * @param head
	 * @return
	 */
	public static ListNode swapPairs(ListNode head) {
		if(head == null){
			return null;
		}
		if(head.next == null){
			return head;
		}
		ListNode ptr = head.next;
		head.next = swapPairs(ptr.next);
		ptr.next = head;
		return ptr;
	}

	/**
	 * 使用栈
	 * @param head
	 * @return
	 */
	public static ListNode swapPairs2(ListNode head) {
		ListNode phead = new ListNode(-1);
		Deque<ListNode> stack = new ArrayDeque<>(2);

		phead.next = head;
		ListNode p = head;
		ListNode q = phead;
		while(null != p){
			stack.addFirst(p);
			p = p.next;
			if(stack.size() == 2){
				q.next = stack.removeFirst();
				q = q.next;
				q.next = stack.removeFirst();
				q = q.next;
			}
		}
		while(stack.size() != 0){
			q.next = stack.removeFirst();
			q = q.next;
		}
		q.next = null;
		return phead.next;
	}

	public static void main(String[] args) {
		ListNode head = LinkedListUtils.getList(new int[]{1,2,3,4,5});
		LinkedListUtils.printListNode(swapPairs2(head));
	}
}
