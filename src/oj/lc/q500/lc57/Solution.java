package oj.lc.q500.lc57;

import utils.methods.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	/**
	 * 自己写的，太复杂了
	 *
	 * @param intervals
	 * @param newInterval
	 * @return
	 */
	public static int[][] insert(int[][] intervals, int[] newInterval) {
		if (intervals.length == 0) {
			return new int[][]{newInterval};
		}
		List<Integer[]> list = new ArrayList<>();
		int left = -1;
		for (int i = 0; i < intervals.length; i++) {
			if (intervals[i][1] < newInterval[0]) {
				list.add(new Integer[]{intervals[i][0], intervals[i][1]});
			} else if (left == -1) {
				left = Math.min(intervals[i][0], newInterval[0]);
			}
			if (left == -2 && intervals[i][0] > newInterval[1]) {
				list.add(new Integer[]{intervals[i][0], intervals[i][1]});
			}
			if (left > -1 && newInterval[1] <= intervals[i][1]) {
				if (newInterval[1] < intervals[i][0]) {
					list.add(new Integer[]{left, newInterval[1]});
					list.add(new Integer[]{intervals[i][0], intervals[i][1]});
				} else {
					list.add(new Integer[]{left, intervals[i][1]});
				}
			}
		}
		int[][] results = new int[list.size()][2];
		int count = 0;
		for (Integer[] nums : list) {
			results[count][0] = nums[0];
			results[count][1] = nums[1];
			count++;
		}
		return results;
	}

	/**
	 * 来自题解，相对简洁
	 *
	 * @param intervals
	 * @param newInterval
	 * @return
	 */
	public static int[][] insert2(int[][] intervals, int[] newInterval) {
		int left = newInterval[0];
		int right = newInterval[1];
		boolean placed = false;
		List<int[]> ansList = new ArrayList<int[]>();
		for (int[] interval : intervals) {
			if (interval[0] > right) {
				// 在插入区间的右侧且无交集
				if (!placed) {
					ansList.add(new int[]{left, right});
					placed = true;
				}
				ansList.add(interval);
			} else if (interval[1] < left) {
				// 在插入区间的左侧且无交集
				ansList.add(interval);
			} else {
				// 与插入区间有交集，计算它们的并集
				left = Math.min(left, interval[0]);
				right = Math.max(right, interval[1]);
			}
		}
		if (!placed) {
			ansList.add(new int[]{left, right});
		}
		int[][] ans = new int[ansList.size()][2];
		for (int i = 0; i < ansList.size(); ++i) {
			ans[i] = ansList.get(i);
		}
		return ans;
	}


	public static void main(String[] args) {
		int[][] intervals = new int[][]{
				{1, 3},
				{6, 9}
		};
		int[] newInterval = new int[]{2, 5};

		int[][] results = insert2(intervals, newInterval);
		ArrayUtils.printArray(results);

	}
}
