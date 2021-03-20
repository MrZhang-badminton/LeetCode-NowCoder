package oj.nc.ncjz1;

public class Solution {

	/**
	 * 暴力解法
	 *
	 * @param target
	 * @param array
	 * @return
	 */
	public static boolean Find(int target, int[][] array) {
		int nr = array.length, nc = array[0].length;
		for (int i = 0; i < nr; i++) {
			for (int j = 0; j < nc; j++) {
				if (array[i][j] == target) {
					return true;
				}
			}
		}
		return false;
	}


	/**
	 * 时间复杂度O(n+m)
	 *
	 * @param target
	 * @param array
	 * @return
	 */
	public static boolean Find2(int target, int[][] array) {
		int nr = array.length, nc = array[0].length;
		int i = 0, j = nc - 1;
		while (i < nr && j >= 0) {
			if (array[i][j] == target) {
				return true;
			} else if (target < array[i][j]) {
				j--;
			} else {
				i++;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(Find2(7, new int[][]{
						{1, 2, 8, 9},
						{2, 4, 9, 12},
						{4, 7, 10, 13},
						{6, 8, 11, 15}
				})
		);
	}
}
