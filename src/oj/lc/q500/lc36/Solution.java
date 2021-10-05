package oj.lc.q500.lc36;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * @Author: zhanghua
 * @Date: 2021/9/17 1:19 上午
 */
public class Solution {


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
