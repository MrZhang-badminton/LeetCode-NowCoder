package oj.lc.q2000.lc1002;

import java.util.*;

/**
 * @Description:
 * @Author: zhanghua
 * @Date: 2022/3/12 12:10 下午
 */
public class Solution {

	/**
	 * 计数
	 * 但是这个方法写的太复杂了
	 *
	 * @param words
	 * @return
	 */
	public static List<String> commonChars(String[] words) {
		Map<Character, Integer> templateMap = initTemplateMap(words[0]);
		Arrays.stream(words).forEach(word -> {
			Map<Character, Integer> map = new HashMap<>(templateMap);
			for (int i = 0; i < word.length(); i++) {
				char ch = word.charAt(i);
				Integer count = map.get(ch);
				if (Objects.nonNull(count)) {
					if (--count == 0) {
						map.remove(ch);
					} else {
						map.put(ch, count);
					}
				}
			}
			if (map.size() != 0) {
				map.entrySet().forEach(entry -> {
					char ch = entry.getKey();
					int count = entry.getValue();
					int originCount = templateMap.get(ch);
					if (templateMap.get(ch) == count) {
						templateMap.remove(ch);
					} else {
						templateMap.put(ch, originCount - count);
					}
				});
			}
		});
		List<String> ansList = new ArrayList<>();
		templateMap.entrySet().forEach(item -> {
			char key = item.getKey();
			int count = item.getValue();
			for (int i = 0; i < count; i++) {
				ansList.add(key + "");
			}
		});
		return ansList;
	}

	private static Map<Character, Integer> initTemplateMap(String word) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		return map;
	}


	/**
	 * 官方题解给的解法思路相同，但是写的比较简单
	 *
	 * @param words
	 * @return
	 */
	public static List<String> commonChars2(String[] words) {
		int[] minfreq = new int[26];
		Arrays.fill(minfreq, Integer.MAX_VALUE);
		for (String word : words) {
			int[] freq = new int[26];
			int length = word.length();
			for (int i = 0; i < length; ++i) {
				char ch = word.charAt(i);
				++freq[ch - 'a'];
			}
			for (int i = 0; i < 26; ++i) {
				minfreq[i] = Math.min(minfreq[i], freq[i]);
			}
		}

		List<String> ans = new ArrayList<String>();
		for (int i = 0; i < 26; ++i) {
			for (int j = 0; j < minfreq[i]; ++j) {
				ans.add(String.valueOf((char) (i + 'a')));
			}
		}
		return ans;
	}


	public static void main(String[] args) {
		System.out.println(commonChars(new String[]{"cool", "lock", "cook"}));
	}
}
