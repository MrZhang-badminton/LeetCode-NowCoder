package oj.lc.q1000.lc918;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description:
 * @Author: zhanghua
 * @Date: 2022/10/30 17:37
 */
public class Solution {


	public static int maxSubarraySumCircular(int[] nums) {
		int len = nums.length;

		int[] arr = new int[len * 2 + 1];
		for (int i = 0; i < 2 * len; i++) {
			arr[i + 1] = arr[i] + nums[i % len];
		}

		int ans = nums[0];
		Deque<Integer> deque = new LinkedList<>();
		deque.offer(0);
		for (int i = 1; i <= 2 * len; i++) {
			if (deque.peekFirst() < i - len) {
				deque.pollFirst();
			}

			ans = Math.max(ans, arr[i] - arr[deque.peekFirst()]);
			while (!deque.isEmpty() && arr[i] <= arr[deque.peekLast()]) {
				deque.pollLast();
			}

			deque.offer(i);
		}

		return ans;
	}


	public static void main(String[] args) {
		System.out.println(maxSubarraySumCircular(new int[]{3, -2, 2, -3}));
	}
}
