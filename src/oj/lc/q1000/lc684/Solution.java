package oj.lc.q1000.lc684;

import utils.ArrayUtils;

/**
 * @Classname: Solution
 * @Author: zhanghua
 * @Date: 2021/9/4 5:59 下午
 */
public class Solution {

	/**
	 * 并查集
	 * 来自官方题解
	 * <p>
	 * 1. 如果两个顶点属于不同的连通分量，则说明在遍历到当前的边之前，这两个顶点之间不连通，
	 * 因此当前的边不会导致环出现，合并这两个顶点的连通分量
	 * <p>
	 * 2. 如果两个顶点属于相同的连通分量，则说明在遍历到当前的边之前，这两个顶点之间已经连通，
	 * 因此当前的边导致环出现，为附加的边，将当前的边作为答案返回。
	 *
	 * @param edges
	 * @return
	 */
	public static int[] findRedundantConnection(int[][] edges) {
		int n = edges.length;
		int[] parent = new int[n + 1];
		// 令parent数组var = index
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
		for (int i = 0; i < n; i++) {
			int[] edge = edges[i];
			int node1 = edge[0], node2 = edge[1];
			// 判断根是否相等
			if (find(parent, node1) != find(parent, node2)) {
				// 不相等就联合
				union(parent, node1, node2);
			} else {
				return edge;
			}
		}
		return new int[0];
	}

	/**
	 * "并"操作
	 *
	 * @param parent
	 * @param index1
	 * @param index2
	 */
	public static void union(int[] parent, int index1, int index2) {
		parent[find(parent, index1)] = find(parent, index2);
	}

	/**
	 * "查"操作
	 * 递归找根
	 *
	 * @param parent
	 * @param index
	 * @return
	 */
	public static int find(int[] parent, int index) {
		if (parent[index] != index) {
			parent[index] = find(parent, parent[index]);
		}
		// parent[index] = index代表父节点就是本身
		return parent[index];
	}


	public static void main(String[] args) {
		int[][] edges = new int[][]{
				{3, 4}, {1, 2}, {2, 4}, {3, 5}, {2, 5}
		};
		ArrayUtils.printArray(findRedundantConnection(edges));
	}
}
