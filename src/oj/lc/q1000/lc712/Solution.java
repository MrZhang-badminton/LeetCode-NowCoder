package oj.lc.q1000.lc712;

/**
 * @Description:
 * @Author: zhanghua
 * @Date: 2022/3/19 5:27 下午
 */
public class Solution {

	/**
	 * 动态规划
	 *
	 * @param s1
	 * @param s2
	 * @return
	 * @ref 最长公共子序列
	 */
	public static int minimumDeleteSum(String s1, String s2) {
		int len1 = s1.length(), len2 = s2.length();
		int[][] dp = new int[len1 + 1][len2 + 1];
		dp[len1][len2] = 0;
		// 初始化边界值
		for (int i = len1 - 1; i >= 0; i--) {
			dp[i][len2] = dp[i + 1][len2] + s1.codePointAt(i);
		}
		for (int i = len2 - 1; i >= 0; i--) {
			dp[len1][i] = dp[len1][i + 1] + s2.codePointAt(i);
		}

		for (int i = len1 - 1; i >= 0; i--) {
			for (int j = len2 - 1; j >= 0; j--) {
				// 状态转移方程
				if (s1.charAt(i) == s2.charAt(j)) {
					dp[i][j] = dp[i + 1][j + 1];
				} else {
					dp[i][j] = Math.min(s1.codePointAt(i) + dp[i + 1][j], s2.codePointAt(j) + dp[i][j + 1]);
				}
			}
		}

		return dp[0][0];
	}

	public static void main(String[] args) {
		System.out.println(minimumDeleteSum("sea", "eat"));
	}

}
