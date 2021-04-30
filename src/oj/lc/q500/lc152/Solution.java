package oj.lc.q500.lc152;

/**
 * 乘积最大子数组
 *
 * @date 2021年04月30日11:58:29
 */
public class Solution {

	/**
	 * 动态规划
	 * 对于一个位置idx，其取值有3种情况
	 * 1. nums[idx] * 前一个位置能达到的最大值
	 * 2. nums[idx]
	 * 3. nums[idx] * 前一个位置能达到的最小值
	 * <p>
	 * 所以要维护前一个位置能达到的最大值和最小值
	 * <p>
	 * 总结
	 * 遇到这种题目就应该挑一个数，考虑到当前位置达到最大值的各种情况
	 *
	 * @param nums
	 * @return
	 */
	public static int maxProduct(int[] nums) {
		int n = nums.length;
		int ans = nums[0];
		int max = nums[0];
		int min = nums[0];

		for (int i = 1; i < n; i++) {
			int mn = min, mx = max;
			max = Math.max(Math.max(nums[i], nums[i] * mx), nums[i] * mn);
			min = Math.min(Math.min(nums[i], nums[i] * mx), nums[i] * mn);
			ans = Math.max(ans, max);
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(maxProduct(new int[]{-1, -2, -3, -4}));
	}
}
