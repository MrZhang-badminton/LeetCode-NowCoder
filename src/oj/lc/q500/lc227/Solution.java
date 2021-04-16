package oj.lc.q500.lc227;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

	public static int calculate(String s) {
		int n = s.length();
		Deque<Integer> stack = new LinkedList<>();
		char preOperator = '+';
		int num = 0;
		for (int i = 0; i < n; i++) {
			char ch = s.charAt(i);
			if (Character.isDigit(ch)) {
				num = num * 10 + ch - '0';
			}

			if (!Character.isDigit(ch) && ch != ' ' || i == n - 1) {
				switch (preOperator) {
					case '+':
						stack.push(num);
						break;
					case '-':
						stack.push(-num);
						break;
					case '*':
						stack.push(stack.pop() * num);
						break;
					case '/':
						stack.push(stack.pop() / num);
				}
				num = 0;
				preOperator = ch;
			}

		}
		int result = 0;
		for(Integer i : stack){
			result += i;
		}
		return result;

	}

	public static void main(String[] args) {
		System.out.println(calculate("3+ 2*   2"));
	}
}
