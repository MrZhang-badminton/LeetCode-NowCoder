package oj.lc.q500.lc16;

import java.util.Arrays;

public class Solution {

	public static int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int n = nums.length;
		//这边不能设置为Integer.MAX_VALUE
		//因为当Math.abs(Integer.MAX_VALUE - (-1))的时候发生溢出
		//int result = Integer.MAX_VALUE;

		//这边设置为16进制0x3f3f3f3f,既可以表示很大的数,又可以在大多数时候避免溢出
		int result = 0x3f3f3f3f;
		for (int i = 0; i < n - 2; i++) {
			if (i != 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int l = i + 1, r = n - 1;
			while (l < r) {
				int sum = nums[i] + nums[l] + nums[r];
				if (sum == target) {
					return target;
				}
				if (Math.abs(sum - target) < Math.abs(result - target)) {
					result = sum;
				}
				if (sum > target) {
					int j = r - 1;
					while (l < j && nums[j] == nums[r]) {
						j--;
					}
					r = j;
				} else {
					int k = l + 1;
					while (k < r && nums[k] == nums[l]) {
						k++;
					}
					l = k;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
	}
}
