package oj.lc.q1000.lc532;

import java.util.*;

public class Solution {

//	public static int findPairs(int[] nums, int k) {
//		Set<Integer> set = new HashSet<>();
//		for(int i : nums){
//			set.add(i);
//		}
//
//		int count = 0;
//		for(int i : set){
//			if(set.contains(i+k)){
//				count++;
//			}
//		}
//
//		return count;
//
//	}

	public static int findPairs(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		int count = 0;
		for (int i : map.keySet()) {
			if (k != 0 && map.containsKey(i + k)) {
				//k != 0 的情况
				count++;
			} else if (k == 0 && map.get(i) > 1) {
				//k = 0 的情况下计算重复次数大于1的数的个数
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(findPairs(new int[]{3, 1, 4, 1, 5}, 0));
	}

}
