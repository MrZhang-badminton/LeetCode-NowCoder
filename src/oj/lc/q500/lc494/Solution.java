package oj.lc.q500.lc494;

public class Solution {
	private static int count;

	public static int findTargetSumWays(int[] nums, int target) {
		count = 0;

		nextStep(nums, 0, target);
		return count;
	}

	public static void nextStep(int[] nums, int index, int target) {
		if (index == nums.length && target == 0) {
			count++;
			return;
		} else if (index == nums.length) {
			return;
		}

		nextStep(nums, index + 1, target - nums[index]);
		nextStep(nums, index + 1, target + nums[index]);

	}

	public static void main(String[] args) {
		System.out.println(findTargetSumWays(new int[]{1, 0}, 1));
	}
}
