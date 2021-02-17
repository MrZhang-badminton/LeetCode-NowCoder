package oj.lc.q1000.lc50;

public class Solution {

	public static double pow(double x, long n) {
		double ans = 1.0;
		while (n > 0) {
			if (n % 2 == 1) {
				ans *= x;
			}
			x *= x;
			n /= 2;
		}
		return ans;
	}

	public static double myPow(double x, int n) {
		long num = n;
		return n >= 0 ? pow(x, n) : 1.0 / pow(x, -n);
	}


}
