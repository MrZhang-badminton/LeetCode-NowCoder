package oj.lc.q500.lc71;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

	public static String simplifyPath(String path) {
		StringBuilder sb = new StringBuilder();
		Deque<String> queue = new LinkedList<>();
		path = path + "/";
		for (int i = 1; i < path.length(); i++) {
			char ch = path.charAt(i);
			if (ch != '/') {
				sb.append(ch);
				continue;
			}
			if (sb.toString().equals("..")) {
				if (!queue.isEmpty()) {
					queue.removeLast();
				}
			} else if (sb.toString().equals(".") || sb.toString().equals("")) {

			} else {
				queue.addLast(sb.toString());
			}
			sb = new StringBuilder();
		}
		sb = new StringBuilder();
		if (!queue.isEmpty()) {
			for (String s : queue) {
				sb.append("/" + s);
			}
		} else {
			sb.append("/");
		}
		return sb.toString();
	}

	public static String simplifyPath2(String path) {
		path = path + "/";
		String[] strings = path.split("/");
		Deque<String> deque = new LinkedList<>();
		for (String s : strings) {
			if (!s.equals(".") && !s.equals("..") && !s.equals("")) {
				deque.addLast(s);
			} else if (s.equals("..")) {
				if (!deque.isEmpty()) {
					deque.removeLast();
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		if (deque.isEmpty()) {
			sb.append("/");
		}else {
			for(String s : deque){
				sb.append("/" + s);
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(simplifyPath2("/a//b////c/d//././/.."));
	}
}
