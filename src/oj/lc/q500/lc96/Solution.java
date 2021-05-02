package oj.lc.q500.lc96;

public class Solution {

	/**
	 * 暴力递归
	 * @param n
	 * @return
	 */
	public static int numTrees(int n) {
		if (n < 2) {
			return 1;
		} else if (n == 2) {
			return 2;
		}
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += numTrees(i - 1) * numTrees(n - i);
		}
		return sum;
	}


	/**
	 * 动态规划
	 * @param n
	 * @return
	 */
	public static int numTrees2(int n) {
		int[] dp = new int[n+1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i] += dp[j-1]*dp[i-j];
			}
		}
		return dp[n];
	}

	public static void main(String[] args) {
		System.out.println(numTrees2(3));
	}
}
