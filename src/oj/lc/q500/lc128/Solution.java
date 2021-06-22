package oj.lc.q500.lc128;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 最长连续序列
 *
 * @date 2021年04月30日03:41:41
 */
public class Solution {

	/**
	 * 哈希表法
	 * 时间复杂度为O(n)
	 *
	 * @param nums
	 * @return
	 */
	public static int longestConsecutive(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		Set<Integer> set = new HashSet<>();
		for (int i : nums) {
			set.add(i);
		}
		int longestLen = Integer.MIN_VALUE;
		for (int i : set) {
			if (set.contains(i - 1)) {
				continue;
			}
			int curLen = 1;
			while (set.contains(i + 1)) {
				curLen++;
				i = i + 1;
			}
			longestLen = Math.max(longestLen, curLen);

		}
		return longestLen;
	}

	/**
	 * 快速排序
	 * @param nums
	 * @return
	 */
	public static int longestConsecutive2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		Arrays.sort(nums);
		int max = 1;
		int sum = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) {
				continue;
			}
			if (nums[i] - 1 == nums[i - 1]) {
				sum++;
			} else {
				sum = 1;
			}
			max = Math.max(max, sum);
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(longestConsecutive2(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
	}
}
