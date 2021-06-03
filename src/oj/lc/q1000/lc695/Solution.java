package oj.lc.q1000.lc695;

public class Solution {
	private static int max;
	private static int tNum;

	public static int maxAreaOfIsland(int[][] matrix) {
		max = 0;
		int row = matrix.length, col = matrix[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == 1) {
					tNum = 0;
					dfs(matrix, i, j);
					max = Math.max(max, tNum);
				}
			}
		}
		return max;
	}

	public static void dfs(int[][] matrix, int r, int c) {
		tNum++;
		matrix[r][c] = 0;
		int row = matrix.length, col = matrix[0].length;

		if (r + 1 < row && matrix[r + 1][c] == 1) {
			dfs(matrix, r + 1, c);
		}

		if (c + 1 < col && matrix[r][c + 1] == 1) {
			dfs(matrix, r, c + 1);
		}

		if (r - 1 >= 0 && matrix[r - 1][c] == 1) {
			dfs(matrix, r - 1, c);
		}

		if (c - 1 >= 0 && matrix[r][c - 1] == 1) {
			dfs(matrix, r, c - 1);
		}
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][]{
				{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
				{0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
				{0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};

		System.out.println(maxAreaOfIsland(matrix));
	}
}
