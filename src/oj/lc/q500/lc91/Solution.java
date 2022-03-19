package oj.lc.q500.lc91;

/**
 * @Description:
 * @Author: zhanghua
 * @Date: 2022/3/17 2:59 下午
 */
public class Solution {

	/**
	 * 【官方题解】 动态规划
	 *
	 * @param s
	 * @return
	 */
	public static int numDecodings(String s) {
		int n = s.length();
		int[] dp = new int[n + 1];
		dp[0] = 1;
		for (int i = 1; i <= n; i++) {
			if (s.charAt(i - 1) != '0') {
				dp[i] += dp[i - 1];
			}
			if (i > 1 && s.charAt(i - 2) != '0' && (((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0')) <= 26)) {
				dp[i] += dp[i - 2];
			}
		}
		return dp[n];
	}

	/**
	 * 动态规划
	 * 该方法空间复杂度为O(1)
	 *
	 * @param s
	 * @return
	 */
	public static int numDecodings2(String s) {
		int n = s.length();
		int a = 0, b = 1, c = 0;
		for (int i = 1; i <= n; i++) {
			c = 0;
			if (s.charAt(i - 1) != '0') {
				c += b;
			}
			if (i > 1 && s.charAt(i - 2) != '0' && (((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0')) <= 26)) {
				c += a;
			}
			a = b;
			b = c;
		}
		return c;
	}


	public static void main(String[] args) {
		System.out.println(numDecodings2("06"));
	}
}
