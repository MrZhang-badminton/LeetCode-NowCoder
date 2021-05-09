package oj.others;

public class StringsExercise {

	public static void main(String[] args) {
		String s1 = "abcbbca", s2 = "bbc";
		System.out.println(kmp(s2, s1));
	}


	/**
	 * KMP字符串匹配算法，简化版本
	 *
	 * @param pat
	 * @param txt
	 * @return
	 */
	public static int kmp(String txt, String pat) {
		int pLen = pat.length(), tLen = txt.length();
		int[][] dp = new int[pLen][256];
		dp[0][pat.charAt(0)] = 1;
		int x = 0;

		for (int i = 1; i < pLen; i++) {
			for (int j = 0; j < 256; j++) {
				dp[i][j] = dp[x][j];
			}
			dp[i][pat.charAt(i)] = i + 1;
			x = dp[x][pat.charAt(i)];
		}

		int j = 0;
		for (int i = 0; i < tLen; i++) {
			j = dp[j][txt.charAt(i)];
			if (j == pLen) {
				return i - pLen + 1;
			}
		}
		return -1;
	}

	/**
	 * 是否是回文数
	 *
	 * @param s
	 * @return
	 */
	public static boolean isPalindrome(String s) {
		char[] arr = s.toCharArray();
		boolean flag = true;

		for (int i = 0; i < (arr.length / 2); i++) {
			if (arr[i] != arr[arr.length - 1 - i]) {
				flag = false;
			}
		}
		return flag;
	}

	public static int getLongestPalindrome(String A, int n) {
		int max = 1;
		for (int i = 0; i < A.length() - 1; i++) {
			for (int j = i + 1; j < A.length(); j++) {
				if (isPalindrome(A.substring(i, j + 1))) {
					max = (j + 1 - i) > max ? (j + 1 - i) : max;
				}
			}
		}
		return max;
	}

	/**
	 * String数组最长前缀
	 *
	 * @param strs
	 * @return
	 */
	public static String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		boolean flag = true;
		for (int i = 0; i < strs[0].length() && flag; i++) {
			char ch = strs[0].charAt(i);
			for (int j = 1; j < strs.length; j++) {
				if (i == strs[j].length() || ch != strs[j].charAt(i)) {
					flag = false;
					break;
				}
			}
			if (flag) {
				sb.append(ch);
			}
		}
		return sb.toString();
	}


	/**
	 * 大数相加字符串版本
	 *
	 * @param s
	 * @param t
	 * @return
	 */
	public static String solve(String s, String t) {
		s = new StringBuilder(s).reverse().toString();
		t = new StringBuilder(t).reverse().toString();
		int i = 0, j = 0, plus = 0;

		StringBuilder sb = new StringBuilder();
		while (i < s.length() || j < t.length() || plus != 0) {
			char ch1, ch2;
			int num1, num2, res;

			if (i < s.length()) {
				ch1 = s.charAt(i);
			} else {
				ch1 = '0';
			}

			if (j < t.length()) {
				ch2 = t.charAt(j);
			} else {
				ch2 = '0';
			}

			num1 = ch1 - '0';
			num2 = ch2 - '0';
			res = num1 + num2 + plus;
			plus = 0;

			if (res >= 10) {
				plus = 1;
				res = res - 10;
			}

			sb.append(res);
			i++;
			j++;
		}

		return sb.reverse().toString();
	}

}
