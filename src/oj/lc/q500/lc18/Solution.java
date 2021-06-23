package oj.lc.q500.lc18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和
 * 注意参考三数之和，使用双指针可以去处一重循环，使得最终
 * 时间复杂度为O(n^3)
 *
 * @date 2021年04月25日01:17:07
 */
public class Solution {
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		int n = nums.length;
		List<List<Integer>> ansList = new ArrayList<>();
		if (nums == null || n < 4) {
			return ansList;
		}
		Arrays.sort(nums);

		for (int i = 0; i < n - 3; i++) {
			if (i != 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
				break;
			}
			if (nums[i] + nums[n - 3] + nums[n - 2] + nums[n - 1] < target) {
				continue;
			}
			for (int j = i + 1; j < n - 2; j++) {
				if (j != i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}
				if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
					break;
				}
				if (nums[i] + nums[j] + nums[n - 2] + nums[n - 1] < target) {
					continue;
				}
				int l = j + 1, r = n - 1;
				while (l < r) {
					int sum = nums[i] + nums[j] + nums[l] + nums[r];
					if (sum == target) {
						ansList.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
						while (l < r && nums[l] == nums[l + 1]) {
							l++;
						}
						l++;
						while (l < r && nums[r] == nums[r - 1]) {
							r--;
						}
						r--;
					} else if (sum < target) {
						l++;
					} else {
						r--;
					}
				}

			}
		}
		return ansList;
	}

	public static void main(String[] args) {
		System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
	}
}
