package oj.lc.q1000.lc525;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	public static int findMaxLength(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;
		int maxLen = 0;
		map.put(count, -1);

		for (int i = 0; i < nums.length; i++) {
			count += nums[i] == 1 ? 1 : -1;
			if(map.containsKey(count)){
				maxLen = Math.max(maxLen,i-map.get(count));
			}else {
				map.put(count,i);
			}
		}
		return maxLen;
	}


	public static void main(String[] args) {
		System.out.println(findMaxLength(new int[]{0, 1, 0}));
	}
}
