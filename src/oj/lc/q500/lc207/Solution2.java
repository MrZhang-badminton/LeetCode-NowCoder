package oj.lc.q500.lc207;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution2 {

	private static List<List<Integer>> edges;
	private static int[] indeg;

	/**
	 * 拓扑排序
	 *
	 * @param numCourses
	 * @param prerequisites
	 * @return
	 */
	public static boolean canFinish2(int numCourses, int[][] prerequisites) {
		edges = new ArrayList<>();
		indeg = new int[numCourses];
		for (int i = 0; i < numCourses; i++) {
			edges.add(new ArrayList<>());
		}
		for(int[] info : prerequisites){
			edges.get(info[1]).add(info[0]);
			indeg[info[0]]++;
		}

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if(indeg[i] == 0){
				queue.offer(i);
			}
		}

		int count = 0;
		while(!queue.isEmpty()){
			count++;
			int u = queue.poll();

			for(int v : edges.get(u)){
				indeg[v]--;
				if(indeg[v]== 0){
					queue.offer(v);
				}
			}
		}

		return count == numCourses;
	}



	public static void main(String[] args) {
		System.out.println(canFinish2(3, new int[][]
				{{0, 1}, {0, 2}, {1, 2}}
		));
	}
}
