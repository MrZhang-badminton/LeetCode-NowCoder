package oj.lc.q500.lc32;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
	/**
	 * 动态规划
	 * <p>
	 * dp[i]表示s.charAt(i)为结尾的最长有效括号长度
	 *
	 * @param s
	 * @return
	 */
	public static int longestValidParentheses(String s) {
		int n = s.length();
		int max = 0;
		int[] dp = new int[n];
		for (int i = 1; i < n; i++) {
			if (s.charAt(i) == ')') {
				if (s.charAt(i - 1) == '(') {
					dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
				} else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
					dp[i] = dp[i - 1] + 2 + ((i - dp[i - 1] - 1) > 0 ? dp[i - dp[i - 1] - 2] : 0);
				}
				max = Math.max(max, dp[i]);
			}
		}
		return max;
	}

	/**
	 * 栈
	 *
	 * @param s
	 * @return
	 */
	public static int longestValidParentheses2(String s) {
		int n = s.length();
		Deque<Integer> stack = new LinkedList<>();
		stack.push(-1);
		int max = 0;
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {
				stack.pop();
				if (stack.isEmpty()) {
					stack.push(i);
				} else {
					max = Math.max(max, i - stack.peek());
				}
			}
		}
		return max;
	}

	/**
	 * 从左向右扫描，从右向左扫描
	 * 空间复杂度优化到O(1)
	 *
	 * @param s
	 * @return
	 */
	public static int longestValidParentheses3(String s) {
		int n = s.length();
		int left = 0, right = 0, max = 0;
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == '(') {
				left++;
			} else {
				right++;
			}
			if (left == right) {
				max = Math.max(max, right * 2);
			} else if (right > left) {
				left = 0;
				right = 0;
			}
		}
		left = 0;
		right = 0;
		for (int i = n-1; i >=0 ; i--) {
			if(s.charAt(i) == ')'){
				right++;
			}else {
				left++;
			}
			if(left == right){
				max = Math.max(max,left*2);
			}else if(left > right){
				left = 0;
				right = 0;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(longestValidParentheses3(")()())"));
	}
}
