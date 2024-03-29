package oj.lc.q2000.lc1143;

/**
 * @Description:
 * @Author: zhanghua
 * @Date: 2022/11/20 02:07
 */
public class Solution {


	/**
	 * （补充）最长公共子序列, 返回最长子序列字符串版本
	 *
	 * @param s1
	 * @param s2
	 * @return
	 */
	public int longestCommonSubsequence(String s1, String s2) {
		char[] str1 = s1.toCharArray(), str2 = s2.toCharArray();
		int[][] dp = new int[str1.length + 1][str2.length + 1];

		for (int i = 1; i <= str1.length; i++) {
			for (int j = 1; j <= str2.length; j++) {
				if (str1[i - 1] == str2[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[str1.length][str2.length];
	}


	/**
	 * （补充）最长公共子序列, 返回最长子序列字符串版本
	 *
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static String LCS(String s1, String s2) {
		char[] str1 = s1.toCharArray(), str2 = s2.toCharArray();
		int[][] dp = new int[str1.length + 1][str2.length + 1];
		//0表示右下方，1表示下方，2表示右方
		int[][] flag = new int[str1.length + 1][str2.length + 1];

		for (int i = 1; i <= str1.length; i++) {
			for (int j = 1; j <= str2.length; j++) {
				if (str1[i - 1] == str2[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					flag[i][j] = 0;
				} else if (dp[i - 1][j] > dp[i][j - 1]) {
					dp[i][j] = dp[i - 1][j];
					flag[i][j] = 1;
				} else {
					dp[i][j] = dp[i][j - 1];
					flag[i][j] = -1;
				}
			}
		}

		if (dp[str1.length][str2.length] == 0) {
			return "-1";
		}

		StringBuilder sb = new StringBuilder();


		int i = str1.length, j = str2.length;
		int k = dp[i][j];
		while (k > 0) {
			if (flag[i][j] == 0) {
				sb.append(str1[j - 1]);
				i--;
				j--;
			} else if (flag[i][j] == 1) {
				sb.append(str2[i - 1]);
				i--;
			} else {
				sb.append(str1[j - 1]);
				j--;
			}
			k--;
		}

		return sb.reverse().toString();


	}

	public static void main(String[] args) {
//		String s1 = "1A2C3D4B56";
//		String s2 = "B1D23CA45B6A";

		String s1 = "abcaa";
		String s2 = "ccabc";

		System.out.println(LCS(s1, s2));
	}
}
