package oj.lc.q500.lc139;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

	public static boolean wordBreak(String s, List<String> wordDict) {
		int n = s.length();
		Set<String> hash = new HashSet<>(wordDict);
		boolean[] dp = new boolean[n+1];
		dp[0] = true;

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				if(dp[j] && hash.contains(s.substring(j,i))){
					dp[i] = true;
					break;
				}
			}
		}
		return dp[n];
	}

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("leet");
		list.add("code");
		System.out.println(wordBreak("leetcode", list));

	}
}
