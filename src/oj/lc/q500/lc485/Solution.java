package oj.lc.q500.lc485;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: zhanghua
 * @Date: 2022/3/12 12:38 下午
 */
public class Solution {
	/**
	 * 切分数组简单写法
	 *
	 * @param nums
	 * @return
	 */
	public static int findMaxConsecutiveOnes(int[] nums) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < nums.length; i++) {
			sb.append(nums[i]);
		}
		String[] result = sb.toString().split("0");
		Optional<String> max = Arrays.stream(result).max(Comparator.comparingInt(String::length));
		return max.isPresent() ? max.get().length() : 0;
	}

	/**
	 * 切分数组
	 *
	 * @param nums
	 * @return
	 */
	public static int findMaxConsecutiveOnes2(int[] nums) {
		List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
		String str = list.toString();
		str = str.substring(1, str.length() - 1);
		str = str + ",";
		str = str.replace(" ", "");
		String[] result = str.split("0,");
		if (result.length == 0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < result.length; i++) {
			max = Math.max(max, result[i].length() / 2);
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(findMaxConsecutiveOnes(new int[]{0, 0}));
	}
}
