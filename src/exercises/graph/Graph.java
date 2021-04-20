package exercises.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
	public static void main(String[] args) {
		List<List<Integer>> lists = new ArrayList<>();
		List<Integer> list0 = new ArrayList<>();
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		List<Integer> list3 = new ArrayList<>();

		list0.add(1);
		list0.add(3);
		list1.add(2);

		lists.add(list0);
		lists.add(list1);
		lists.add(list2);
		lists.add(list3);

		bfs(new int[][]{{0, 1, 0, 1},
				{0, 0, 1, 0},
				{0, 0, 0, 0},
				{0, 0, 0, 0}}, new boolean[4], lists, 0);
	}

	/**
	 * 有向图的深度优先遍历
	 *
	 * @param graph
	 * @param flag
	 * @param start
	 */
	public static void dfs(int[][] graph, boolean[] flag, List<List<Integer>> lists, int start) {
		int n = graph.length;
		System.out.println(start);
		List<Integer> tempList = lists.get(start);
		for (int i : tempList) {
			if (!flag[i]) {
				flag[i] = true;
				dfs(graph, flag, lists, i);
			}
		}
	}

	/**
	 * 广度优先遍历
	 * @param graph
	 * @param flag
	 * @param lists
	 * @param start
	 */
	public static void bfs(int[][] graph, boolean[] flag, List<List<Integer>> lists, int start) {
		Queue<Integer> queue = new LinkedList<>();

		queue.add(start);
		while(!queue.isEmpty()){
			int v = queue.poll();
			flag[v] = true;
			System.out.println(v);
			List<Integer> tempList = lists.get(v);
			for (int i : tempList) {
				if(!flag[i]){
					queue.add(i);
				}
			}
		}
	}
}
