package oj.lc.q500.lc20;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @date 2021年02月24日11:02:12
 */
public class Solution {
	/**
	 * 注意学习本体用到的Map映射，代替最原始的switch
	 *
	 * @param s
	 * @return
	 */
	public static boolean isValid(String s) {
		int n = s.length();
		if (n == 0 || n % 2 == 1) {
			return false;
		}
		Map<Character, Character> pairs = new HashMap<Character, Character>() {{
			put(')', '(');
			put(']', '[');
			put('}', '{');
		}};

		Deque<Character> stack = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			char ch = s.charAt(i);
			if (pairs.containsKey(ch)) {
				if (stack.isEmpty() || !stack.peek().equals(pairs.get(ch))) {
					return false;
				}
				stack.pop();
			} else {
				stack.push(ch);
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println(isValid("()[]{}"));
	}
}