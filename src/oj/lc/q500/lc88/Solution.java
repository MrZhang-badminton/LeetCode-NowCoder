package oj.lc.q500.lc88;

import utils.ArrayUtils;

import java.util.Arrays;

public class Solution {

	/**
	 * 合并再排序
	 *
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 */
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		for (int i = 0; i < n; i++) {
			nums1[m++] = nums2[i];
		}
		Arrays.sort(nums1);
	}

	/**
	 * 逆向双指针
	 *
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 */
	public static void merge2(int[] nums1, int m, int[] nums2, int n) {
		int index = m + n - 1;
		int i = m - 1, j = n - 1;
		while (i >= 0 && j >= 0) {
			if (nums1[i] > nums2[j]) {
				nums1[index--] = nums1[i--];
			} else {
				nums1[index--] = nums2[j--];
			}
		}
		while (i >= 0) {
			nums1[index--] = nums1[i--];
		}
		while (j >= 0) {
			nums1[index--] = nums2[j--];
		}
	}

	public static void main(String[] args) {
		int[] nums1 = new int[]{0};
		merge2(nums1, 0, new int[]{1}, 1);
		ArrayUtils.printArray(nums1);
	}
}
