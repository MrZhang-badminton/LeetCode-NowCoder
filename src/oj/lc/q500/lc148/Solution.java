package oj.lc.q500.lc148;

import utils.ds.ListNode;

/**
 * 链表排序
 * 已完成：
 * 1. 冒泡排序
 * 2. 快速排序
 * <p>
 * 待完成：
 * 1. 插入排序
 * 2. 归并排序
 * 3.堆排序
 *
 * @author Peter Hua
 * @date 2021年04月22日11:10:02
 */
public class Solution {


	/**
	 * BubbleSort-LinkedList
	 *
	 * @param head
	 * @return
	 */
	public static ListNode bubbleSort(ListNode head) {
		if (head == null) {
			return null;
		}
		int n = 0;
		ListNode p = head;
		while (p != null) {
			n++;
			p = p.next;
		}
		ListNode pHead = new ListNode(-1);
		pHead.next = head;
		for (int i = n - 1; i >= 1; i--) {
			p = pHead;
			for (int j = 0; j < i; j++) {
				ListNode pre = p.next, post = p.next.next;
				if (pre.val > post.val) {
					pre.next = post.next;
					p.next = post;
					post.next = pre;
				}
				p = p.next;
			}
		}
		return pHead.next;
	}

	/**
	 * 快速排序
	 * <p>
	 * 1. 本题里面不能直接采取第一个元素作为pivot，因为给的测试用例里面有有序数组
	 * 导致了，这是的时间复杂度达到O(n^2)。所以，我用快慢指针法找到了中间元素，
	 * 然后对两遍分别进行快排。
	 * <p>
	 * 2. 虽然是快速排序，时间复杂度降到了O(nlogn)
	 * 但是运行的时间是1900多ms
	 * 讲道理有点难受，还是题解里给的归并算法比较快
	 * 感觉还是快速排序里面多了很多次扫描，所以时间很长
	 * 时间复杂度达到要求，所以时间在限制之内
	 * 但是过多的扫描还是导致了时间比较慢
	 * <p>
	 * 3. 解决：
	 * 看看是否可以减少遍历的次数，如果不行，那就算了快排就这样
	 *
	 * @param head
	 * @return
	 */
	public static ListNode quickSort(ListNode head) {
		if (head == null) {
			return null;
		}

		ListNode pivot;
		//如果链表至少有三个节点
		if (head.next != null && head.next.next != null) {
			pivot = findMidNodeandRemove(head);

		} else {
			//小于三个节点的情况
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


	/**
	 * 归并排序——递归版本（来自题解）
	 *
	 * @param head
	 * @return
	 */
	public static ListNode mergeSort(ListNode head) {
		return mergeSort0(head, null);
	}

	public static ListNode mergeSort0(ListNode head, ListNode tail) {
		if (head == null) {
			return head;
		}
		if (head.next == tail) {
			head.next = null;
			return head;
		}
		ListNode slow = head, fast = head;
		while (fast != tail) {
			slow = slow.next;
			fast = fast.next;
			if (fast != tail) {
				fast = fast.next;
			}
		}
		ListNode mid = slow;
		ListNode list1 = mergeSort0(head, mid);
		ListNode list2 = mergeSort0(mid, tail);
		ListNode sorted = merge(list1, list2);
		return sorted;
	}

	public static ListNode merge(ListNode head1, ListNode head2) {
		ListNode pHead = new ListNode(0);
		ListNode p = pHead, p1 = head1, p2 = head2;
		while (p1 != null && p2 != null) {
			if (p1.val <= p2.val) {
				p.next = p1;
				p1 = p1.next;
			} else {
				p.next = p2;
				p2 = p2.next;
			}
			p = p.next;
		}
		if (p1 != null) {
			p.next = p1;
		} else if (p2 != null) {
			p.next = p2;
		}
		return pHead.next;
	}


	/**
	 * 归并排序——非递归版本（来自题解）
	 *
	 * @param head
	 * @return
	 */
	public ListNode mergeSortNr(ListNode head) {
		if (head == null) {
			return head;
		}
		int length = 0;
		ListNode node = head;
		while (node != null) {
			length++;
			node = node.next;
		}
		ListNode dummyHead = new ListNode(0, head);
		for (int subLength = 1; subLength < length; subLength <<= 1) {
			ListNode prev = dummyHead, curr = dummyHead.next;
			while (curr != null) {
				ListNode head1 = curr;
				for (int i = 1; i < subLength && curr.next != null; i++) {
					curr = curr.next;
				}
				ListNode head2 = curr.next;
				curr.next = null;
				curr = head2;
				for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
					curr = curr.next;
				}
				ListNode next = null;
				if (curr != null) {
					next = curr.next;
					curr.next = null;
				}
				ListNode merged = merge1(head1, head2);
				prev.next = merged;
				while (prev.next != null) {
					prev = prev.next;
				}
				curr = next;
			}
		}
		return dummyHead.next;
	}

	public ListNode merge1(ListNode head1, ListNode head2) {
		ListNode dummyHead = new ListNode(0);
		ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
		while (temp1 != null && temp2 != null) {
			if (temp1.val <= temp2.val) {
				temp.next = temp1;
				temp1 = temp1.next;
			} else {
				temp.next = temp2;
				temp2 = temp2.next;
			}
			temp = temp.next;
		}
		if (temp1 != null) {
			temp.next = temp1;
		} else if (temp2 != null) {
			temp.next = temp2;
		}
		return dummyHead.next;
	}


	public static void main(String[] args) {
		ListNode head = ListNode.getList(new int[]{4, 2, 1, 3});
		ListNode.printListNode(mergeSort(head));
	}
}
