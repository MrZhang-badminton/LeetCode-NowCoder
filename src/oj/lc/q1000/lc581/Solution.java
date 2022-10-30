package oj.lc.q1000.lc581;

import java.util.Arrays;

/**
 * @Description:
 * @Author: zhanghua
 * @Date: 2022/10/30 20:05
 */
public class Solution {

	public static int findUnsortedSubarray(int[] nums) {
		int len = nums.length;
		int[] arr = Arrays.copyOf(nums, len);
		Arrays.sort(arr);
		int i = 0;
		while (i < len && nums[i] == arr[i]) i++;
		int a = i == len ? 0 : i - 1;
		i = len - 1;
		while (i >= 0 && nums[i] == arr[i]) i--;
		int b = i == -1 ? 0 : i;
		return b - a;

	}


	public static int findUnsortedSubarray2(int[] nums) {
		int n = nums.length;
		int maxn = Integer.MIN_VALUE, right = -1;
		int minn = Integer.MAX_VALUE, left = -1;
		for (int i = 0; i < n; i++) {
			if (maxn > nums[i]) {
				right = i;
			} else {
				maxn = nums[i];
			}

			if (minn < nums[n - i - 1]) {
				left = n - i - 1;
			} else {
				minn = nums[n - i - 1];
			}
		}
		return right == -1 ? 0 : right - left + 1;
	}


	public static void main(String[] args) {
		System.out.println(findUnsortedSubarray2(new int[]{2, 6, 4, 8, 10, 9, 15}));
	}
}
