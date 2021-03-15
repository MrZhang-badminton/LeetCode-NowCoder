package oj.lc.q500.lc48;

/**
 * 旋转矩阵
 *
 * @date 2021年03月15日14:39:46
 */
public class Solution {


	public static void rotate(int[][] matrix) {
		int n = matrix.length;

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n / 2; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][n - 1 - j];
				matrix[i][n - 1 - j] = temp;
			}
		}

	}

	public static void main(String[] args) {
		int[][] matrix = new int[][]{
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		rotate(matrix);
		System.out.println();
	}
}
