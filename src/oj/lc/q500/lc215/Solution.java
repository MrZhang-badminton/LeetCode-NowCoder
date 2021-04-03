package oj.lc.q500.lc215;

public class Solution {


	/**
	 * 找到第k大的数，但是一开始看错了
	 * 第K大，也就是下边为(len-k)的数
	 *
	 * @param nums
	 * @param k
	 * @return
	 */
	public static int findKthLargest(int[] nums, int k) {
		return find(nums, 0, nums.length - 1, nums.length - k);
	}

	/**
	 * 找到第k小的数
	 *
	 * @param nums
	 * @param left
	 * @param right
	 * @param k
	 * @return
	 */
	public static int find(int[] nums, int left, int right, int k) {

		int pivot = nums[left];
		int l = left, r = right;
		while (l < r) {
			while (l < r && nums[r] >= pivot) {
				r--;
			}
			nums[l] = nums[r];
			while (l < r && nums[l] <= pivot) {
				l++;
			}
			nums[r] = nums[l];
		}
		if (l == k) {
			return pivot;
		} else if (l < k) {
			return find(nums, l + 1, right, k);
		} else {
			return find(nums, left, l - 1, k);
		}

	}


	public static void main(String[] args) {
		System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
	}
}
