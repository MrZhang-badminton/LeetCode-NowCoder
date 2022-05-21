package oj.lc.q1000.lc517;

import java.util.Arrays;

/**
 * @Description:
 * @Author: zhanghua
 * @Date: 2022/3/6 1:33 上午
 */
public class Solution {


	/**
	 * 来自官方题解
	 * <p>
	 * 贪心法，本题还是挺巧妙的
	 */
	public static int findMinMoves(int[] machines) {
		int tot = Arrays.stream(machines).sum();
		int n = machines.length;
		if (tot % n != 0) {
			return -1;
		}
		int avg = tot / n;
		int ans = 0, sum = 0;
		for (int num : machines) {
			num -= avg;
			sum += num;
			ans = Math.max(ans, Math.max(Math.abs(sum), num));
		}
		return ans;

	}


	public static void main(String[] args) {
		System.out.println(findMinMoves(new int[]{1, 1, 9, 1}));
	}
}
