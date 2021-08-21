package oj.lc.q500.lc30;

import java.util.*;

/**
 * @Classname: Solution
 * @Author: zhanghua
 * @Date: 2021/8/17 1:05 上午
 */
public class Solution {

	private List<Integer> ansList;

	/**
	 * 回溯法（超时）
	 *
	 * @param s
	 * @param words
	 * @return
	 */
	public List<Integer> findSubstring(String s, String[] words) {
		ansList = new ArrayList<>();
		List<String> list = new LinkedList<>();
		for (String str : words) {
			list.add(str);
		}
		for (int i = 0; i < s.length(); i++) {
			handle(i, i, s, list);
		}
		Set<Integer> set = new HashSet<>(ansList);
		ansList = new ArrayList<>(set);
		return ansList;
	}

	public void handle(int start, int curIndex, String s, List<String> list) {
		if (list.size() == 0) {
			ansList.add(start);
			return;
		}
		for (int i = 0; i < list.size(); i++) {
			String word = list.get(i);
			int len = word.length();
			int nextIndex;
			if ((nextIndex = curIndex + word.length()) <= s.length()) {
				if (s.substring(curIndex, curIndex + len).equals(word)) {
					list.remove(i);
					handle(start, nextIndex, s, list);
					list.add(i, word);
				}
			}
		}
	}

	/**
	 * 滑动窗口（参照题解）
	 * 时间复杂度约为O(n)
	 *
	 * @param s
	 * @param words
	 * @return
	 */
	public static List<Integer> findSubstring3(String s, String[] words) {
		List<Integer> ansList = new ArrayList<>();
		if (s == null || s.length() == 0 || words == null || words.length == 0) {
			return ansList;
		}
		Map<String, Integer> map = new HashMap<>();
		int len = words[0].length();
		for (String w : words) {
			map.put(w, map.getOrDefault(w, 0) + 1);
		}
		for (int i = 0; i < len; i++) {
			int left = i, right = i, count = 0;
			Map<String, Integer> tMap = new HashMap<>();
			while (right + len <= s.length()) {
				String word = s.substring(right, right + len);
				right += len;
				if (map.containsKey(word)) {
					tMap.put(word, tMap.getOrDefault(word, 0) + 1);
					count++;
					while (tMap.getOrDefault(word, 0) > map.getOrDefault(word, 0)) {
						String tWord = s.substring(left, left + len);
						count--;
						tMap.put(tWord, tMap.getOrDefault(tWord, 0) - 1);
						left += len;
					}
					if (count == words.length) {
						ansList.add(left);
					}
				} else {
					count = 0;
					left = right;
					tMap.clear();
				}

			}
		}
		return ansList;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.findSubstring3("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "good"}));
	}
}
