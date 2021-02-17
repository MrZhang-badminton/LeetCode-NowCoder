package oj.lc.q500.lc279;

public class Solution {

	public static int numSquares(int n) {
		int temp = (int) Math.sqrt(n * 1.0);
		int[] dp = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			dp[i] = n + 1;//设置为最大值
			for (int j = 1; j <= temp; j++) {
				int pow = (int) Math.pow(j, 2);
				if (pow <= i) {
					dp[i] = Math.min(dp[i], dp[i - pow] + 1);
				}
			}
		}
		return dp[n];
	}

	public static boolean isSquare(int n) {
		int temp = (int) Math.sqrt(1.0 * n);
		return n == temp * temp;
	}

	public static int numSquares_math(int n) {
		while (n % 4 == 0) {
			n /= 4;
		}
		if (n % 8 == 7) {
			return 4;
		}
		if (isSquare(n)) {
			return 1;
		}
		for (int i = 1; i * i < n; i++) {
			if (isSquare(n - i * i)) {
				return 2;
			}

		}
		return 3;
	}

	public static void main(String[] args) {
		System.out.println(numSquares_math(68));
	}
}
