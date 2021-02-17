package oj.lc.q500.lc198;

public class Solution {
	public static int rob(int[] nums) {
		int n = nums.length;
		if(n == 0){
			return 0;
		}
		else if (n == 1) {
			return nums[0];
		}

		int max = 0;

		int first = nums[0];
		int second = nums[0] > nums[1] ? nums[0] : nums[1];
		max = second;
		for (int i = 2; i < n; i++) {
			int temp = second;
			if ((first + nums[i]) > second) {
				second = first + nums[i];
			} else {
				second = second;
			}
			first = temp;
			max = Math.max(max, second);

		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(rob(new int[]{2, 7, 9, 3, 1}));
	}
}
