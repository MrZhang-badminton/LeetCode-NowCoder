package oj.lc.q500.lc200;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	public static void dfs(char[][] grid, int r, int c) {
		int nr = grid.length;
		int nc = grid[0].length;

		if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
			return;
		}

		grid[r][c] = '0';
		dfs(grid, r - 1, c);
		dfs(grid, r + 1, c);
		dfs(grid, r, c - 1);
		dfs(grid, r, c + 1);
	}

	public static int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int nr = grid.length;
		int nc = grid[0].length;
		int islandsSums = 0;
		for (int i = 0; i < nr; i++) {
			for (int j = 0; j < nc; j++) {
				if (grid[i][j] == '1') {
					islandsSums++;
					dfs(grid, i, j);
				}
			}
		}

		int sum = Integer.valueOf("123") + Integer.valueOf("123");
		return islandsSums;

	}

	public static int numIslands2(char[][] grid) {
		if (grid == null) {
			return 0;
		}
		int nr = grid.length;
		int nc = grid[0].length;
		int islandSum = 0;

		for (int r = 0; r < nr; r++) {
			for (int c = 0; c < nc; c++) {
				if (grid[r][c] == '1') {
					islandSum++;
					grid[r][c] = '0';
					Queue<Integer> queue = new LinkedList<>();
					queue.add(r * nc + c);
					while (!queue.isEmpty()) {
						int id = queue.remove();
						int row = id / nc;
						int col = id % nc;
						if (row - 1 >= 0 && grid[row - 1][col] == '1') {
							queue.add((row - 1) * nc + col);
							grid[row - 1][col] = '0';
						}
						if (row + 1 < nr && grid[row + 1][col] == '1') {
							queue.add((row + 1) * nc + col);
							grid[row + 1][col] = '0';
						}
						if (col - 1 >= 0 && grid[row][col - 1] == '1') {
							queue.add(row * nc + col - 1);
							grid[row][col - 1] = '0';
						}
						if (col + 1 < nc && grid[row][col + 1] == '1') {
							queue.add(row * nc + col + 1);
							grid[row][col + 1] = '0';
						}
					}
				}
			}
		}
		return islandSum;
	}

	public static void main(String[] args) {
		System.out.println(numIslands(new char[][]{
				{'1', '1', '1', '1', '0'},
				{'1', '1', '0', '1', '0'},
				{'1', '1', '0', '0', '0'},
				{'0', '0', '0', '0', '0'}
		}));
	}
}
