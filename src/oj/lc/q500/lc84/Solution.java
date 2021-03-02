package oj.lc.q500.lc84;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * lc84柱状图中最大的矩阵
 *
 * @date 2021年02月28日21:48:38
 */
public class Solution {

	/**
	 * 暴力算法（超时）
	 * 时间复杂度O(n)
	 *
	 * @param heights
	 * @return
	 */
	public static int largestRectangleArea(int[] heights) {
		int n = heights.length;
		if (n == 1) {
			return heights[0];
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			int min = heights[i];

			for (int j = i; j < n; j++) {
				min = Math.min(min, heights[j]);
				int width = j - i + 1;
				max = Math.max(max, width * min);
			}
		}
		return max;
	}

	/**
	 * 单调栈解法
	 *
	 * @param heights
	 * @return
	 */
	public static int largestRectangleArea2(int[] heights) {
		int n = heights.length;
		int[] left = new int[n];
		int[] right = new int[n];
		Arrays.fill(right, n);

		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
				right[stack.peek()] = i;
				stack.pop();
			}
			left[i] = stack.isEmpty() ? -1 : stack.peek();
			stack.push(i);
		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
		}
		return ans;
	}


	public static void main(String[] args) {
		System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
	}
}
