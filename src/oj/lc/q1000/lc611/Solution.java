package oj.lc.q1000.lc611;

import java.util.Arrays;

public class Solution {

	/**
	 * 暴力解法
	 *
	 * @param nums
	 * @return
	 */
	public int triangleNumber(int[] nums) {
		int count = 0;
		for (int i = 0; i < nums.length - 2; i++) {
			for (int j = i + 1; j < nums.length - 1; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					if (nums[i] + nums[j] > nums[k] && nums[i] + nums[k] > nums[j] && nums[j] + nums[k] > nums[i]) {
						count++;
					}
				}
			}
		}
		return count;
	}

	/**
	 * 二分查找法
	 *
	 * @param nums
	 * @return
	 */
	public static int binarySearch(int[] nums, int l, int r, int target) {
		while (r >= l && r < nums.length) {
			int mid = (l + r) / 2;
			if (nums[mid] >= target) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return l;
	}

	public static int triangleNumber2(int[] nums) {
		int count = 0;
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			int k = i + 2;
			for (int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++) {
				//这边做了优化，不必每次从j+1开始遍历，可以直接从上一次的结果k处开始遍历
				k = binarySearch(nums, k, nums.length - 1, (nums[i] + nums[j]));
				count += k - j - 1;
			}
		}

		return count;
	}

	/**
	 * 双指针法
	 *
	 * @param nums
	 * @return
	 */
	public static int triangleNumber3(int[] nums) {
		int count = 0;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			int k = i + 2;
			for (int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++) {
				while (k < nums.length && nums[i] + nums[j] > nums[k]) {
					k++;
					count += k - j - 1;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(triangleNumber2(new int[]{2, 2, 3, 4}));
	}
}
