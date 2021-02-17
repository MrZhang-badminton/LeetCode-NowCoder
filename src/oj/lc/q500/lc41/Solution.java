package oj.lc.q500.lc41;

public class Solution {

	public static int firstMissingPositive(int[] nums) {
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			while (nums[i] <= nums.length && 0 < nums[i] && (nums[i] - 1) != i
			&&nums[nums[i]-1] != nums[i]) {
				int temp = nums[nums[i] - 1];
				nums[nums[i] - 1] = nums[i];
				nums[i] = temp;
			}
		}
		int i = 0;
		for (i = 0; i < n && (nums[i] - 1) == i; i++) {

		}
		return i + 1;

	}

	public static void main(String[] args) {
		System.out.println(firstMissingPositive(new int[]{1,1}));
	}
}
