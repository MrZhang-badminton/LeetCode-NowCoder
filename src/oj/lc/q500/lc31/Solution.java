package oj.lc.q500.lc31;

/**
 * 本体要找到数字的下一个排列，找到了一个前者nums[i]比后者nums[j]小的相邻序列的时候，前者及之后的
 * 都要进行重排序，希望找到一个比nums[i]大，且尽可能小的数组，然后将他放到i位置，后面的数组在进行
 * reverse即可
 * @date 2021年02月25日16:51:35
 */
public class Solution {

	public static void swap(int[] nums, int i, int j) {
		int temp = nums[j];
		nums[j] = nums[i];
		nums[i] = temp;
	}

	public static void reverse(int[] nums, int left, int right) {
		for (int i = left; i <= (left + right) / 2; i++) {
			swap(nums, i, right - (i - left));
		}
	}

	public static void nextPermutation(int[] nums) {
		int n = nums.length;
		int i = n - 2;

		while (i >= 0 && nums[i] >= nums[i + 1]) {
			i--;
		}
		if (i >= 0) {
			int j = n - 1;
			while (nums[j] <= nums[i]) {
				j--;
			}
			swap(nums, i, j);
		}
		reverse(nums, i + 1, n - 1);
	}

	public static void main(String[] args) {
		int[] nums = new int[]{1, 3, 2};
		nextPermutation(nums);

		System.out.println();
	}
}
