package oj.lc.q500.lc35;

import basic.search.BinarySearch;

/**
 * @Description:
 * @Author: zhanghua
 * @Date: 2022/3/6 11:02 上午
 */
public class Solution {
	/**
	 * 二分查找
	 *
	 * @param nums
	 * @param target
	 * @return
	 *
	 * @see BinarySearch#findTargetPreIndex(int[], int)
	 */
	public static int searchInsert(int[] nums, int target) {
		int l = 0, r = nums.length - 1, pos = -1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (nums[mid] < target) {
				pos = mid;
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return pos + 1;
	}

	public static void main(String[] args) {
		System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 2));
	}
}
