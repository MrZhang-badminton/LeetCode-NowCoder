package utils;

import utils.node.ListNode;

/**
 * @Description:
 * @Author: zhanghua
 * @Date: 2022/3/6 12:41 上午
 */
public class LinkedListUtils {
	/**
	 * 根据数组创建链表
	 *
	 * @param nums
	 * @return
	 */
	public static ListNode createList(int[] nums) {
		return getList(nums);
	}

	/**
	 * 旧版本根据数组，创建链表
	 * 保留旧版本，用于兼容之前写的代码
	 * 最新版本的应该使用上述createList函数
	 *
	 * @param nums
	 * @return
	 */
	public static ListNode getList(int[] nums) {
		ListNode pHead = new ListNode(-1);
		ListNode tail = pHead;

		for (int i = 0; i < nums.length; i++) {
			tail.next = new ListNode(nums[i]);
			tail = tail.next;
		}
		return pHead.next;
	}

	public static void printListNode(ListNode head) {
		System.out.print("[");
		while (head != null) {
			if (head.next != null) {
				System.out.print(head.val + ", ");
			} else {
				System.out.print(head.val);
			}
			head = head.next;
		}
		System.out.print("]");
		System.out.println();
	}
}
