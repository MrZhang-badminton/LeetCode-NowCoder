package oj.lc.q2000.lc1248;

public class Solution {

	/**
	 * 前缀和
	 *
	 * @param nums
	 * @param k
	 * @return
	 */
	public static int numberOfSubarrays(int[] nums, int k) {
		int n = nums.length;
		int[] count = new int[n + 1];
		int odd = 0, ans = 0;
		count[0] = 1;
		for (int i = 0; i < n; i++) {
			odd += nums[i] & 1;
			ans += odd >= k ? count[odd - k] : 0;
			count[odd] += 1;
		}
		return ans;
	}

	/**
	 * 数学方法
	 *
	 * @param nums
	 * @param k
	 * @return
	 */
	public static int numberOfSubarrays2(int[] nums, int k) {
		int n = nums.length;
		int[] odd = new int[n + 2];
		int ans = 0, count = 0;
		for (int i = 0; i < n; i++) {
			if ((nums[i] & 1) != 0) {
				odd[++count] = i;
			}
		}
		odd[0] = -1;
		odd[++count] = n;
		for (int i = 1; i + k <= count; i++) {
			ans += (odd[i] - odd[i - 1]) * (odd[i + k] - odd[i + k - 1]);
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(numberOfSubarrays2(new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2}, 2));

	}
}
