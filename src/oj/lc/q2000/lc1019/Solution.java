package oj.lc.q2000.lc1019;

import utils.LinkedListUtils;
import utils.node.ListNode;

import java.util.*;

/**
 * @Description:
 * @Author: zhanghua
 * @Date: 2022/3/11 2:18 上午
 */
public class Solution {

	/**
	 * 单调栈
	 *
	 * @param head
	 * @return
	 */
	public static int[] nextLargerNodes(ListNode head) {
		List<Integer> list = new ArrayList<>();
		Deque<Integer> stack = new LinkedList<>();
		stack.push(Integer.MIN_VALUE);

		ListNode p = head;
		while (p != null) {
			list.add(p.val);
			p = p.next;
		}
		int len = list.size();
		int[] nums = list.stream().mapToInt(Integer::valueOf).toArray();
		for (int i = len - 1; i >= 0; i--) {
			while (!stack.isEmpty() && nums[i] >= stack.peek()) {
				stack.pop();
			}
			if (!stack.isEmpty()) {
				int tmp = nums[i];
				nums[i] = stack.peek();
				stack.push(tmp);
			} else {
				stack.push(nums[i]);
				nums[i] = 0;
			}
		}

		return nums;
	}


	public static void main(String[] args) {
		int[] results = nextLargerNodes(
				LinkedListUtils.createList(new int[]{1, 7, 5, 1, 9, 2, 5, 1})
		);
		Arrays.stream(results).forEach(System.out::println);
	}
}
