package oj.lc.q500.lc135;

import java.util.Arrays;

/**
 * @Classname: Solution
 * @Author: zhanghua
 * @Date: 2021/8/29 2:18 下午
 */
public class Solution {

	/**
	 * 两次遍历
	 * 从左向右扫描，从右向左扫描
	 * 时间复杂度O(n)
	 *
	 * @param ratings
	 * @return
	 */
	public static int candy(int[] ratings) {
		int len = ratings.length;
		int[] candy = new int[len];
		Arrays.fill(candy, 1);
		int sum = 0;
		// 从左向右
		for (int i = 0; i < len; i++) {
			if (i - 1 >= 0 && ratings[i] > ratings[i - 1]) {
				candy[i] = candy[i - 1] + 1;
			}
			if (i + 1 < len && ratings[i] > ratings[i + 1]) {
				candy[i] = candy[i + 1] + 1;
			}
		}
		// 从右向左
		for (int i = len - 1; i >= 0; i--) {
			if (i - 1 >= 0 && ratings[i] > ratings[i - 1]) {
				// 取较大值
				candy[i] = Math.max(candy[i], candy[i - 1] + 1);
			}
			if (i + 1 < len && ratings[i] > ratings[i + 1]) {
				// 取较大值
				candy[i] = Math.max(candy[i], candy[i + 1] + 1);
			}
			sum += candy[i];
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(candy(new int[]{1, 2, 87, 87, 87, 2, 1}));
	}
}
