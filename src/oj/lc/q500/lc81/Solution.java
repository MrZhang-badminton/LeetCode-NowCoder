package oj.lc.q500.lc81;


/**
 * 是LC33题的变式
 *
 * @date 2021年06月09日14:45:52
 */
public class Solution {

	/**
	 * 二分法，但是要对左边、中间、右边相等的情况进行特殊处理
	 *
	 * @param nums
	 * @param target
	 * @return
	 */
	public static boolean search(int[] nums, int target) {
		int n = nums.length;
		if (n == 0) {
			return false;
		}
		if (n == 1) {
			return nums[0] == target;
		}

		int l = 0, r = nums.length - 1;
		while (l < r) {
			int mid = (l + r) / 2;
			if (nums[mid] == target) {
				return true;
			}
			if (nums[l] == nums[mid] && nums[mid] == nums[r]) {
				l++;
				r--;
			} else if (nums[l] <= nums[mid]) {
				if (nums[l] <= target && target < nums[mid]) {
					r = mid - 1;
				} else {
					l = mid + 1;
				}
			} else {
				if (nums[mid] < target && target <= nums[r]) {
					l = mid + 1;
				} else {
					r = mid - 1;
				}
			}
		}
		return nums[l] == target;
	}

	public static void main(String[] args) {
		System.out.println(search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0));
	}
}
