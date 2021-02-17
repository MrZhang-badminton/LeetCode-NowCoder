package oj.nc.nc91;

import java.util.*;

public class Solution {

	/**
	 * 求一个数组最长的递增序列（严格单调递增）
	 * @param arr
	 * @return
	 */
	public static int[] LIS(int[] arr) {
		int n = arr.length;
		if (n < 2) {
			return arr;
		}
		//list.get(0)代表长度为0 + 1 = 1 的递增序列的最后一个字母，不断更新
		//最终为长度为0 + 1 = 1的字典序最小的递增序列的最后一个字母
		List<Integer> list = new ArrayList<>();
		//dp为以arr[i]为结尾的最长递增序列长度
		int[] dp = new int[n];

		list.add(arr[0]);
		dp[0] = 1;

		for (int i = 1; i < n; i++) {
			if (arr[i] > arr[i - 1]) {
				dp[i] = dp[i - 1] + 1;
				dp[i] = list.size() + 1;
				list.add(arr[i]);
			} else {
				int index = binarySearchTarget(list, arr[i]);
				list.set(index, arr[i]);
				dp[i] = index + 1;
			}
		}

		int len = list.size();
		int[] ans = new int[len];
		for (int i = n - 1; i >= 0; i--) {
			if (dp[i] == len) {
				ans[len - 1] = arr[i];
				len--;
			}
		}
		return ans;

	}

	public static int binarySearchTarget(List<Integer> list, int target) {
		int l = 0, r = list.size() - 1;
		while (l < r) {
			int mid = (l + r) / 2;
			// <= 使得最终找到的index为list.get(index - 1) < target < list.get(index)
			// 便于后序替换掉index位置的数字
			if (list.get(mid) <= target) {
				l = mid + 1;
			} else {
				r = mid;
			}
		}
		return l;
	}

	public static void main(String[] args) {
		int[] arr = new int[]{1, 2, 8, 6, 4};
		int[] res = LIS(arr);
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}
}