package oj.lc.q500.lc438;

import java.util.*;

/**
 * @Description:
 * @Author: zhanghua
 * @Date: 2021/11/28 4:24 下午
 */
class Solution {

	/**
	 * 暴力法
	 * 将模式串p，按照abc顺序排序后编程s2
	 * 从第一个位置循环取出p.length()长度的子串
	 * 转化为数组排序后再转回String
	 * 最后做比较
	 * <p>
	 * m为s长度，n为p长度
	 * 时间复杂度O(mnlogn)
	 * 空间复杂度O(n)
	 *
	 * @param s
	 * @param p
	 * @return
	 */
	public static List<Integer> findAnagrams(String s, String p) {
		List<Integer> ansList = new ArrayList<>();
		int len1 = s.length(), len2 = p.length();
		char[] chars1 = p.toCharArray();
		Arrays.sort(chars1);
		String s2 = String.valueOf(chars1);
		for (int i = 0; i < len1 - len2 + 1; i++) {
			String str = s.substring(i, i + len2);
			char[] chars = str.toCharArray();
			Arrays.sort(chars);
			String s1 = String.valueOf(chars);

			if (s1.equals(s2)) {
				ansList.add(i);
			}
		}
		return ansList;
	}


	/**
	 * 来自官方题解，该思路和我一开始想的一致，不过这么写感觉还是挺简洁的
	 *
	 * @param s
	 * @param p
	 * @return
	 */
	public static List<Integer> findAnagrams2(String s, String p) {
		int sLen = s.length(), pLen = p.length();
		if (sLen < pLen) {
			return new ArrayList<>();
		}
		List<Integer> ansList = new ArrayList<>();
		// 字母ascii码最大为122，其实这边可以无脑200
		int[] sHash = new int[123];
		int[] pHash = new int[123];
		for (int i = 0; i < pLen; i++) {
			++sHash[s.charAt(i)];
			++pHash[p.charAt(i)];
		}
		if (Arrays.equals(sHash, pHash)) {
			ansList.add(0);
		}
		for (int i = 0; i < sLen - pLen; i++) {
			--sHash[s.charAt(i)];
			++sHash[s.charAt(i + pLen)];
			if (Arrays.equals(sHash, pHash)) {
				ansList.add(i + 1);
			}
		}
		return ansList;
	}

	public static void main(String[] args) {
		System.out.println(findAnagrams2("cbaebabacd", "abc"));
	}
}