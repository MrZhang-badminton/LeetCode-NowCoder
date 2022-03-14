package oj.lc.q1000.lc547;

import java.util.Arrays;

/**
 * @Description:
 * @Author: zhanghua
 * @Date: 2022/3/12 2:49 下午
 */
public class Solution {


	/**
	 * 图
	 * <p>
	 * 题目等价于求有多少个联通分量？
	 *
	 * @param isConnected
	 * @return
	 */
	public static int findCircleNum(int[][] isConnected) {
		int num = isConnected.length;
		int ans = 0;
		int[] vs = new int[num];
		Arrays.fill(vs, 1);
		for (int i = 0; i < num; i++) {
			if (vs[i] != 0) {
				dfs(isConnected, i, vs);
				vs[0] = 0;
				ans++;
			}
		}

		return ans;
	}

	public static void dfs(int[][] isConnected, int v, int[] vs) {
		int n = isConnected.length;
		for (int i = 0; i < n; i++) {
			if (isConnected[v][i] == 1) {
				isConnected[v][i] = 0;
				vs[i] = 0;
				dfs(isConnected, i, vs);
			}
		}
	}


	public static void main(String[] args) {
		System.out.println(findCircleNum(new int[][]{
				{1, 0, 0, 1},
				{0, 1, 1, 0},
				{0, 1, 1, 1},
				{1, 0, 1, 1}
		}));
	}
}
