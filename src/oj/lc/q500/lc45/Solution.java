package oj.lc.q500.lc45;

/**
 * @Description:
 * @Author: zhanghua
 * @Date: 2022/3/6 10:41 上午
 */
public class Solution {


	/**
	 * 动态规划
	 *
	 * 时间复杂度O(n^2)
	 * 空间复杂度O(n)
	 *
	 * @param nums
	 * @return
	 */
	public static int jump(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		for (int i = 1; i < n; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < i; j++) {
				if (j + nums[j] >= i) {
					min = Math.min(min, dp[j] + 1);
				}
			}
			dp[i] = min;
		}

		return dp[n - 1];
	}

	/**
	 * 来自官方题解
	 *
	 * 时间复杂度为O(n)
	 * 空间复杂度O(1)
	 * @param nums
	 * @return
	 */
	public static int jump2(int[] nums){
			int length = nums.length;
			int end = 0;
			int maxPosition = 0;
			int steps = 0;
			for (int i = 0; i < length - 1; i++) {
				maxPosition = Math.max(maxPosition, i + nums[i]);
				if (i == end) {
					end = maxPosition;
					steps++;
				}
			}
			return steps;

	}

	public static void main(String[] args) {
		System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
	}


}
