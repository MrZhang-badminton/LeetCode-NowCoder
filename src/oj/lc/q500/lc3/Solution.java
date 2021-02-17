package oj.lc.q500.lc3;

import java.util.HashSet;
import java.util.Set;

class Solution {
	//	public static int lengthOfLongestSubstring(String s) {
//		Set<Character> hashSet = new HashSet<>();
//		int n = s.length();
//		int right = -1, ans = 0;
//		for(int i = 0; i < n; i++){
//			if(i != 0){
//				hashSet.remove(s.charAt(i-1));
//			}
//			while(right + 1 < n && !hashSet.contains(s.charAt(right + 1))){
//				hashSet.add(s.charAt(right + 1));
//				right++;
//			}
//			ans = Math.max(ans, right - i + 1);
//		}
//		return ans;
//	}
	public static int lengthOfLongestSubstring(String s) {
		int n = s.length();
		Set<Character> set = new HashSet<>();
		int right = 0, ans = 0;
		for (int i = 0; i < n; i++) {
			if (i != 0) {
				set.remove(s.charAt(i - 1));
			}
			while (right < n && !set.contains(s.charAt(right))) {
				set.add(s.charAt(right));
				right++;
			}
			ans = Math.max(ans, right - i);
		}
		return ans;
	}


	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
	}
}