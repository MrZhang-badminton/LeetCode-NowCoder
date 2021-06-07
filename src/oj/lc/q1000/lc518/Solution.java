package oj.lc.q1000.lc518;

public class Solution {

	private static int count;

	/**
	 * 回溯算法
	 * 时间复杂度太高，超时！
	 *
	 * @param amount
	 * @param coins
	 * @return
	 */
	public static int change(int amount, int[] coins) {
		count = 0;
		backTrace(coins, amount, coins.length - 1);
		return count;
	}


	public static void backTrace(int[] coins, int amount, int index) {

		if (amount == 0) {
			count++;
			return;
		}
		if (index < 0 || amount < coins[index]) {
			return;
		}

		int sum = 0;
		while (sum <= amount) {
			backTrace(coins, amount - sum, index - 1);
			sum += coins[index];
		}

	}

	/**
	 * 来自第三方题解
	 *
	 * @param amount
	 * @param coins
	 * @return
	 */
	public static int change2(int amount, int[] coins) {
		int n = coins.length;

		int[][] dp = new int[n + 1][amount + 1];
		for (int i = 0; i <= n; i++) {
			dp[i][0] = 1;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= amount; j++) {
				if (j - coins[i - 1] >= 0) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[n][amount];
	}

	/**
	 * 官方题解
	 * <p>
	 * 本质上来说与上面这种方法一样，但是对空间进行了优化
	 * 因为每次使用dp[i-1][j] 或者 dp[i][j - coin[i]]
	 * 只要用到上一行同一列的数值，所以只要在符合要求时候只要
	 * dp[i][j] += dp[i][j-coin[i]]
	 * 即可
	 *
	 * @param amount
	 * @param coins
	 * @return
	 */
	public int change3(int amount, int[] coins) {
		int[] dp = new int[amount + 1];
		dp[0] = 1;

		for (int coin : coins) {
			for (int x = coin; x < amount + 1; ++x) {
				dp[x] += dp[x - coin];
			}
		}
		return dp[amount];

	}

	public static void main(String[] args) {
		System.out.println(change2(5, new int[]{1, 2, 5}));
	}
}
