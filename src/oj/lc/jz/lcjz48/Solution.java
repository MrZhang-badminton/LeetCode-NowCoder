package oj.lc.jz.lcjz48;

public class Solution {
	public static int lengthOfLongestSubstring(String s) {
		if(s.length() == 0){
			return 0;
		}
		int n = s.length();
		int[] hash = new int[256];
		int max = Integer.MIN_VALUE;
		int l = -1;
		for (int r = 0; r < n; r++) {
			char ch = s.charAt(r);
			while (hash[ch] > 0) {
				hash[s.charAt(l + 1)] = 0;
				l++;
			}
			hash[ch] = 1;
			max = Math.max(max, r - l);

		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("pwwkew"));
	}
}
