package oj.lc.q500.lc42;

/**
 * @Description:
 * @Author: zhanghua
 * @Date: 2022/11/8 23:43
 */
public class Solution2 {
	public static int trap(int[] height) {
		int n = height.length;
		int[] leftMaxArr = new int[n];
		int[] rightMaxArr = new int[n];
		leftMaxArr[0] = height[0];
		rightMaxArr[n - 1] = height[n - 1];

		for (int i = 1; i < n; i++) {
			leftMaxArr[i] = Math.max(leftMaxArr[i - 1], height[i]);
			rightMaxArr[n - 1 - i] = Math.max(rightMaxArr[n - i], height[n - 1 - i]);
		}

		int result = 0;
		for (int i = 1; i < n - 1; i++) {
			int min = Math.min(leftMaxArr[i], rightMaxArr[i]);
			result += Math.max(min - height[i], 0);
		}

		return result;
	}


	public static void main(String[] args) {
		System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
	}


}
