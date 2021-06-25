package oj.lc.q500.lc17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	private static List<String> ansList;

	private static Map<Character, String> map = new HashMap<Character, String>() {{
		put('2', "abc");
		put('3', "def");
		put('4', "ghi");
		put('5', "jkl");
		put('6', "mno");
		put('7', "pqrs");
		put('8', "tuv");
		put('9', "wxyz");
	}};

	public static List<String> letterCombinations(String digits) {
		ansList = new ArrayList<>();
		if (digits.length() == 0) {
			return ansList;
		}
		backTrace(digits, 0, new StringBuilder());
		return ansList;
	}

	public static void backTrace(String digits, int index, StringBuilder sb) {
		if (index == digits.length()) {
			ansList.add(sb.toString());
		} else {
			char digit = digits.charAt(index);
			String letters = map.get(digit);
			int n = letters.length();
			for (int i = 0; i < n; i++) {
				sb.append(letters.charAt(i));
				backTrace(digits, index + 1, sb);
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(letterCombinations("23"));
	}
}
