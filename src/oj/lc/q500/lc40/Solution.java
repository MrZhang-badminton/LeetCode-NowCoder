package oj.lc.q500.lc40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	private static List<List<Integer>> ansList;

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		ansList = new ArrayList<>();
		Arrays.sort(candidates);
		List<Integer> list = new ArrayList<>();
		backTrace(candidates, 0, 0, target, list);

		return ansList;
	}

	public static void backTrace(int[] nums, int index, int sum, int target, List<Integer> list) {
		int n = nums.length;
		if (index >= n) {
			if (sum == target) {
				ansList.add(new ArrayList<>(list));
			}
			return;
		}
		if (sum > target) {
			return;
		}
		for (int i = index; i < n; i++) {
			if (i > index && nums[i] == nums[i - 1]) {
				continue;
			}
			sum += nums[i];
			list.add(nums[i]);
			if (sum == target) {
				ansList.add(new ArrayList<>(list));
			} else {
				backTrace(nums, i + 1, sum, target, list);
			}
			sum -= nums[i];
			list.remove(list.size() - 1);
		}
	}

	public static void main(String[] args) {
		System.out.println(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
	}
}
