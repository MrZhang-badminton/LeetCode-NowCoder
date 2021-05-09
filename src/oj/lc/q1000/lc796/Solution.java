package oj.lc.q1000.lc796;

public class Solution {

	/**
	 * 自己方法
	 *
	 * @param A
	 * @param B
	 * @return
	 */
	public static boolean rotateString(String A, String B) {
		if (A.length() == 0 && B.length() == 0) {
			return true;
		}
		StringBuilder sb = new StringBuilder(A);

		for (int i = 0; i < A.length(); i++) {
			if (sb.toString().equals(B)) {
				return true;
			}
			char ch = sb.charAt(0);
			sb.deleteCharAt(0);
			sb.append(ch);
		}
		return false;
	}

	/**
	 * 比上边方法写法更简约
	 *
	 * @param A
	 * @param B
	 * @return
	 */
	public static boolean rotateString2(String A, String B) {
		int l1 = A.length(), l2 = B.length();
		if (l1 != l2) {
			return false;
		}
		if (A.equals(B)) {
			return true;
		}
		for (int i = 1; i < l1; i++) {
			if (B.startsWith(A.substring(i)) && B.endsWith(A.substring(0, i))) {
				return true;
			}
		}

		return false;
	}

	/**
	 * 判断子串
	 *
	 * @param A
	 * @param B
	 * @return
	 */
	public static boolean rotateString3(String A, String B) {
		return A.length() == B.length() && (A + A).contains(B);
	}

	public static boolean rotateString4(String A,String B){
		if(A.length() != B.length()) return false;
		if(A.length() == 0) return true;
		int n = A.length(); int[] next = new int[n];

		//求next数组
		next[0] = -1;
		int i = 0,j = -1;
		while(i < n - 1) {
			if(j == -1 || B.charAt(i) == B.charAt(j)) {
				++i;++j;
				next[i] = j;
			}
			else {
				j = next[j];
			}
		}

		i = 0;j = 0; A = A + A;
		while(i < 2 * n && j < n) {
			if(j == -1 || A.charAt(i) == B.charAt(j)) {
				++i;
				++j;
			}
			else {
				j = next[j];
			}
		}

		if(j >= n) return true;

		return false;
	}

	public static void main(String[] args) {
		System.out.println(rotateString4("abcde", "cdeab"));
		System.out.println(rotateString("", ""));
	}
}
