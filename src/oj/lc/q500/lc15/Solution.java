package oj.lc.q500.lc15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	public static List<List<Integer>> threeSum(int[] nums) {
		int n = nums.length;
		Arrays.sort(nums);
		List<List<Integer>> retList = new ArrayList<>();
		for (int i = 0; i < n - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int k = n - 1;
			int target = -nums[i];
			for (int j = i + 1; j < n; j++) {
				if(j > i+1 && nums[j] == nums[j-1]){
					continue;
				}
				while(j < k && nums[j] + nums[k] > target){
					k--;
				}
				if(j == k){
					break;
				}
				if(nums[j] + nums[k] == target){
					List<Integer> list = new ArrayList<>();
					list.add(nums[i]);
					list.add(nums[j]);
					list.add(nums[k]);
					retList.add(list);
				}
			}
		}
		return retList;
	}

	public static void main(String[] args) {
		System.out.println(threeSum(new int[]{0}));
	}
}
