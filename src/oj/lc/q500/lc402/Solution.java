package oj.lc.q500.lc402;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {

	public static String removeKdigits(String num, int k) {
		Deque<Integer> stack = new LinkedList<>();
		for (int i = 0; i < num.length(); i++) {
			int n = num.charAt(i) - '0';
			if (!stack.isEmpty() && n < stack.peek() && k > 0) {
				while (!stack.isEmpty() && n < stack.peek() && k > 0) {
					stack.pop();
					k--;
				}
			}
			stack.push(n);
		}
		while (k > 0) {
			stack.pop();
			k--;
		}

		StringBuilder sb = new StringBuilder();
		for (Integer i : stack) {
			sb.append(i);
		}
		String ans = sb.reverse().toString();
		int i = 0;
		for (; i < ans.length() && ans.charAt(i) == '0'; i++) ;
		ans = ans.substring(i);
		return ans.equals("") ? "0" : ans;
	}

	public static void main(String[] args) {
		System.out.println(removeKdigits("10", 2));
	}
}
