package oj.lc.q500.lc300;

import utils.methods.ArrayUtils;

import java.util.Arrays;

public class Solution {

	/**
	 * 普通动态规划
	 * 时间复杂度为O(n^2)
	 *
	 * @param nums
	 * @return
	 */
	public static int lengthOfLIS(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		dp[0] = 1;
		int max = dp[0];
		Arrays.fill(dp, 1);
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(dp[i], max);
		}
		return max;
	}

	/**
	 * 贪心思想
	 * 时间复杂度为O(nlogn)
	 *
	 * @param nums
	 * @return
	 */
	public static int lengthOfLIS2(int[] nums) {
		int n = nums.length;
		if (n == 0) {
			return 0;
		}
		int len = 1;
		int[] d = new int[n + 1];
		d[len] = nums[0];

		for (int i = 1; i < n; i++) {
			if (nums[i] > d[len]) {
				d[++len] = nums[i];
			} else {
				int l = 1, r = len, pos = 0;
				while (l <= r) {
					int mid = (l + r) / 2;
					if (d[mid] < nums[i]) {
						pos = mid;
						l = mid + 1;
					} else {
						r = mid - 1;
					}
				}
				d[pos + 1] = nums[i];
			}
		}
		return len;
	}

	public static void main(String[] args) {

		System.out.println(lengthOfLIS2(new int[]{0, 1, 0, 3, 2, 3}));
	}
}
