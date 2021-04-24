package oj.lc.q500.lc240;

/**
 * 方法
 * 1. 空间缩减（最优方法），时间复杂度O(m + n)。
 * <p>
 * 2. 二分法，时间复杂度O(nlogn)。从左上角向右下角遍历，对于每个对角元素，
 * 分别使用二分法，在行和列上查找，如果查找到返回true。如果到最后一个元素
 * 还有查找到的话，就返回false。
 *
 * @date 2021年04月24日10:21:48
 */
public class Solution {

	public static void main(String[] args) {

		int[][] matrix = new int[][]{
				{1, 4, 7, 11, 15},
				{2, 5, 8, 12, 19},
				{3, 6, 9, 16, 22},
				{10, 13, 14, 17, 24},
				{18, 21, 23, 26, 30}
		};
		System.out.println(searchMatrix(matrix, 100));
	}

	/**
	 * 空间缩减
	 * <p>
	 * 左下角和右上角的元素具备特性，是使用该方法的前提
	 *
	 * @param matrix
	 * @param target
	 * @return
	 */
	public static boolean searchMatrix(int[][] matrix, int target) {
		int nc = matrix[0].length;
		return find(matrix, 0, nc - 1, target);
	}

	public static boolean find(int[][] matrix, int r, int c, int target) {
		if (r >= matrix.length || c < 0) {
			return false;
		}
		if (matrix[r][c] == target) {
			return true;
		} else if (target < matrix[r][c]) {
			return find(matrix, r, c - 1, target);
		} else {
			return find(matrix, r + 1, c, target);
		}
	}


}
