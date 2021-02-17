package oj.lc.jz.lcjz42;

public class Solution {
	public static int maxSubArray(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n + 1];
		int max = Integer.MIN_VALUE;

		for (int i = 1; i < n + 1; i++) {
			if (dp[i - 1] > 0) {
				dp[i] = dp[i - 1] + nums[i - 1];
			} else {
				dp[i] = nums[i - 1];
			}
			max = Math.max(dp[i], max);
		}
		return max;
	}

	public static int maxSubArray2(int[] nums) {
		int n = nums.length;
		int res = nums[0];
		for (int i = 1; i < n; i++) {
			nums[i] += Math.max(nums[i - 1], 0);
			res = Math.max(res, nums[i]);
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
	}
}
