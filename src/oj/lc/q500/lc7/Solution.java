package oj.lc.q500.lc7;

public class Solution {

	public static void main(String[] args) {
		System.out.println(reverse2(1999999999));
	}

	/**
	 * 来自官方题解
	 *
	 * @param x
	 * @return
	 */
	public static int reverse(int x) {
		int rev = 0;
		while (x != 0) {
			int pop = x % 10;
			x /= 10;
			if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
			if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
			rev = rev * 10 + pop;
		}
		return rev;
	}

	/**
	 * 字符串翻转法，先将int数据存储到String类型
	 * 然后将String类型转化为Long类型，然后与Integer.MAX_VALUE和
	 * Integer.MIN_VALUE比较，符合要求输出int，否则输出0
	 * <p>
	 * emmmmm 速度好像比官方题解的慢
	 *
	 * @param x
	 * @return
	 */
	public static int reverse2(int x) {
		String s = String.valueOf(x);
		if (s.charAt(0) == '-') {
			s = '-' + new StringBuilder(s.substring(1, s.length())).reverse().toString();
		} else {
			s = new StringBuilder(s).reverse().toString();
		}

		Long l = Long.valueOf(s);
		if (l < Integer.MIN_VALUE || l > Integer.MAX_VALUE) {
			return 0;
		}
		return Integer.valueOf(s);

	}
}
