package oj.lc.q500.lc287;

public class Solution {
	public static int findDuplicate(int[] nums) {
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			while (nums[nums[i]] != nums[i]) {
				int temp = nums[i];
				int temp2 = nums[nums[i]];
				nums[nums[i]] = temp;
				nums[i] = temp2;

			}
			if(nums[nums[i]] == nums[i]){
				return nums[i];
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(findDuplicate(new int[]{1, 3, 4, 2, 2}));
	}
}
