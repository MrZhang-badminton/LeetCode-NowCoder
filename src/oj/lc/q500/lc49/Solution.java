package oj.lc.q500.lc49;

import java.util.*;

/**
 * @Description:
 * @Author: zhanghua
 * @Date: 2022/9/21 09:15
 */
public class Solution {


	public static List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> result = new HashMap<>();
		for(String s : strs){
			char[] chars = s.toCharArray();
			Arrays.sort(chars);
			String key = new String(chars);
			List<String> itemList = result.getOrDefault(key, new ArrayList<>());
			itemList.add(s);
			result.put(key,itemList);
		}
		return new ArrayList<>(result.values());
	}

	public static void main(String[] args) {
		String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(groupAnagrams(strings));
	}
}
