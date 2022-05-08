package oj.lc.q500.lc442;

import java.util.*;

/**
 * @Description:
 * @Author: zhanghua
 * @Date: 2022/5/8 6:36 下午
 */
public class Solution {

	/**
	 * 思维最简单
	 * <p>
	 * 时间复杂度O(n)
	 * 空间复杂度O(n)
	 *
	 * @param nums
	 * @return
	 */
	public static List<Integer> findDuplicates(int[] nums) {
		List<Integer> ansList = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		Arrays.stream(nums).forEach(item -> {
			if (!set.contains(item)) {
				set.add(item);
			} else {
				ansList.add(item);
			}
		});

		return ansList;
	}


	/**
	 * "发配法"，将元素放到相应位置
	 * 元素和位置不符的则为ans
	 *
	 * @param nums
	 * @return
	 */
	public static List<Integer> findDuplicates2(int[] nums) {
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			while (nums[i] != nums[nums[i] - 1]) {
				swap(nums, i, nums[i] - 1);
			}
		}
		List<Integer> ans = new ArrayList<>();
		for (int i = 0; i < len; i++) {
			if (nums[i] - 1 != i) {
				ans.add(nums[i]);
			}
		}
		return ans;
	}

	public static void swap(int[] nums, int l, int r) {
		int temp = nums[l];
		nums[l] = nums[r];
		nums[r] = temp;
	}

	public static void main(String[] args) {
		System.out.println(findDuplicates2(new int[]{5, 4, 6, 7, 9, 3, 10, 9, 5, 6}));
	}
}
