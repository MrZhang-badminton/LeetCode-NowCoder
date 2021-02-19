package oj.lc.q500.lc456;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @date 2021年02月19日11:35:21
 */
public class Solution {
	public static boolean find132pattern(int[] nums) {
		int n = nums.length;
		if (n < 3) {
			return false;
		}

		for (int i = 0; i < n - 2; i++) {
			for (int j = i + 2; j < n; j++) {
				for (int k = i + 1; k < j; k++) {
					if (nums[j] > nums[i] && nums[k] > nums[j]) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public static boolean find132pattern1(int[] nums) {
		int n = nums.length;
		if (n < 3) {
			return false;
		}

		Stack<Integer> stack = new Stack<>();
		int[] min = new int[n];
		min[0] = nums[0];
		for (int i = 1; i < n; i++) {
			min[i] = Math.min(min[i - 1], nums[i]);
		}

		for (int i = n - 1; i >= 0; i--) {
			if (nums[i] > min[i]) {
				while (!stack.isEmpty() && stack.peek() <= min[i]) {
					stack.pop();
				}
				if (!stack.isEmpty() && stack.peek() < nums[i]) {
					return true;
				}
				stack.push(nums[i]);
			}
		}

		return false;
	}

	public static void main(String[] args) {
		System.out.println(find132pattern1(new int[]{3, 5, 0, 3, 4}));
	}
}