package oj.lc.q500.lc74;

/**
 * @date 2021年03月13日15:30:15
 */
public class Solution {

	public static int getValue(int[][] matrix, int index) {
		int row = index / matrix[0].length;
		int col = index % matrix[0].length;
		return matrix[row][col];
	}

	/**
	 * 二分法
	 * 题设所给二维数组，本质还是一位数组，利用二分法求解
	 * 注意封装一下取值方法
	 *
	 * @param matrix
	 * @param target
	 * @return
	 */
	public static boolean searchMatrix(int[][] matrix, int target) {
		int nr = matrix.length;
		int nc = matrix[0].length;
		int len = nr * nc;
		int l = 0, r = len - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (getValue(matrix, mid) == target) {
				return true;
			} else if (getValue(matrix, mid) < target) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return false;

	}

	public static void main(String[] args) {
		System.out.println(searchMatrix(new int[][]{
				{1, 3, 5, 7},
				{10, 11, 16, 20},
				{23, 30, 34, 60}
		}, 3));
	}
}
