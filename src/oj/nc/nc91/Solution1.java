package oj.nc.nc91;

import java.util.Arrays;

public class Solution1 {

	public static int lengthOfLIS1(int[] nums) {
		int[] dp = new int[nums.length];
		// dp数组全部初始化为1
		Arrays.fill(dp, 1);
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}

		int res = 0;
		for (int i = 0; i < dp.length; i++) {
			res = Math.max(res, dp[i]);
		}
		return res;
	}


	public static int lengthOfLIS(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		for(int i = 1; i < n; i++){
			for(int j = 0; j < i; j++){
				if(nums[j] <= nums[i]){
					dp[i] = Math.max(dp[j] + 1, dp[i]);
				}
			}
		}

		int max = -1;
		for(int i = 0; i < n; i++){
			max = Math.max(max, dp[i]);
		}
		return max;
	}

	public static void main(String[] args) {
		int[] arr = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
		System.out.println(lengthOfLIS(arr));
	}
}
