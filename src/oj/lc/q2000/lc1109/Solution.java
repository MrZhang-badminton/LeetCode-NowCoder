package oj.lc.q2000.lc1109;

import utils.ArrayUtils;

/**
 * @Description:
 * @Author: zhanghua
 * @Date: 2022/3/14 2:45 下午
 */
public class Solution {

	/**
	 * 差分法（来自官方题解）
	 *
	 * @param bookings
	 * @param n
	 * @return
	 */
	public static int[] corpFlightBookings(int[][] bookings, int n) {
		int[] nums = new int[n];
		for (int[] booking : bookings) {
			nums[booking[0] - 1] += booking[2];
			if (booking[1] < n) {
				nums[booking[1]] -= booking[2];
			}
		}
		for (int i = 1; i < n; i++) {
			nums[i] += nums[i - 1];
		}

		return nums;
	}

	public static void main(String[] args) {
		int[][] bookings = {
				{1, 2, 10},
				{2, 3, 20},
				{2, 5, 25}
		};
		ArrayUtils.printArray(corpFlightBookings(bookings, 5));
	}
}
