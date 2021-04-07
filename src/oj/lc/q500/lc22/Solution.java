package oj.lc.q500.lc22;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Peter
 * <p>
 * 解题思路
 * 就是任何时刻，右括号不能比左括号多，左括号不能超过n
 * 当左右括号的数量都为n的时候就可以将结果添加到结果集合中
 */
public class Solution {

	/**
	 * 法一（复杂写法）：dfs
	 * 在某一时刻左括号的数量永远比右括号大或等于
	 */
	private static List<String> ansList;

	public static List<String> generateParenthesis(int n) {
		ansList = new ArrayList<>();
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
	 * 法一（简便写法）:dfs
	 *
	 * @param n
	 * @return
	 */
	private static List<String> retList;

	public static List<String> generateParenthesis2(int n) {
		retList = new ArrayList<>();
		dfs("", n, 0, 0);
		return retList;
	}

	public static void dfs(String s, int n, int lc, int rc) {
		if (rc > lc || lc > n) {
			return;
		}
		if (lc == n && rc == n) {
			retList.add(s);
		}
		dfs(s + "(", n, lc + 1, rc);
		dfs(s + ")", n, lc, rc + 1);

	}


	/**
	 * 法二：回溯法
	 * <p>
	 * 回溯法最核心的就是遍历 + 还原
	 *
	 * @param n
	 * @return
	 */
	public static List<String> generateParenthesis3(int n) {
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
