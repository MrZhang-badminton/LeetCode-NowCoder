package oj.lc.q500.lc76;

public class Solution {

	public static String minWindow(String s, String t) {
		int[] hash = new int[256];
		int[] set = new int[256];
		int len = t.length();
		for (int i = 0; i < len; i++) {
			char ch = t.charAt(i);
			hash[ch]++;
			set[ch]++;
		}
		int r = 0;
		int max = Integer.MAX_VALUE;
		String ans = "";
		for (int i = 0; i < s.length() - t.length() + 1; i++) {
			while (len > 0 && r < s.length()) {
				char ch = s.charAt(r);
				if (hash[ch] > 0) {
					set[ch]--;
					if (set[ch] >= 0) {
						len--;
					}
				}
				r++;
			}
			if (len == 0 && r - i < max) {
				ans = s.substring(i, r);
				max = r - i;
			}
			char ch = s.charAt(i);
			if (hash[ch] > 0) {
				set[ch]++;
				if (set[ch] > 0) {
					len++;
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(minWindow("abcb", "aab"));
	}
}
