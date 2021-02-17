package oj.lc.q500.lc213;

public class Solution {

	public static int rob(int[] nums) {
		int n = nums.length;
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return nums[0];
		}
		int[] dp = new int[n];
		int max = 0;

		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		max = dp[1];

		if (n == 2) {
			return max;
		}

		for (int i = 2; i < n - 1; i++) {
			dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
			max = Math.max(dp[i], max);
		}

		dp[1] = nums[1];
		dp[2] = Math.max(nums[1], nums[2]);
		for (int i = 3; i < n; i++) {
			dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
			max = Math.max(dp[i], max);
		}
		return max;

	}

	public static void main(String[] args) {
		System.out.println(rob(new int[]{2, 3, 2}));
	}
}
