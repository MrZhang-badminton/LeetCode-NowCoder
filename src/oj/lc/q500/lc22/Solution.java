package oj.lc.q500.lc22;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	/**
	 * 法一：递归
	 * 在某一时刻左括号的数量永远比右括号大或等于
	 */
	private static List<String> ansList = new ArrayList<>();

	public static List<String> generateParenthesis(int n) {
		if (n <= 0) {
			return ansList;
		}
		generate("", n, n);
		return ansList;
	}

	public static void generate(String s, int left, int right) {
		if (left == 0 && right == 0) {
			ansList.add(s);
			return;
		}
		if (left == right) {
			generate(s + "(", left - 1, right);
		} else if (left < right) {
			if (left > 0) {
				generate(s + "(", left - 1, right);
			}
			generate(s + ")", left, right - 1);
		}
	}

	/**
	 * 法二：回溯法
	 *
	 * 回溯法最核心的就是遍历 + 还原
	 *
	 * @param n
	 * @return
	 */
	public static List<String> generateParenthesis2(int n) {
		List<String> ansList = new ArrayList<>();
		fuc(ansList, new StringBuilder(), 0, 0, n);
		return ansList;
	}

	public static void fuc(List<String> list, StringBuilder cur,
						   int open, int close, int max) {

		if (cur.length() == max * 2) {
			list.add(cur.toString());
			return;
		}
		if (open < max) {
			cur.append("(");
			fuc(list, cur, open + 1, close, max);
			//还原
			cur.deleteCharAt(cur.length() - 1);
		}
		if (close < open) {
			cur.append(")");
			fuc(list, cur, open, close + 1, max);
			//还原
			cur.deleteCharAt(cur.length() - 1);
		}
	}

	public static void main(String[] args) {
		System.out.println(generateParenthesis2(3));
	}
}
