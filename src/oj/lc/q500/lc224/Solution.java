package oj.lc.q500.lc224;

import java.util.Deque;
import java.util.LinkedList;


public class Solution {

	public static int calculate(String s) {
		Deque<Integer> stack = new LinkedList<>();
		stack.push(1);
		int sign = 1;

		int ret = 0;
		int n = s.length();
		int i = 0;
		while (i < n) {
			if (s.charAt(i) == ' ') {
				i++;
			} else if (s.charAt(i) == '+') {
				sign = stack.peek();
				i++;
			} else if (s.charAt(i) == '-') {
				sign = -stack.peek();
				i++;
			} else if (s.charAt(i) == '(') {
				stack.push(sign);
				i++;
			} else if (s.charAt(i) == ')') {
				stack.pop();
				i++;
			} else {
				long num = 0;
				while (i < n && Character.isDigit(s.charAt(i))) {
					num = num * 10 + s.charAt(i) - '0';
					i++;
				}
				ret += sign * num;
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		System.out.println(calculate(" 2-(1 + 2) "));
	}
}
