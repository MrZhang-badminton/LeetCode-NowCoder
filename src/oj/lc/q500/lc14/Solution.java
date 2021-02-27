package oj.lc.q500.lc14;

/**
 * @date 2021年02月25日20:56:39
 */
public class Solution {
	public static String longestCommonPrefix(String[] strs) {
		int n = strs.length;
		if (n == 0) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		boolean flag = true;
		for (int i = 0; i < strs[0].length(); i++) {
			char ch = strs[0].charAt(i);
			for (int j = 1; j < n; j++) {
				if (strs[j].length() < i + 1) {
					flag = false;
				} else if (strs[j].charAt(i) != ch) {
					flag = false;
				}
			}
			if (flag) {
				sb.append(ch);
			} else {
				break;
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String[] strings = new String[]{"ab", "a"};
		System.out.println(longestCommonPrefix(strings));
	}
}
