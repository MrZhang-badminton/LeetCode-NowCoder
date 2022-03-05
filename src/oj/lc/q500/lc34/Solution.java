package oj.lc.q500.lc34;

import utils.ArrayUtils;

public class Solution {


	/**
	 * 二分搜索
	 * 写法较为笨拙，冗余
	 *
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] searchRange(int[] nums, int target) {
		int index1 = searchLeft(nums, target);
		int index2 = searchRight(nums, target);
		return new int[]{index1, index2};
	}

	public static int searchLeft(int[] nums, int target) {
		int n = nums.length;
		int l = 0, r = n - 1, pos = -1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (nums[mid] < target) {
				pos = mid;
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		pos++;
		if (pos >= 0 && pos < n && nums[pos] == target) {
			return pos;
		}
		return -1;
	}

	public static int searchRight(int[] nums, int target) {
		int n = nums.length;
		int l = 0, r = n - 1, pos = n;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (nums[mid] > target) {
				pos = mid;
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		pos--;
		if (pos >= 0 && pos < n && nums[pos] == target) {
			return pos;
		}
		return -1;
	}

	/**
	 * 二分搜索
	 * 来自题解
	 * 写法较为简单
	 *
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] searchRange2(int[] nums, int target) {
		int leftIdx = binarySearch(nums, target, true);
		int rightIdx = binarySearch(nums, target, false) - 1;
		if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
			return new int[]{leftIdx, rightIdx};
		}
		return new int[]{-1, -1};
	}

	public static int binarySearch(int[] nums, int target, boolean lower) {
		int left = 0, right = nums.length - 1, ans = nums.length;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] > target || (lower && nums[mid] >= target)) {
				right = mid - 1;
				ans = mid;
			} else {
				left = mid + 1;
			}
		}
		return ans;
	}


	public static void main(String[] args) {
		int[] result = searchRange(new int[]{1}, 1);
		ArrayUtils.printArray(result);
	}
}
