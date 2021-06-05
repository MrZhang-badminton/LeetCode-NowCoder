package oj.lc.q500.lc221;

public class Solution {

	/**
	 * 动态规划
	 * 自己写的方法其实参照题解还是可以优化
	 * 在确定当前dp[i][j]的时候，其实和dp[i-1][j],dp[i][j-1]有关
	 * 具体做法见下方题解
	 *
	 * @param matrix
	 * @return
	 */
	public static int maximalSquare(char[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		int[][] dp = new int[row + 1][col + 1];
		int max = 0;


		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= col; j++) {
				if (matrix[i - 1][j - 1] == '1') {
					dp[i][j] = 1;
					if (i - 2 >= 0 && j - 2 >= 0 && matrix[i - 2][j - 2] == '1') {
						int n = dp[i - 1][j - 1];
						int k;
						for (int l = n; l >= 1; l--) {
							for (k = 1; k <= l; k++) {
								if (matrix[i - 1 - k][j - 1] == '0' || matrix[i - 1][j - k - 1] == '0') {
									break;
								}
							}
							if (k > l) {
								dp[i][j] = l + 1;
								break;
							}
						}

					}
				} else {
					dp[i][j] = 0;
				}
				max = Math.max(max, dp[i][j]);
			}
		}
		return max * max;
	}

	/**
	 * 题解做法
	 *
	 * @param matrix
	 * @return
	 */
	public int maximalSquare2(char[][] matrix) {
		int maxSide = 0;
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return maxSide;
		}
		int rows = matrix.length, columns = matrix[0].length;
		int[][] dp = new int[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (matrix[i][j] == '1') {
					if (i == 0 || j == 0) {
						dp[i][j] = 1;
					} else {
						dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
					}
					maxSide = Math.max(maxSide, dp[i][j]);
				}
			}
		}
		int maxSquare = maxSide * maxSide;
		return maxSquare;
	}

	public static void main(String[] args) {

		char[][] matrix = new char[][]{
				{'0', '0', '0', '1'},
				{'1', '1', '0', '1'},
				{'1', '1', '1', '1'},
				{'0', '1', '1', '1'},
				{'0', '1', '1', '1'}};

		System.out.println(maximalSquare(matrix));
	}
}
