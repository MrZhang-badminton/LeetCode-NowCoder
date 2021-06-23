package oj.lc.q500.lc472;

import java.util.*;

public class Solution {

	public static List<String> findAllConcatenatedWordsInADict(String[] words) {

		List<String> ansList = new ArrayList<>();
		if (words == null || words.length < 3) {
			return ansList;
		}
		Set<String> hashSet = new HashSet<>();
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (String s : words) {
			hashSet.add(s);
			queue.offer(s.length());
		}
		int minLen = queue.poll() + queue.poll();
		for (String s : words) {
			if (s.length() < minLen) {
				continue;
			}
			if (backTrace(s, 0, hashSet, 0)) {
				ansList.add(s);
			}
		}
		return ansList;
	}

	public static boolean backTrace(String str, int index, Set<String> hashSet,
									int count) {
		int len = str.length();
		if (count >= 2 && index == len) {
			return true;
		}
		for (int i = index + 1; i <= len; i++) {
			String s = str.substring(index, i);
			if (!s.equals(str) && hashSet.contains(s)) {
				count++;
				if (backTrace(str, i, hashSet, count)) {
					return true;
				}
				count--;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		String[] words = new String[]{
				"a", "b", "ab", "abc"
		};

		System.out.println(findAllConcatenatedWordsInADict(words));
	}
}
