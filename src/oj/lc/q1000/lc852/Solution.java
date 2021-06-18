package oj.lc.q1000.lc852;

public class Solution {

	public static int peakIndexInMountainArray(int[] nums) {
		int l = 0, r = nums.length - 2;
		int ans = 0;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (nums[mid] > nums[mid + 1]) {
				ans = mid;
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(peakIndexInMountainArray(new int[]{3, 5, 3, 2, 0}));
	}
}
