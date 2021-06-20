package oj.lc.q1000.lc862;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

	public static int shortestSubarray(int[] nums, int k) {
		int n = nums.length;
		int right = 0;
		int sum = 0, minLen = Integer.MAX_VALUE;

		for (int left = 0; left < n; left++) {
			if (left != 0) {
				sum -= nums[left - 1];
			}
			if (right == n) {
				sum = 0;
				right = left;
			}
			while (right < n && sum < k) {
				sum += nums[right];
				right++;
			}
			if (sum >= k) {
				minLen = Math.min(minLen, right - left);
			}
		}
		return minLen == Integer.MAX_VALUE ? -1 : minLen;
	}

	/**
	 * 前缀和 + 滑动窗口
	 *
	 * @param nums
	 * @param k
	 * @return
	 */
	public static int shortestSubarray2(int[] nums, int k) {
		int n = nums.length;
		long[] arr = new long[n + 1];
		int max = Integer.MAX_VALUE;
		Deque<Integer> deque = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			arr[i + 1] = arr[i] + (long) nums[i];
		}

		for (int i = 0; i < n + 1; i++) {
			while (!deque.isEmpty() && arr[deque.getLast()] >= arr[i]) {
				deque.removeLast();
			}
			while (!deque.isEmpty() && arr[i] - arr[deque.getFirst()] >= k) {
				max = Math.min(max, i - deque.removeFirst());
			}
			deque.addLast(i);
		}
		return max == Integer.MAX_VALUE ? -1 : max;
	}


	public static void main(String[] args) {
		System.out.println(shortestSubarray(new int[]{
				-28, 81, -20, 28, -29

		}, 89));
	}
}
