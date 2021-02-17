package oj.lc.q500.lc347;

import utils.methods.ArrayUtils;

import java.util.*;

public class Solution {

	public static void quickSort(List<int[]> list, int left, int right, int k) {
		if (left >= right) {
			return;
		}
		int[] pivot = list.get(left);
		int l = left, r = right;
		while (l < r) {
			while (l < r && list.get(r)[1] >= pivot[1]) {
				r--;
			}
			list.set(l, list.get(r));
			while (l < r && list.get(l)[1] <= pivot[1]) {
				l++;
			}
			list.set(r, list.get(l));
		}
		list.set(l,pivot);
		if (l == (right - k + 1)) {
			return;
		} else if (l < (right - k + 1)) {
			quickSort(list, l + 1, right, k);
		} else {
			quickSort(list, left, l - 1, k - (right - l + 1));
		}
	}

	public static int[] topKFrequent(int[] nums, int k) {
		int n = nums.length;
		Map<Integer, Integer> map = new HashMap<>();
		List<int[]> list = new ArrayList<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int num = entry.getKey(), count = entry.getValue();
			list.add(new int[]{num, count});
		}

		quickSort(list, 0, list.size() - 1, k);

		int[] ans = new int[k];
		int index = k-1;
		for (int i = 0; i < k; i++) {
			ans[index--] = list.get(list.size()-i-1)[0];
		}
		return ans;
	}

	public static void main(String[] args) {
		ArrayUtils.printArray(topKFrequent(new int[]{1,2}, 2));
	}
}
