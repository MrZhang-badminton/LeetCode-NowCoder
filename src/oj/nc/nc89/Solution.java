package oj.nc.nc89;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 本题牛客给的测试用例比较奇怪
 * 题目也比较奇怪，对于Java语言给出字符串，长度自然就有了，不知道为什么还要再给一个字符串长度
 */
public class Solution {

	public static String trans(String s, int n) {
		String[] strings = s.split(" ");
		List<String> list = Arrays.asList(strings);
		Collections.reverse(list);
		StringBuilder sb = new StringBuilder();
		for (String str : list) {
			sb.append(" ");
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if (ch >= 65 && ch <= 90) {
					sb.append((char) (ch + 32));
				} else if (ch >= 97 && ch <= 122) {
					sb.append((char) (ch - 32));
				}
			}

		}
		String res = sb.toString().substring(1);
		if (s.charAt(s.length() - 1) == ' ') {
			res = " " + res;
		}
		return res;

	}

	public static void main(String[] args) {
		System.out.println(trans("This is a sample", 16));
	}
}
