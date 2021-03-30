package oj.lc.q1000.q922;

import java.util.*;

public class Solution {
	/**
	 * 双指针法
	 * 空间复杂度为O(n)
	 *
	 * @param nums
	 * @return
	 */
	public int[] sortArrayByParityII(int[] nums) {
		int n = nums.length;
		int j = 1;
		for (int i = 0; i < n; i += 2) {
			if (nums[i] % 2 == 1) {
				while (nums[j] % 2 == 1) {
					j += 2;
				}
				swap(nums, i, j);
			}
		}
		return nums;
	}

	public static void swap(int[] arr, int l, int r) {
		int temp = arr[l];
		arr[l] = arr[r];
		arr[r] = temp;
	}

	/**
	 * 将所有的奇数、偶数分别放入相应的队列中
	 * 然后将这些数字分别放到原数组中的对应位置
	 *
	 * @param nums
	 * @return
	 */
	public int[] sortArrayByParityII2(int[] nums) {
		Queue<Integer> queue1 = new LinkedList<>();
		Queue<Integer> queue2 = new LinkedList<>();

		for (int num : nums) {
			if (num % 2 == 0) {
				queue2.add(num);
			} else {
				queue1.add(num);
			}
		}

		int count = 0;
		while (!queue1.isEmpty()) {
			if (count % 2 == 0) {
				nums[count] = queue2.poll();
			} else {
				nums[count] = queue1.poll();
			}
			count++;
		}
		return nums;
	}
}
