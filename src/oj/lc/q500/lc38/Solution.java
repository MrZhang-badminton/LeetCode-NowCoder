package oj.lc.q500.lc38;

import java.util.LinkedList;
import java.util.List;

public class Solution {


	public static String countAndSay(int n) {
		return handle("1", n - 1);
	}

	public static String handle(String s, int n) {
		if (n == 0) {
			return s;
		}
		int length = s.length();
		List<int[]> list = new LinkedList<>();
		int count = 0;
		char ch = s.charAt(length - 1);
		for (int i = length - 1; i >= 0; i--) {
			if (s.charAt(i) != ch) {
				list.add(new int[]{ch, count});
				ch = s.charAt(i);
				count = 0;
			}
			count++;
		}
		list.add(new int[]{ch, count});

		StringBuilder sb = new StringBuilder();
		for (int[] info : list) {
			sb.append((String.valueOf((char) info[0]) + info[1]));
		}
		return handle(sb.reverse().toString(), n - 1);
	}


	public static void main(String[] args) {
		System.out.println(countAndSay(4));
//		char ch = '1';
//		int n = ch;
//		System.out.println((char) n);
	}
}
