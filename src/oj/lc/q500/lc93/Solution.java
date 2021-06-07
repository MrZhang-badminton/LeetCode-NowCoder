package oj.lc.q500.lc93;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 回溯法
 * 优化版本在Solution2.java
 *
 * @date 2021年06月07日16:42:26
 */
public class Solution {
	private static List<String> ansList;

	public static List<String> restoreIpAddresses(String s) {
		ansList = new ArrayList<>();
		backTrace(s, new LinkedList<>());
		return ansList;
	}

	public static void backTrace(String str, LinkedList<String> list) {

		int n = str.length();
		if ((n == 0 && list.size() < 4) || (list.size() == 4 && n != 0)) {
			return;
		}

		if (list.size() == 4 && n == 0) {
			StringBuilder sb = new StringBuilder();
			sb.append(list.get(3) + ".");
			sb.append(list.get(2) + ".");
			sb.append(list.get(1) + ".");
			sb.append(list.get(0));
			ansList.add(sb.toString());
			return;
		}


		for (int i = 1; i <= 3; i++) {
			if (n - i < 0) {
				continue;
			}
			String s = str.substring(n - i, n);
			if (s.length() != 1 && s.charAt(0) == '0') {
				continue;
			}
			int num = Integer.valueOf(s);
			if (num >= 0 && num <= 255) {
				list.addLast(s);
				backTrace(str.substring(0, n - i), list);
				list.removeLast();
			}
		}
	}
}
