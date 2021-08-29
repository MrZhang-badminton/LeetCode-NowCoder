package oj.lc.q500.lc55;

/**
 * @Classname: Solution
 * @Author: zhanghua
 * @Date: 2021/8/29 3:08 下午
 */
public class Solution {

	/**
	 * 贪心算法（来自题解）
	 *
	 * @param nums
	 * @return
	 */
	public static boolean canJump(int[] nums) {
		int n = nums.length;
		int rightmost = 0;
		for (int i = 0; i < n; ++i) {
			if (i <= rightmost) {
				rightmost = Math.max(rightmost, i + nums[i]);
				if (rightmost >= n - 1) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(canJump(new int[]{3, 4, 1, 0, 4}));
	}
}
