package oj.lc.q500.lc36;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * @Author: zhanghua
 * @Date: 2021/9/17 1:19 上午
 */
public class Solution {


	/**
	 * 简单遍历（写法有点复杂）
	 * @param board
	 * @return
	 */
	public static boolean isValidSudoku(char[][] board) {
		if (!judgeRowOrCol(board)) {
			return false;
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				Set<Character> tSet = new HashSet<>();
				for (int k = 0; k < 3; k++) {
					for (int l = 0; l < 3; l++) {
						char num = board[i * 3 + k][j * 3 + l];
						if (tSet.contains(num)) {
							return false;
						} else if (num != '.') {
							tSet.add(num);
						}
					}
				}
			}
		}

		return true;
	}

	public static boolean judgeRowOrCol(char[][] board) {
		for (int i = 0; i < 9; i++) {
			Set<Character> rowSet = new HashSet<>();
			Set<Character> colSet = new HashSet<>();
			for (int j = 0; j < 9; j++) {
				char num1 = board[i][j];
				if (num1 == '0' || rowSet.contains(num1)) {
					return false;
				} else if (num1 != '.') {
					rowSet.add(num1);
				}
				char num2 = board[j][i];
				if (num2 == '0' || colSet.contains(num2)) {
					return false;
				} else if (num2 != '.') {
					colSet.add(num2);
				}
			}
		}
		return true;
	}

	/**
	 * 来自评论
	 * @param board
	 * @return
	 */
	public boolean isValidSudoku2(char[][] board) {
		// 记录某行，某位数字是否已经被摆放
		boolean[][] row = new boolean[9][9];
		// 记录某列，某位数字是否已经被摆放
		boolean[][] col = new boolean[9][9];
		// 记录某 3x3 宫格内，某位数字是否已经被摆放
		boolean[][] block = new boolean[9][9];

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					int num = board[i][j] - '1';
					int blockIndex = i / 3 * 3 + j / 3;
					if (row[i][num] || col[j][num] || block[blockIndex][num]) {
						return false;
					} else {
						row[i][num] = true;
						col[j][num] = true;
						block[blockIndex][num] = true;
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		char[][] board = new char[][]{
				{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
				, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
				, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
				, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
				, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
				, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
				, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
				, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
				, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}

		};

		System.out.println(isValidSudoku(board));

	}
}
