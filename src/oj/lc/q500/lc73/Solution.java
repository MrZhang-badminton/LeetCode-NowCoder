package oj.lc.q500.lc73;

import java.util.*;

public class Solution {

	/**
	 * 空间复杂度为O(m*n)
	 *
	 * @param matrix
	 */
	public static void setZeroes(int[][] matrix) {

		int nr = matrix.length;
		int nc = matrix[0].length;
		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < nr; i++) {
			for (int j = 0; j < nc; j++) {
				if (matrix[i][j] == 0) {
					list.add(new int[]{i, j});
				}
			}
		}
		if (!list.isEmpty()) {
			for (int[] arr : list) {
				setZeroesFun(matrix, arr[0], arr[1]);
			}
		}
	}

	public static void setZeroesFun(int[][] matrix, int row, int col) {
		int nr = matrix.length;
		int nc = matrix[0].length;
		for (int i = 0; i < nc; i++) {
			matrix[row][i] = 0;
		}
		for (int i = 0; i < nr; i++) {
			matrix[i][col] = 0;
		}
	}

	/**
	 * 空间复杂度为O(m + n)
	 *
	 * @param matrix
	 */
	public static void setZeroes2(int[][] matrix) {
		int nr = matrix.length;
		int nc = matrix[0].length;
		Set<Integer> rowSet = new HashSet<>();
		Set<Integer> colSet = new HashSet<>();
		for (int i = 0; i < nr; i++) {
			for (int j = 0; j < nc; j++) {
				if (matrix[i][j] == 0) {
					rowSet.add(i);
					colSet.add(j);
				}
			}
		}

		Iterator<Integer> rowIterator = rowSet.iterator();
		while (rowIterator.hasNext()) {
			int tempRow = rowIterator.next();
			for (int i = 0; i < nc; i++) {
				matrix[tempRow][i] = 0;
			}
		}

		// 第二次遍历降低了速度
		Iterator<Integer> colIterator = colSet.iterator();
		while (colIterator.hasNext()) {
			int tempCol = colIterator.next();
			for (int i = 0; i < nr; i++) {
				matrix[i][tempCol] = 0;
			}
		}

	}

	/**
	 * 空间复杂度为O(1)
	 *
	 * @param matrix
	 */
	public static void setZeroes3(int[][] matrix) {
		int MODIFIED = -1000000;
		int R = matrix.length;
		int C = matrix[0].length;

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (matrix[r][c] == 0) {
					// We modify the corresponding rows and column elements in place.
					// Note, we only change the non zeroes to MODIFIED
					for (int k = 0; k < C; k++) {
						if (matrix[r][k] != 0) {
							matrix[r][k] = MODIFIED;
						}
					}
					for (int k = 0; k < R; k++) {
						if (matrix[k][c] != 0) {
							matrix[k][c] = MODIFIED;
						}
					}
				}
			}
		}

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				// Make a second pass and change all MODIFIED elements to 0 """
				if (matrix[r][c] == MODIFIED) {
					matrix[r][c] = 0;
				}
			}
		}
	}

	public static void setZeroes4(int[][] matrix) {
		Boolean isCol = false;
		int R = matrix.length;
		int C = matrix[0].length;

		for (int i = 0; i < R; i++) {

			if (matrix[i][0] == 0) {
				isCol = true;
			}

			for (int j = 1; j < C; j++) {
				// If an element is zero, we set the first element of the corresponding row and column to 0
				if (matrix[i][j] == 0) {
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}

		for (int i = 1; i < R; i++) {
			for (int j = 1; j < C; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}

		if (matrix[0][0] == 0) {
			for (int j = 0; j < C; j++) {
				matrix[0][j] = 0;
			}
		}

		if (isCol) {
			for (int i = 0; i < R; i++) {
				matrix[i][0] = 0;
			}
		}
	}

	public static void main(String[] args) {

		int[][] array = new int[][]{
				{0, 1, 2, 0},
				{3, 4, 5, 2},
				{1, 3, 1, 5}
		};
		setZeroes4(array);
		System.out.println();

	}
}
