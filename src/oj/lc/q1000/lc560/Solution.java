package oj.lc.q1000.lc560;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	public static int subarraySum(int[] nums, int k) {
		int count = 0;
		int counter = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(counter, 1);
		for (int i = 0; i < nums.length; i++) {
			counter += nums[i];
			if (map.containsKey(counter - k)) {
				count += map.get(counter - k);
			}
			map.put(counter, map.getOrDefault(counter,0) + 1);
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(subarraySum(new int[]{1, -1, 0}, 0));
	}
}
