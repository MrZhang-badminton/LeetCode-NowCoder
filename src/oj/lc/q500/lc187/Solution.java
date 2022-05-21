package oj.lc.q500.lc187;

import java.util.*;

/**
 * @Description:
 * @Author: zhanghua
 * @Date: 2022/5/21 5:58 下午
 */
public class Solution {


	static final int L = 10;

	/**
	 * 来自官方题解
	 * subString + hash
	 *
	 * @param s
	 * @return
	 */
	public static List<String> findRepeatedDnaSequences(String s) {
		List<String> ansList = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		int len = s.length();

		for (int i = 0; i <= len - L; i++) {
			String subStr = s.substring(i, i + L);
			map.put(subStr, map.getOrDefault(subStr, 0) + 1);
			if (map.get(subStr) == 2) {
				ansList.add(subStr);
			}
		}
		return ansList;
	}


	public static void main(String[] args) {
		System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
	}

}
