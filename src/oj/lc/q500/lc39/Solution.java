package oj.lc.q500.lc39;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

	private static List<List<Integer>> ansList;

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		ansList = new ArrayList<>();
		LinkedList<Integer> list = new LinkedList<>();
		backTrace(candidates, target, candidates.length - 1, list);
		return ansList;
	}

	public static void backTrace(int[] candidates, int amount, int index, LinkedList<Integer> list) {

		if (amount == 0) {
			ansList.add(new ArrayList<>(list));
			return;
		}
		if (index < 0) {
			return;
		}

		int sum = 0;
		int count = 0;
		while (sum <= amount) {
			count++;
			if (sum != 0) {
				list.addLast(candidates[index]);
			}
			backTrace(candidates, amount - sum, index - 1, list);
			sum += candidates[index];
		}
		count--;
		while (count > 0) {
			list.removeLast();
			count--;
		}

	}


	public static void main(String[] args) {
		System.out.println(combinationSum(new int[]{1, 2}, 1));
	}
}
