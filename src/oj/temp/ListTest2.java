package oj.temp;

public class ListTest2 {

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

	public static String longestCommonPrefix (String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		boolean flag = true;
		for(int i = 0; i < strs[0].length() && flag; i++){
			char ch = strs[0].charAt(i);
			for(int j = 1; j < strs.length; j++) {
				if(i == strs[j].length() || ch != strs[j].charAt(i)) {
					flag = false;
					break;
				}
			}
			if(flag) {
				sb.append(ch);
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String[] strs = new String[]{"abca","abc","abca","abc","abcc"};
		System.out.println(longestCommonPrefix(strs));
	}
}
