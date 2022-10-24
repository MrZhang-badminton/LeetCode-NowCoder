package oj.lc.q2000.lc1171;

import utils.LinkedListUtils;
import utils.node.ListNode;

import java.util.*;


/**
 * @Description:
 * @Author: zhanghua
 * @Date: 2021/11/13 8:51 下午
 */
public class Solution {

	/**
	 * 该方法来自题解
	 * 比较巧妙
	 *
	 * @param head
	 * @return
	 */
	public static ListNode removeZeroSumSublists(ListNode head) {
		ListNode dummy = new ListNode();
		dummy.next = head;

		Map<Integer, ListNode> map = new HashMap<>();

		// 首次遍历建立 节点处链表和<->节点 哈希表
		// 若同一和出现多次会覆盖，即记录该sum出现的最后一次节点
		int sum = 0;
		for (ListNode p = dummy; p != null; p = p.next) {
			sum += p.val;
			map.put(sum, p);
		}

		// 第二遍遍历 若当前节点处sum在下一处出现了则表明两结点之间所有节点和为0 直接删除区间所有节点
		sum = 0;
		for (ListNode p = dummy; p != null; p = p.next) {
			sum += p.val;
			p.next = map.get(sum).next;
		}

		return dummy.next;
	}


	/**
	 * 貌似是比较笨的方法，耗时比较长，只击败了5.02%的用户
	 *
	 * @param head
	 * @return
	 */
	public static ListNode removeZeroSumSublists2(ListNode head) {
		List<Integer> list = new ArrayList<>();
		List<Integer> valList = new ArrayList<>();
		list.add(0);
		valList.add(0);
		int count = 0;
		ListNode p = head;
		while (p != null) {
			count += p.val;
			if (list == null || list.size() == 0 || !list.contains(count)) {
				list.add(count);
				valList.add(p.val);
			} else {
				int idx = list.indexOf(count);
				list = list.subList(0, idx + 1);
				valList = valList.subList(0, idx + 1);
			}
			p = p.next;
		}
		if (list.size() <= 1) {
			return null;
		}
		ListNode pHead = new ListNode();
		ListNode tail = pHead;
		for (Integer val : valList.subList(1, valList.size())) {
			tail.next = new ListNode(val);
			tail = tail.next;
		}
		return pHead.next;
	}


	/**
	 * 击败了30%
	 *
	 * @param head
	 * @return
	 * @time 2022年10月25日02:00:01
	 */
	public ListNode removeZeroSumSublists3(ListNode head) {
		ListNode pHead = new ListNode(0);
		pHead.next = head;
		ListNode p = head;
		int count = 0;

		while (p != null) {
			count += p.val;
			ListNode ptr = pHead;
			int cnt = 0;
			while (ptr != null && ptr != p && (cnt += ptr.val) != count) {
				ptr = ptr.next;
			}
			if (ptr != null && cnt == count) {
				ptr.next = p.next;
			}

			p = p.next;
		}

		return pHead.next;
	}

	public static void main(String[] args) {
		ListNode head = LinkedListUtils.createList(new int[]{1, -1});
		LinkedListUtils.printListNode(removeZeroSumSublists(head));
	}
}
