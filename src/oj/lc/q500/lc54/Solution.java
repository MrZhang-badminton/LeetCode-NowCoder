package oj.lc.q500.lc54;

import java.util.ArrayList;
import java.util.List;

class Solution {

	public static int[][] generateMatrix(int n) {
		int[][] ans = new int[n][n];
		int num = 1;
		int left = 0, right = n - 1, top = 0, bottom = n - 1;
		while (left <= right && top <= bottom) {
			for (int col = left; col <= right; col++) {
				ans[top][col] = num++;
			}

			for (int row = top + 1; row <= bottom; row++) {
				ans[row][right] = num++;
			}
			if (left < right && top < bottom) {
				for (int col = right - 1; col > left; col--) {
					ans[bottom][col] = num++;
				}
				for (int row = bottom; row > top; row--) {
					ans[row][left] = num++;
				}
			}
			left++;
			right--;
			top++;
			bottom--;
		}
		return ans;
	}


	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList<>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return list;
		}
		int rows = matrix.length, columns = matrix[0].length;
		int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
		while (left <= right && top <= bottom) {
			for (int col = left; col <= right; col++) {
				list.add(matrix[top][col]);
			}
			for (int row = top + 1; row <= bottom; row++) {
				list.add(matrix[row][right]);
			}
			if (left < right && top < bottom) {
				for (int col = right - 1; col > left; col--) {
					list.add(matrix[bottom][col]);
				}
				for (int row = bottom; row > top; row--) {
					list.add(matrix[row][left]);
				}
			}
			left++;
			right--;
			top++;
			bottom--;
		}
		return list;
	}


	public static void main(String[] args) {

		System.out.println(generateMatrix(3));


		int[][] mar = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
		System.out.println(spiralOrder(mar));
	}
}