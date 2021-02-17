package oj.temp;

public class Test {

	/**
	 * 大数相加字符串版本
	 * @param s
	 * @param t
	 * @return
	 */
	public static String solve(String s, String t) {
		s = new StringBuilder(s).reverse().toString();
		t = new StringBuilder(t).reverse().toString();
		int i = 0, j = 0, plus = 0;

		StringBuilder sb = new StringBuilder();
		while (i < s.length() || j < t.length() || plus != 0) {
			char ch1, ch2;
			int num1, num2, res;

			if (i < s.length()) {
				ch1 = s.charAt(i);
			} else {
				ch1 = '0';
			}

			if (j < t.length()) {
				ch2 = t.charAt(j);
			} else {
				ch2 = '0';
			}

			num1 = ch1 - '0';
			num2 = ch2 - '0';
			res = num1 + num2 + plus;
			plus = 0;

			if(res >= 10) {
				plus = 1;
				res = res - 10;
			}

			sb.append(res);
			i++;j++;
		}

		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		String s1 = "1";
		String s2 = "99";
		System.out.println(solve(s1, s2));
	}
}
