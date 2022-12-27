package oj.lc.q1000.lc704;

/**
 * @Description:
 * @Author: zhanghua
 * @Date: 2022/12/27 01:51
 */
public class Solution {


	/**
	 * 二分查找
	 *
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int search(int[] nums, int target) {
		int l = 0, r = nums.length - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (target == nums[mid]) {
				return mid;
			} else if (nums[mid] < target) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
	}
}
