package oj.lc.q1000.lc556;

/**
 * @Description:
 * @Author: zhanghua
 * @Date: 2022/11/20 14:41
 */
public class Solution {


	public static int nextGreaterElement(int n) {
		char[] nums = Integer.toString(n).toCharArray();
		int len = nums.length;
		int i = len - 2;
		while (i >= 0 && nums[i] >= nums[i + 1]) {
			i--;
		}
		if (i < 0) {
			return -1;
		}
		int j = len - 1;
		while (j >= 0 && nums[i] >= nums[j]) {
			j--;
		}
		swap(nums, i, j);
		reverse(nums, i + 1);
		long ans = Long.parseLong(new String(nums));
		return ans > Integer.MAX_VALUE ? -1 : (int) ans;
	}

	private static void reverse(char[] nums, int start) {
		int i = start, j = nums.length - 1;
		while (i < j) {
			swap(nums, i, j);
			i++;
			j--;
		}
	}

	private static void swap(char[] nums, int i, int j) {
		char t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}


	public static void main(String[] args) {
		System.out.println(nextGreaterElement(230241));
	}
}
