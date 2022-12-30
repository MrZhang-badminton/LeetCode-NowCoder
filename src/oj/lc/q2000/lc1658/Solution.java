package oj.lc.q2000.lc1658;

/**
 * @Description:
 * @Author: zhanghua
 * @Date: 2022/12/30 23:00
 */
public class Solution {


	/**
	 * 参照题解思路, 本题可以转化为最长连续子序列
	 * <p>
	 * target = sum - x; 找到和为target的最大子序列
	 *
	 * @param nums
	 * @param x
	 * @return
	 */
	public static int minOperations(int[] nums, int x) {
		int sum = 0;
		int len = nums.length;

		for (int num : nums) {
			sum += num;
		}

		int target = sum - x;
		if (target < 0) {
			return -1;
		}

		int left = 0, right = 0, count = 0, max = Integer.MIN_VALUE;

		while (right < len) {
			count += nums[right];
			while (count > target) {
				count -= nums[left++];
			}
			if (count == target) {
				max = Math.max(max, right - left + 1);
			}
			right++;
		}

		return max == Integer.MIN_VALUE ? -1 : len - max;
	}


	public static void main(String[] args) {

		System.out.println(minOperations(new int[]{5, 2, 3, 1, 1}, 5));
	}

}
