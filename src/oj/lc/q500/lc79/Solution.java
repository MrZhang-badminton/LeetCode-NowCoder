package oj.lc.q500.lc79;

/**
 * @date 2021年03月02日14:32:52
 */
public class Solution {

	/**
	 * 深度优先遍历 + 回溯
	 * 尤其要注意回溯时候，恢复初始值
	 *
	 * @param board
	 * @param word
	 * @param flag
	 * @param i
	 * @param j
	 * @param index
	 * @return
	 */
	public static boolean check(char[][] board, String word, boolean[][] flag, int i, int j, int index) {
		if (index == word.length() - 1) {
			return true;
		}
		flag[i][j] = true;
		index++;
		if (i - 1 >= 0 && flag[i - 1][j] == false && board[i - 1][j] == word.charAt(index)
				&& check(board, word, flag, i - 1, j, index)) {
			return true;
		}
		if (i + 1 < board.length && flag[i + 1][j] == false && board[i + 1][j] == word.charAt(index)
				&& check(board, word, flag, i + 1, j, index)) {
			return true;
		}
		if (j - 1 >= 0 && flag[i][j - 1] == false && board[i][j - 1] == word.charAt(index) && check(board, word, flag, i, j - 1, index)) {
			return true;
		}
		if (j + 1 < board[0].length && flag[i][j + 1] == false && board[i][j + 1] == word.charAt(index) && check(board, word, flag, i, j + 1, index)) {
			return true;
		}
		flag[i][j] = false;
		return false;

	}

	public static boolean exist(char[][] board, String word) {
		int nr = board.length;
		int nc = board[0].length;
		boolean[][] flag;
		for (int i = 0; i < nr; i++) {
			for (int j = 0; j < nc; j++) {
				if (board[i][j] == word.charAt(0)) {
					flag = new boolean[nr][nc];
					if (check(board, word, flag, i, j, 0)) {
						return true;
					}
					;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(exist(new char[][]{
				{'A', 'B', 'C', 'E'},
				{'S', 'F', 'E', 'S'},
				{'A', 'D', 'E', 'E'}
		}, "ABCESEEEFS"));

	}
}
