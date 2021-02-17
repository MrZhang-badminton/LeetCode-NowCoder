package oj.lc.q500.lc64;

public class Solution {

	public static int minPathSum(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		int[][] dp = new int[row + 1][col + 1];
		for (int i = 0; i < row + 1; i++) {
			for (int j = 0; j < col + 1; j++) {
				dp[i][j] = Integer.MAX_VALUE;
			}
		}
		dp[1][1] = grid[0][0];
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= col; j++) {
				if (i == 1 && j == 1) {
					continue;
				}
				dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i - 1][j - 1];

			}
		}
		return dp[row][col];
	}

	/**
	 * 空间优化版本、因为都是每个数字都用一次，可以直接在原来数组上改
	 * @param grid
	 * @return
	 */
	public int minPathSum2(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		for (int i = 1; i < m; i++) {
			grid[i][0] += grid[i - 1][0];
		}
		for (int i = 1; i < n; i++) {
			grid[0][i] += grid[0][i - 1];
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
			}
		}
		return grid[m - 1][n - 1];
	}

	public static void main(String[] args) {
		System.out.println(minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
	}
}
