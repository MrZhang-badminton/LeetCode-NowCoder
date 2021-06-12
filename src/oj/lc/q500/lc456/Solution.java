package oj.lc.q500.lc456;

import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

public class Solution {

	/**
	 * 单调栈
	 * 时间复杂度为O(n)
	 * 空间复杂度为O(n)
	 *
	 * @param nums
	 * @return
	 */
	public static boolean find132pattern(int[] nums) {
		int n = nums.length;
		int[] min = new int[n];
		min[0] = nums[0];
		Deque<Integer> stack = new LinkedList<>();

		for (int i = 1; i < n; i++) {
			min[i] = Math.min(min[i - 1], nums[i]);
		}

		for (int i = n - 1; i > 0; i--) {
			if (nums[i] > min[i]) {
				while (!stack.isEmpty() && stack.peek() <= min[i]) {
					stack.pop();
				}
				if (!stack.isEmpty() && nums[i] > stack.peek()) {
					return true;
				}
				stack.push(nums[i]);
			}
		}
		return false;
	}

	/**
	 * 时间比较慢
	 * 时间复杂度为O(nlogn)
	 * 空间复杂度为O(n)
	 *
	 * @param nums
	 * @return
	 */
	public static boolean find132pattern2(int[] nums) {
		int n = nums.length;
		if (n < 3) {
			return false;
		}
		int leftMin = nums[0];
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int i = 2; i < n; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
		for (int i = 1; i < n - 1; i++) {
			if (leftMin < nums[i]) {
				Integer next = map.ceilingKey(leftMin + 1);
				if (next != null && next < nums[i]) {
					return true;
				}
			}
			leftMin = Math.min(leftMin, nums[i]);
			map.put(nums[i + 1], map.get(nums[i + 1]) - 1);
			if (map.get(nums[i + 1]) == 0) {
				map.remove(nums[i + 1]);
			}
		}
		return false;
	}

	public static void main(String[] args) {

		System.out.println(find132pattern(new int[]{1, 5, 3, 4}));
	}
}
