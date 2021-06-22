package oj.lc.q500.lc329;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {

	private static int[][] dirs = new int[][]{
			{-1, 0}, {1, 0}, {0, -1}, {0, 1}
	};
	private static int rows, cols;

	public static int longestIncreasingPath(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		rows = matrix.length;
		cols = matrix[0].length;
		int[][] outdegrees = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				for (int[] dir : dirs) {
					int newRow = i + dir[0], newCol = j + dir[1];
					if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
							&& matrix[newRow][newCol] > matrix[i][j]) {
						outdegrees[i][j]++;
					}
				}
			}
		}
		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (outdegrees[i][j] == 0) {
					queue.offer(new int[]{i, j});
				}
			}
		}
		int ans = 0;
		while (!queue.isEmpty()) {
			++ans;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] cell = queue.poll();
				int row = cell[0], col = cell[1];
				for (int[] dir : dirs) {
					int newRow = row + dir[0], newCol = col + dir[1];
					if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
							&& matrix[newRow][newCol] < matrix[row][col]) {
						--outdegrees[newRow][newCol];
						if (outdegrees[newRow][newCol] == 0) {
							queue.offer(new int[]{newRow, newCol});
						}
					}
				}
			}
		}
		return ans;
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
