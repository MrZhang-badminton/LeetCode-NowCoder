package oj.lc.q500.lc131;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: zhanghua
 * @Date: 2022/12/27 01:19
 */
public class Solution {

	private static List<List<String>> ret;

	private static List<String> ans;

	private static int[][] dp;

	private static int n;

	/**
	 * 参考官方题解
	 * 回溯 + 记忆化搜索
	 *
	 * @param s
	 * @return
	 */
	public static List<List<String>> partition(String s) {
		ret = new ArrayList<>();
		ans = new ArrayList<>();
		n = s.length();
		dp = new int[n][n];

		dfs(s, 0);
		return ret;
	}

	private static void dfs(String s, int i) {
		if (i == n) {
			ret.add(new ArrayList<>(ans));
			return;
		}

		for (int j = i; j < n; j++) {
			if (judge(s, i, j) == 1) {
				ans.add(s.substring(i, j + 1));
				dfs(s, j + 1);
				ans.remove(ans.size() - 1);
			}
		}
	}

	/**
	 * 利用全局变量dp[][] 二维数组, 来减少冗余计算
	 *
	 * @param s
	 * @param i
	 * @param j
	 * @return
	 */
	private static int judge(String s, int i, int j) {
		if (dp[i][j] != 0) {
			return dp[i][j];
		}
		if (i >= j) {
			dp[i][j] = 1;
		} else if (s.charAt(i) == s.charAt(j)) {
			dp[i][j] = judge(s, i + 1, j - 1);
		} else {
			dp[i][j] = -1;
		}
		return dp[i][j];
	}


	public static void main(String[] args) {
		System.out.println(partition("a"));
	}
}
