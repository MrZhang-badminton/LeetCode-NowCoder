package oj.lc.q500.lc43;

/**
 * @Description:
 * @Author: zhanghua
 * @Date: 2021/11/13 5:48 下午
 */
public class Solution {

	/**
	 * 边乘边加
	 *
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static String multiply(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0")) {
			return "0";
		}
		String shortNum, longNum;
		int len1 = num1.length(), len2 = num2.length();
		longNum = len1 > len2 ? num1 : num2;
		shortNum = len1 > len2 ? num2 : num1;
		String result = null;
		String zero = "";
		for (int i = shortNum.length() - 1; i >= 0; i--) {
			int n = shortNum.charAt(i) - '0';
			if (i == shortNum.length() - 1) {
				result = subMultiply(longNum, n);
			} else {
				zero = zero + "0";
				result = plus(subMultiply(longNum, n) + zero, result);
			}
		}
		return result;
	}

	public static String subMultiply(String num1, int num) {
		int temp = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = num1.length() - 1; i >= 0; i--) {
			int count = num1.charAt(i) - '0';
			int sum = num * count + temp;
			temp = sum / 10;
			sb.append(sum % 10);
		}
		if (temp > 0) {
			return temp + sb.reverse().toString();
		}
		return sb.reverse().toString();
	}

	public static String plus(String num1, String num2) {
		int len1, len2;
		int length = Math.max(len1 = num1.length(), len2 = num2.length());
		StringBuilder sb = new StringBuilder();

		int temp = 0;
		for (int i = 0; i < length; i++) {
			int n1 = len1 - 1 - i >= 0 ? num1.charAt(len1 - 1 - i) - '0' : 0;
			int n2 = len2 - 1 - i >= 0 ? num2.charAt(len2 - 1 - i) - '0' : 0;
			int sum = n1 + n2 + temp;
			temp = sum / 10;
			sb.append(sum % 10);
		}
		if (temp > 0) {
			return "1" + sb.reverse();
		}
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		System.out.println(multiply("123", "456"));
	}

}
