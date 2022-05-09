package oj.lc.q500.lc63;

/**
 * @Description:
 * @Author: zhanghua
 * @Date: 2021/10/6 3:38 下午
 */
public class Solution {
	/**
	 * 动态规划
	 * 时间复杂度O(mn),空间复杂度(mn)
	 * <p>
	 * 看了下题解，这边空间还可以进行优化，因为只会用到左边和上边的元素
	 * 可以只用复杂度为O(n)（n指的是列数）
	 *
	 * @param obstacleGrid
	 * @return
	 */
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length, n = obstacleGrid[0].length;
		int[][] matrix = new int[m + 1][n + 1];
		if (obstacleGrid[0][0] == 0) {
			matrix[1][1] = 1;
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == 1 && j == 1) {
					continue;
				}
				if (obstacleGrid[i - 1][j - 1] == 1) {
					matrix[i][j] = 0;
					continue;
				}
				matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
			}
		}
		return matrix[m][n];
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][]{
				{0, 0, 0},
				{0, 1, 0},
				{0, 0, 0}
		};
		System.out.println(uniquePathsWithObstacles(matrix));
	}
}
