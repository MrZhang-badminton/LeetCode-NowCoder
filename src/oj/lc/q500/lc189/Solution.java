package oj.lc.q500.lc189;

import utils.ArrayUtils;

/**
 * @Description:
 * @Author: zhanghua
 * @Date: 2022/3/14 3:04 下午
 */
public class Solution {

	/**
	 * 暴力方法
	 * <p>
	 * 时间复杂度为O(n)
	 * 空间复杂度为O(n)
	 *
	 * @param nums
	 * @param k
	 */
	public static void rotate(int[] nums, int k) {
		int n = nums.length;
		k %= n;
		int[] arr = new int[n];
		int index = 0;
		for (int i = n - k; i < n; i++) {
			arr[index++] = nums[i];
		}
		for (int i = 0; i < n - k; i++) {
			arr[index++] = nums[i];
		}
		System.arraycopy(arr, 0, nums, 0, n);
	}


	/**
	 * 超级转转转方法
	 * <p>
	 * 时间复杂度O(n)
	 * 空间复杂度O(1)
	 *
	 * @param nums
	 * @param k
	 */
	public static void rotate2(int[] nums, int k) {
		int n = nums.length;
		k %= n;
		reverse(nums, 0, n - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, n - 1);
	}

	private static void reverse(int[] nums, int l, int r) {
		while (l < r) {
			int tmp = nums[l];
			nums[l] = nums[r];
			nums[r] = tmp;
			l++;
			r--;
		}
	}


	public static void main(String[] args) {
		int[] nums = new int[]{-1};
		rotate2(nums, 2);
		ArrayUtils.printArray(nums);
	}
}
