package oj.lc.q500.lc33;

public class Solution {


	public static int search(int[] nums, int target) {
		if (nums.length == 0) {
			return -1;
		}
		if (nums.length == 1) {
			return nums[0] == target ? 0 : -1;
		}

		int left = 0, right = nums.length - 1;
		while (left < right) {
			int mid = (left + right) / 2;
			if (nums[mid] == target) {
				return mid;
			}
			if (nums[0] < nums[mid]) {
				if (nums[left] <= target && target <= nums[mid - 1]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else {
				if (nums[mid + 1] <= target && target <= nums[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}
		return nums[left] == target ? left : -1;
	}

	public static void main(String[] args) {
		System.out.println(search(new int[]{3,5, 1}, 0));
	}
}
