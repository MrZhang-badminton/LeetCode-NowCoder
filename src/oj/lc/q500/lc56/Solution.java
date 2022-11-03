package oj.lc.q500.lc56;

import utils.ArrayUtils;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 合并区间
 *
 * @date 2021年05月01日22:11:51
 */
public class Solution {


	/**
	 * 先排序, 再处理
	 * @param intervals
	 * @return
	 */
	public static int[][] merge(int[][] intervals) {
		int n = intervals.length;
		Arrays.sort(intervals, (o1, o2) -> {
			if (o1[0] == o2[0]) {
				return o1[1] - o2[1];
			}
			return o1[0] - o2[0];
		});

		Map<Integer, Integer> map = new HashMap<>();
		int left = intervals[0][0], right = intervals[0][1];

		for (int i = 1; i < n; i++) {

			int l = intervals[i][0], r = intervals[i][1];
			if (l <= right) {
				right = Math.max(right, r);
			} else {
				map.put(left, right);
				left = l;
				right = r;
			}
		}

		map.put(left, right);
		int size = map.size();
		int[][] result = new int[size][2];
		int k = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			result[k][0] = entry.getKey();
			result[k++][1] = entry.getValue();
		}
		return result;
	}


	public static void main(String[] args) {

		int[][] matrix = merge(new int[][]{
				{1, 4}, {4, 5}
		});
		ArrayUtils.printArray(matrix);


//		List<Integer> list = new ArrayList<>();
//		list.add(123);
//		System.out.println(list.get(0));
	}
}
