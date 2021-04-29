package oj.lc.q500.lc1;

import java.util.*;

public class Solution {
	private static final int target = 1;

	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		int[] res = new int[2];

		for(int i = 0; i < nums.length; i++){
			if(map.containsKey(target - nums[i])){
				res[0] = map.get(target - nums[i]);
				res[1] = i;
				break;
			}
			map.put(nums[i],i);
		}
		return res;
	}
	public static void main(String[] args) {
		int[] nums = new int[]{-1,0,1,2,-1,-4};
		int[] result = twoSum(nums, target);
		for (int i = 0; i < 2; i++){
			System.out.println(result[i]);
		}
	}
}
