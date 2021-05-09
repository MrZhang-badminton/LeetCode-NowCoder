package oj.lc.q500.lc28;


public class Solution {


	public static void main(String[] args) {
		System.out.println(strStr2("abkkkbbcbabc", "bc"));
	}


	/**
	 * 暴力算法
	 *
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public static int strStr(String haystack, String needle) {
		if ((haystack.length() == 0 && needle.length() == 0)
				|| needle.length() == 0) {
			return 0;
		}
		int n = needle.length();
		for (int i = 0; i < haystack.length() - n + 1; i++) {
			if (haystack.substring(i, i + n).equals(needle)) {
				return i;
			}
		}
		return -1;
	}


	/**
	 * 经典KMP算法，先计算next数组
	 *
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public static int strStr2(String haystack, String needle) {
		//处理题目中特殊测试用例
		if ((haystack.length() == 0 && needle.length() == 0)
				|| needle.length() == 0) {
			return 0;
		}
		int n1 = haystack.length(), n2 = needle.length();
		int[] next = new int[n2];

		next[0] = -1;
		int i = 0, j = -1;
		while (i < n2 - 1) {
			if (j == -1 || needle.charAt(i) == needle.charAt(j)) {
				++i;
				++j;
				next[i] = j;
			} else {
				j = next[j];
			}
		}

		i = 0;
		j = 0;
		while (i < n1 && j < n2) {
			if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
				i++;
				j++;
			} else {
				j = next[j];
			}
		}
		if (j >= n2) {
			return i - j;
		}
		return -1;
	}

	/**
	 * labuladuo KMP简化算法
	 *
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public static int strStr3(String haystack, String needle) {
		if ((haystack.length() == 0 && needle.length() == 0) || needle.length() == 0) {
			return 0;
		}

		int pLen = needle.length(), tLen = haystack.length();
		int[][] dp = new int[pLen][256];
		dp[0][needle.charAt(0)] = 1;
		int x = 0;

		for (int i = 1; i < pLen; i++) {
			for (int j = 0; j < 256; j++) {
				dp[i][j] = dp[x][j];
			}
			dp[i][needle.charAt(i)] = i + 1;
			x = dp[x][needle.charAt(i)];
		}

		int j = 0;
		for (int i = 0; i < tLen; i++) {
			j = dp[j][haystack.charAt(i)];
			if (j == pLen) {
				return i - pLen + 1;
			}
		}
		return -1;
	}


}
