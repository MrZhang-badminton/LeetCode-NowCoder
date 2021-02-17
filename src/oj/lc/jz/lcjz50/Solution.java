package oj.lc.jz.lcjz50;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public static char firstUniqChar(String s) {
		if (s == null || s.length() == 0) {
			return ' ';
		}
		Map<Character, Integer> map = new HashMap<>();
		char ch = ' ';
//		boolean flag = false;
		for (int i = 0; i < s.length(); i++) {
			ch = s.charAt(i);
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		int i;
		for (i = 0; i < s.length(); i++) {
			ch = s.charAt(i);
			if (map.get(ch) == 1) {
				break;
//				flag = true;
			}
		}
		return i < s.length() ? ch : ' ';
	}

	public static void main(String[] args) {
		System.out.println(firstUniqChar("leetcode"));
	}
}
