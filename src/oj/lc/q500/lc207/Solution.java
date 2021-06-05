package oj.lc.q500.lc207;

import java.util.*;

public class Solution {

	private static List<List<Integer>> edges;
	private static int[] visited;
	private static boolean valid;

	/**
	 * 深度优先遍历
	 *
	 * @param numCourses
	 * @param prerequisites
	 * @return
	 */
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		edges = new ArrayList<>();
		visited = new int[numCourses];
		valid = true;

		for (int i = 0; i < numCourses; i++) {
			edges.add(new ArrayList<>());
		}

		for (int[] info : prerequisites) {
			edges.get(info[1]).add(info[0]);
		}

		for (int i = 0; i < numCourses; i++) {
			if (visited[i] == 0) {
				dfs(i);
			}
		}
		return valid;
	}

	public static void dfs(int u) {
		visited[u] = 1;
		for (int v : edges.get(u)) {
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
	}





	public static void main(String[] args) {
		System.out.println(canFinish(3, new int[][]
				{{0, 1}, {0, 2}, {1, 2}}
		));
	}
}
