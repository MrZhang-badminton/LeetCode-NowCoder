package oj.others;


public class QuickSortDemo {

	public static void quickSort(int[] nums) {
		quick(nums, 0, nums.length - 1);
	}

	public static void quick(int[] nums, int left, int right) {
		if (left >= right) {
			return;
		}
		int pivot = nums[left];
		int l = left, r = right;
		while (l < r) {
			while (l < r && nums[r] >= nums[l]) {
				r--;
			}
			nums[l] = nums[r];
			while (l < r && nums[l] <= nums[r]) {
				l++;
			}
			nums[r] = nums[l];
		}
		nums[l] = pivot;
		quick(nums, left, l - 1);
		quick(nums, l + 1, right);
	}


	public static void main(String[] args) {
		int[] nums = new int[]{5, 4, 3, 1, 7, 8, 9, 23, 99};
		quickSort(nums);
		System.out.println();
	}
}
