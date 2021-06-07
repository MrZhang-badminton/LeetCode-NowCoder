package oj.lc.q1000.lc912;

public class Solution {
	public static int[] sortArray(int[] nums) {
		quickSort(nums, 0, nums.length - 1);
		return nums;
	}

	public static void quickSort(int[] nums, int left, int right) {
		if (left >= right) {
			return;
		}
		int pivot = nums[left];
		int l = left, r = right;
		while (l < r) {
			while (l < r && nums[r] >= pivot) {
				r--;
			}
			nums[l] = nums[r];
			while (l < r && nums[l] <= pivot) {
				l++;
			}
			nums[r] = nums[l];
		}
		nums[l] = pivot;
		quickSort(nums, left, l - 1);
		quickSort(nums, l + 1, right);
	}

	public static void main(String[] args) {
		int[] ans = sortArray(new int[]{5, 2, 3, 1});
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
	}
}
