package oj.lc.q1000.lc862;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

	public static int shortestSubarray2(int[] nums, int k) {
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

	public static int shortestSubarray(int[] nums, int k) {
		int n = nums.length;
		long[] p = new long[n + 1];
		for (int i = 0; i < n; i++) {
			p[i + 1] = p[i] + (long) nums[i];
		}
		int ans = n + 1;
		Deque<Integer> deque = new LinkedList<>();

		for (int y = 0; y < p.length; y++) {
			while (!deque.isEmpty() && p[y] <= p[deque.getLast()]) {
				deque.removeLast();
			}
			while (!deque.isEmpty() && p[y] >= p[deque.getFirst()] + k) {
				ans = Math.min(ans, y - deque.removeFirst());
			}
			deque.addLast(y);
		}
		return ans < n + 1 ? ans : -1;
	}

	public static void main(String[] args) {
		System.out.println(shortestSubarray(new int[]{
				-28, 81, -20, 28, -29

		}, 89));
	}
}
