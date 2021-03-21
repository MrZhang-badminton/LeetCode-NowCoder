package oj.lc.temp.lc162;

public class Solution {
	/**
	 * 二分法，可以用画图来解决，每个数值都是一个点，然后将点连起来
	 * 可以找到规律，向有大的值那边收缩
	 *
	 * @param nums
	 * @return
	 */
	public static int findPeakElement(int[] nums) {
		return search(nums, 0, nums.length - 1);
	}

	public static int search(int[] nums, int l, int r) {
		if (l == r) {
			return l;
		}
		int mid = (l + r) / 2;
		if (nums[mid] > nums[mid + 1]) {
			return search(nums, l, mid);
		}
		return search(nums, mid + 1, r);
	}

	public static void main(String[] args) {
		System.out.println(findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
	}
}