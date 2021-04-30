package oj.lc.q500.lc53;

public class Solution {

	public static int maxSubArray(int[] nums) {
		int temp = nums[0];
		int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			temp = Math.max(nums[i],temp+nums[i]);
			max = Math.max(temp,max);
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(maxSubArray(new int[]{1}));
	}

}
