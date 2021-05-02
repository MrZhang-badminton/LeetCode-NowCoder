package oj.lc.q1000.lc796;

public class Solution {

	public static boolean rotateString(String A, String B) {
		if(A.length() == 0 && B.length() == 0){
			return true;
		}
		StringBuilder sb = new StringBuilder(A);

		for (int i = 0; i < A.length(); i++) {
			if(sb.toString().equals(B)){
				return true;
			}
			char ch = sb.charAt(0);
			sb.deleteCharAt(0);
			sb.append(ch);
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(rotateString("abcde", "cdeab"));
		System.out.println(rotateString("", ""));
	}
}
