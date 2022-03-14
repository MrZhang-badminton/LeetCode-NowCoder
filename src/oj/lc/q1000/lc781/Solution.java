package oj.lc.q1000.lc781;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: zhanghua
 * @Date: 2022/3/14 3:49 下午
 */
public class Solution {

	/**
	 * 把报的数字相同的放到一起
	 *
	 * @param answers
	 * @return
	 */
	public static int numRabbits(int[] answers) {
		Map<Integer, Integer> map = new HashMap<>();
		int ans = 0;
		for (int i = 0; i < answers.length; i++) {
			map.put(answers[i], map.getOrDefault(answers[i], 0) + 1);
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int key = entry.getKey();
			int value = entry.getValue();
			ans += ((value - 1) / (key + 1) + 1) * (key + 1);
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(numRabbits(new int[]{1, 1, 2}));
	}
}
