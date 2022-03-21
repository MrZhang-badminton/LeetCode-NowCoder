package oj.lc.q500.lc334;

/**
 * @Description:
 * @Author: zhanghua
 * @Date: 2022/3/20 7:43 下午
 */
public class Solution {


	/**
	 * 两次遍历
	 *
	 * @param nums
	 * @return
	 */
	public static boolean increasingTriplet(int[] nums) {
		int n = nums.length;
		int[] leftMin = new int[n], rightMax = new int[n];
		leftMin[0] = nums[0];
		rightMax[n - 1] = nums[n - 1];
		for (int i = 1; i < n; i++) {
			leftMin[i] = Math.min(leftMin[i - 1], nums[i]);
			rightMax[n - i - 1] = Math.max(rightMax[n - i], nums[n - i - 1]);
		}
		for (int i = 0; i < n; i++) {
			if (nums[i] > leftMin[i] && nums[i] < rightMax[i]) {
				return true;
			}
		}
		return false;
	}


	/**
	 * 贪心思想
	 *
	 * @param nums
	 * @return
	 */
	public static boolean increasingTriplet2(int[] nums) {
		int n = nums.length;
		int a = nums[0], b = Integer.MAX_VALUE;
		for (int i = 1; i < n; i++) {
			if (nums[i] > b) {
				return true;
			} else if (nums[i] > a) {
				b = nums[i];
			} else {
				a = nums[i];
			}
		}


		return false;
	}


	public static void main(String[] args) {
		System.out.println(increasingTriplet2(new int[]{2, 4, -2, -3}));
	}
}
