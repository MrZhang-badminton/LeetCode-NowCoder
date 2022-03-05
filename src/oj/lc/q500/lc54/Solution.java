package oj.lc.q500.lc54;

import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

	/**
	 * 输出顺时针螺旋顺序
	 * @param matrix
	 * @return
	 */
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

	/**
	 * 变种
	 * 第一圈顺时针
	 * 第二圈逆时针
	 * 第三圈顺指针
	 * 以此类推
	 *
	 * @param matrix
	 * @return
	 */
	public static List<Integer> specialSpiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList<>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return list;
		}
		int rows = matrix.length, cols = matrix[0].length;
		int left = 0, top = 0, down = rows - 1, right = cols - 1;
		int count = 0;
		while (left <= right && top <= down) {
			List<Integer> tList = new ArrayList<>();
			for (int i = left; i < right; i++) {
				tList.add(matrix[top][i]);
			}
			for (int i = top; i < down; i++) {
				tList.add(matrix[i][right]);
			}
			for (int i = right; i > left; i--) {
				tList.add(matrix[down][i]);
			}
			for (int i = down; i > top; i--) {
				tList.add(matrix[i][left]);
			}
			if (count % 2 == 1) {
				int temp = tList.get(0);
				tList.remove(0);
				tList.add(temp);
				Collections.reverse(tList);
			}
			list.addAll(tList);
			left++;
			top++;
			right--;
			down--;
			count++;
		}
		return list;

	}


	/**
	 * 生成螺旋矩阵
	 * @param n
	 * @return
	 */
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

	public static void main(String[] args) {

		ArrayUtils.printArray(generateMatrix(3));
		int[][] mar = new int[][]{
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 16, 3, 1},
				{17, 10, 11, 12}};
		System.out.println(spiralOrder(mar));
		System.out.println(specialSpiralOrder(mar));

	}
}