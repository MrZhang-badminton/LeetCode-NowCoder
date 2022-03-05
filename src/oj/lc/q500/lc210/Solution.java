package oj.lc.q500.lc210;

import utils.ArrayUtils;

import java.util.*;

public class Solution {

	/**
	 * 拓扑排序
	 *
	 * @param numCourses
	 * @param prerequisites
	 * @return
	 */
	public static int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] result = new int[numCourses];
		int[] in = new int[numCourses];
		int n = prerequisites.length;
		int count = 0;

		List<List<Integer>> edgesList = new ArrayList<>();
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 0; i < numCourses; i++) {
			edgesList.add(new ArrayList<>());
		}

		for (int i = 0; i < n; i++) {
			in[prerequisites[i][0]]++;
			List<Integer> list = edgesList.get(prerequisites[i][1]);
			list.add(prerequisites[i][0]);
		}

		for (int i = 0; i < numCourses; i++) {
			if (in[i] == 0) {
				queue.offer(i);
			}
		}

		while (!queue.isEmpty()) {
			int num = queue.poll();
			result[count++] = num;
			//更新边
			List<Integer> tList = edgesList.get(num);
			for (int k : tList) {
				in[k]--;
				if (in[k] == 0) {
					queue.offer(k);
				}
			}
		}
		if (count < numCourses) {
			return new int[0];
		}
		return result;
	}


	public static void main(String[] args) {
		int[] result = findOrder(3, new int[][]{
				{1, 0},
				{0, 1},
//				{1, 2}
//				{2, 0},
//				{3, 1},
//				{3, 2}
		});
		ArrayUtils.printArray(result);
	}
}
