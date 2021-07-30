package basic.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @date 2021年04月21日13:09:06
 * <p>
 * 基于邻接矩阵的深度优先遍历与广度优先遍历
 */
public class Graph {
	public static void main(String[] args) {

		dfs(new int[][]{{0, 1, 0, 1},
				{0, 0, 1, 0},
				{0, 0, 0, 0},
				{0, 0, 0, 0}}, new boolean[4], 0);
	}

	public static List<Integer> getNeighbour(int[][] graph, int start) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < graph.length; i++) {
			if (graph[start][i] != 0) {
				list.add(i);
			}
		}
		return list;
	}

	/**
	 * 有向图的深度优先遍历
	 *
	 * @param graph
	 * @param flag
	 * @param start
	 */
	public static void dfs(int[][] graph, boolean[] flag, int start) {
		int n = graph.length;
		System.out.println(start);
		List<Integer> tempList = getNeighbour(graph, start);
		for (int i : tempList) {
			if (!flag[i]) {
				flag[i] = true;
				dfs(graph, flag, i);
			}
		}
	}

	/**
	 * 广度优先遍历
	 *
	 * @param graph
	 * @param flag
	 * @param start
	 */
	public static void bfs(int[][] graph, boolean[] flag, int start) {
		Queue<Integer> queue = new LinkedList<>();

		queue.add(start);
		while (!queue.isEmpty()) {
			int v = queue.poll();
			flag[v] = true;
			System.out.println(v);
			List<Integer> tempList = getNeighbour(graph, v);
			for (int i : tempList) {
				if (!flag[i]) {
					queue.add(i);
				}
			}
		}
	}
}
