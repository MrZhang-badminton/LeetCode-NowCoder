package oj.lc.q500.lc150;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

	public static int calculate(int a, int b, char operator) {
		switch (operator) {
			case '+':
				return a + b;
			case '-':
				return a - b;
			case '*':
				return a * b;
			case '/':
				return a / b;
		}
		return -1;
	}

	public static int evalRPN(String[] tokens) {
		Deque<Integer> stack = new LinkedList<>();

		for (int i = 0; i < tokens.length; i++) {
			char ch = tokens[i].charAt(0);
			if (ch <= '9' && ch >= '0' || (ch == '-' && tokens[i].length() > 1)) {
				stack.push(Integer.valueOf(tokens[i]));
			} else {
				int b = stack.pop();
				int a = stack.pop();
				stack.push(calculate(a, b, ch));
			}
		}
		return stack.pop();
	}

	public static void main(String[] args) {
		System.out.println(evalRPN(new String[]{"4", "3", "-"}));
	}
}