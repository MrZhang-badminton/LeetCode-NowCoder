package oj.lc.q500.lc128;

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
	 * @param nums
	 * @return
	 */
	public static int longestConsecutive(int[] nums) {
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

	public static void main(String[] args) {
		System.out.println(longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
	}
}
