package oj.lc.q500.lc93;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 剪枝优化后的回溯
 *
 * @date 2021年06月07日16:42:16
 */
public class Solution2 {
	private static List<String> ansList;

	public static List<String> restoreIpAddresses(String s) {
		ansList = new ArrayList<>();
		backTrace(s, new LinkedList<>());
		return ansList;
	}

	public static void backTrace(String str, LinkedList<String> list) {
		int n = str.length();
		int len = list.size();
		int min = 4 - len;
		int max = (4 - len) * 3;
		if (len > 4 || n < min && n > max) {
			return;
		}


		if (len == 4 && "".equals(str)) {
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

	public static void main(String[] args) {
		String s = "";
		System.out.println(restoreIpAddresses("25525511135"));
	}
}
