package oj.lc.jz.lcjz51;

/**
 * @Classname: Solution
 * @Author: zhanghua
 * @Date: 2021/8/14 2:42 上午
 */
public class Solution {

	private static int ans;

	/**
	 * 归并排序变种
	 * <p>
	 * 插入排序等都可以实现，不过插入排序时间复杂度是O(n^2)不过最好情况是O(n)
	 *
	 * @param nums
	 * @return
	 */
	public static int reversePairs(int[] nums) {
		ans = 0;
		int[] arr = new int[nums.length];
		merge(nums, arr, 0, nums.length - 1);
		return ans;
	}

	private static void merge(int[] nums, int[] arr, int left, int right) {
		if (left >= right) {
			return;
		}
		int mid = (left + right) / 2;
		merge(nums, arr, left, mid);
		merge(nums, arr, mid + 1, right);

		int index = left;
		int l = left, r = mid + 1;
		int count = mid + 1 - left;
		while (l <= mid && r <= right) {
			if (nums[l] > nums[r]) {
				ans += count;
				arr[index++] = nums[r];
				r++;
			} else {
				count--;
				arr[index++] = nums[l];
				l++;
			}

		}
		while (l <= mid) {
			arr[index++] = nums[l++];
		}
		while (r <= right) {
			arr[index++] = nums[r++];
		}
		for (int i = left; i <= right; i++) {
			nums[i] = arr[i];
		}
	}


	public static void main(String[] args) {
		System.out.println(reversePairs(new int[]{4, 5, 6, 7}));
	}
}
