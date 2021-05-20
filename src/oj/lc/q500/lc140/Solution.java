package oj.lc.q500.lc140;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

	private static List<String> ansList = new LinkedList<>();

	public static List<String> wordBreak(String s, List<String> wordDict) {
		int maxLen = 0;
		for (String str : wordDict) {
			maxLen = Math.max(str.length(), maxLen);
		}
		backTrace(s, wordDict, maxLen, "");
		return ansList;
	}

	public static void backTrace(String s, List<String> wordDict, int maxLen, String preStr) {
		for (int i = 0; i < s.length() && i < maxLen; i++) {
			String str = s.substring(0, i + 1);
			if(wordDict.contains(str)){
				if(i == s.length()-1){
					ansList.add(preStr + str);
				}else {
					backTrace(s.substring(i+1,s.length()),wordDict,maxLen, preStr + str + " ");
				}
			}
		}
	}

	public static void main(String[] args) {
		String[] dict = new String[]{
				"cat", "cats", "and", "sand", "dog"
		};
		System.out.println(wordBreak("catsanddog", Arrays.asList(dict)));

//		System.out.println("123".substring(3,4));
	}
}
