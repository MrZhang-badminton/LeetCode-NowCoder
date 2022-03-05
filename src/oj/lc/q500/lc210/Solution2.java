package oj.lc.q500.lc210;

import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

	static List<List<Integer>> edgeList = new ArrayList<>();
	static int[] visited;
	static int[] result;
	static boolean valid;
	static int index;

	/**
	 * 深度优先遍历
	 *
	 * @param numCourses
	 * @param prerequisites
	 * @return
	 */
	public static int[] findOrder(int numCourses, int[][] prerequisites) {
		edgeList = new ArrayList<>();
		for (int i = 0; i < numCourses; i++) {
			edgeList.add(new ArrayList<>());
		}
		visited = new int[numCourses];
		result = new int[numCourses];
		index = numCourses - 1;
		valid = true;
		for (int[] info : prerequisites) {
			edgeList.get(info[1]).add(info[0]);
		}
		for (int i = 0; i < numCourses && valid; i++) {
			if (visited[i] == 0) {
				dfs(i);
			}
		}
		if (!valid) {
			return new int[0];
		}
		return result;
	}

	public static void dfs(int u) {
		visited[u] = 1;
		for (int v : edgeList.get(u)) {

			if (visited[v] == 0) {
				dfs(v);
				if (!valid) {
					return;
				}
			} else if (visited[v] == 1) {
				valid = false;
				return;
			}
		}
		visited[u] = 2;
		result[index--] = u;
	}


	public static void main(String[] args) {
		int[] result = findOrder(2, new int[][]{
				{1, 0},
//				{0, 1},
//				{1, 2}
//				{2, 0},
//				{3, 1},
//				{3, 2}
		});
		ArrayUtils.printArray(result);
	}
}
