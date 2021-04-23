package oj.lc.q500.lc46;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 输出全排列
 * <p>
 * 经典回溯法
 *
 * @date 2021年04月23日21:56:47
 */
public class Solution {

	public static void main(String[] args) {
		System.out.println(permute(new int[]{1, 2, 3}));
	}

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> ansList = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		for (int num : nums) {
			list.add(num);
		}
		int n = nums.length;
		backTrack(n, list, ansList, 0);
		return ansList;

	}

	public static void backTrack(int n, List<Integer> list, List<List<Integer>> ansList, int first) {
		if (first == n) {
			ansList.add(new ArrayList<>(list));
		}
		for (int i = first; i < n; i++) {
			Collections.swap(list, first, i);
			backTrack(n, list, ansList, first + 1);
			Collections.swap(list, first, i);
		}
	}


}
