package oj.lc.q500.lc47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	static boolean[] vis;

	static List<List<Integer>> ansList;

	public static List<List<Integer>> permuteUnique(int[] nums) {
		int n = nums.length;

		vis = new boolean[n];
		ansList = new ArrayList<>();
		Arrays.sort(nums);
		List<Integer> list = new ArrayList<>();
		backTrace(nums, list, 0);
		return ansList;
	}

	public static void backTrace(int[] nums, List<Integer> list, int index) {
		int n = nums.length;
		if (index == n) {
			ansList.add(new ArrayList<>(list));
			return;
		}
		for (int i = 0; i < n; i++) {
			if (vis[i] || (i != 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
				continue;
			}

			list.add(nums[i]);
			vis[i] = true;
			backTrace(nums, list, index + 1);
			vis[i] = false;
			list.remove(list.size() - 1);
		}
	}

	public static void main(String[] args) {
		System.out.println(permuteUnique(new int[]{1, 1, 2}));
	}
}
