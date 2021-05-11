package oj.lc.q500.lc69;

public class Solution {
	public static void main(String[] args) {
		System.out.println(mySqrt2(5));
	}

	/**
	 * 暴力算法，效率比较低
	 *
	 * @param x
	 * @return
	 */
	public static int mySqrt(int x) {
		long k = x;
		long i = 0;
		for (i = 1; i * i <= k; i++) ;
		return (int) (i - 1);
	}


	/**
	 * 二分查找
	 *
	 * @param x
	 * @return
	 */
	public static int mySqrt2(int x) {
		// 右边r可以取值到中间位置
		int l = 0, r = x / 2 + 1, ans = -1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if ((long) mid * mid <= x) {
				ans = mid;
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return ans;
	}

	/**
	 * 数学方法
	 * 来自题解
	 *
	 * @param x
	 * @return
	 */
	public static int mySqrt3(int x) {
		if (x == 0) {
			return 0;
		}
		int ans = (int) Math.exp(0.5 * Math.log(x));
		return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
	}


	/**
	 * 牛顿迭代法
	 * 来自题解
	 *
	 * @param x
	 * @return
	 */
	public int mySqrt4(int x) {
		if (x == 0) {
			return 0;
		}

		double C = x, x0 = x;
		while (true) {
			double xi = 0.5 * (x0 + C / x0);
			if (Math.abs(x0 - xi) < 1e-7) {
				break;
			}
			x0 = xi;
		}
		return (int) x0;
	}
}
