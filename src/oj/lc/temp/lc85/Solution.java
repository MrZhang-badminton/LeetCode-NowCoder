package oj.lc.temp.lc85;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {

	/**
	 * 遍历每个元素，已每个元素为右下角，转化为LC84中，求柱状图中矩形最大面经
	 * 时间复杂度O(m*m*n)
	 *
	 * @param matrix
	 * @return
	 */
	public static int maximalRectangle(char[][] matrix) {
		int nr = matrix.length;
		if (nr == 0) {
			return 0;
		}
		int nc = matrix[0].length;
		int[][] left = new int[nr][nc];

		//计算每行，以j结尾，之前连续的1的数量
		for (int i = 0; i < nr; i++) {
			int count = 1;
			for (int j = 0; j < nc; j++) {
				if (matrix[i][j] == '1') {
					left[i][j] = count++;
				} else {
					count = 1;
				}
			}
		}

		int ret = 0;
		for (int i = 0; i < nr; i++) {
			for (int j = 0; j < nc; j++) {
				if (matrix[i][j] == '0') {
					continue;
				}
				int width = left[i][j];
				int area = width;
				for (int k = i - 1; k >= 0 && matrix[k][j] != 0; k--) {
					width = Math.min(width, left[k][j]);
					area = Math.max(area, width * (i - k + 1));
				}
				ret = Math.max(area, ret);
			}
		}
		return ret;
	}

	/**
	 * 单调栈
	 * 时间复杂度O(m*m)
	 *
	 * @param matrix
	 * @return
	 */
	public static int maximalRectangle2(char[][] matrix) {
		int nr = matrix.length;
		if (nr == 0) {
			return 0;
		}
		int nc = matrix[0].length;
		int[][] left = new int[nr][nc];

		//计算每行，以j结尾，之前连续的1的数量
		for (int i = 0; i < nr; i++) {
			int count = 1;
			for (int j = 0; j < nc; j++) {
				if (matrix[i][j] == '1') {
					left[i][j] = count++;
				} else {
					count = 1;
				}
			}
		}
		int ret = 0;
		for (int j = 0; j < nc; j++) {
			int[] up = new int[nr];
			int[] down = new int[nr];
			Arrays.fill(down, nr);

			Deque<Integer> deque = new LinkedList<>();
			for (int i = 0; i < nr; i++) {
				while (!deque.isEmpty() && left[deque.peek()][j] >= left[i][j]) {
					down[deque.peek()] = i;
					deque.pop();
				}
				up[i] = (deque.isEmpty()) ? -1 : deque.peek();
				deque.push(i);
			}

			int ans = 0;
			for (int i = 0; i < nr; i++) {
				ans = Math.max(ans, (down[i] - up[i] - 1) * left[i][j]);
			}
			ret = Math.max(ans, ret);
		}
		return ret;

	}


	public static void main(String[] args) {
		System.out.println(maximalRectangle2(new char[][]{
				{'1', '0', '1', '0', '0'},
				{'1', '0', '1', '1', '1'},
				{'1', '1', '1', '1', '1'},
				{'1', '0', '0', '1', '0'}

		}));
	}

//	public static void main(String[] args) {
//		System.out.println(maximalRectangle(new char[][]{
//				{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},
//				{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},
//				{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},
//				{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},
//				{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},
//
//				{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},
//				{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},
//				{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},
//				{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},
//				{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},
//
//				{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},
//				{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},
//				{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},
//				{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},
//				{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},
//
//				{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},
//				{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '1', '1', '1', '1'}
//
//		}));
//	}
}