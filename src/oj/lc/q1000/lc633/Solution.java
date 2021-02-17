package oj.lc.q1000.lc633;

public class Solution {

	public static boolean judgeSquareSum(int c) {
		int n = ((int) Math.sqrt(c));
		int[] arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = i * i;
		}

		for (int i = 0; i < n + 1; i++) {
			if (Math.pow((int)Math.sqrt(c - arr[i]),2) == (c - arr[i])) {
				return true;
			}
		}
		return false;
	}

	public static boolean judgeSquareSum1(int c) {
		for (int i = 2; i < c; i++) {
			if (c % i == 0) {
				int count = 0;
				while (c % i == 0) {
					count++;
					c /= i;
				}
				if (i % 4 == 3 && count % 2 != 0) {
					return false;
				}
			}
		}
		return c % 4 != 3;
	}

	public static boolean judgeSquareSum2(int c) {
		int left = 0;
		int right = (int) Math.sqrt(c);
		while (left <= right) {
			int temp = left * left + right * right;
			if (temp < c) {
				left++;
			} else if (temp > c) {
				right--;
			} else {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(judgeSquareSum(11));
	}
}