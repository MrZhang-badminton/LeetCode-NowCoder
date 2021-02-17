package oj.lc.q500.lc122;

class Solution {
	public static int maxProfit2_1(int[] prices) {
		int n = prices.length;
		int sum = 0;
		for (int i = 1; i < n; i++) {
			if (prices[i] > prices[i - 1]) {
				sum += prices[i] - prices[i - 1];
			}
		}
		return sum;
	}

	public static int maxProfit2_2(int[] prices) {
		int n = prices.length;
		int[][] dp = new int[n][n];

		dp[0][0] = 0;
		dp[0][1] = -prices[0];

		for (int i = 1; i < n; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
			dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
		}
		return dp[n - 1][0];
	}

	public static int maxProfit2_3(int[] prices) {
		int n = prices.length;
		int dp0, dp1;
		dp0 = 0;
		dp1 = -prices[0];

		for (int i = 1; i < n; i++) {
			int newDp0, newDp1;
			newDp0 = Math.max(dp0, dp1 + prices[i]);
			newDp1 = Math.max(dp1, dp0 - prices[i]);
			dp0 = newDp0;
			dp1 = newDp1;
		}
		return dp0;
	}

	public static int maxProfit3_1(int[] prices) {
		int n = prices.length;
		int buy1, sell1, buy2, sell2;
		buy1 = -prices[0];
		sell1 = 0;
		buy2 = -prices[0];
		sell2 = 0;

		for (int i = 1; i < n; i++) {
			buy1 = Math.max(buy1, -prices[i]);
			sell1 = Math.max(sell1, buy1 + prices[i]);
			buy2 = Math.max(buy2, sell1 - prices[i]);
			sell2 = Math.max(sell2, buy2 + prices[i]);
		}
		return sell2;

	}

	public static int maxProfit4(int k, int[] prices) {
		if(prices.length == 0 || k == 0){
			return 0;
		}
		int n = prices.length;
		int[] buy = new int[k];
		int[] sell = new int[k];
		for (int i = 0; i < k; i++) {
			buy[i] = -prices[0];
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < k; j++) {
				if (j == 0) {
					buy[j] = Math.max(buy[j], -prices[i]);

				} else {
					buy[j] = Math.max(buy[j], sell[j-1] - prices[i]);
				}
				sell[j] = Math.max(sell[j], buy[j] + prices[i]);
			}
		}
		return sell[k-1];
	}

	public static void main(String[] args) {
		System.out.println(maxProfit4(2, new int[]{2,4,1}));
	}
}

