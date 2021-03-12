package oj.lc.q500.lc71;

import java.util.HashMap;
import java.util.Map;

/**
 * 最小覆盖子串
 * 还有优化版本的有时间记得完成
 * @date 2021年03月12日17:44:51
 */
public class Solution {

	/**
	 * 经典滑动窗口
	 * @param s
	 * @param t
	 * @return
	 */
	public static String minWindow(String s, String t) {
		if(s.length() < t.length()){
			return "";
		}
		int n = s.length();

		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < t.length(); i++) {
			map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
		}

		int right = 0, len = t.length();
		StringBuilder sb = new StringBuilder();
		String ans = "";
		int ansLen = Integer.MAX_VALUE;


		for (int i = 0; i < n; i++) {
			if (i != 0) {
				char ch = s.charAt(i-1);
				if(map.containsKey(ch)){
					map.put(ch,map.get(ch)+1);
					if(map.get(ch)>0){
						len++;
					}
				}
				sb.deleteCharAt(0);
			}
			while (right < n && len > 0) {
				char ch = s.charAt(right);
				sb.append(ch);
				if (map.containsKey(ch)) {
					map.put(ch, map.get(ch) - 1);
					if(map.get(ch) >= 0){
						len--;
					}
				}
				right++;
			}
			if(len == 0 && sb.length() < ansLen){
				ans = sb.toString();
				ansLen = sb.length();
			}
		}
		return ans;

	}

	public static void main(String[] args) {
		System.out.println(minWindow("aa", "aa"));
	}
}
