package oj.lc.q500.lc5;

public class Solution {

	/**
	 * 动态规划（该方法来自题解）
	 * 注意这个地方不能从第一行开始依次遍历！！（一开始犯的错误）
	 * 遍历长度依次为1、2、3……
	 *
	 * @param s
	 * @return
	 */
	public static String longestPalindrome(String s) {
		int n = s.length();
		boolean[][] dp = new boolean[n][n];
		String ans = "";

		for (int l = 0; l < n; l++) {
			for (int i = 0; i + l < n; i++) {
				int j = i + l;
				if (l == 0) {
					dp[i][j] = true;
				} else if (l == 1) {
					dp[i][j] = (s.charAt(i) == s.charAt(j));
				} else {
					dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
				}
				if (dp[i][j] && l + 1 > ans.length()) {
					ans = s.substring(i, i + l + 1);
				}
			}
		}
		return ans;
	}


	/**
	 * 中心扩散法
	 *
	 * @param s
	 * @return
	 */
	public static String longestPalindrome2(String s) {
		int n = s.length();
		int start = 0, end = 0;
		for (int i = 0; i < n; i++) {
			int len1 = getPalindromeLength(s, i, i);
			int len2 = getPalindromeLength(s, i, i + 1);
			int len = Math.max(len1, len2);
			if (len > end - start) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		return s.substring(start, end + 1);
	}

	public static int getPalindromeLength(String s, int left, int right) {
		int n = s.length();
		while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return right - left - 1;
	}

	public static void main(String[] args) {
		System.out.println(longestPalindrome2("babad"));
	}
}
