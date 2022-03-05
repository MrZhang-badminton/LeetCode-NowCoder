package oj.nc.nc91;

import utils.ArrayUtils;

import java.util.*;

public class Solution {

	/**
	 * 一开始写的，过程比较繁琐
	 * 而且时间复杂度同LIS2
	 * 所以运行结果也是超时的
	 *
	 * @param arr
	 * @return
	 */
	public static int[] LIS(int[] arr) {
		int n = arr.length;
		int[] dp = new int[n];
		int[] path = new int[n];
		path[0] = -1;

		Arrays.fill(dp, 1);
		for (int i = 1; i < n; i++) {
			int index = -1;
			int minVal = arr[i];
			int dpVal = dp[i];
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] < arr[i] && arr[j] < minVal && dp[j] + 1 >= dpVal) {
					index = j;
					minVal = arr[j];
					dpVal = dp[j] + 1;
				}
			}
			path[i] = index;
			dp[i] = dpVal;
		}

		int max = -1;
		int index = -1;
		int minVal = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if (dp[i] > max) {
				max = dp[i];
				index = i;
				minVal = arr[i];
			} else if (dp[i] == max && arr[i] < minVal) {
				minVal = arr[i];
				index = i;
			}
		}
		int[] ret = new int[max];
		ret[--max] = arr[index];

		while (max > 0) {
			ret[--max] = arr[path[index]];
			index = path[index];
		}

		return ret;
	}


	/**
	 * 简单动态规划，时间复杂度为O(n^2)
	 * 超时！
	 *
	 * @param nums
	 * @return
	 */
	public static int[] LIS2(int[] nums) {
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

		int len = max;
		int[] ret = new int[len];
		for (int i = n - 1; i >= 0; i--) {
			if (dp[i] == len) {
				ret[--len] = nums[i];
			}
		}
		return ret;
	}


	/**
	 * 贪心 + 二分
	 * 时间复杂度为O(nlogn)
	 *
	 * @param nums
	 * @return
	 */
	public static int[] LIS3(int[] nums) {
		int n = nums.length;
		if (n == 0) {
			return new int[0];
		}
		int len = 1;
		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		int[] d = new int[n + 1];
		d[len] = nums[0];

		for (int i = 1; i < n; i++) {
			if (nums[i] > d[len]) {
				d[++len] = nums[i];
				dp[i] = len;
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
				dp[i] = pos + 1;
			}
		}
		int[] ret = new int[len];
		for (int i = n - 1; i >= 0; i--) {
			if (dp[i] == len) {
				ret[--len] = nums[i];
			}
		}

		return ret;
	}


	public static void main(String[] args) {
		int[] arr = new int[]{1, 2, 8, 6, 4};
		int[] res = LIS3(arr);
		ArrayUtils.printArray(res);
	}
}