package oj.lc.q1000.lc807;

public class Solution {
	public static int maxIncreaseKeepingSkyline(int[][] grid) {
		int n = grid.length;
		int[] rows = new int[n], cols = new int[n];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				rows[i] = Math.max(grid[i][j],rows[i]);
				cols[i] = Math.max(grid[j][i],cols[i]);
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int min = Math.min(rows[i],cols[j]);
				if(min > grid[i][j]){
					sum += min - grid[i][j];
				}
			}
		}

		return sum;
	}

	public static void main(String[] args) {
		System.out.println(maxIncreaseKeepingSkyline(new int[][]{
				{3, 0, 8, 4},
				{2, 4, 5, 7},
				{9, 2, 6, 3},
				{0, 3, 1, 0}
		}));
	}
}
