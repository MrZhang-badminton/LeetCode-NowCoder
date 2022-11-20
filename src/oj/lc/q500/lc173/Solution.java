package oj.lc.q500.lc173;

/**
 * @Description:
 * @Author: zhanghua
 * @Date: 2022/11/20 02:10
 */
public class Solution {

	public static int findNumberOfLIS(int[] nums) {
		int len = nums.length;
		int[] dp = new int[len];
		int[] cnt = new int[len];
		dp[0] = 1;
		cnt[0] = 1;
		int max = dp[0];
		for (int i = 1; i < len; i++) {
			int j = i - 1;
			int maxCnt = 0;
			int count = 0;
			while (j >= 0) {
				if (nums[j] < nums[i]) {
					if (dp[j] > maxCnt) {
						maxCnt = dp[j];
						count = cnt[j];
					} else if (dp[j] == maxCnt) {
						count += cnt[j];
					}
				}
				j--;
			}
			dp[i] = maxCnt + 1;
			max = Math.max(dp[i], max);
			cnt[i] = count == 0 ? 1 : count;
		}
		int result = 0;
		for (int i = 0; i < len; i++) {
			if (dp[i] == max) {
				result += cnt[i];
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(findNumberOfLIS(new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3}));
	}
}
