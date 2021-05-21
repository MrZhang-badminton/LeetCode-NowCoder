package oj.lc.q500.lc56;

import utils.methods.ArrayUtils;

import java.util.*;

/**
 * 合并区间
 *
 * @date 2021年05月01日22:11:51
 */
public class Solution {

	/**
	 * 先排序，再处理
	 * @param intervals
	 * @return
	 */
	public static int[][] merge(int[][] intervals) {
		int n = intervals.length;
		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			}
		});
		Map<Integer, Integer> map = new LinkedHashMap<>();
		int left = intervals[0][0], right = intervals[0][1];
		for (int i = 1; i < n; i++) {
			int l = intervals[i][0], r = intervals[i][1];
			if (l <= right) {
				right = Math.max(right, r);
			} else if (right < l) {
				map.put(left, right);
				left = l;
				right = r;
			}
		}
		map.put(left,right);
		int[][] ret = new int[map.size()][2];
		int index = 0;
		for(Map.Entry entry : map.entrySet()){
			ret[index][0] = (Integer) entry.getKey();
			ret[index][1] = (Integer)entry.getValue();
			index++;
		}
		return ret;
	}

	public static void main(String[] args) {

		int[][] matrix = merge(new int[][]{
				{1,4},{4,5}
		});
		ArrayUtils.printArray(matrix);



		List<Integer> list = new ArrayList<>();
		list.add(123);
		System.out.println(list.get(0));
	}
}
