package oj.lc.q500.lc9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @Description:
 * @Author: zhanghua
 * @Date: 2022/10/29 01:28
 */
public class Solution {

	public static boolean isPalindrome(int x) {
		String s1 = String.valueOf(x);
		StringBuilder sb2 = new StringBuilder(s1);
		sb2.reverse();
		return sb2.toString().equals(s1);
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome(123201));
	}
}
