package basicalogrithm.others;


import java.util.Arrays;

/**
 * 一个矩阵，只能向右或者向下走，起始到终点要走多少步
 * map[][]数组可通行为0，有障碍为1
 *
 * @date 2021年04月29日01:30:54
 */
public class ShortesePath {

	/**
	 * 动态规划
	 *
	 * @param map
	 * @param p
	 * @param q
	 * @param m
	 * @param n
	 * @return 返回需要的步数，如果不可达返回-1
	 */
	public static int shortestPath(int[][] map, int p, int q, int m, int n) {
		int nr = map.length, nc = map[0].length;
		int[][] dp = new int[nr + 1][nc + 1];
		for (int i = 0; i <= nc; i++) {
			dp[p][i] = Integer.MAX_VALUE;
		}
		for (int i = 0; i <= nr; i++) {
			dp[i][q] = Integer.MAX_VALUE;
		}
		p++;
		q++;
		m++;
		n++;


		for (int i = p; i <= m; i++) {
			for (int j = q; j <= n; j++) {
				if (i == p && j == q) {
					continue;
				}
				if (map[i - 1][j - 1] == 1) {
					dp[i][j] = Integer.MAX_VALUE;
				} else {
					int left = dp[i][j - 1];
					int up = dp[i - 1][j];
					if (left == Integer.MAX_VALUE && up == Integer.MAX_VALUE) {
						dp[i][j] = Integer.MAX_VALUE;
					} else {
						dp[i][j] = Math.min(left, up) + 1;
					}
				}
			}
		}

		if (dp[m][n] == Integer.MAX_VALUE) {
			return -1;
		}

		return dp[m][n];
	}

	public static void main(String[] args) {
		int[][] map = new int[5][5];
		for (int i = 0; i < map.length; i++) {
			Arrays.fill(map[i], 0);
		}
		map[2][2] = 1;
		map[4][3] = 1;
		map[3][4] = 1;

		System.out.println(shortestPath(map, 1, 3, 4, 4));
	}
}
