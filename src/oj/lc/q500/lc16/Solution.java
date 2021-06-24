package oj.lc.q500.lc16;

import java.util.Arrays;

public class Solution {

	public static int threeSumClosest(int[] nums, int target) {
		int n = nums.length;
		Arrays.sort(nums);
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < n - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			int left = i + 1, right = n - 1;
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (sum == target) {
					return sum;
				}
				if (Math.abs(sum - target) < Math.abs(ans - target)) {
					ans = sum;
				}
				if (sum < target) {
					int l = left + 1;
					while (l < right && nums[l] == nums[l - 1]) {
						l++;
					}
					left = l;
				} else {
					int r = right - 1;
					while (left < r && nums[r] == nums[r + 1]) {
						r--;
					}
					right = r;
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
	}
}
