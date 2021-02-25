package oj.lc.q500.lc316;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {
	public static String removeDuplicateLetters(String s) {
		int n = s.length();
		if (s == null || n == 0) {
			return "";
		}
		Boolean[] inDeque = new Boolean[200];
		int[] lastIndex = new int[200];

		Arrays.fill(inDeque, false);
		for (int i = 0; i < n; i++) {
			lastIndex[s.charAt(i)] = i;
		}

		Deque<Character> deque = new LinkedList<>();

		deque.add(s.charAt(0));
		inDeque[s.charAt(0)] = true;


		for (int i = 1; i < n; i++) {
			char ch = s.charAt(i);
			if (inDeque[ch] == true) {
				continue;
			}
			while (!deque.isEmpty() && deque.getLast() > ch) {
				if (lastIndex[deque.getLast()] > i) {
					inDeque[deque.getLast()] = false;
					deque.removeLast();
				} else {
					break;
				}
			}
			deque.addLast(ch);
			inDeque[ch] = true;
		}
		StringBuilder sb = new StringBuilder();
		for (char ch : deque) {
			sb.append(ch);
		}
		return sb.toString();

	}

	public static void main(String[] args) {
		System.out.println(removeDuplicateLetters("cbacdcbc"));
	}
}
