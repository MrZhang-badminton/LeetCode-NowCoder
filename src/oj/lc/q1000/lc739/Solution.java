package oj.lc.q1000.lc739;

import utils.ArrayUtils;

import java.util.*;

/**
 * @Classname: Solution
 * @Author: zhanghua
 * @Date: 2021/8/14 2:42 上午
 */
public class Solution {

	/**
	 * 暴力算法
	 * 时间复杂度O(n)
	 *
	 * @param temperatures
	 * @return
	 */
	public static int[] dailyTemperatures(int[] temperatures) {
		int n = temperatures.length;
		int[] ans = new int[n];
		for (int i = 0; i < n - 1; i++) {
			int j = i + 1;
			while (j < n && temperatures[j] <= temperatures[i]) {
				j++;
			}
			if (j == n) {
				ans[i] = 0;
			} else {
				ans[i] = j - i;
			}
		}
		return ans;
	}

	/**
	 * 单调栈
	 *
	 * @param temperatures
	 * @return
	 */
	public static int[] dailyTemperatures2(int[] temperatures) {
		int n = temperatures.length;
		Deque<Integer> deque = new LinkedList<>();
		int[] ans = new int[n];
		for (int i = 0; i < n; i++) {
			while (!deque.isEmpty() && temperatures[i] > temperatures[deque.getLast()]) {
				ans[deque.getLast()] = i - deque.removeLast();
			}
			deque.addLast(i);
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
		nums = dailyTemperatures2(nums);
		ArrayUtils.printArray(nums);
	}
}
