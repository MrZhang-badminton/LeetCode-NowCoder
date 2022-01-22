package oj.lc.q2000.lc1332;

/**
 * @Description:
 * @Author: zhanghua
 * @Date: 2022/1/22 4:10 下午
 */
public class Solution {

	/**
	 * 相同字母的序列一定是回文序列
	 * 也就是说一个只有a、b组成的字符串至多2次能删除完
	 * 只要看看当前序列是不是回文字符串，如果是则1次，否则2次
	 *
	 * @param s
	 * @return
	 */
	public static int removePalindromeSub(String s){
		int n = s.length();
		for (int i = 0; i < n / 2; i++) {
			if(s.charAt(i) != s.charAt(n-i-1)){
				return 2;
			}
		}
		return 1;
	}

	public static void main(String[] args) {
		System.out.println(removePalindromeSub("abbbaa"));
	}


}
