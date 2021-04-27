package oj.others;

import utils.ds.ListNode;

public class LinkedListExercise {


	public static void main(String[] args) {
		ListNode head = ListNode.getList(new int[]{1,2,3,4,5,6});
		ListNode.printListNode(removeLastK(head,4));
	}


	/**
	 * 两个链表生成相加链表
	 *
	 * @param head1
	 * @param head2
	 * @return
	 */
	public static ListNode addInList(ListNode head1, ListNode head2) {
		ListNode pHead = new ListNode(-1);
		ListNode p;

		head1 = reverse(head1);
		head2 = reverse(head2);

		int plus = 0;

		while (head1 != null || head2 != null || plus != 0) {
			int num1 = 0, num2 = 0, res;
			if (head1 != null) {
				num1 = head1.val;
			}
			if (head2 != null) {
				num2 = head2.val;
			}
			res = num1 + num2 + plus;
			plus = 0;
			if (res >= 10) {
				plus = 1;
				res = res - 10;
			}
			p = new ListNode(res);
			p.next = pHead.next;
			pHead.next = p;
			if (head1 != null) {
				head1 = head1.next;
			}
			if (head2 != null) {
				head2 = head2.next;
			}
		}

		return pHead.next;
	}

	public static ListNode reverse(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode pHead = new ListNode(-1);
		ListNode p;
		while (head != null) {
			p = head.next;
			head.next = pHead.next;
			pHead.next = head;
			head = p;
		}
		return pHead.next;
	}

	/**
	 * 逆置每k个结点
	 *
	 * @param head
	 * @param k
	 * @return
	 */
	public static ListNode reverseKGroup(ListNode head, int k) {
		if (head == null) {
			return null;
		}

		//不足k个结点的部分不翻转
		int count = 0;
		ListNode w = head;
		while (w != null && count <= k) {
			count++;
			w = w.next;
		}
		if (count < k) {
			return head;
		}

		ListNode pHead = new ListNode(-1);
		ListNode p, tail = pHead;
		int j = k;

		for (int i = 0; i < k && head != null; i++) {
			p = head.next;
			head.next = pHead.next;
			pHead.next = head;
			head = p;
			if (i == 0) {
				tail = pHead.next;
			}
		}
		tail.next = reverseKGroup(head, k);

		return pHead.next;
	}


	/**
	 * 找到第一个相遇的节点
	 *
	 * @param pHead1
	 * @param pHead2
	 * @return
	 */
	public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		int len1 = 0;
		int len2 = 0;
		ListNode p = pHead1, q = pHead2;
		while (p != null) {
			len1++;
			p = p.next;
		}
		while (q != null) {
			len2++;
			q = q.next;
		}

		if (len1 > len2) {
			for (int i = 0; i < len1 - len2; i++) {
				pHead1 = pHead1.next;
			}
		} else if (len2 > len1) {
			for (int i = 0; i < len2 - len1; i++) {
				pHead2 = pHead2.next;
			}
		}
		while (pHead1 != pHead2) {
			pHead1 = pHead1.next;
			pHead2 = pHead2.next;
		}
		return pHead1;
	}

	/**
	 * 删除倒数第k个结点，如果不存在返回null
	 *
	 * @param head
	 * @param k
	 * @return
	 */
	public static ListNode removeLastK(ListNode head, int k) {
		if (k < 0) {
			return null;
		}
		if (k == 0) {
			return head;
		}
		ListNode pHead = new ListNode(-1, head);
		ListNode slow = pHead, fast = pHead;
		int count = 0;
		for (int i = 0; i < k + 1 && fast != null; i++) {
			fast = fast.next;
			count++;
		}
		if (count - 1 < k) {
			return null;
		}
		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}

		slow.next = slow.next.next;

		return pHead.next;
	}

	public static void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
}


