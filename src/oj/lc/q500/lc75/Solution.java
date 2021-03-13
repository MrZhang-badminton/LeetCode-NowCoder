package oj.lc.q500.lc75;

public class Solution {

	public static void swap(int[] nums, int l, int r) {
		int temp = nums[l];
		nums[l] = nums[r];
		nums[r] = temp;
	}

	public static void sortColors(int[] nums) {
		int n = nums.length;
		int l = -1, r = n;
		int i = 0;
		while (i < r) {
			while (i < r && nums[i] == 2) {
				swap(nums, i, --r);
			}
			if(i < r && nums[i] == 0){
				swap(nums,i,++l);
			}
			i++;
		}

	}

	public static void main(String[] args) {
		sortColors(new int[]{2, 0, 2, 1, 1, 0});
		System.out.println();
	}
}
