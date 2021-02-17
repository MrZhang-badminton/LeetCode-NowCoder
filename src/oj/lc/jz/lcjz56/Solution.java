package oj.lc.jz.lcjz56;

import java.util.Arrays;

public class Solution {

	public static int singleNumber(int[] nums) {
		Arrays.sort(nums);
		int i;
		for (i = 0; i < nums.length - 2; i += 3) {
			if (nums[i] != nums[i + 2]) {
				break;
			}
		}
		return nums[i];
	}

	public static void main(String[] args) {
		System.out.println(singleNumber(new int[]{9, 1, 7, 9, 7, 9, 7}));
	}
}
