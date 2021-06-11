package oj.lc.q500.lc329;

public class Solution {

	private static int[][] dirs = new int[][]{
			{-1, 0}, {1, 0}, {0, 1}, {0, -1}
	};
	private static int row, col;

	public static int longestIncreasingPath(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		row = matrix.length;
		col = matrix[0].length;
		int[][] memo = new int[row][col];
		int ans = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				ans = Math.max(ans, dfs(matrix, i, j, memo));
			}
		}
		return ans;
	}

	public static int dfs(int[][] matrix, int i, int j, int[][] memo) {
		if (memo[i][j] != 0) {
			return memo[i][j];
		}
		++memo[i][j];
		for (int[] dir : dirs) {
			int newRow = i + dir[0], newCol = j + dir[1];
			if (newRow >= 0 && newRow < row && newCol >= 0 && newCol < col
					&& matrix[newRow][newCol] > matrix[i][j]) {
				matrix[i][j] = Math.max(matrix[i][j], dfs(matrix, newRow, newCol, memo) + 1);
			}
		}
		return memo[i][j];
	}


	public static void main(String[] args) {
		int[][] matrix = new int[][]{
				{9, 9, 4},
				{6, 6, 8},
				{2, 1, 1}
		};
		System.out.println(longestIncreasingPath(matrix));
	}
}
